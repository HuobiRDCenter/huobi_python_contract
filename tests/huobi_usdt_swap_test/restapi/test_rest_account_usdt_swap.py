import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_account_usdt_swap import HuobiUsdtSwapRestAccountAPI
from tests.config import config

sys.path.append('..')


class TestRestAccountUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestAccountAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_get_swap_balance_valuation(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_balance_valuation())
        print(result)
        loop.close()

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
            self.api.get_account_position("BTC-USDT"))
        print(result)
        loop.close()

    def test_swap_sub_auth(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_sub_auth("123456", 1))
        print(result)
        loop.close()

    def test_get_swap_sub_auth_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_sub_auth_list())
        print(result)
        loop.close()

    def test_get_swap_sub_account_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_sub_account_list())
        print(result)
        loop.close()

    def test_get_swap_sub_account_info_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_sub_account_info_list())
        print(result)
        loop.close()

    def test_get_swap_sub_account_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_sub_account_info(123456, "BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_sub_position_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_sub_position_info(123456, "BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_financial_record(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_financial_record("USDT"))
        print(result)
        loop.close()

    def test_get_swap_available_level_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_available_level_rate())
        print(result)
        loop.close()

    def test_get_swap_order_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_order_limit("limit"))
        print(result)
        loop.close()

    def test_get_swap_fee(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_fee())
        print(result)
        loop.close()

    def test_get_swap_transfer_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_transfer_limit())
        print(result)
        loop.close()

    def test_get_swap_position_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_position_limit())
        print(result)
        loop.close()

    def test_get_swap_lever_position_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_lever_position_limit())
        print(result)
        loop.close()

    def test_swap_master_sub_transfer(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_master_sub_transfer(123456, "USDT", "BTC-USDT",
                                              "USDT", 20, "master_to_sub",
                                              456321))
        print(result)
        loop.close()

    def test_get_swap_master_sub_transfer_record(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_master_sub_transfer_record("BTC-USDT", 30))
        print(result)
        loop.close()

    def test_transfer_inner(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.transfer_inner("USDT", "BTC-USDT", "ETH-USDT", 10, 456321))
        print(result)
        loop.close()

    def test_get_swap_api_trading_status(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_api_trading_status())
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
