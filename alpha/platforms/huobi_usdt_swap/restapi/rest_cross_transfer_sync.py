import json

from alpha.utils.http_utils import get


class RestCrossTransferUsdtSwap:
    def __init__(self, access_key: str, secret_key: str, host: str = None):
        self.access_key = access_key
        self.secret_key = secret_key
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def swap_cross_transfer_state(self, params: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_transfer_state"
        return get(self.host, path, params)

