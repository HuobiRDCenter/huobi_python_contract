import json

from alpha.utils.http_utils import get


class RestCrossReferenceUsdtSwap:
    def __init__(self, host=None):
        if host is None:
            host = "api.hbdm.com"
        self.host = host

    def swap_cross_ladder_margin(self, params: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_ladder_margin"
        return get(self.host, path, params)

    def swap_cross_adjustfactor(self, params: dict = None) -> json:
        path = "/linear-swap-api/v1/swap_cross_adjustfactor"
        return get(self.host, path, params)
