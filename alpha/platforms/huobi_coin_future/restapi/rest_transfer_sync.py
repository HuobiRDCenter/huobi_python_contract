import json

from alpha.utils.http_utils import post


class RestTransferCoinFuture:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.huobi.pro"
        self.host = host

    def futures_transfer(self, data: dict = None) -> json:
        path = "/v1/futures/transfer"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def account_transfer(self, data: dict = None) -> json:
        path = "/v2/account/transfer"
        return post(self.access_key, self.secret_key, self.host, path, data)
