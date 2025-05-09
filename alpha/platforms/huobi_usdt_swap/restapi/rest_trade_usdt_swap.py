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

__all__ = ("HuobiUsdtSwapRestTradeAPI",)


class HuobiUsdtSwapRestTradeAPI:
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

    async def linear_cancel_after(self, on_off, time_out=None):

        uri = "/linear-swap-api/v1/linear-cancel-after"
        body = {
            "on_off": on_off
        }

        if time_out:
            body.update({"time_out": time_out})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_switch_position_mode(self, margin_account, position_mode):

        uri = "/linear-swap-api/v1/swap_switch_position_mode"
        body = {
            "margin_account": margin_account,
            "position_mode": position_mode
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def create_order(self, volume, direction, lever_rate, order_price_type, contract_code=None, reduce_only=None,
                           client_order_id=None, price=None, offset=None, tp_trigger_price=None, tp_order_price=None,
                           tp_order_price_type=None, sl_trigger_price=None, sl_order_price=None,
                           sl_order_price_type=None):
        """ Create an new order.

        Args:
            contract_code: such as "BTC-USDT".
            price: Order price.
            quantity: Order amount.
            direction: Transaction direction, `buy` / `sell`.
            offset: `open` / `close`.
            lever_rate: Leverage rate, 10 or 20.
            order_price_type: Order type, `limit` - limit order, `opponent` - market order.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_order"
        body = {
            "volume": volume,
            "direction": direction,
            "lever_rate": lever_rate,
            "order_price_type": order_price_type
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if reduce_only:
            body.update({"reduce_only": reduce_only})
        if client_order_id:
            body.update({"client_order_id": client_order_id})
        if price:
            body.update({"price": price})
        if offset:
            body.update({"offset": offset})
        if tp_trigger_price:
            body.update({"tp_trigger_price": tp_trigger_price})
        if tp_order_price:
            body.update({"tp_order_price": tp_order_price})
        if tp_order_price_type:
            body.update({"tp_order_price_type": tp_order_price_type})
        if sl_trigger_price:
            body.update({"sl_trigger_price": sl_trigger_price})
        if sl_order_price:
            body.update({"sl_order_price": sl_order_price})
        if sl_order_price_type:
            body.update({"sl_order_price_type": sl_order_price_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def create_orders(self, orders_data):
        """ Batch Create orders.
            {
              "orders_data": [
                {
                  "contract_code": "btc-usdt",
                  "direction": "sell",
                  "offset": "open",
                  "price": "29999",
                  "lever_rate": 5,
                  "volume": 1,
                  "order_price_type": "opponent",
                  "tp_trigger_price": 27000,
                  "tp_order_price": 27000,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": "30100",
                  "sl_order_price": "30100",
                  "sl_order_price_type": "optimal_5"
                },
                {
                  "contract_code": "btc-usdt",
                  "direction": "buy",
                  "offset": "open",
                  "price": "29999",
                  "lever_rate": 5,
                  "volume": 1,
                  "order_price_type": "post_only",
                  "tp_trigger_price": 31000,
                  "tp_order_price": 31000,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": "29100",
                  "sl_order_price": "29100",
                  "sl_order_price_type": "optimal_5"
                }
              ]
            }
        """
        uri = "/linear-swap-api/v1/swap_batchorder"
        body = orders_data
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def revoke_order(self, contract_code, order_id=None, client_order_id=None):
        """ Revoke an order.

        Args:
            contract_code: such as "BTC-USDT".
            order_id: Order ID.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_cancel"
        body = {
            "contract_code": contract_code
        }
        if order_id:
            body["order_id"] = order_id
        if client_order_id:
            body["client_order_id"] = client_order_id

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def revoke_order_all(self, contract_code, direction=None, offset=None):
        """ Revoke all orders.

        Args:
            contract_code: such as "BTC-USDT".

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.

        * NOTE: 1. If input `contract_code`, only matching this contract code.
                2. If not input `contract_code`, matching by `symbol + contract_type`.
        """
        uri = "/linear-swap-api/v1/swap_cancelall"
        body = {
            "contract_code": contract_code,
        }

        if direction:
            body["direction"] = direction
        if offset:
            body["offset"] = offset

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_switch_lever_rate(self, contract_code, lever_rate):

        uri = "/linear-swap-api/v1/swap_switch_lever_rate"
        body = {
            "contract_code": contract_code,
            "lever_rate": lever_rate
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_order_info(self, contract_code, order_ids=None, client_order_ids=None):
        """ Get order information.

        Args:
            contract_code: such as "BTC-USDT".
            order_ids: Order ID list. (different IDs are separated by ",", maximum 20 orders can be requested at one time.)
            client_order_ids: Client Order ID list. (different IDs are separated by ",", maximum 20 orders can be requested at one time.)

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_order_info"
        body = {
            "contract_code": contract_code
        }

        if order_ids:
            body.update({"order_id": ",".join(order_ids)})
        if client_order_ids:
            body.update({"client_order_id": ",".join(client_order_ids)})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_order_detail(self, contract_code, order_id, created_at=None, order_type=None, page_index=1,
                               page_size=20):
        """ Get Order Detail

        Args:
            contract_code: such as "BTC-USDT"
            order_id: order id.
            created_at: create timestamp.
            order_type: order type, 1. Quotation; 2. Cancelled order; 3. Forced liquidation; 4. Delivery Order
            page_index: page idnex. 1 default.
            page_size: page size. 20 default. 50 max.
        Note:
            When getting information on order cancellation via query order detail interface,
            users who type in parameters “created_at” and “order_type” can query last 24-hour data,
            while users who don’t type in parameters “created_at” and “order_type” can only query last 12-hour data.
            created_at should use timestamp of long type as 13 bits (include Millisecond),
            if send the accurate timestamp for "created_at", query performance will be improved.
            eg. the timestamp "2019/10/18 10:26:22" can be changed：1571365582123.It can also directly
            obtain the timestamp（ts) from the returned ordering interface(swap_order) to query the corresponding
            orders.
        """
        uri = "/linear-swap-api/v1/swap_order_detail"
        body = {
            "contract_code": contract_code,
            "order_id": order_id,
            "page_index": page_index,
            "page_size": page_size
        }
        if created_at:
            body.update({"created_at": created_at})
        if order_type:
            body.update({"order_type": order_type})
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_open_orders(self, contract_code, index=1, size=50, sort_by="created_at", trade_type=0):
        """ Get open order information.

        Args:
            contract_code: such as "BTC-USDT".
            index: Page index, default 1st page.
            size: Page size, Default 20，no more than 50.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_openorders"
        body = {
            "contract_code": contract_code,
            "page_index": index,
            "page_size": size,
            "sort_by": sort_by,
            "trade_type": trade_type
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_hisorders(self, trade_type, type, status, contract=None, start_time=None, end_time=None,
                                 direct=None, from_id=None):

        uri = "/linear-swap-api/v3/swap_hisorders"
        body = {
            "trade_type": trade_type,
            "type": type,
            "status": status
        }

        if contract:
            body.update({"contract": contract})
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

    async def get_swap_hisorders_exact(self, trade_type, type, status, contract=None, pair=None, start_time=None,
                                       end_time=None, direct=None, from_id=None, price_type=None):

        uri = "/linear-swap-api/v3/swap_hisorders_exact"
        body = {
            "trade_type": trade_type,
            "type": type,
            "status": status
        }

        if contract:
            body.update({"contract": contract})
        if pair:
            body.update({"pair": pair})
        if start_time:
            body.update({"start_time": start_time})
        if end_time:
            body.update({"end_time": end_time})
        if direct:
            body.update({"direct": direct})
        if from_id:
            body.update({"from_id": from_id})
        if price_type:
            body.update({"price_type": price_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_matchresults(self, trade_type, contract=None, pair=None, start_time=None,
                                    end_time=None, direct=None, from_id=None):

        uri = "/linear-swap-api/v3/swap_matchresults"
        body = {
            "trade_type": trade_type
        }

        if contract:
            body.update({"contract": contract})
        if pair:
            body.update({"pair": pair})
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

    async def get_swap_matchresults_exact(self, contract, trade_type, start_time=None,
                                          end_time=None, direct=None, from_id=None):

        uri = "/linear-swap-api/v3/swap_matchresults_exact"
        body = {
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

    async def swap_lightning_close_position(self, contract_code, direction, client_order_id=None,
                                            order_price_type=None):

        uri = "/linear-swap-api/v1/swap_lightning_close_position"
        body = {
            "contract_code": contract_code,
            "direction": direction
        }

        if client_order_id:
            body.update({"client_order_id": client_order_id})
        if order_price_type:
            body.update({"order_price_type": order_price_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_position_side(self, margin_account):

        uri = "/linear-swap-api/v1/swap_position_side"
        params = {
            "margin_account": margin_account
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def swap_trade_order(self, contract_code, margin_mode, position_side, side, type, price_match,
                                            client_order_id, price, volume, reduce_only, time_in_force, tp_trigger_price,
                                            tp_order_price, tp_type, tp_trigger_price_type, sl_trigger_price, sl_order_price,
                                            sl_type, sl_trigger_price_type, price_protect, trigger_protect):

        uri = "/v5/trade/order"
        body = {
            "contract_code": contract_code,
            "margin_mode": margin_mode,
            "position_side": position_side,
            "side": side,
            "type": type,
            "price_match": price_match,
            "client_order_id": client_order_id,
            "price": price,
            "volume": volume,
            "reduce_only": reduce_only,
            "time_in_force": time_in_force,
            "tp_trigger_price": tp_trigger_price,
            "tp_order_price": tp_order_price,
            "tp_trigger_price_type": tp_trigger_price_type,
            "sl_trigger_price": sl_trigger_price,
            "sl_order_price": sl_order_price,
            "sl_type": sl_type,
            "tp_type": tp_type,
            "sl_trigger_price_type": sl_trigger_price_type
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_batchorder(self, contract_code, margin_mode, position_side, side, type, price_match,
                                            client_order_id, price, volume, reduce_only, time_in_force, tp_trigger_price,
                                            tp_order_price, tp_type, tp_trigger_price_type, sl_trigger_price, sl_order_price,
                                            sl_type, sl_trigger_price_type):

        uri = "/v5/trade/batch_orders"
        body = {
            "contract_code": contract_code,
            "margin_mode": margin_mode,
            "position_side": position_side,
            "side": side,
            "type": type,
            "price_match": price_match,
            "client_order_id": client_order_id,
            "price": price,
            "volume": volume,
            "reduce_only": reduce_only,
            "time_in_force": time_in_force,
            "tp_trigger_price": tp_trigger_price,
            "tp_order_price": tp_order_price,
            "tp_trigger_price_type": tp_trigger_price_type,
            "sl_trigger_price": sl_trigger_price,
            "sl_order_price": sl_order_price,
            "sl_type": sl_type,
            "tp_type": tp_type,
            "sl_trigger_price_type": sl_trigger_price_type
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_cancel_order(self, contract_code, order_id, client_order_id):

        uri = "/v5/trade/cancel_order"
        body = {
            "contract_code": contract_code,
            "order_id": order_id,
            "client_order_id": client_order_id
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_cancel_batchOrders(self, contract_code, order_id, client_order_id, price_protect, trigger_protect):

        uri = "/v5/trade/cancel_batch_orders"
        body = {
            "contract_code": contract_code,
            "order_id": order_id,
            "client_order_id": client_order_id
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_cancel_allOrders(self, contract_code, side, position_side):

        uri = "/v5/trade/cancel_all_orders"
        body = {
            "contract_code": contract_code,
            "side": side,
            "position_side": position_side
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_position(self, contract_code, margin_mode, position_side, client_order_id):

        uri = "/v5/trade/position"
        body = {
            "contract_code": contract_code,
            "margin_mode": margin_mode,
            "position_side": position_side,
            "client_order_id": client_order_id
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_positionAll(self):

        uri = "/v5/trade/position_all"
        body = {
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_porder_opens(self, contract_code, side, margin_mode, order_id, client_order_id, from_, limit,
                                      direct):

        uri = "/v5/trade/positionAll"
        body = {
            "contract_code": contract_code,
            "side": side,
            "margin_mode": margin_mode,
            "order_id": order_id,
            "client_order_id": client_order_id,
            "from": from_,
            "limit": limit,
            "direct": direct,
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_order_trades(self, contract_code, order_id, client_order_id, start_time, end_time, from_, limit, direct):

        uri = "/api/V5/trade/order/details"
        params = {
            "contract_code": contract_code,
            "order_id": order_id,
            "client_order_id": client_order_id,
            "start_time": start_time,
            "end_time": end_time,
            "from_": from_,
            "limit": limit,
            "direct": direct
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def swap_trade_order_history(self, contract_code, state, type, price_match,
                                       start_time, end_time, from_, limit, direct, business_type, margin_mode):

        uri = "/api/v5/trade/order/history"
        params = {
            "contract_code": contract_code,
            "start_time": start_time,
            "end_time": end_time,
            "from_": from_,
            "limit": limit,
            "state": state,
            "type": type,
            "price_match": price_match,
            "direct": direct,
            "margin_mode": margin_mode,
            "business_type": business_type
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def swap_trade_position_opens(self, contract_code):

        uri = "/api/v5/trade/order/history"
        params = {
            "contract_code": contract_code
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def swap_trade_position_history(self, contract_code, contract_type, margin_mode,
                                       start_time, end_time, from_, limit, direct):

        uri = "/v5/trade/position/history"
        params = {
            "contract_code": contract_code,
            "contract_type": contract_type,
            "margin_mode": margin_mode,
            "start_time": start_time,
            "end_time": end_time,
            "from": from_,
            "limit": limit,
            "direct": direct
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def swap_trade_position_lever(self, contract_code, margin_mode):

        uri = "/v5/position/lever"
        params = {
            "contract_code": contract_code,
            "margin_mode": margin_mode
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def swap_position_lever(self, contract_code, margin_mode, lever_rate):

        uri = "/v5/position/lever"
        body = {
            "contract_code": contract_code,
            "margin_mode": margin_mode,
            "lever_rate": lever_rate
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trade_position_mode(self):

        uri = "/api/v5/position/mode"
        params = {
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def swap_trade_position_riskLimit(self, contract_code, margin_mode, position_side):

        uri = "/v5/position/riskLimit"
        params = {
            "contract_code": contract_code,
            "margin_mode": margin_mode,
            "position_side": position_side
        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def get_trade_order(self, contract_code, margin_mode, order_id, client_order_id):

        uri = "/v5/trade/order"
        params = {
            "contract_code": contract_code,
            "order_id": order_id,
            "client_order_id": client_order_id,
            "margin_mode": margin_mode
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