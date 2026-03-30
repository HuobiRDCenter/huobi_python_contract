# -*- coding:utf-8 -*-

import gzip
import json
import copy
import hmac
import base64
import urllib
import hashlib
import datetime
import time
from urllib.parse import urljoin
from alpha.utils.request import AsyncHttpRequests
from alpha.const import USER_AGENT

__all__ = ("HuobiUsdtSwapRestCopytradingTradeAPI",)

class HuobiUsdtSwapRestCopytradingTradeAPI:
    """ Huobi USDT Swap REST API Client. """

    def __init__(self, host: str, access_key: str, secret_key: str):
        """初始化跟单API客户端
        
        Args:
            host: API主机地址，如 "https://api.hbdm.com"
            access_key: API访问密钥
            secret_key: API秘密密钥
        """
        self._host = host
        self._access_key = access_key
        self._secret_key = secret_key
        self._success_code = "0"

    async def query_trader_instruments(self, inst_type: str) -> tuple:
        uri = "/api/v6/copyTrading/trader/instruments"
        params = {"instType": inst_type}
        return await self._request("GET", uri, params=params, auth=True)

    async def query_trader_statistics(self, inst_type: str) -> tuple:
        uri = "/api/v6/copyTrading/trader/statistics"
        params = {"instType": inst_type}
        return await self._request("GET", uri, params=params, auth=True)
    
    async def query_trader_profit_sharing_history(self, inst_id: str, inst_type: str, begin: str=None, end: str=None, after: str=None, before: str=None, limit: str=None) -> tuple:
        uri = "/api/v6/copyTrading/trader/profit-sharing-history"
        params = {"instId": inst_id, "instType": inst_type}
        if begin:
            params["begin"] = begin
        if end:
            params["end"] = end
        if after:
            params["after"] = after
        if before:
            params["before"] = before
        if limit:
            params["limit"] = limit
        return await self._request("GET", uri, params=params, auth=True)

    async def query_trader_profit_sharing_history_summary(self, inst_type: str) -> tuple:
        uri = "/api/v6/copyTrading/trader/profit-sharing-history-summary"
        params = {"instType": inst_type}
        return await self._request("GET", uri, params=params, auth=True)
    
    async def query_trader_unrealized_profit_sharing_summary(self, inst_type: str, ccy: str=None) -> tuple:
        uri = "/api/v6/copyTrading/trader/unrealized-profit-sharing-summary"
        params = {"instType": inst_type}
        if ccy:
            params["ccy"] = ccy
        return await self._request("GET", uri, params=params, auth=True)
    
    async def query_trader_followers(self, inst_type: str, begin: str=None, end: str=None, after: str=None, before: str=None, limit: str=None) -> tuple:
        uri = "/api/v6/copyTrading/trader/followers"
        params = {"instType": inst_type}
        if begin:
            params["begin"] = begin
        if end:
            params["end"] = end
        if after:
            params["after"] = after
        if before:
            params["before"] = before
        if limit:
            params["limit"] = limit
        return await self._request("GET", uri, params=params, auth=True)
    
    async def delete_trader_follower(self, inst_type: str, follower_uids: str) -> tuple:
        uri = "/api/v6/copyTrading/trader/follower"
        body = {"instType": inst_type, "followerUids": follower_uids}
        return await self.request("POST", uri, body=body, auth=True)

    async def trader_transfer(self, amt: str, from_: str, to: str, ccy: str=None) -> tuple:
        uri = "/api/v6/copyTrading/trader/transfer"
        body = {"amt": amt, "from": from_, "to": to}
        if ccy:
            body["ccy"] = ccy
        return await self.request("POST", uri, body=body, auth=True)

    async def trader_follower_settings(self, inst_type: str, enable: str=None, profit_sharing_ratio: str=None, max_followers: str=None) -> tuple:
        uri = "/api/v6/copyTrading/trader/follower-settings"
        body = {"instType": inst_type}
        if enable:
            body["enable"] = enable
        if profit_sharing_ratio:
            body["profitSharingRatio"] = profit_sharing_ratio
        if max_followers:
            body["maxFollowers"] = max_followers
        return await self.request("POST", uri, body=body, auth=True)

    async def trader_config(self, inst_type: str) -> tuple:
        uri = "/api/v6/copyTrading/trader/config"
        params = {"instType": inst_type}
        return await self._request("GET", uri, params=params, auth=True)
    
    async def trader_apikey(self, inst_type: str) -> tuple:
        uri = "/api/v6/copyTrading/trader/apikey"
        body = {"instType": inst_type}
        return await self.request("POST", uri, body=body, auth=True)

    async def request(self, method, uri, params=None, body=None, headers=None, auth=False):
        """ Do HTTP request.

        Args:
            method: HTTP request method. `GET` / `POST` / `DELETE` / `PUT`.
            uri: HTTP request uri.
            params: HTTP query params.
            body: HTTP request body.
            headers: HTTP request headers.
            auth: If this request requires authentication.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        if uri.startswith("http://") or uri.startswith("https://"):
            url = uri
        else:
            url = self._host + uri

        if auth:
            timestamp = datetime.datetime.utcnow().strftime("%Y-%m-%dT%H:%M:%S")
            params = params if params else {}
            params.update({"AccessKeyId": self._access_key,
                           "SignatureMethod": "HmacSHA256",
                           "SignatureVersion": "2",
                           "Timestamp": timestamp})

            params["Signature"] = self.generate_signature(method, params, uri)

        if not headers:
            headers = {}
        if method == "GET":
            headers["Content-type"] = "application/x-www-form-urlencoded"
            headers["User-Agent"] = USER_AGENT
            _, success, error = await AsyncHttpRequests.fetch("GET", url, params=params, headers=headers, timeout=10)
        else:
            headers["Accept"] = "application/json"
            headers["Content-type"] = "application/json"
            headers["User-Agent"] = USER_AGENT
            _, success, error = await AsyncHttpRequests.fetch("POST", url, params=params, data=body, headers=headers,
                                                              timeout=10)
        if error:
            return None, error
        if not isinstance(success, dict):
            result = json.loads(success)
        else:
            result = success
        if result.get("status") != "ok":
            return None, result
        return result, None

    def generate_signature(self, method, params, request_path):
        if request_path.startswith("http://") or request_path.startswith("https://"):
            host_url = urllib.parse.urlparse(request_path).hostname.lower()
            request_path = '/' + '/'.join(request_path.split('/')[3:])
        else:
            host_url = urllib.parse.urlparse(self._host).hostname.lower()
        sorted_params = sorted(params.items(), key=lambda d: d[0], reverse=False)
        encode_params = urllib.parse.urlencode(sorted_params)
        payload = [method, host_url, request_path, encode_params]
        payload = "\n".join(payload)
        payload = payload.encode(encoding="UTF8")
        secret_key = self._secret_key.encode(encoding="utf8")
        digest = hmac.new(secret_key, payload, digestmod=hashlib.sha256).digest()
        signature = base64.b64encode(digest)
        signature = signature.decode()
        return signature