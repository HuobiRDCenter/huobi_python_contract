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

__all__ = ("HuobiUsdtSwapRestMarketAPI",)


class HuobiUsdtSwapRestMarketAPI:
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

    async def get_orderbook(self, contract_code, type="step0"):
        """ Get orderbook information.

        Args:
            contract_code:  such as "BTC-USDT".

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-ex/market/depth"
        params = {
            "contract_code": contract_code,
            "type": type
        }
        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_market_bbo(self, contract_code=None, business_type=None):

        uri = "/linear-swap-ex/market/bbo"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code
        if business_type:
            params["business_type"] = business_type

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_klines(self, contract_code, period, size=None, sfrom=None, to=None):
        """ Get kline information.

        Args:
            contract_code:  such as "BTC-USDT".
            period: 1min, 5min, 15min, 30min, 60min,4hour,1day, 1mon
            size: [1,2000]

        Returns:
            success: Success results, otherwise it's None.
            error: Error information, otherwise it's None.
        """
        uri = "/linear-swap-ex/market/history/kline"
        params = {
            "contract_code": contract_code,
            "period": period
        }
        if size:
            params["size"] = size
        if sfrom:
            params["from"] = sfrom
        if to:
            params["to"] = to
        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_linear_swap_mark_price_kline(self, contract_code, period, size):

        uri = "/index/market/history/linear_swap_mark_price_kline"
        params = {
            "contract_code": contract_code,
            "period": period,
            "size": size
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_merged_data(self, contract_code):
        """ Get Merged Data.

        Args:
            contract_code: such as "BTC-USDT"

        Returns:
            success: Success results.
            error: Error information.
        """
        uri = "/linear-swap-ex/market/detail/merged"
        params = {
            "contract_code": contract_code
        }
        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_batch_merged(self, contract_code=None, business_type=None):

        uri = "/v2/linear-swap-ex/market/detail/batch_merged"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code
        if business_type:
            params["business_type"] = business_type

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_market_trade(self, contract_code=None, business_type=None):

        uri = "/linear-swap-ex/market/trade"
        params = {

        }
        if contract_code:
            params["contract_code"] = contract_code
        if business_type:
            params["business_type"] = business_type

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_market_history_trade(self, contract_code, size):

        uri = "/linear-swap-ex/market/history/trade"
        params = {
            "contract_code": contract_code,
            "size": size
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_swap_his_open_interest(self, period, amount_type, contract_code=None, pair=None, contract_type=None,
                                         size=None):

        uri = "/linear-swap-api/v1/swap_his_open_interest"
        params = {
            "period": period,
            "amount_type": amount_type
        }
        if contract_code:
            params["contract_code"] = contract_code
        if pair:
            params["pair"] = pair
        if contract_type:
            params["contract_type"] = contract_type
        if size:
            params["size"] = size

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_linear_swap_premium_index_kline(self, contract_code, period, size):

        uri = "/index/market/history/linear_swap_premium_index_kline"
        params = {
            "contract_code": contract_code,
            "period": period,
            "size": size
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_linear_swap_estimated_rate_kline(self, contract_code, period, size):

        uri = "/index/market/history/linear_swap_estimated_rate_kline"
        params = {
            "contract_code": contract_code,
            "period": period,
            "size": size
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def get_linear_swap_basis(self, contract_code, period, size, basis_price_type=None):

        uri = "/index/market/history/linear_swap_basis"
        params = {
            "contract_code": contract_code,
            "period": period,
            "size": size
        }
        if basis_price_type:
            params["basis_price_type"] = basis_price_type

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def market_assets_deduction_currency(self):

        uri = "/v5/market/assets_deduction_currency"
        params = {
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error

    async def multi_assets_margin_list(self, multi_assets):

        uri = "/v5/market/multi_assets_margin"
        params = {
            "multi_assets": multi_assets
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error
    
    async def market_risk_limit(self, contract_code, contract_type, margin_mode, tier):

        uri = "/v5/market/risk/limit"
        params = {
            "contract_code": contract_code,
            "contract_type": contract_type,
            "margin_mode": margin_mode,
            "tier": tier
        }

        success, error = await self.request("GET", uri, params=params)
        return success, error
    
    async def get_funding_rate(self, contract_code: str):
        """查询资金费率"""
        uri = "/v5/market/funding_rate"
        params = {
            "contract_code": contract_code
        }

        success, error = await self.request("GET", uri, params=params, auth=False)
        return success, error

    async def get_funding_rate_history(self, 
                                      contract_code: str, 
                                      start_time: int = None, 
                                      end_time: int = None,
                                      from_page: int = None,
                                      limit: int = None,
                                      direct: str = None):
        """查询历史资金费率"""
        uri = "/v5/market/funding_rate_history"
        params = {
            "contract_code": contract_code
        }

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

        success, error = await self.request("GET", uri, params=params, auth=False)
        return success, error

    async def get_open_interest(self, contract_code: str):
        """查询持仓总量"""
        uri = "/v5/market/open_interest"
        params = {
            "contract_code": contract_code
        }

        success, error = await self.request("GET", uri, params=params, auth=False)
        return success, error

    async def get_price_limit(self):
        """查询价格限制"""
        uri = "/v5/market/price_limit"
        params = {}

        success, error = await self.request("GET", uri, params=params, auth=False)
        return success, error

    async def get_liquidation_orders(self, 
                                    contract_code: str = None, 
                                    pair: str = None,
                                    start_time: int = None,
                                    end_time: int = None,
                                    direct: str = None,
                                    from_page: int = None,
                                    limit: int = None):
        """查询强平订单"""
        uri = "/v5/market/liquidation_orders"
        params = {}

        if contract_code:
            params["contract_code"] = contract_code
        if pair:
            params["pair"] = pair
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if direct:
            params["direct"] = direct
        if from_page is not None:
            params["from"] = from_page
        if limit is not None:
            params["limit"] = limit

        success, error = await self.request("GET", uri, params=params, auth=False)
        return success, error

    async def get_settlement_history(self, 
                                    contract_code: str = None,
                                    start_time: int = None,
                                    end_time: int = None,
                                    direct: str = None,
                                    from_page: str = None,
                                    limit: int = None):
        """查询结算历史"""
        uri = "/v5/market/settlement_history"
        params = {}

        if contract_code:
            params["contract_code"] = contract_code
        if start_time:
            params["start_time"] = start_time
        if end_time:
            params["end_time"] = end_time
        if direct:
            params["direct"] = direct
        if from_page:
            params["from"] = from_page
        if limit is not None:
            params["limit"] = limit

        success, error = await self.request("GET", uri, params=params, auth=False)
        return success, error

    async def get_elite_account_ratio(self, contract_code: str, period: str = None):
        """查询精英账户多空持仓对比"""
        uri = "/v5/market/elite_account_ratio"
        params = {
            "contract_code": contract_code
        }

        if period:
            params["period"] = period

        success, error = await self.request("GET", uri, params=params, auth=False)
        return success, error

    async def get_elite_position_ratio(self, contract_code: str, period: str = None):
        """查询精英账户多空持仓对比(持仓数)"""
        uri = "/v5/market/elite_position_ratio"
        params = {
            "contract_code": contract_code
        }

        if period:
            params["period"] = period

        success, error = await self.request("GET", uri, params=params, auth=False)
        return success, error

    async def get_estimated_settlement_price(self, contract_code: str = None):
        """查询预估结算价"""
        uri = "/v5/market/estimated_settlement_price"
        params = {}

        if contract_code:
            params["contract_code"] = contract_code

        success, error = await self.request("GET", uri, params=params, auth=False)
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
