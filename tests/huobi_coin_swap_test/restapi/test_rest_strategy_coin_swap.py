import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_swap.restapi.rest_strategy_coin_swap import HuobiCoinSwapRestStrategyAPI
from tests.config import config

sys.path.append('..')


class TestRestStrategyCoinSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinSwapRestStrategyAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_swap_trigger_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_trigger_order("BTC-USD", "ge", 0.1, 1,
                                        "buy", "open"))
        print(result)
        loop.close()

    def test_swap_trigger_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_trigger_cancel("BTC-USD", "1234567"))
        print(result)
        loop.close()

    def test_swap_trigger_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_trigger_cancelall("BTC-USD"))
        print(result)
        loop.close()

    def test_swap_trigger_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_trigger_openorders("BTC-USD"))
        print(result)
        loop.close()

    def test_get_swap_trigger_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_trigger_hisorders("BTC-USD", 0, 0, 30))
        print(result)
        loop.close()

    def test_swap_tpsl_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_tpsl_order("BTC-USD", "buy", 1))
        print(result)
        loop.close()

    def test_swap_tpsl_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_tpsl_cancel("BTC-USD", "1234567"))
        print(result)
        loop.close()

    def test_swap_tpsl_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_tpsl_cancelall("BTC-USD"))
        print(result)
        loop.close()

    def test_swap_tpsl_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_tpsl_openorders("BTC-USD"))
        print(result)
        loop.close()

    def test_get_swap_tpsl_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_tpsl_hisorders("BTC-USD", 0, 30))
        print(result)
        loop.close()

    def test_get_swap_relation_tpsl_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_relation_tpsl_order("BTC-USD", "1234567"))
        print(result)
        loop.close()

    def test_swap_track_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_order("BTC-USD", "buy", "open", 1, 0.01,
                                      1, "optimal_5"))
        print(result)
        loop.close()

    def test_swap_track_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_cancel("BTC-USD", "1234567"))
        print(result)
        loop.close()

    def test_swap_track_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_cancelall("BTC-USD"))
        print(result)
        loop.close()

    def test_swap_track_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_openorders("BTC-USD"))
        print(result)
        loop.close()

    def test_swap_track_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_hisorders("BTC-USD", 0, 0, 30))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
