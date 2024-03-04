import json

from alpha.utils.http_utils import post


class RestTradeUsdtSwap:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def linear_cancel_after(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/linear-cancel-after"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_switch_position_mode(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_switch_position_mode"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_order(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_batchorder(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_batchorder"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cancel(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cancel"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cancelall(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cancelall"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_switch_lever_rate(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_switch_lever_rate"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_order_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_order_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_order_detail(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_order_detail"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_openorders(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_openorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_hisorders(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_hisorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_hisorders_exact(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_hisorders_exact"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_matchresults(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_matchresults"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_matchresults_exact(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_matchresults_exact"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_lightning_close_position(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_lightning_close_position"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_position_side(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_position_side"
        return post(self.access_key, self.secret_key, self.host, path, data)
