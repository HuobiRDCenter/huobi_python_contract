import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_reference_usdt_swap import HuobiUsdtSwapRestReferenceAPI
from tests.config import config

sys.path.append('..')


class TestRestReferenceUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestReferenceAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_get_swap_unified_account_type(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_unified_account_type())
        print(result)
        loop.close()

    def test_swap_switch_account_type(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_switch_account_type(1))
        print(result)
        loop.close()

    def test_get_swap_funding_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_funding_rate("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_batch_funding_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_batch_funding_rate())
        print(result)
        loop.close()

    def test_get_swap_historical_funding_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_historical_funding_rate("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_liquidation_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_liquidation_orders(5))
        print(result)
        loop.close()

    def test_get_swap_settlement_records(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_settlement_records("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_elite_account_ratio(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_elite_account_ratio("BTC-USDT", "5min"))
        print(result)
        loop.close()

    def test_get_swap_elite_position_ratio(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_elite_position_ratio("BTC-USDT", "1day"))
        print(result)
        loop.close()

    def test_get_swap_api_state(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_api_state())
        print(result)
        loop.close()

    def test_get_swap_ladder_margin(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_ladder_margin())
        print(result)
        loop.close()

    def test_get_swap_estimated_settlement_price(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_estimated_settlement_price())
        print(result)
        loop.close()

    def test_get_swap_adjustfactor(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_adjustfactor())
        print(result)
        loop.close()

    def test_get_swap_insurance_fund(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_insurance_fund("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_risk_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_risk_info())
        print(result)
        loop.close()

    def test_get_price_limit(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_price_limit())
        print(result)
        loop.close()

    def test_get_swap_open_interest(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_open_interest())
        print(result)
        loop.close()

    def test_get_swap_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_info())
        print(result)
        loop.close()

    def test_get_swap_index(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_index())
        print(result)
        loop.close()

    def test_get_swap_query_elements(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_query_elements())
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
