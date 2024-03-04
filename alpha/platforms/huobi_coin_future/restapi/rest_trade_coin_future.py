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

__all__ = ("HuobiCoinFutureRestTradeAPI",)


class HuobiCoinFutureRestTradeAPI:
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

    async def contract_cancel_after(self, on_off, time_out=None):

        uri = "/api/v1/contract-cancel-after"
        body = {
            "on_off": on_off
        }

        if time_out:
            body.update({"time_out": time_out})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def contract_order(self, volume, direction, offset, lever_rate, order_price_type, symbol=None,
                             contract_type=None, contract_code=None, client_order_id=None, price=None,
                             tp_trigger_price=None, tp_order_price=None, tp_order_price_type=None, sl_trigger_price=None,
                             sl_order_price=None, sl_order_price_type=None):

        uri = "/api/v1/contract_order"
        body = {
            "volume": volume,
            "direction": direction,
            "offset": offset,
            "lever_rate": lever_rate,
            "order_price_type": order_price_type
        }

        if symbol:
            body.update({"symbol": symbol})
        if contract_type:
            body.update({"contract_type": contract_type})
        if contract_code:
            body.update({"contract_code": contract_code})
        if client_order_id:
            body.update({"client_order_id": client_order_id})
        if price:
            body.update({"price": price})
        if tp_trigger_price:
            body.update({"tp_trigger_price": tp_trigger_price})
        if tp_order_price:
            body.update({"tp_order_price": tp_order_price})
        if tp_order_price_type:
            body.update({"tp_order_price_type": tp_order_price_type})
        if sl_trigger_price:
            body.update({"sl_trigger_price": sl_trigger_price})
        if sl_order_price:
            body.update({"time_osl_order_priceut": sl_order_price})
        if sl_order_price_type:
            body.update({"sl_order_price_type": sl_order_price_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def create_orders(self, orders_data):
        """ Batch Create orders.
            {
              "orders_data": [
                {
                  "symbol“:"BTC",
                  "contract_type":"this_week",
                  "contract_code": "bch210326",
                  "client_order_id":1,
                  "direction": "buy",
                  "offset": "open",
                  "price": 360,
                  "lever_rate": 75,
                  "volume": 1,
                  "order_price_type": "opponent",
                  "tp_trigger_price": 450,
                  "tp_order_price": 450,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": 330,
                  "sl_order_price": 330,
                  "sl_order_price_type": "optimal_5"
                },
                {
                  "symbol“:"BTC",
                  "contract_type":"this_week",
                  "contract_code": "bch210326",
                  "client_order_id":1,
                  "direction": "buy",
                  "offset": "open",
                  "price": 360,
                  "lever_rate": 75,
                  "volume": 1,
                  "order_price_type": "post_only",
                  "tp_trigger_price": 450,
                  "tp_order_price": 450,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": 330,
                  "sl_order_price": 330,
                  "sl_order_price_type": "optimal_5"
                }
              ]
            }
        """
        uri = "/api/v1/contract_batchorder"
        body = orders_data
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def revoke_order(self, symbol, order_id=None, client_order_id=None):
        """ Revoke an order.

        Args:
            symbol: Currency name, e.g. BTC.
            order_id: Order ID.
            client_order_id: Custom Order ID.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/api/v1/contract_cancel"
        body = {
            "symbol": symbol
        }
        if order_id:
            body["order_id"] = order_id
        if client_order_id:
            body["client_order_id"] = client_order_id

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def revoke_orders(self, symbol, order_ids=None, client_order_ids=None):
        """ Revoke multiple orders.

        Args:
            symbol: Currency name, e.g. BTC.
            order_ids: Order ID list.
            client_order_ids: Client Order Ids.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/api/v1/contract_cancel"
        body = {
            "symbol": symbol
        }
        if order_ids:
            body["order_id"] = ",".join(order_ids)
        if client_order_ids:
            body["client_order_id"] = ",".join(client_order_ids)

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def revoke_order_all(self, symbol, contract_code=None, contract_type=None, direction=None, offset=None):
        """ Revoke all orders.

        Args:
            symbol: Currency name, e.g. BTC.
            contract_type: Contract type, `this_week` / `next_week` / `quarter`, default `None` will return all types.
            contract_code: Contract code, e.g. BTC180914.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.

        * NOTE: 1. If input `contract_code`, only matching this contract code.
                2. If not input `contract_code`, matching by `symbol + contract_type`.
        """
        uri = "/api/v1/contract_cancelall"
        body = {
            "symbol": symbol,
        }
        if contract_code:
            body["contract_code"] = contract_code
        if contract_type:
            body["contract_type"] = contract_type
        if direction:
            body["direction"] = direction
        if offset:
            body["offset"] = offset
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def contract_switch_lever_rate(self, symbol, lever_rate):

        uri = "/api/v1/contract_switch_lever_rate"
        body = {
            "symbol": symbol,
            "lever_rate": lever_rate
        }

    async def get_order_info(self, symbol, order_ids=[], client_order_ids=[]):
        """ Get order information.

        Args:
            order_ids: Order ID list. (different IDs are separated by ",", maximum 20 orders can be requested at one time.)
            client_order_ids: Client Order ID list. (different IDs are separated by ",", maximum 20 orders can be requested at one time.)

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/api/v1/contract_order_info"
        body = {
            "symbol": symbol
        }

        if order_ids:
            body.update({"order_id": ",".join(order_ids)})
        if client_order_ids:
            body.update({"client_order_id": ",".join(client_order_ids)})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_contract_order_detail(self, symbol, order_id, created_at=None, order_type=None, page_index=None, page_size=None):

        uri = "/api/v1/contract_order_detail"
        body = {
            "symbol": symbol,
            "order_id": order_id
        }

        if created_at:
            body.update({"created_at": created_at})
        if order_type:
            body.update({"order_type": order_type})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_open_orders(self, symbol, index=1, size=50, sort_by='created_at', trade_type=0):
        """ Get open order information.

        Args:
            symbol: Currency name, e.g. BTC.
            index: Page index, default 1st page.
            size: Page size, Default 20，no more than 50.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/api/v1/contract_openorders"
        body = {
            "symbol": symbol,
            "page_index": index,
            "page_size": size,
            "sort_by": sort_by,
            "trade_type": trade_type
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_contract_hisorders(self, symbol, trade_type, type, status, contract=None, order_type=None, sort_by=None,
                                     start_time=None, end_time=None, direct=None, from_id=None):

        uri = "/api/v3/contract_hisorders"
        body = {
            "symbol": symbol,
            "trade_type": trade_type,
            "type": type,
            "status": status
        }

        if symbol:
            body.update({"symbol": symbol})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_contract_hisorders_exact(self, symbol, trade_type, type, status, contract=None, order_type=None,
                                           start_time=None, end_time=None, direct=None, from_id=None):

        uri = "/api/v3/contract_hisorders_exact"
        body = {
            "symbol": symbol,
            "trade_type": trade_type,
            "type": type,
            "status": status
        }

        if contract:
            body.update({"contract": contract})
        if order_type:
            body.update({"order_type": order_type})
        if start_time:
            body.update({"start_time": start_time})
        if end_time:
            body.update({"end_time": end_time})
        if direct:
            body.update({"direct": direct})
        if from_id:
            body.update({"from_id": from_id})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_contract_matchresults(self, symbol, trade_type, start_time=None, end_time=None, direct=None, from_id=None):

        uri = "/api/v3/contract_matchresults"
        body = {
            "symbol": symbol,
            "trade_type": trade_type
        }

        if start_time:
            body.update({"start_time": start_time})
        if end_time:
            body.update({"end_time": end_time})
        if direct:
            body.update({"direct": direct})
        if from_id:
            body.update({"from_id": from_id})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_contract_matchresults_exact(self, symbol, contract, trade_type, start_time=None, end_time=None, direct=None, from_id=None):

        uri = "/api/v3/contract_matchresults_exact"
        body = {
            "symbol": symbol,
            "contract": contract,
            "trade_type": trade_type
        }

        if start_time:
            body.update({"start_time": start_time})
        if end_time:
            body.update({"end_time": end_time})
        if direct:
            body.update({"direct": direct})
        if from_id:
            body.update({"from_id": from_id})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def lightning_close_position(self, symbol, contract_type, contract_code, volume, direction, client_order_id, \
                                       order_price_type):
        """ Close position.

        Args:
            symbol: string.  eg: 'BTC'
            contract_type: string. eg: 'this_week'\'next_week'\'quarter'
            contract_code: string. eg: 'BTC190903'
            volume: int. eg: 1
            direction: string. eg: 'buy' or 'sell'
            client_order_id: int. eg: 11
            order_price_type: string. eg: "lightning"\"lightning_fok"\"lightning_ioc"

        Returns:
            https://docs.huobigroup.com/docs/dm/v1/cn/#669c2a2e3d

        """
        uri = "/api/v1/lightning_close_position"
        body = {
            "volume": volume,
            "direction": direction,
        }

        if symbol:
            body.update({"symbol": symbol})

        if contract_type:
            body.update({"contract_type": contract_type})

        if contract_code:
            body.update({"contract_code": contract_code})

        if client_order_id:
            body.update({"client_order_id": client_order_id})

        if order_price_type:
            body.update({"order_price_type": order_price_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
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