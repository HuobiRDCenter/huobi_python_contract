import json

from alpha.utils.http_utils import post, get_url_suffix, get


class RestCopyTradingSync:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def contract_copytrading_trader_place_order(self, data: dict = None) -> json:
        path = "/copytrading/trader/place_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_query_contract_lever(self, params: dict = None) -> json:
        path = "/copytrading/trader/query_contract_lever"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_updated_contract_lever(self, data: dict = None) -> json:
        path = "/copytrading/trader/updated_contract_lever"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_close_order(self, data: dict = None) -> json:
        path = "/copytrading/trader/close_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_close_all_position(self, data: dict = None) -> json:
        path = "/copytrading/trader/close_all_position"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_add_margin(self, data: dict = None) -> json:
        path = "/copytrading/trader/add_margin"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_position_list(self, params: dict = None) -> json:
        path = "/copytrading/trader/position_list"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_account_transfer(self, data: dict = None) -> json:
        path = "/copytrading/trader/account_transfer"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_current_positions(self, params: dict = None) -> json:
        path = "/copytrading/trader/current_positions"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_position_positions(self, params: dict = None) -> json:
        path = "/copytrading/trader/position_positions"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_tpsl_order(self, data: dict = None) -> json:
        path = "/copytrading/trader/tpsl_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_query_contract(self, params: dict = None) -> json:
        path = "/copytrading/trader/query_contract"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_order_total_detail(self, params: dict = None) -> json:
        path = "/copytrading/trader/order_total_detail"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_profit_history_details(self, params: dict = None) -> json:
        path = "/copytrading/trader/profit_history_details"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_total_profit_history(self, params: dict = None) -> json:
        path = "/copytrading/trader/total_profit_history"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_query_followers(self, params: dict = None) -> json:
        path = "/copytrading/trader/query_followers"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_remove_follower(self, data: dict = None) -> json:
        path = "/copytrading/trader/remove_follower"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_open_orders(self, params: dict = None) -> json:
        path = "/copytrading/trader/open_orders"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_tpsl_open_orders(self, params: dict = None) -> json:
        path = "/copytrading/trader/tpsl_open_orders"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)