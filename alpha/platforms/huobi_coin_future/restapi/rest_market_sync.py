import json

from alpha.utils.http_utils import get


class RestMarketCoinFuture:
    def __init__(self, host=None):
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def depth(self, params: dict = None) -> json:
        path = "/market/depth"
        return get(self.host, path, params)

    def bbo(self, params: dict = None) -> json:
        path = "/market/bbo"
        return get(self.host, path, params)

    def kline(self, params: dict = None) -> json:
        path = "/market/history/kline"
        return get(self.host, path, params)

    def mark_price_kline(self, params: dict = None) -> json:
        path = "/index/market/history/mark_price_kline"
        return get(self.host, path, params)

    def merged(self, params: dict = None) -> json:
        path = "/market/detail/merged"
        return get(self.host, path, params)

    def batch_merged(self, params: dict = None) -> json:
        path = "/v2/market/detail/batch_merged"
        return get(self.host, path, params)

    def trade(self, params: dict = None) -> json:
        path = "/market/trade"
        return get(self.host, path, params)

    def history_trade(self, params: dict = None) -> json:
        path = "/market/history/trade"
        return get(self.host, path, params)

    def index(self, params: dict = None) -> json:
        path = "/index/market/history/index"
        return get(self.host, path, params)

    def basis(self, params: dict = None) -> json:
        path = "/index/market/history/basis"
        return get(self.host, path, params)