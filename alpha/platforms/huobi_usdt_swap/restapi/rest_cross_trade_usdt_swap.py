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
__all__ = ("HuobiUsdtSwapRestCrossTradeAPI",)


class HuobiUsdtSwapRestCrossTradeAPI:
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

    async def get_swap_cross_trade_state(self, contract_code=None, pair=None, contract_type=None, business_type=None):

        uri = "/linear-swap-api/v1/swap_cross_trade_state"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code
        if pair:
            params["pair"] = pair
        if contract_type:
            params["contract_type"] = contract_type
        if business_type:
            params["business_type"] = business_type

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def swap_cross_switch_position_mode(self, margin_account, position_mode):

        uri = "/linear-swap-api/v1/swap_cross_switch_position_mode"
        body = {
            "margin_account": margin_account,
            "position_mode": position_mode
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def create_order(self, volume, direction, lever_rate, order_price_type, contract_code=None, pair=None,
                           contract_type=None, reduce_only=None, client_order_id=None, price=None, offset=None,
                           tp_trigger_price=None, tp_order_price=None, tp_order_price_type=None, sl_trigger_price=None,
                           sl_order_price=None, sl_order_price_type=None):
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
        uri = "/linear-swap-api/v1/swap_cross_order"
        body = {
            "volume": volume,
            "direction": direction,
            "lever_rate": lever_rate,
            "order_price_type": order_price_type
        }
        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})
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
        uri = "/linear-swap-api/v1/swap_cross_batchorder"
        body = orders_data
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def revoke_order(self, contract_code, order_id=None, client_order_id=None, pair=None, contract_type=None):
        """ Revoke an order.

        Args:
            contract_code: such as "BTC-USDT".
            order_id: Order ID.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_cross_cancel"
        body = {
            "contract_code": contract_code
        }
        if order_id:
            body["order_id"] = order_id
        if client_order_id:
            body["client_order_id"] = client_order_id
        if pair:
            body["pair"] = pair
        if contract_type:
            body["contract_type"] = contract_type

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def revoke_orders(self, contract_code, order_ids=None, client_order_ids=None, pair=None, contract_type=None):
        """ Revoke multiple orders.

        Args:
            contract_code: such as "BTC-USDT".
            order_ids: Order ID list.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_cross_cancel"
        body = {
            "contract_code": contract_code
        }
        if order_ids:
            body["order_id"] = ",".join(order_ids)
        if client_order_ids:
            body["client_order_id"] = ",".join(client_order_ids)
        if pair:
            body["pair"] = pair
        if contract_type:
            body["contract_type"] = contract_type

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def revoke_order_all(self, contract_code, pair=None, contract_type=None, direction=None, offset=None):
        """ Revoke all orders.

        Args:
            contract_code: such as "BTC-USDT".

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.

        * NOTE: 1. If input `contract_code`, only matching this contract code.
                2. If not input `contract_code`, matching by `symbol + contract_type`.
        """
        uri = "/linear-swap-api/v1/swap_cross_cancelall"
        body = {
            "contract_code": contract_code,
        }
        if pair:
            body["pair"] = pair
        if contract_type:
            body["contract_type"] = contract_type
        if direction:
            body["direction"] = direction
        if offset:
            body["offset"] = offset
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_switch_lever_rate(self, lever_rate, contract_code=None, pair=None, contract_type=None):

        uri = "/linear-swap-api/v1/swap_cross_switch_lever_rate"
        body = {
            "lever_rate": lever_rate
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_order_info(self, contract_code, order_ids=None, client_order_ids=None, pair=None):
        """ Get order information.

        Args:
            contract_code: such as "BTC-USDT".
            order_ids: Order ID list. (different IDs are separated by ",", maximum 20 orders can be requested at one time.)
            client_order_ids: Client Order ID list. (different IDs are separated by ",", maximum 20 orders can be requested at one time.)

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_cross_order_info"
        body = {
            "contract_code": contract_code
        }

        if order_ids:
            body.update({"order_id": ",".join(order_ids)})
        if client_order_ids:
            body.update({"client_order_id": ",".join(client_order_ids)})
        if pair:
            body["pair"] = pair

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_order_detail(self, contract_code, order_id, created_at=None, order_type=None, page_index=1,
                               page_size=20, pair=None):
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
        uri = "/linear-swap-api/v1/swap_cross_order_detail"
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
        if pair:
            body["pair"] = pair
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_open_orders(self, contract_code, index=1, size=50, pair=None, sort_by=None, trade_type=None):
        """ Get open order information.

        Args:
            contract_code: such as "BTC-USDT".
            index: Page index, default 1st page.
            size: Page size, Default 20，no more than 50.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_cross_openorders"
        body = {
            "contract_code": contract_code,
            "page_index": index,
            "page_size": size
        }
        if pair:
            body["pair"] = pair
        if sort_by:
            body["sort_by"] = sort_by
        if trade_type:
            body["trade_type"] = trade_type
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_hisorders(self, trade_type, type, status, contract=None, pair=None, start_time=None, end_time=None,
                                 direct=None, from_id=None):

        uri = "/linear-swap-api/v3/swap_cross_hisorders"
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

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_hisorders_exact(self, trade_type, type, status, contract=None, pair=None, start_time=None,
                                       end_time=None,direct=None, from_id=None, price_type=None):

        uri = "/linear-swap-api/v3/swap_cross_hisorders_exact"
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

    async def get_swap_cross_matchresults(self, contract, trade_type, pair=None, start_time=None,
                                    end_time=None, direct=None, from_id=None):

        uri = "/linear-swap-api/v3/swap_cross_matchresults"
        body = {
            "contract": contract,
            "trade_type": trade_type
        }

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

    async def get_swap_cross_matchresults_exact(self, contract, trade_type, pair=None, start_time=None,
                                    end_time=None, direct=None, from_id=None):

        uri = "/linear-swap-api/v3/swap_cross_matchresults_exact"
        body = {
            "contract": contract,
            "trade_type": trade_type
        }

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

    async def swap_cross_lightning_close_position(self, direction, contract_code=None, pair=None, contract_type=None,
                                                client_order_id=None, order_price_type=None):

        uri = "/linear-swap-api/v1/swap_cross_lightning_close_position"
        body = {
            "direction": direction
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})
        if client_order_id:
            body.update({"client_order_id": client_order_id})
        if order_price_type:
            body.update({"order_price_type": order_price_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_position_side(self, margin_account):

        uri = "/linear-swap-api/v1/swap_cross_position_side"
        params = {
            "margin_account": margin_account
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