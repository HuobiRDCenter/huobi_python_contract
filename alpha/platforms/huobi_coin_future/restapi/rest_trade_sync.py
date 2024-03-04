import json

from alpha.utils.http_utils import post


class RestTradeCoinFuture:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def contract_cancel_after(self, data: dict = None) -> json:
        path = "/api/v1/contract-cancel-after"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_order(self, data: dict = None) -> json:
        path = "/api/v1/contract_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_batchorder(self, data: dict = None) -> json:
        path = "/api/v1/contract_batchorder"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_cancel(self, data: dict = None) -> json:
        path = "/api/v1/contract_cancel"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_cancelall(self, data: dict = None) -> json:
        path = "/api/v1/contract_cancelall"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_switch_lever_rate(self, data: dict = None) -> json:
        path = "/api/v1/contract_switch_lever_rate"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_order_info(self, data: dict = None) -> json:
        path = "/api/v1/contract_order_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_order_detail(self, data: dict = None) -> json:
        path = "/api/v1/contract_order_detail"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_openorders(self, data: dict = None) -> json:
        path = "/api/v1/contract_openorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_hisorders(self, data: dict = None) -> json:
        path = "/api/v3/contract_hisorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_hisorders_exact(self, data: dict = None) -> json:
        path = "/api/v3/contract_hisorders_exact"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_matchresults(self, data: dict = None) -> json:
        path = "/api/v3/contract_matchresults"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_matchresults_exact(self, data: dict = None) -> json:
        path = "/api/v3/contract_matchresults_exact"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def lightning_close_position(self, data: dict = None) -> json:
        path = "/api/v1/lightning_close_position"
        return post(self.access_key, self.secret_key, self.host, path, data)
