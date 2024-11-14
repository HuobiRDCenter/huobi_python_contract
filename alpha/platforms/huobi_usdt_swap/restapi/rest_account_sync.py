import json

from alpha.utils.http_utils import post, get_url_suffix, get


class RestAccountUsdtSwap:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def swap_balance_valuation(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_balance_valuation"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_account_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_account_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_position_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_account_position_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_account_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_sub_auth(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_sub_auth"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_sub_auth_list(self, params: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_sub_auth_list"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_sub_account_list(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_sub_account_list"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_sub_account_info_list(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_sub_account_info_list"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_sub_account_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_sub_account_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_sub_position_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_sub_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_financial_record(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_financial_record"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_available_level_rate(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_available_level_rate"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_order_limit(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_order_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_fee(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_fee"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_transfer_limit(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_transfer_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_position_limit(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_position_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_lever_position_limit(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_lever_position_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_master_sub_transfer(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_master_sub_transfer"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_master_sub_transfer_record(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_master_sub_transfer_record"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_transfer_inner(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_transfer_inner"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_api_trading_status(self, params: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_api_trading_status"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_api_account_balance(self, params: dict = None) -> json:
        path = "/v5/account/balance"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def swap_multi_assets_margin(self, data: dict = None) -> json:
        path = "/v5/account/multi_assets_margin"
        return post(self.access_key, self.secret_key, self.host, path, data)
