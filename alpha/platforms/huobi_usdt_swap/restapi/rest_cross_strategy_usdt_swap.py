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
__all__ = ("HuobiUsdtSwapRestCrossStrategyAPI",)


class HuobiUsdtSwapRestCrossStrategyAPI:
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

    async def swap_cross_trigger_order(self, trigger_type, trigger_price, volume, direction, contract_code=None,
                                       reduce_only=None, order_price=None, order_price_type=None, offset=None,
                                       lever_rate=None):

        uri = "/linear-swap-api/v1/swap_cross_trigger_order"
        body = {
            "trigger_type": trigger_type,
            "trigger_price": trigger_price,
            "volume": volume,
            "direction": direction
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if reduce_only:
            body.update({"reduce_only": reduce_only})
        if order_price:
            body.update({"order_price": order_price})
        if order_price_type:
            body.update({"order_price_type": order_price_type})
        if offset:
            body.update({"offset": offset})
        if lever_rate:
            body.update({"lever_rate": lever_rate})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_trigger_cancel(self, order_id, contract_code=None, pair=None, contract_type=None):

        uri = "/linear-swap-api/v1/swap_cross_trigger_cancel"
        body = {
            "order_id": order_id
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_trigger_cancelall(self, contract_code=None, pair=None, contract_type=None, direction=None,
                                           offset=None):

        uri = "/linear-swap-api/v1/swap_cross_trigger_cancelall"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})
        if direction:
            body.update({"direction": direction})
        if offset:
            body.update({"offset": offset})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_trigger_openorders(self, contract_code=None, pair=None, page_index=None, page_size=None,
                                                trade_type=None):

        uri = "/linear-swap-api/v1/swap_cross_trigger_openorders"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if trade_type:
            body.update({"trade_type": trade_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_trigger_hisorders(self, trade_type, status, create_date, contract_code=None, pair=None,
                                               page_index=None, page_size=None, sort_by=None):

        uri = "/linear-swap-api/v1/swap_cross_trigger_hisorders"
        body = {
            "trade_type": trade_type,
            "status": status,
            "create_date": create_date
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if sort_by:
            body.update({"sort_by": sort_by})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_tpsl_order(self, direction, volume, contract_code=None, pair=None, contract_type=None,
                                    tp_trigger_price=None, tp_order_price=None, tp_order_price_type=None,
                                    sl_trigger_price=None, sl_order_price=None, sl_order_price_type=None):

        uri = "/linear-swap-api/v1/swap_cross_tpsl_order"
        body = {
            "direction": direction,
            "volume": volume
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})
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

    async def swap_cross_tpsl_cancel(self, order_id, contract_code=None, pair=None, contract_type=None):

        uri = "/linear-swap-api/v1/swap_cross_tpsl_cancel"
        body = {
            "order_id": order_id
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_tpsl_cancelall(self, contract_code=None, pair=None, contract_type=None, direction=None):

        uri = "/linear-swap-api/v1/swap_cross_tpsl_cancelall"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})
        if direction:
            body.update({"direction": direction})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_tpsl_openorders(self, contract_code=None, pair=None, page_index=None, page_size=None,
                                             trade_type=None):

        uri = "/linear-swap-api/v1/swap_cross_tpsl_openorders"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if trade_type:
            body.update({"trade_type": trade_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_tpsl_hisorders(self, status, create_date, contract_code=None, pair=None, page_index=None,
                                            page_size=None, sort_by=None):

        uri = "/linear-swap-api/v1/swap_cross_tpsl_hisorders"
        body = {
            "status": status,
            "create_date": create_date
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if sort_by:
            body.update({"sort_by": sort_by})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_relation_tpsl_order(self, order_id, contract_code=None, pair=None):

        uri = "/linear-swap-api/v1/swap_cross_relation_tpsl_order"
        body = {
            "order_id": order_id
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_track_order(self, direction, volume, callback_rate, active_price, order_price_type,
                                     contract_code=None, pair=None, contract_type=None, reduce_only=None,
                                     lever_rate=None):

        uri = "/linear-swap-api/v1/swap_cross_track_order"
        body = {
            "direction": direction,
            "volume": volume,
            "callback_rate": callback_rate,
            "active_price": active_price,
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
        if lever_rate:
            body.update({"lever_rate": lever_rate})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_track_cancel(self, order_id, contract_code=None, pair=None, contract_type=None):

        uri = "/linear-swap-api/v1/swap_cross_track_cancel"
        body = {
            "order_id": order_id
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_track_cancelall(self, contract_code=None, pair=None, contract_type=None, direction=None,
                                         offset=None):

        uri = "/linear-swap-api/v1/swap_cross_track_cancelall"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})
        if direction:
            body.update({"direction": direction})
        if offset:
            body.update({"offset": offset})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_cross_track_openorders(self, contract_code=None, pair=None, trade_type=None, page_index=None,
                                              page_size=None):

        uri = "/linear-swap-api/v1/swap_cross_track_openorders"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if trade_type:
            body.update({"trade_type": trade_type})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_cross_track_hisorders(self, status, trade_type, create_date, contract_code=None, pair=None,
                                         page_index=None, page_size=None, sort_by=None):

        uri = "/linear-swap-api/v1/swap_cross_track_hisorders"
        body = {
            "status": status,
            "trade_type": trade_type,
            "create_date": create_date
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if sort_by:
            body.update({"sort_by": sort_by})

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