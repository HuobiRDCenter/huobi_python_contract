import json

from alpha.utils.http_utils import post, get_url_suffix, get


class RestCrossTradeUsdtSwap:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def swap_cross_trade_state(self, params: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_trade_state"
        return get(self.host, path, params)

    def swap_cross_switch_position_mode(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_switch_position_mode"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_order(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_batchorder(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_batchorder"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_cancel(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_cancel"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_cancelall(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_cancelall"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_switch_lever_rate(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_switch_lever_rate"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_order_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_order_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_order_detail(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_order_detail"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_openorders(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_openorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_hisorders(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_cross_hisorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_hisorders_exact(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_cross_hisorders_exact"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_matchresults(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_cross_matchresults"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_matchresults_exact(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_cross_matchresults_exact"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_lightning_close_position(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_lightning_close_position"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_position_side(self, params: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_position_side"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)
