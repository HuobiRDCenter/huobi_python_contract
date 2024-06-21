import json

from alpha.utils.http_utils import post


class RestUnifiedAccountUsdtSwap:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def swap_unified_account_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/unified_account_info"
        return get(self.access_key, self.secret_key, self.host, path, data)

    def swap_linear_swap_overview_account_info(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/linear_swap_overview_account_info"
        return get(self.access_key, self.secret_key, self.host, path, data)

    def swap_linear_swap_fee_switch(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/linear_swap_fee_switch"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_fix_position_margin_change(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/fix_position_margin_change"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_fix_position_margin_change_record(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/fix_position_margin_change_record"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def swap_swap_unified_account_type(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_unified_account_type"
        return get(self.access_key, self.secret_key, self.host, path, data)

    def swap_swap_switch_account_type(self, data: dict = None) -> json:
        path = "/linear-swap-api/v3/swap_switch_account_type"
        return post(self.access_key, self.secret_key, self.host, path, data)

