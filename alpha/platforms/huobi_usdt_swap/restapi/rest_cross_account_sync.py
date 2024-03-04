import json

from alpha.utils.http_utils import post


class RestCrossAccountUsdtSwap:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def swap_cross_account_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_account_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_position_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_account_position_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_account_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_sub_account_list(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_sub_account_list"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_sub_account_info_list(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_sub_account_info_list"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_sub_account_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_sub_account_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_sub_position_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_sub_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_available_level_rate(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_available_level_rate"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_transfer_limit(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_transfer_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_position_limit(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_position_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_cross_lever_position_limit(self, data: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_lever_position_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)
