import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_cross_account_usdt_swap import HuobiUsdtSwapRestCrossAccountAPI
from tests.config import config

sys.path.append('..')


class TestRestCrossAccountUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestCrossAccountAPI(config["host"], config["access_key"], config["secret_key"])

    def test_get_asset_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_asset_info())
        print(result)
        loop.close()

    def test_get_position(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_position())
        print(result)
        loop.close()

    def test_get_account_position(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_account_position("USDT"))
        print(result)
        loop.close()

    def test_get_swap_cross_sub_account_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_sub_account_list())
        print(result)
        loop.close()

    def test_get_swap_cross_sub_account_info_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_sub_account_info_list())
        print(result)
        loop.close()

    def test_get_swap_cross_sub_account_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_sub_account_info(123456, "USDT"))
        print(result)
        loop.close()

    def test_get_swap_cross_sub_position_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_sub_position_info(123456, "BTC-USDT", "BTC-USDT",
                                                      "swap"))
        print(result)
        loop.close()

    def test_get_swap_cross_available_level_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_available_level_rate())
        print(result)
        loop.close()

    def test_get_swap_cross_transfer_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_transfer_limit())
        print(result)
        loop.close()

    def test_get_swap_cross_position_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_position_limit())
        print(result)
        loop.close()

    def test_get_swap_cross_lever_position_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_lever_position_limit())
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
