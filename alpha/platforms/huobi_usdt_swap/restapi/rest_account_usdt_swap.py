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
__all__ = ("HuobiUsdtSwapRestAccountAPI",)


class HuobiUsdtSwapRestAccountAPI:
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

    async def get_swap_balance_valuation(self, valuation_asset=None):

        uri = "/linear-swap-api/v1/swap_balance_valuation"
        body = {

        }

        if valuation_asset:
            body.update({"valuation_asset": valuation_asset})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_asset_info(self, contract_code=None):
        """ Get account asset information.

        Args:
            contract_code: such as "BTC-USDT".

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_account_info"
        body = {}
        if contract_code:
            body["contract_code"] = contract_code
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_position(self, contract_code=None):
        """ Get position information.

        Args:
            contract_code: such as "BTC-USDT".

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_position_info"
        body = {}
        if contract_code:
            body["contract_code"] = contract_code
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_account_position(self, contract_code):
        """ Get position and account information.

        Args:
            contract_code: Currency name, e.g. BTC-USDT.

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-api/v1/swap_account_position_info"
        body = {"contract_code": contract_code}
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_sub_auth(self, sub_uid, sub_auth):

        uri = "/linear-swap-api/v1/swap_sub_auth"
        body = {
            "sub_uid": sub_uid,
            "sub_auth": sub_auth
        }

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_sub_auth_list(self, sub_uid=None, start_time=None, end_time=None, direct=None, from_id=None):

        uri = "/linear-swap-api/v1/swap_sub_auth_list"
        params = {

        }
        if sub_uid:
            params["sub_uid"] = sub_uid
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if direct:
            params["direct"] = direct
        if from_id:
            params["from_id"] = from_id

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def get_swap_sub_account_list(self, contract_code=None, direct=None, from_id=None):

        uri = "/linear-swap-api/v1/swap_sub_account_list"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if direct:
            body.update({"direct": direct})
        if from_id:
            body.update({"from_id": from_id})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_sub_account_info_list(self, contract_code=None, page_index=None, page_size=None):

        uri = "/linear-swap-api/v1/swap_sub_account_info_list"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_sub_account_info(self, sub_uid, contract_code=None):

        uri = "/linear-swap-api/v1/swap_sub_account_info"
        body = {
            "sub_uid": sub_uid
        }

        if contract_code:
            body.update({"contract_code": contract_code})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_sub_position_info(self, sub_uid, contract_code=None):

        uri = "/linear-swap-api/v1/swap_sub_position_info"
        body = {
            "sub_uid": sub_uid
        }

        if contract_code:
            body.update({"contract_code": contract_code})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_financial_record(self, mar_acct, contract=None, type=None, start_time=None, end_time=None,
                                        direct=None, from_id=None):

        uri = "/linear-swap-api/v3/swap_financial_record"
        body = {
            "mar_acct": mar_acct
        }

        if contract:
            body.update({"contract": contract})
        if type:
            body.update({"type": type})
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

    async def get_swap_available_level_rate(self, contract_code=None):

        uri = "/linear-swap-api/v1/swap_available_level_rate"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_order_limit(self, order_price_type, contract_code=None, pair=None, contract_type=None,
                                   business_type=None):

        uri = "/linear-swap-api/v1/swap_order_limit"
        body = {
            "order_price_type": order_price_type
        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})
        if business_type:
            body.update({"business_type": business_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_fee(self, contract_code=None, pair=None, contract_type=None, business_type=None):

        uri = "/linear-swap-api/v1/swap_fee"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if pair:
            body.update({"pair": pair})
        if contract_type:
            body.update({"contract_type": contract_type})
        if business_type:
            body.update({"business_type": business_type})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_transfer_limit(self, contract_code=None):

        uri = "/linear-swap-api/v1/swap_transfer_limit"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_position_limit(self, contract_code=None):

        uri = "/linear-swap-api/v1/swap_position_limit"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_lever_position_limit(self, contract_code=None, lever_rate=None):

        uri = "/linear-swap-api/v1/swap_lever_position_limit"
        body = {

        }

        if contract_code:
            body.update({"contract_code": contract_code})
        if lever_rate:
            body.update({"lever_rate": lever_rate})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def swap_master_sub_transfer(self, sub_uid, asset, from_margin_account, to_margin_account, amount, type,
                                       client_order_id=None):

        uri = "/linear-swap-api/v1/swap_master_sub_transfer"
        body = {
            "sub_uid": sub_uid,
            "asset": asset,
            "from_margin_account": from_margin_account,
            "to_margin_account": to_margin_account,
            "amount": amount,
            "type": type
        }

        if client_order_id:
            body.update({"client_order_id": client_order_id})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_master_sub_transfer_record(self, margin_account, create_date, transfer_type=None,
                                                  page_index=None,
                                                  page_size=None):

        uri = "/linear-swap-api/v1/swap_master_sub_transfer_record"
        body = {
            "margin_account": margin_account,
            "create_date": create_date
        }

        if transfer_type:
            body.update({"transfer_type": transfer_type})
        if page_index:
            body.update({"page_index": page_index})
        if page_size:
            body.update({"page_size": page_size})

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def transfer_inner(self, asset, from_, to, amount, client_order_id=None):
        """ Do transfer under the same account
        Args:
            asset: such as USDT
            from_: from_margin_account.such as BTC-USDT
            to: to_margin_account.such as BTC-USDT
            amount: transfer amount.
        """
        uri = "/linear-swap-api/v1/swap_transfer_inner"
        body = {
            "asset": asset,
            "from_margin_account": from_,
            "to_margin_account": to,
            "amount": amount
        }

        if client_order_id:
            body["client_order_id"] = client_order_id

        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_api_trading_status(self):

        uri = "/linear-swap-api/v1/swap_api_trading_status"
        params = {

        }

        success, error = await self.request("GET", uri, params=params, auth=True)
        return success, error

    async def get_swap_multi_assets_margin(self, assets_mode):
        uri = "/v5/account/multi_assets_margin"
        body = {
            "assets_mode": assets_mode
        }
        success, error = await self.request("POST", uri, body=body, auth=True)
        return success, error

    async def get_swap_api_account_balance(self):
        uri = "/v5/account/balance"
        params = {}
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
