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

__all__ = ("HuobiUsdtSwapRestStrategyAPI",)


class HuobiUsdtSwapRestStrategyAPI:
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

    async def swap_trigger_order(self, contract_code, trigger_type, trigger_price, volume, direction,
                                 reduce_only=None, order_price=None, order_price_type=None, offset=None,
                                 lever_rate=None):

        uri = "/linear-swap-api/v1/swap_trigger_order"
        body = {
            "contract_code": contract_code,
            "trigger_type": trigger_type,
            "trigger_price": trigger_price,
            "volume": volume,
            "direction": direction
        }

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

    async def swap_trigger_cancel(self, contract_code, order_id):

        uri = "/linear-swap-api/v1/swap_trigger_cancel"
        body = {
            "contract_code": contract_code,
            "order_id": order_id
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_trigger_cancelall(self, contract_code, direction=None, offset=None):

        uri = "/linear-swap-api/v1/swap_trigger_cancelall"
        body = {
            "contract_code": contract_code
        }

        if direction:
            body.update({"direction": direction})
        if offset:
            body.update({"offset": offset})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_trigger_openorders(self, contract_code, page_index=None, page_size=None, trade_type=None):

        uri = "/linear-swap-api/v1/swap_trigger_openorders"
        body = {
            "contract_code": contract_code
        }

        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if trade_type:
            body.update({"trade_type": trade_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_trigger_hisorders(self, contract_code, trade_type, status, create_date, page_index=None,
                                         page_size=None, sort_by=None):

        uri = "/linear-swap-api/v1/swap_trigger_hisorders"
        body = {
            "contract_code": contract_code,
            "trade_type": trade_type,
            "status": status,
            "create_date": create_date
        }

        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if sort_by:
            body.update({"sort_by": sort_by})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_tpsl_order(self, contract_code, direction, volume, tp_trigger_price=None, tp_order_price=None,
                              tp_order_price_type=None, sl_trigger_price=None, sl_order_price=None,
                              sl_order_price_type=None):

        uri = "/linear-swap-api/v1/swap_tpsl_order"
        body = {
            "contract_code": contract_code,
            "direction": direction,
            "volume": volume
        }

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

    async def swap_tpsl_cancel(self, contract_code, order_id):

        uri = "/linear-swap-api/v1/swap_tpsl_cancel"
        body = {
            "contract_code": contract_code,
            "order_id": order_id
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_tpsl_cancelall(self, contract_code, direction=None):

        uri = "/linear-swap-api/v1/swap_tpsl_cancelall"
        body = {
            "contract_code": contract_code
        }

        if direction:
            body.update({"direction": direction})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_tpsl_openorders(self, contract_code, page_index=None, page_size=None, trade_type=None):

        uri = "/linear-swap-api/v1/swap_tpsl_openorders"
        body = {
            "contract_code": contract_code
        }

        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if trade_type:
            body.update({"trade_type": trade_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_tpsl_hisorders(self, contract_code, status, create_date, page_index=None, page_size=None,
                                      sort_by=None):

        uri = "/linear-swap-api/v1/swap_tpsl_hisorders"
        body = {
            "contract_code": contract_code,
            "status": status,
            "create_date": create_date
        }

        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})
        if sort_by:
            body.update({"sort_by": sort_by})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_relation_tpsl_order(self, contract_code, order_id):

        uri = "/linear-swap-api/v1/swap_relation_tpsl_order"
        body = {
            "contract_code": contract_code,
            "order_id": order_id
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_track_order(self, contract_code, direction, volume, callback_rate, active_price, order_price_type,
                               reduce_only=None, offset=None, lever_rate=None):

        uri = "/linear-swap-api/v1/swap_track_order"
        body = {
            "contract_code": contract_code,
            "direction": direction,
            "volume": volume,
            "callback_rate": callback_rate,
            "active_price": active_price,
            "order_price_type": order_price_type
        }

        if reduce_only:
            body.update({"reduce_only": reduce_only})
        if offset:
            body.update({"offset": offset})
        if lever_rate:
            body.update({"lever_rate": lever_rate})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_track_cancel(self, contract_code, order_id):

        uri = "/linear-swap-api/v1/swap_track_cancel"
        body = {
            "contract_code": contract_code,
            "order_id": order_id
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_track_cancelall(self, contract_code, direction=None, offset=None):

        uri = "/linear-swap-api/v1/swap_track_cancelall"
        body = {
            "contract_code": contract_code
        }

        if direction:
            body.update({"direction": direction})
        if offset:
            body.update({"offset": offset})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_track_openorders(self, contract_code, trade_type=None, page_index=None, page_size=None):

        uri = "/linear-swap-api/v1/swap_track_openorders"
        body = {
            "contract_code": contract_code
        }

        if trade_type:
            body.update({"trade_type": trade_type})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_track_hisorders(self, contract_code, status, trade_type, create_date, page_index=None, page_size=None,
                                   sort_by=None):

        uri = "/linear-swap-api/v1/swap_track_hisorders"
        body = {
            "contract_code": contract_code,
            "status": status,
            "trade_type": trade_type,
            "create_date": create_date
        }

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