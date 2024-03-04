import json

from alpha.utils.http_utils import get


class RestReferenceCoinSwap:
    def __init__(self, host=None):
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def swap_risk_info(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_risk_info"
        return get(self.host, path, params)

    def swap_insurance_fund(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_insurance_fund"
        return get(self.host, path, params)

    def swap_adjustfactor(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_adjustfactor"
        return get(self.host, path, params)

    def swap_his_open_interest(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_his_open_interest"
        return get(self.host, path, params)

    def swap_ladder_margin(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_ladder_margin"
        return get(self.host, path, params)

    def swap_elite_account_ratio(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_elite_account_ratio"
        return get(self.host, path, params)

    def swap_elite_position_ratio(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_elite_position_ratio"
        return get(self.host, path, params)

    def swap_estimated_settlement_price(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_estimated_settlement_price"
        return get(self.host, path, params)

    def swap_api_state(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_api_state"
        return get(self.host, path, params)

    def swap_funding_rate(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_funding_rate"
        return get(self.host, path, params)

    def swap_batch_funding_rate(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_batch_funding_rate"
        return get(self.host, path, params)

    def swap_historical_funding_rate(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_historical_funding_rate"
        return get(self.host, path, params)

    def swap_liquidation_orders(self, params: dict = None) -> json:
        path = "/swap-api/v3/swap_liquidation_orders"
        return get(self.host, path, params)

    def swap_settlement_records(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_settlement_records"
        return get(self.host, path, params)

    def swap_contract_info(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_contract_info"
        return get(self.host, path, params)

    def swap_index(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_index"
        return get(self.host, path, params)

    def swap_query_elements(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_query_elements"
        return get(self.host, path, params)

    def swap_price_limit(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_price_limit"
        return get(self.host, path, params)

    def swap_open_interest(self, params: dict = None) -> json:
        path = "/swap-api/v1/swap_open_interest"
        return get(self.host, path, params)

    def timestamp(self, params: dict = None) -> json:
        path = "/api/v1/timestamp"
        return get(self.host, path, params)

    def heartbeat(self, params: dict = None) -> json:
        path = "/heartbeat/"
        return get(self.host, path, params)

    def summary(self, params: dict = None) -> json:
        path = "https://status-swap.huobigroup.com/api/v2/summary.json"
        return get(self.host, path, params)
