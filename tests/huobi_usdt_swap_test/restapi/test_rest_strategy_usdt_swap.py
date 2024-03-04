import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_strategy_usdt_swap import HuobiUsdtSwapRestStrategyAPI
from tests.config import config

sys.path.append('..')


class TestRestStrategyUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestStrategyAPI(config["host"], config["access_key"], config["secret_key"])

    def test_swap_trigger_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_trigger_order("BTC-USDT", "ge", 1111, 111, "buy"))
        print(result)
        loop.close()

    def test_swap_trigger_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_trigger_cancel("BTC-USDT", "456789123"))
        print(result)
        loop.close()

    def test_swap_trigger_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_trigger_cancelall("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_trigger_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_trigger_openorders("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_trigger_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_trigger_hisorders("BTC-USDT", 0, 0, 30))
        print(result)
        loop.close()

    def test_swap_tpsl_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_tpsl_order("btc-usdt", "sell", 1))
        print(result)
        loop.close()

    def test_swap_tpsl_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_tpsl_cancel("BTC-USDT", "2345567123"))
        print(result)
        loop.close()

    def test_swap_tpsl_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_tpsl_cancelall("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_tpsl_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_tpsl_openorders("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_tpsl_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_tpsl_hisorders("BTC-USDT", 0, 30))
        print(result)
        loop.close()

    def test_get_swap_relation_tpsl_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_relation_tpsl_order("BTC-USDT", 3456678123))
        print(result)
        loop.close()

    def test_swap_track_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_order("BTC-USDT", "buy", 100, 0.01,
                                      1670, "optimal_5"))
        print(result)
        loop.close()

    def test_swap_track_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_cancel("BTC-USDT", "456457123"))
        print(result)
        loop.close()

    def test_swap_track_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_cancelall("BTC-USDT"))
        print(result)
        loop.close()

    def test_swap_track_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_openorders("BTC-USDT"))
        print(result)
        loop.close()

    def test_swap_track_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_track_hisorders("BTC-USDT", 0, 0, 30))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
