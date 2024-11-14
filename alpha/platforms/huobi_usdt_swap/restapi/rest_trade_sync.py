import json

from alpha.utils.http_utils import post, get_url_suffix, get


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

    def swap_trade_order(self, data: dict = None) -> json:
        path = "/v5/trade/order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_batchorder(self, data: dict = None) -> json:
        path = "/v5/trade/batchorder"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_cancel_order(self, data: dict = None) -> json:
        path = "/v5/trade/order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_cancel_batchOrders(self, data: dict = None) -> json:
        path = "/v5/trade/batchOrders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_cancel_allOrders(self, data: dict = None) -> json:
        path = "/v5/trade/allOrders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_position(self, data: dict = None) -> json:
        path = "/v5/trade/position"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_positionAll(self, data: dict = None) -> json:
        path = "/v5/trade/positionAll"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_porder_opens(self, data: dict = None) -> json:
        path = "/v5/trade/order/opens"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_order_trades(self, params: dict = None) -> json:
        path = "/api/v5/trade/order/trades"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_trade_order_history(self, params: dict = None) -> json:
        path = "/api/v5/trade/order/history"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_trade_position_opens(self, params: dict = None) -> json:
        path = "/v5/trade/position/opens"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_trade_position_history(self, params: dict = None) -> json:
        path = "/v5/trade/position/history"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_trade_position_lever(self, params: dict = None) -> json:
        path = "/v5/position/lever"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_position_lever(self, data: dict = None) -> json:
        path = "/v5/position/lever"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_trade_position_mode(self, params: dict = None) -> json:
        path = "/api/v5/position/mode"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_trade_position_riskLimit(self, params: dict = None) -> json:
        path = "/v5/position/riskLimit"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)