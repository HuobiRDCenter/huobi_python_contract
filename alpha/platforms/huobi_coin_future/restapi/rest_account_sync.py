import json

from alpha.utils.http_utils import post, get_url_suffix, get


class RestAccountCoinFuture:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def contract_balance_valuation(self, data: dict = None) -> json:
        path = "/api/v1/contract_balance_valuation"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_account_info(self, data: dict = None) -> json:
        path = "/api/v1/contract_account_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_position_info(self, data: dict = None) -> json:
        path = "/api/v1/contract_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_sub_auth(self, data: dict = None) -> json:
        path = "/api/v1/contract_sub_auth"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_sub_auth_list(self, data: dict = None) -> json:
        path = "/api/v1/contract_sub_auth_list"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_sub_account_list(self, data: dict = None) -> json:
        path = "/api/v1/contract_sub_account_list"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_sub_account_info_list(self, data: dict = None) -> json:
        path = "/api/v1/contract_sub_account_info_list"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_sub_account_info(self, data: dict = None) -> json:
        path = "/api/v1/contract_sub_account_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_sub_position_info(self, data: dict = None) -> json:
        path = "/api/v1/contract_sub_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_financial_record(self, data: dict = None) -> json:
        path = "/api/v3/contract_financial_record"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_financial_record_exact(self, data: dict = None) -> json:
        path = "/api/v3/contract_financial_record_exact"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_user_settlement_records(self, data: dict = None) -> json:
        path = "/api/v1/contract_user_settlement_records"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_order_limit(self, data: dict = None) -> json:
        path = "/api/v1/contract_order_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_fee(self, data: dict = None) -> json:
        path = "/api/v1/contract_fee"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_transfer_limit(self, data: dict = None) -> json:
        path = "/api/v1/contract_transfer_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_position_limit(self, data: dict = None) -> json:
        path = "/api/v1/contract_position_limit"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_account_position_info(self, data: dict = None) -> json:
        path = "/api/v1/contract_account_position_info"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_master_sub_transfer(self, data: dict = None) -> json:
        path = "/api/v1/contract_master_sub_transfer"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_master_sub_transfer_record(self, data: dict = None) -> json:
        path = "/api/v1/contract_master_sub_transfer_record"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_api_trading_status(self, params: dict = None) -> json:
        path = "/api/v1/contract_api_trading_status"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_available_level_rate(self, data: dict = None) -> json:
        path = "/api/v1/contract_available_level_rate"
        return post(self.access_key, self.secret_key, self.host, path, data)
