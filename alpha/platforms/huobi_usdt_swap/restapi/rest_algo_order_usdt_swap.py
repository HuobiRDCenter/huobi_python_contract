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

__all__ = ("HuobiUsdtSwapRestAlgoOrderAPI",)


class HuobiUsdtSwapRestAlgoOrderAPI:
    """Huobi USDT Swap 策略订单REST API Client"""
    
    def __init__(self, host, access_key, secret_key):
        self._host = host
        self._access_key = access_key
        self._secret_key = secret_key

    async def algo_order(self, 
                        contract_code: str, 
                        type: str, 
                        position_side: str, 
                        side: str, 
                        margin_mode: str,
                        algo_client_order_id: str = None,
                        volume: str = None,
                        tp_trigger_price: str = None,
                        tp_order_price: str = None,
                        tp_type: str = None,
                        tp_trigger_price_type: str = None,
                        sl_trigger_price: str = None,
                        sl_order_price: str = None,
                        sl_type: str = None,
                        sl_trigger_price_type: str = None,
                        price: str = None,
                        price_match: str = None,
                        trigger_price: str = None,
                        trigger_price_type: str = None,
                        active_price: str = None,
                        order_price_type: str = None,
                        callback_rate: str = None,
                        reduce_only: bool = None):
        """创建策略订单"""
        uri = "/v5/algo/order"
        body = {
            "contract_code": contract_code,
            "type": type,
            "position_side": position_side,
            "side": side,
            "margin_mode": margin_mode
        }

        # 可选字段
        if algo_client_order_id:
            body["algo_client_order_id"] = algo_client_order_id
        if volume:
            body["volume"] = volume
        if tp_trigger_price:
            body["tp_trigger_price"] = tp_trigger_price
        if tp_order_price:
            body["tp_order_price"] = tp_order_price
        if tp_type:
            body["tp_type"] = tp_type
        if tp_trigger_price_type:
            body["tp_trigger_price_type"] = tp_trigger_price_type
        if sl_trigger_price:
            body["sl_trigger_price"] = sl_trigger_price
        if sl_order_price:
            body["sl_order_price"] = sl_order_price
        if sl_type:
            body["sl_type"] = sl_type
        if sl_trigger_price_type:
            body["sl_trigger_price_type"] = sl_trigger_price_type
        if price:
            body["price"] = price
        if price_match:
            body["price_match"] = price_match
        if trigger_price:
            body["trigger_price"] = trigger_price
        if trigger_price_type:
            body["trigger_price_type"] = trigger_price_type
        if active_price:
            body["active_price"] = active_price
        if order_price_type:
            body["order_price_type"] = order_price_type
        if callback_rate:
            body["callback_rate"] = callback_rate
        if reduce_only is not None:
            body["reduce_only"] = 1 if reduce_only else 0

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def cancel_algo_orders(self, 
                                algo_id: str = None, 
                                algo_client_order_id: str = None, 
                                contract_code: str = None):
        """取消策略订单"""
        uri = "/v5/algo/cancel-orders"
        body = {}

        if algo_id:
            body["algo_id"] = algo_id
        if algo_client_order_id:
            body["algo_client_order_id"] = algo_client_order_id
        if contract_code:
            body["contract_code"] = contract_code

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def query_algo_order(self, 
                              type: str, 
                              algo_id: str = None, 
                              algo_client_order_id: str = None, 
                              contract_code: str = None):
        """查询策略订单"""
        uri = "/v5/algo/order"
        params = {
            "type": type
        }

        if algo_id:
            params["algo_id"] = algo_id
        if algo_client_order_id:
            params["algo_client_order_id"] = algo_client_order_id
        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def query_open_algo_orders(self, 
                                    type: str, 
                                    contract_code: str = None, 
                                    algo_id: str = None, 
                                    algo_client_order_id: str = None,
                                    from_page: int = None,
                                    limit: int = None,
                                    direct: str = None):
        """查询未触发策略订单"""
        uri = "/v5/algo/order/opens"
        params = {
            "type": type
        }

        if contract_code:
            params["contract_code"] = contract_code
        if algo_id:
            params["algo_id"] = algo_id
        if algo_client_order_id:
            params["algo_client_order_id"] = algo_client_order_id
        if from_page is not None:
            params["from"] = from_page
        if limit is not None:
            params["limit"] = limit
        if direct:
            params["direct"] = direct

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def query_algo_order_history(self, 
                                      type: str, 
                                      contract_code: str = None, 
                                      margin_mode: str = None, 
                                      states: list = None,
                                      start_time: int = None,
                                      end_time: int = None,
                                      from_page: int = None,
                                      limit: int = None,
                                      direct: str = None):
        """查询历史策略订单"""
        uri = "/v5/algo/order/history"
        params = {
            "type": type
        }

        if contract_code:
            params["contract_code"] = contract_code
        if margin_mode:
            params["margin_mode"] = margin_mode
        if states:
            params["states"] = ",".join(states)
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if from_page is not None:
            params["from"] = from_page
        if limit is not None:
            params["limit"] = limit
        if direct:
            params["direct"] = direct

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