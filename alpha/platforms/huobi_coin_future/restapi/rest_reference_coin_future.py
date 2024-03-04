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

__all__ = ("HuobiCoinFutureRestReferenceAPI",)


class HuobiCoinFutureRestReferenceAPI:
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

    async def get_contract_risk_info(self, symbol=None):

        uri = "/api/v1/contract_risk_info"
        params = {}
        if symbol:
            params["symbol"] = symbol

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_insurance_fund(self, symbol):

        uri = "/api/v1/contract_insurance_fund"
        params = {
            "symbol": symbol
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_adjustfactor(self, symbol=None):

        uri = "/api/v1/contract_adjustfactor"
        params = {}
        if symbol:
            params["symbol"] = symbol

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_his_open_interest(self, symbol, contract_type, period, amount_type, size=None):

        uri = "/api/v1/contract_his_open_interest"
        params = {
            "symbol": symbol,
            "contract_type": contract_type,
            "period": period,
            "amount_type": amount_type
        }
        if size:
            params["size"] = size

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_ladder_margin(self, symbol=None):

        uri = "/api/v1/contract_ladder_margin"
        params = {

        }
        if symbol:
            params["symbol"] = symbol

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_elite_account_ratio(self, symbol, period):

        uri = "/api/v1/contract_elite_account_ratio"
        params = {
            "symbol": symbol,
            "period": period
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_elite_position_ratio(self, symbol, period):

        uri = "/api/v1/contract_elite_position_ratio"
        params = {
            "symbol": symbol,
            "period": period
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_liquidation_orders(self, symbol, trade_type, start_time=None, end_time=None, direct=None,
                                              from_id=None):

        uri = "/api/v3/contract_liquidation_orders"
        params = {
            "symbol": symbol,
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

    async def get_contract_settlement_records(self, symbol, start_time=None, end_time=None, page_index=None, page_size=None):

        uri = "/api/v1/contract_settlement_records"
        params = {
            "symbol": symbol
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

    async def get_price_limit(self, symbol=None, contract_type=None, contract_code=None):
        """ Get contract price limit.

        Args:
            symbol: Trade pair, default `None` will return all symbols.
            contract_type: Contract type, `this_week` / `next_week` / `quarter`, default `None` will return all types.
            contract_code: Contract code, e.g. BTC180914.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.

        * NOTE: 1. If input `contract_code`, only matching this contract code.
                2. If not input `contract_code`, matching by `symbol + contract_type`.
        """
        uri = "/api/v1/contract_price_limit"
        params = {}
        if symbol:
            params["symbol"] = symbol
        if contract_type:
            params["contract_type"] = contract_type
        if contract_code:
            params["contract_code"] = contract_code
        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_open_interest(self, symbol=None, contract_type=None, contract_code=None):

        uri = "/api/v1/contract_open_interest"
        params = {

        }
        if symbol:
            params["symbol"] = symbol
        if contract_type:
            params["contract_type"] = contract_type
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_delivery_price(self, symbol):

        uri = "/api/v1/contract_delivery_price"
        params = {
            "symbol": symbol
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_estimated_settlement_price(self, symbol=None):

        uri = "/api/v1/contract_estimated_settlement_price"
        params = {

        }
        if symbol:
            params["symbol"] = symbol

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_api_state(self, symbol=None):

        uri = "/api/v1/contract_api_state"
        params = {

        }
        if symbol:
            params["symbol"] = symbol

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_info(self, symbol=None, contract_type=None, contract_code=None):
        """ Get contract information.

        Args:
            symbol: Trade pair, default `None` will return all symbols.
            contract_type: Contract type, `this_week` / `next_week` / `quarter`, default `None` will return all types.
            contract_code: Contract code, e.g. BTC180914.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.

        * NOTE: 1. If input `contract_code`, only matching this contract code.
                2. If not input `contract_code`, matching by `symbol + contract_type`.
        """
        uri = "/api/v1/contract_contract_info"
        params = {}
        if symbol:
            params["symbol"] = symbol
        if contract_type:
            params["contract_type"] = contract_type
        if contract_code:
            params["contract_code"] = contract_code
        success, error = await self.request("GET", uri, params)
        return success, error

    async def get_contract_query_elements(self, contract_code=None):

        uri = "/api/v1/contract_query_elements"
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

        uri = "https://status-dm.huobigroup.com/api/v2/summary.json"
        params = {

        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_contract_index(self, symbol=None):

        uri = "/api/v1/contract_index"
        params = {

        }
        if symbol:
            params["symbol"] = symbol

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