import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_future.restapi.rest_account_coin_future import HuobiCoinFutureRestAccountAPI
from tests.config import config

sys.path.append('..')


class TestRestAccountCoinFuture(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinFutureRestAccountAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_get_contract_balance_valuation(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_balance_valuation())
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

    def test_set_contract_sub_auth(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.set_contract_sub_auth("123456", 1))
        print(result)
        loop.close()

    def test_get_contract_sub_auth_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_sub_auth_list())
        print(result)
        loop.close()

    def test_get_contract_sub_account_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_sub_account_list())
        print(result)
        loop.close()

    def test_get_contract_sub_account_info_list(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_sub_account_info_list())
        print(result)
        loop.close()

    def test_get_contract_sub_account_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_sub_account_info(123456))
        print(result)
        loop.close()

    def test_get_contract_sub_position_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_sub_position_info(123456789))
        print(result)
        loop.close()

    def test_get_contract_financial_record(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_financial_record("3,4,5,6,7,8", "BTC"))
        print(result)
        loop.close()

    def test_get_contract_financial_record_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_financial_record_exact("3,4,5,6,7,8", "BTC"))
        print(result)
        loop.close()

    def test_get_contract_user_settlement_records(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_user_settlement_records("BTC"))
        print(result)
        loop.close()

    def test_get_contract_order_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_order_limit("limit"))
        print(result)
        loop.close()

    def test_get_contract_fee(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_fee())
        print(result)
        loop.close()

    def test_get_contract_transfer_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_transfer_limit())
        print(result)
        loop.close()

    def test_get_contract_position_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_position_limit())
        print(result)
        loop.close()

    def test_get_account_position(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_account_position("btc"))
        print(result)
        loop.close()

    def test_get_contract_master_sub_transfer(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_master_sub_transfer("123456789", "BTC", "123",
                                                      "master_to_sub"))
        print(result)
        loop.close()

    def test_get_contract_master_sub_transfer_record(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_master_sub_transfer_record("BTC-USDT", 30))
        print(result)
        loop.close()

    def test_get_api_trading_status(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_api_trading_status())
        print(result)
        loop.close()

    def test_get_contract_available_level_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_available_level_rate())
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
