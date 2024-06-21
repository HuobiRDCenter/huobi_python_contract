# -*- coding:utf-8 -*-

"""
Huobi USDT Swap Api Module.

Author: QiaoXiaofeng
Date:   2020/09/10
Email:  andyjoe318@gmail.com
"""

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

__all__ = ("HuobiUsdtSwapRestUnifiedAccountAPI",)


class HuobiUsdtSwapRestUnifiedAccountAPI:
    """ Huobi USDT Swap REST API Client.

    Attributes:
        host: HTTP request host.
        access_key: Account's ACCESS KEY.
        secret_key: Account's SECRET KEY.
        passphrase: API KEY Passphrase.
    """

    def __init__(self, host, access_key, secret_key):
        """ initialize REST API client. """
        self._host = host
        self._access_key = access_key
        self._secret_key = secret_key


    async def linear_swap_fee_switch(self, fee_option, deduction_currency):

        uri = "/linear-swap-api/v3/linear_swap_fee_switch"
        body = {
            "fee_option": fee_option,
            "deduction_currency": deduction_currency
        }

        # if contract_code:
        #     body["contract_code"] = contract_code

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def fix_position_margin_change(self, amount, asset, contract_code, type, direction, clientOrderId=None):

        uri = "/linear-swap-api/v3/fix_position_margin_change"
        body = {
            "amount": amount,
            "asset": asset,
            "contract_code": contract_code,
            "type": type,
            "direction": direction
        }

        if clientOrderId:
            body["clientOrderId"] = clientOrderId

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_switch_account_type(self, account_type):

        uri = "/linear-swap-api/v3/swap_switch_account_type"
        body = {
            "account_type": account_type
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_unified_account_info(self, contract_code=None):

        uri = "/linear-swap-api/v3/unified_account_info"
        params = {
            "contract_code": contract_code
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def get_linear_swap_overview_account_info(self, trade_partition=None):

        uri = "/linear-swap-api/v3/linear_swap_overview_account_info"
        params = {
            "trade_partition": trade_partition
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def get_fix_position_margin_change_record(self, asset, contract_code, start_time=None, end_time=None, direct=None, from_id=None):

        uri = "/linear-swap-api/v3/fix_position_margin_change_record"
        params = {
            "asset": asset,
            "contract_code": contract_code
        }

        if start_time:
            body["start_time"] = start_time
        if end_time:
            body["end_time"] = end_time
        if direct:
            body["direct"] = direct
        if from_id:
            body["from_id"] = from_id

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def get_swap_unified_account_type(self):

        uri = "/linear-swap-api/v3/swap_unified_account_type"
        params = {
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
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
