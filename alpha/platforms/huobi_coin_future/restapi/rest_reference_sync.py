import json

from alpha.utils.http_utils import get


class RestReferenceCoinFuture:
    def __init__(self, host=None):
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def contract_risk_info(self, params: dict = None) -> json:
        path = "/api/v1/contract_risk_info"
        return get(self.host, path, params)

    def contract_insurance_fund(self, params: dict = None) -> json:
        path = "/api/v1/contract_insurance_fund"
        return get(self.host, path, params)

    def contract_adjustfactor(self, params: dict = None) -> json:
        path = "/api/v1/contract_adjustfactor"
        return get(self.host, path, params)

    def contract_his_open_interest(self, params: dict = None) -> json:
        path = "/api/v1/contract_his_open_interest"
        return get(self.host, path, params)

    def contract_ladder_margin(self, params: dict = None) -> json:
        path = "/api/v1/contract_ladder_margin"
        return get(self.host, path, params)

    def contract_elite_account_ratio(self, params: dict = None) -> json:
        path = "/api/v1/contract_elite_account_ratio"
        return get(self.host, path, params)

    def contract_elite_position_ratio(self, params: dict = None) -> json:
        path = "/api/v1/contract_elite_position_ratio"
        return get(self.host, path, params)

    def contract_liquidation_orders(self, params: dict = None) -> json:
        path = "/api/v3/contract_liquidation_orders"
        return get(self.host, path, params)

    def contract_settlement_records(self, params: dict = None) -> json:
        path = "/api/v1/contract_settlement_records"
        return get(self.host, path, params)

    def contract_price_limit(self, params: dict = None) -> json:
        path = "/api/v1/contract_price_limit"
        return get(self.host, path, params)

    def contract_open_interest(self, params: dict = None) -> json:
        path = "/api/v1/contract_open_interest"
        return get(self.host, path, params)

    def contract_delivery_price(self, params: dict = None) -> json:
        path = "/api/v1/contract_delivery_price"
        return get(self.host, path, params)

    def contract_estimated_settlement_price(self, params: dict = None) -> json:
        path = "/api/v1/contract_estimated_settlement_price"
        return get(self.host, path, params)

    def contract_api_state(self, params: dict = None) -> json:
        path = "/api/v1/contract_api_state"
        return get(self.host, path, params)

    def contract_contract_info(self, params: dict = None) -> json:
        path = "/api/v1/contract_contract_info"
        return get(self.host, path, params)

    def contract_query_elements(self, params: dict = None) -> json:
        path = "/api/v1/contract_query_elements"
        return get(self.host, path, params)

    def timestamp(self, params: dict = None) -> json:
        path = "/api/v1/timestamp"
        return get(self.host, path, params)

    def heartbeat(self, params: dict = None) -> json:
        path = "/heartbeat/"
        return get(self.host, path, params)

    def summary(self, params: dict = None) -> json:
        path = "https://status-dm.huobigroup.com/api/v2/summary.json"
        return get(self.host, path, params)

    def contract_index(self, params: dict = None) -> json:
        path = "/api/v1/contract_index"
        return get(self.host, path, params)
