import json

from alpha.utils.http_utils import get


class RestMarketCoinSwap:
    def __init__(self, host=None):
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def depth(self, params: dict = None) -> json:
        path = "/swap-ex/market/depth"
        return get(self.host, path, params)

    def bbo(self, params: dict = None) -> json:
        path = "/swap-ex/market/bbo"
        return get(self.host, path, params)

    def kline(self, params: dict = None) -> json:
        path = "/swap-ex/market/history/kline"
        return get(self.host, path, params)

    def mark_price_kline(self, params: dict = None) -> json:
        path = "/index/market/history/swap_mark_price_kline"
        return get(self.host, path, params)

    def merged(self, params: dict = None) -> json:
        path = "/swap-ex/market/detail/merged"
        return get(self.host, path, params)

    def batch_merged(self, params: dict = None) -> json:
        path = "/v2/swap-ex/market/detail/batch_merged"
        return get(self.host, path, params)

    def trade(self, params: dict = None) -> json:
        path = "/swap-ex/market/trade"
        return get(self.host, path, params)

    def history_trade(self, params: dict = None) -> json:
        path = "/swap-ex/market/history/trade"
        return get(self.host, path, params)

    def swap_premium_index_kline(self, params: dict = None) -> json:
        path = "/index/market/history/swap_premium_index_kline"
        return get(self.host, path, params)

    def swap_estimated_rate_kline(self, params: dict = None) -> json:
        path = "/index/market/history/swap_estimated_rate_kline"
        return get(self.host, path, params)

    def swap_basis(self, params: dict = None) -> json:
        path = "/index/market/history/swap_basis"
        return get(self.host, path, params)
