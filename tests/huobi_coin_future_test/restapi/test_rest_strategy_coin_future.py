import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_future.restapi.rest_strategy_coin_future import HuobiCoinFutureRestStrategyAPI
from tests.config import config

sys.path.append('..')


class TestRestStrategyCoinFuture(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinFutureRestStrategyAPI(config["host"], config["access_key"], config["secret_key"])

    def test_create_trigger_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.create_trigger_order("ge", 10000, 10000, 1, "BUY",
                                          "OPEN", 5))
        print(result)
        loop.close()

    def test_revoke_trigger_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_trigger_order("BTC", "123456"))
        print(result)
        loop.close()

    def test_revoke_all_trigger_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_all_trigger_orders("BTC"))
        print(result)
        loop.close()

    def test_get_trigger_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_trigger_openorders("BTC"))
        print(result)
        loop.close()

    def test_get_trigger_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_trigger_hisorders("BTC", 0, "0", 30))
        print(result)
        loop.close()

    def test_get_contract_tpsl_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_tpsl_order("sell", 1))
        print(result)
        loop.close()

    def test_contract_tpsl_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_tpsl_cancel("BTC", "123456"))
        print(result)
        loop.close()

    def test_contract_tpsl_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_tpsl_cancelall())
        print(result)
        loop.close()

    def test_get_contract_tpsl_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_tpsl_openorders("BTC"))
        print(result)
        loop.close()

    def test_get_contract_tpsl_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_tpsl_hisorders("BTC", "0", 30))
        print(result)
        loop.close()

    def test_get_contract_relation_tpsl_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_relation_tpsl_order("BTC", 123456))
        print(result)
        loop.close()

    def test_contract_track_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_track_order("sell", "open", 1, 0.01, 1700,
                                          "optimal_5"))
        print(result)
        loop.close()

    def test_contract_track_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_track_cancel("BTC", "123456"))
        print(result)
        loop.close()

    def test_contract_track_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_track_cancelall("BTC"))
        print(result)
        loop.close()

    def test_contract_track_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_track_openorders("BTC"))
        print(result)
        loop.close()

    def test_contract_track_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_track_hisorders("BTC", "0", 0, 30))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
