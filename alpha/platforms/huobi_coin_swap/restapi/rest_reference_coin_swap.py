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
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
__all__ = ("HuobiCoinSwapRestReferenceAPI",)


class HuobiCoinSwapRestReferenceAPI:
    """ Huobi USDT Swap REST API Client.

    Attributes:
        host: HTTP request host.
        access_key: Account's ACCESS KEY.
        secret_key: Account's SECRET KEY.
        passphrase: API KEY Passphrase.
    """

    def __init__(self, host, access_key, secret_key, sign):
        """ initialize REST API client. """
        self._host = host
        self._sign = sign
        self._access_key = access_key
        self._secret_key = secret_key

    async def get_swap_risk_info(self, contract_code=None):

        uri = "/swap-api/v1/swap_risk_info"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_insurance_fund(self, contract_code, page_index=None, page_size=None):

        uri = "/swap-api/v1/swap_insurance_fund"
        params = {
            "contract_code": contract_code
        }
        if page_index:
            params["page_index"] = page_index
        if page_size:
            params["page_size"] = page_size

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_adjustfactor(self, contract_code=None):

        uri = "/swap-api/v1/swap_adjustfactor"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_his_open_interest(self, contract_code, period, amount_type, size=None):

        uri = "/swap-api/v1/swap_his_open_interest"
        params = {
            "contract_code": contract_code,
            "period": period,
            "amount_type": amount_type
        }
        if size:
            params["size"] = size

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_ladder_margin(self, contract_code=None):

        uri = "/swap-api/v1/swap_ladder_margin"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_elite_account_ratio(self, contract_code, period):

        uri = "/swap-api/v1/swap_elite_account_ratio"
        params = {
            "contract_code": contract_code,
            "period": period
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_elite_position_ratio(self, contract_code, period):

        uri = "/swap-api/v1/swap_elite_position_ratio"
        params = {
            "contract_code": contract_code,
            "period": period
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_estimated_settlement_price(self, contract_code=None):

        uri = "/swap-api/v1/swap_estimated_settlement_price"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_api_state(self, contract_code=None):

        uri = "/swap-api/v1/swap_api_state"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_funding_rate(self, contract_code):

        uri = "/swap-api/v1/swap_funding_rate"
        params = {
            "contract_code": contract_code
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_batch_funding_rate(self, contract_code=None):

        uri = "/swap-api/v1/swap_batch_funding_rate"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_historical_funding_rate(self, contract_code, page_index=None, page_size=None):

        uri = "/swap-api/v1/swap_historical_funding_rate"
        params = {
            "contract_code": contract_code
        }
        if page_index:
            params["page_index"] = page_index
        if page_size:
            params["page_size"] = page_size

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_liquidation_orders(self, contract, trade_type, start_time=None, end_time=None, direct=None, from_id=None):

        uri = "/swap-api/v3/swap_liquidation_orders"
        params = {
            "contract": contract,
            "trade_type": trade_type
        }
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if direct:
            params["direct"] = direct
        if from_id:
            params["from_id"] = from_id

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_settlement_records(self, contract_code, start_time=None, end_time=None, page_index=None,
                                          page_size=None):

        uri = "/swap-api/v1/swap_settlement_records"
        params = {
            "contract_code": contract_code
        }
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if page_index:
            params["page_index"] = page_index
        if page_size:
            params["page_size"] = page_size

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_info(self, contract_code=None):
        """ Get Swap Info

        Args:
            contract_code:  such as "BTC-USD".

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        * Note: 1. If input `contract_code`, only matching this contract code.
                2. If not input 'contract_code', matching all contract_codes.
        """
        uri = "/swap-api/v1/swap_contract_info"
        params = {}
        if contract_code:
            params["contract_code"] = contract_code
        success, error = await self.request("GET", uri, params)
        return success, error

    async def get_swap_index(self, contract_code=None):

        uri = "/swap-api/v1/swap_index"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_query_elements(self, contract_code=None):

        uri = "/swap-api/v1/swap_query_elements"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_price_limit(self, contract_code=None):
        """ Get swap price limit.

        Args:
            contract_code:  such as "BTC-USD".

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.

        * NOTE: 1. If input `contract_code`, only matching this contract code.
                2. If not input 'contract_code', matching all contract_codes.
        """
        uri = "/swap-api/v1/swap_price_limit"
        params = {}
        if contract_code:
            params["contract_code"] = contract_code
        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_open_interest(self, contract_code=None):

        uri = "/swap-api/v1/swap_open_interest"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_timestamp(self):

        uri = "/api/v1/timestamp"
        params = {

        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_heartbeat(self):

        uri = "/heartbeat/"
        params = {

        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_summary(self):

        uri = "https://status-swap.huobigroup.com/api/v2/summary.json"
        params = {

        }

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