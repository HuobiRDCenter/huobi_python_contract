import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_cross_reference_usdt_swap import HuobiUsdtSwapRestCrossReferenceAPI
from tests.config import config

sys.path.append('..')


class TestRestCrossReferenceUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestCrossReferenceAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_get_swap_cross_ladder_margin(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_ladder_margin())
        print(result)
        loop.close()

    def test_get_swap_cross_adjustfactor(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_adjustfactor())
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
