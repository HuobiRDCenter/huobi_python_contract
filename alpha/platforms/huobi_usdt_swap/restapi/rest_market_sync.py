import json

from alpha.utils.http_utils import get, get_url_suffix


class RestMarketUsdtSwap:
    def __init__(self, host=None):
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def depth(self, params: dict = None) -> json:
        path = "/linear-swap-ex/market/depth"
        return get(self.host, path, params)

    def bbo(self, params: dict = None) -> json:
        path = "/linear-swap-ex/market/bbo"
        return get(self.host, path, params)

    def kline(self, params: dict = None) -> json:
        path = "/linear-swap-ex/market/history/kline"
        return get(self.host, path, params)

    def mark_price_kline(self, params: dict = None) -> json:
        path = "/index/market/history/linear_swap_mark_price_kline"
        return get(self.host, path, params)

    def merged(self, params: dict = None) -> json:
        path = "/linear-swap-ex/market/detail/merged"
        return get(self.host, path, params)

    def batch_merged(self, params: dict = None) -> json:
        path = "/v2/linear-swap-ex/market/detail/batch_merged"
        return get(self.host, path, params)

    def trade(self, params: dict = None) -> json:
        path = "/linear-swap-ex/market/trade"
        return get(self.host, path, params)

    def history_trade(self, params: dict = None) -> json:
        path = "/linear-swap-ex/market/history/trade"
        return get(self.host, path, params)

    def swap_his_open_interest(self, params: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_his_open_interest"
        return get(self.host, path, params)

    def linear_swap_premium_index_kline(self, params: dict = None) -> json:
        path = "/index/market/history/linear_swap_premium_index_kline"
        return get(self.host, path, params)

    def linear_swap_estimated_rate_kline(self, params: dict = None) -> json:
        path = "/index/market/history/linear_swap_estimated_rate_kline"
        return get(self.host, path, params)

    def linear_swap_basis(self, params: dict = None) -> json:
        path = "/index/market/history/linear_swap_basis"
        return get(self.host, path, params)

    def market_assets_deduction_currency(self, params: dict = None) -> json:
        path = "/v5/market/assets_deduction_currency"
        return get(self.host, path, params)

    def multi_assets_margin_list(self, params: dict = None) -> json:
        path = "/v5/market/multi_assets_margin/list"
        return get(self.host, path, params)
    
    def market_risk_limit(self, params: dict = None) -> json:
        path = "/v5/market/risk/limit"
        return get(self.host, path, params)

    def market_funding_rate(self, params: dict = None) -> dict:
        """查询资金费率"""
        path = "/v5/market/funding_rate"
        return get(self.host, path, params)

    def market_funding_rate_history(self, params: dict = None) -> dict:
        """查询历史资金费率"""
        path = "/v5/market/funding_rate_history"
        return get(self.host, path, params)

    def market_open_interest(self, params: dict = None) -> dict:
        """查询持仓总量"""
        path = "/v5/market/open_interest"
        return get(self.host, path, params)

    def market_price_limit(self, params: dict = None) -> dict:
        """查询价格限制"""
        path = "/v5/market/price_limit"
        return get(self.host, path, params)

    def market_liquidation_orders(self, params: dict = None) -> dict:
        """查询强平订单"""
        path = "/v5/market/liquidation_orders"
        return get(self.host, path, params)

    def market_settlement_history(self, params: dict = None) -> dict:
        """查询结算历史"""
        path = "/v5/market/settlement_history"
        return get(self.host, path, params)

    def market_elite_account_ratio(self, params: dict = None) -> dict:
        """查询精英账户多空持仓对比"""
        path = "/v5/market/elite_account_ratio"
        return get(self.host, path, params)

    def market_elite_position_ratio(self, params: dict = None) -> dict:
        """查询精英账户多空持仓对比(持仓数)"""
        path = "/v5/market/elite_position_ratio"
        return get(self.host, path, params)

    def market_estimated_settlement_price(self, params: dict = None) -> dict:
        """查询预估结算价"""
        path = "/v5/market/estimated_settlement_price"
        return get(self.host, path, params)
