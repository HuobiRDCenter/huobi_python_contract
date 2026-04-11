import json

from alpha.utils.http_utils import post, get_url_suffix, get

class RestCopyTradingTradeSync:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def contract_copytrading_trader_instruments(self, params: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/instruments"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)
    
    def contract_copytrading_trader_statistics(self, params: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/statistics"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_profit_sharing_history(self, params: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/profit-sharing-history"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_profit_sharing_history_summary(self, params: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/profit-sharing-history-summary"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)
    
    def contract_copytrading_trader_unrealized_profit_sharing_summary(self, params: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/unrealized-profit-sharing-summary"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)
    
    def contract_copytrading_trader_followers(self, params: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/followers"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_follower(self, data: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/follower"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_transfer(self, data: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/transfer"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_copytrading_trader_follower_settings(self, data: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/follower-settings"
        return post(self.access_key, self.secret_key, self.host, path, data)
    
    def contract_copytrading_trader_config(self, params: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/config"
        path = "{}?{}".format(path, get_url_suffix('get', self.access_key, self.secret_key, self.host, path))
        return get(self.host, path, params)

    def contract_copytrading_trader_apikey(self, data: dict = None) -> json:
        path = "/api/v6/copyTrading/trader/apikey"
        return post(self.access_key, self.secret_key, self.host, path, data)

