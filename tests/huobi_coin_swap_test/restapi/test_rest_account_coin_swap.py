import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_swap.restapi.rest_account_coin_swap import HuobiCoinSwapRestAccountAPI
from tests.config import config

sys.path.append('..')


class TestRestAccountCoinSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinSwapRestAccountAPI(config["host"], config["access_key"], config["secret_key"])

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
            self.api.get_account_position("BTC-USD"))
        print(result)
        loop.close()

    def test_swap_sub_auth(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_sub_auth("BTC-USD", 321456))
        print(result)
        loop.close()

    def test_get_swap_sub_account_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_sub_account_list())
        print(result)
        loop.close()

    def test_swap_sub_account_info_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_sub_account_info_list())
        print(result)
        loop.close()

    def test_get_swap_sub_account_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_sub_account_info(123456))
        print(result)
        loop.close()

    def test_get_swap_sub_position_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_sub_position_info(123456789))
        print(result)
        loop.close()

    def test_get_swap_financial_record(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_financial_record("BTC-USD"))
        print(result)
        loop.close()

    def test_get_swap_financial_record_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_financial_record_exact("BTC-USD"))
        print(result)
        loop.close()

    def test_get_swap_user_settlement_records(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_user_settlement_records("BTC-USD"))
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

    def test_swap_master_sub_transfer(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_master_sub_transfer("123", "BTC-USD", 100, "master_to_sub"))
        print(result)
        loop.close()

    def test_get_swap_master_sub_transfer_record(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_master_sub_transfer_record("BTC-USDT", 30))
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
