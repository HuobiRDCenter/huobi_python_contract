import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_future.restapi.rest_reference_coin_future import HuobiCoinFutureRestReferenceAPI
from tests.config import config

sys.path.append('..')


class TestRestReferenceCoinFuture(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinFutureRestReferenceAPI(config["host"], config["access_key"], config["secret_key"])

    def test_get_contract_risk_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_risk_info())
        print(result)
        loop.close()

    def test_get_contract_insurance_fund(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_insurance_fund("ETH"))
        print(result)
        loop.close()

    def test_get_contract_adjustfactor(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_adjustfactor())
        print(result)
        loop.close()

    def test_get_contract_his_open_interest(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_his_open_interest("BTC", "this_week", "60min", 1))
        print(result)
        loop.close()

    def test_get_contract_ladder_margin(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_ladder_margin())
        print(result)
        loop.close()

    def test_get_contract_elite_account_ratio(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_elite_account_ratio("BTC", "60min"))
        print(result)
        loop.close()

    def test_get_contract_elite_position_ratio(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_elite_position_ratio("BTC", "60min"))
        print(result)
        loop.close()

    def test_get_contract_liquidation_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_liquidation_orders("BTC", 5))
        print(result)
        loop.close()

    def test_get_contract_settlement_records(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_settlement_records("BTC"))
        print(result)
        loop.close()

    def test_gget_price_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_price_limit())
        print(result)
        loop.close()

    def test_get_contract_open_interest(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_open_interest())
        print(result)
        loop.close()

    def test_get_contract_delivery_price(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_delivery_price("BTC"))
        print(result)
        loop.close()

    def test_get_contract_estimated_settlement_price(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_estimated_settlement_price())
        print(result)
        loop.close()

    def test_get_contract_api_state(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_api_state())
        print(result)
        loop.close()

    def test_get_contract_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_info())
        print(result)
        loop.close()

    def test_get_contract_index(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_index())
        print(result)
        loop.close()

    def test_get_contract_query_elements(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_query_elements())
        print(result)
        loop.close()

    def test_get_timestamp(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_timestamp())
        print(result)
        loop.close()

    def test_get_heartbeat(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_heartbeat())
        print(result)
        loop.close()

    def test_get_summary(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_summary())
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
