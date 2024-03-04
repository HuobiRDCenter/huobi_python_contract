import json

from alpha.utils.http_utils import post


class RestStrategyCoinFuture:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def contract_trigger_order(self, data: dict = None) -> json:
        path = "/api/v1/contract_trigger_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_trigger_cancel(self, data: dict = None) -> json:
        path = "/api/v1/contract_trigger_cancel"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_trigger_cancelall(self, data: dict = None) -> json:
        path = "/api/v1/contract_trigger_cancelall"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_trigger_openorders(self, data: dict = None) -> json:
        path = "/api/v1/contract_trigger_openorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_trigger_hisorders(self, data: dict = None) -> json:
        path = "/api/v1/contract_trigger_hisorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_tpsl_order(self, data: dict = None) -> json:
        path = "/api/v1/contract_tpsl_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_tpsl_cancel(self, data: dict = None) -> json:
        path = "/api/v1/contract_tpsl_cancel"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_tpsl_cancelall(self, data: dict = None) -> json:
        path = "/api/v1/contract_tpsl_cancelall"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_tpsl_openorders(self, data: dict = None) -> json:
        path = "/api/v1/contract_tpsl_openorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_tpsl_hisorders(self, data: dict = None) -> json:
        path = "/api/v1/contract_tpsl_hisorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_relation_tpsl_order(self, data: dict = None) -> json:
        path = "/api/v1/contract_relation_tpsl_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_track_order(self, data: dict = None) -> json:
        path = "/api/v1/contract_track_order"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_track_cancel(self, data: dict = None) -> json:
        path = "/api/v1/contract_track_cancel"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_track_cancelall(self, data: dict = None) -> json:
        path = "/api/v1/contract_track_cancelall"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_track_openorders(self, data: dict = None) -> json:
        path = "/api/v1/contract_track_openorders"
        return post(self.access_key, self.secret_key, self.host, path, data)

    def contract_track_hisorders(self, data: dict = None) -> json:
        path = "/api/v1/contract_track_hisorders"
        return post(self.access_key, self.secret_key, self.host, path, data)
