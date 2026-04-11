import json

from alpha.utils.http_utils import post, get_url_suffix, get

class RestAlgoOrderUsdtSwap:

    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def algo_order(self, data: dict = None) -> dict:
        """创建策略订单"""
        path = "/v5/algo/order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def cancel_algo_orders(self, data: dict = None) -> dict:
        """取消策略订单"""
        path = "/v5/algo/cancel-orders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def query_algo_order(self, params: dict = None) -> dict:
        """查询策略订单"""
        path = "/v5/algo/order"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def query_open_algo_orders(self, params: dict = None) -> dict:
        """查询未触发策略订单"""
        path = "/v5/algo/order/opens"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def query_algo_order_history(self, params: dict = None) -> dict:
        """查询历史策略订单"""
        path = "/v5/algo/order/history"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)