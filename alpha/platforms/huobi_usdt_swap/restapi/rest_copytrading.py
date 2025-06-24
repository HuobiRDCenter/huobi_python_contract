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

__all__ = ("HuobiCopytradingAPI",)


class HuobiCopytradingAPI:
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

    async def copytrading_trader_place_order(self, contract_code, amount, margin_mode, order_price_type, order_direction,
                                         lever, price=None, tp_trigger_price=None, sl_trigger_price=None):
        uri = "/copytrading/trader/place_order"
        body = {}
        if contract_code:
            body.update({"contract_code": contract_code})
        if amount:
            body.update({"amount": amount})
        if margin_mode:
            body.update({"margin_mode": margin_mode})
        if order_price_type:
            body.update({"order_price_type": order_price_type})
        if order_direction:
            body.update({"order_direction": order_direction})
        if lever:
            body.update({"lever": lever})
        if price:
            body.update({"price": price})
        if tp_trigger_price:
            body.update({"tp_trigger_price": tp_trigger_price})
        if sl_trigger_price:
            body.update({"sl_trigger_price": sl_trigger_price})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def copytrading_trader_query_contract_lever(self, contract_code, margin_mode):
        uri = "/copytrading/trader/query_contract_lever"
        params = {}
        if contract_code:
            params["contract_code"] = contract_code
        if margin_mode:
            params["margin_mode"] = margin_mode
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_updated_contract_lever(self, contract_code, lever, margin_mode):
        uri = "/copytrading/trader/updated_contract_lever"
        body = {}
        if contract_code:
            body.update({"contract_code": contract_code})
        if lever:
            body.update({"lever": lever})
        if margin_mode:
            body.update({"margin_mode": margin_mode})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def copytrading_trader_close_order(self, sub_position_id):
        uri = "/copytrading/trader/close_order"
        body = {}
        if sub_position_id:
            body.update({"sub_position_id": sub_position_id})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def copytrading_trader_close_all_position(self, contract_code, margin_mode, position_side):
        uri = "/copytrading/trader/close_all_position"
        body = {}
        if margin_mode:
            body.update({"margin_mode": margin_mode})
        if contract_code:
            body.update({"contract_code": contract_code})
        if position_side:
            body.update({"position_side": position_side})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def copytrading_trader_add_margin(self, contract_code, amount, type, position_side):
        uri = "/copytrading/trader/add_margin"
        body = {}
        if amount:
            body.update({"amount": amount})
        if contract_code:
            body.update({"contract_code": contract_code})
        if position_side:
            body.update({"position_side": position_side})
        if type:
            body.update({"type": type})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def copytrading_trader_position_list(self):
        uri = "/copytrading/trader/position_list"
        params = {}
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_account_transfer(self, amount, type, currency):
        uri = "/copytrading/trader/account_transfer"
        body = {}
        if amount:
            body.update({"amount": amount})
        if currency:
            body.update({"currency": currency})
        if type:
            body.update({"type": type})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def copytrading_trader_current_positions(self, contract_code, start_time=None, end_time=None,
                                                   direct=None, from_id=None, limit=None):
        uri = "/copytrading/trader/current_positions"
        params = {}
        if contract_code:
            params["contract_code"] = contract_code
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if direct:
            params["direct"] = direct
        if from_id:
            params["from_id"] = from_id
        if limit:
            params["limit"] = limit
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_position_positions(self, contract_code, start_time=None, end_time=None,
                                                   direct=None, from_id=None, limit=None):
        uri = "/copytrading/trader/position_positions"
        params = {}
        if contract_code:
            params["contract_code"] = contract_code
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if direct:
            params["direct"] = direct
        if from_id:
            params["from_id"] = from_id
        if limit:
            params["limit"] = limit
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_tpsl_order(self, sub_position_id, tp_trigger_price=None, sl_trigger_price=None):
        uri = "/copytrading/trader/tpsl_order"
        body = {}
        if sub_position_id:
            body.update({"sub_position_id": sub_position_id})
        if tp_trigger_price:
            body.update({"tp_trigger_price": tp_trigger_price})
        if sl_trigger_price:
            body.update({"sl_trigger_price": sl_trigger_price})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def copytrading_trader_query_contract(self):
        uri = "/copytrading/trader/query_contract"
        params = {}
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_order_total_detail(self):
        uri = "/copytrading/trader/order_total_detail"
        params = {}
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_profit_history_details(self, start_time=None, end_time=None,
                                                   direct=None, from_id=None, limit=None):
        uri = "/copytrading/trader/profit_history_details"
        params = {}
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if direct:
            params["direct"] = direct
        if from_id:
            params["from_id"] = from_id
        if limit:
            params["limit"] = limit
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_total_profit_history(self):
        uri = "/copytrading/trader/total_profit_history"
        params = {}
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_query_followers(self, start_time=None, end_time=None,
                                                   direct=None, from_id=None, limit=None):
        uri = "/copytrading/trader/query_followers"
        params = {}
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if direct:
            params["direct"] = direct
        if from_id:
            params["from_id"] = from_id
        if limit:
            params["limit"] = limit
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_remove_follower(self, follower_uid):
        uri = "/copytrading/trader/remove_follower"
        body = {}
        if follower_uid:
            body.update({"follower_uid": follower_uid})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def copytrading_trader_open_orders(self, contract_code=None):
        uri = "/copytrading/trader/open_orders"
        params = {}
        if contract_code:
            params["contract_code"] = contract_code
        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def copytrading_trader_tpsl_open_orders(self, contract_code=None):
        uri = "/copytrading/trader/tpsl_open_orders"
        params = {}
        if contract_code:
            params["contract_code"] = contract_code
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