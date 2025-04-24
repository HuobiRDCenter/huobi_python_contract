# -*- coding:utf-8 -*-

"""
Huobi USDT Swap Api Module.

Author: QiaoXiaofeng
Date:   2020/09/10
Email:  andyjoe318@gmail.com
"""
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
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

from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

from alpha.utils.request import AsyncHttpRequests
from alpha.const import USER_AGENT

__all__ = ("HuobiCoinFutureRestMarketAPI",)


class HuobiCoinFutureRestMarketAPI:
    """ Huobi USDT Swap REST API Client.

    Attributes:
        host: HTTP request host.
        access_key: Account's ACCESS KEY.
        secret_key: Account's SECRET KEY.
        passphrase: API KEY Passphrase.
    """

    def __init__(self, host, access_key, secret_key,sign):
        """ initialize REST API client. """
        self._host = host
        self._sign = sign
        self._access_key = access_key
        self._secret_key = secret_key

    async def get_orderbook(self, symbol: 'str', type: 'str'='step0', depth: 'int'=None):
        """ Get orderbook information.

        Args:
            symbol: Symbol name, `BTC_CW` - current week, `BTC_NW` next week, `BTC_CQ` current quarter.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/market/depth"
        params = {
            "symbol": symbol,
            "type": type,
            "depth": depth

        }
        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_bbo(self, symbol=None):

        uri = "/market/bbo"
        params = {

        }
        if symbol:
            params["symbol"] = symbol

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_klines(self, symbol, period, size=None, sfrom=None, to=None):
        """ Get kline information.

        Args:
            symbol: Symbol name, `BTC_CW` - current week, `BTC_NW` next week, `BTC_CQ` current quarter.
            period: 1min, 5min, 15min, 30min, 60min,4hour,1day, 1mon
            size: [1,2000]

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/market/history/kline"
        params = {
            "symbol": symbol,
            "period": period
        }
        if size:
            params["size"] = size
        if sfrom:
            params["from"] = sfrom
        if to:
            params["to"] = to
        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_mark_price_kline(self, symbol, period, size):

        uri = "/index/market/history/mark_price_kline"
        params = {
            "symbol": symbol,
            "period": period,
            "size": size
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_merged(self, symbol):

        uri = "/market/detail/merged"
        params = {
            "symbol": symbol
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_batch_merged(self, symbol=None):

        uri = "/v2/market/detail/batch_merged"
        params = {

        }
        if symbol:
            params["symbol"] = symbol

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_trade(self, symbol=None):

        uri = "/market/trade"
        params = {

        }
        if symbol:
            params["symbol"] = symbol

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_history_trade(self, symbol, size):

        uri = "/market/history/trade"
        params = {
            "symbol": symbol,
            "size": size
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_history_index(self, symbol, period, size):

        uri = "/index/market/history/index"
        params = {
            "symbol": symbol,
            "period": period,
            "size": size
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_history_basis(self, symbol, period, size, basis_price_type=None):

        uri = "/index/market/history/basis"
        params = {
            "symbol": symbol,
            "period": period,
            "size": size
        }
        if basis_price_type:
            params["basis_price_type"] = basis_price_type

        success, error = await self.request("GET", uri, params=params)
        return success, error

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
            if (self._sign == "256"):

                params.update({"AccessKeyId": self._access_key,
                               "SignatureMethod": "HmacSHA256",
                               "SignatureVersion": "2",
                               "Timestamp": timestamp})
            else:
                params.update({"AccessKeyId": self._access_key,
                               "SignatureMethod": "Ed25519",
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
        if self._sign == "256":
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
        else:
            if request_path.startswith("http://") or request_path.startswith("https://"):
                host_url = urllib.parse.urlparse(request_path).hostname.lower()
                request_path = '/' + '/'.join(request_path.split('/')[3:])
            else:
                host_url = urllib.parse.urlparse(self._host).hostname.lower()

            sorted_params = sorted(params.items(), key=lambda d: d[0], reverse=False)
            encode_params = urllib.parse.urlencode(sorted_params)

            payload = [method, host_url, request_path, encode_params]
            payload = "\n".join(payload)
            payload = payload.encode(encoding="UTF-8")

            # 从 PEM 格式的私钥加载 Ed25519 密钥
            private_key = serialization.load_pem_private_key(
                self._secret_key.encode(),
                password=None,
                backend=default_backend()
            )

            # 使用 Ed25519 签名
            signature = private_key.sign(payload)

            # 将签名编码为 Base64
            signature_b64 = base64.b64encode(signature).decode()
            return signature_b64