import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_cross_strategy_usdt_swap import HuobiUsdtSwapRestCrossStrategyAPI
from tests.config import config

sys.path.append('..')


class TestRestCrossStrategyUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestCrossStrategyAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_swap_cross_trigger_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_trigger_order("le", 16500, 10, "buy"))
        print(result)
        loop.close()

    def test_swap_cross_trigger_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_trigger_cancel("1888"))
        print(result)
        loop.close()

    def test_swap_cross_trigger_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_trigger_cancelall())
        print(result)
        loop.close()

    def test_get_swap_cross_trigger_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_trigger_openorders())
        print(result)
        loop.close()

    def test_get_swap_cross_trigger_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_trigger_hisorders(0, 0, 30))
        print(result)
        loop.close()

    def test_swap_cross_tpsl_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_tpsl_order("sell", 1))
        print(result)
        loop.close()

    def test_swap_cross_tpsl_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_tpsl_cancel("2345567123"))
        print(result)
        loop.close()

    def test_swap_cross_tpsl_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_tpsl_cancelall())
        print(result)
        loop.close()

    def test_get_swap_cross_tpsl_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_tpsl_openorders())
        print(result)
        loop.close()

    def test_get_swap_cross_tpsl_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_tpsl_hisorders(0, 30))
        print(result)
        loop.close()

    def test_get_swap_cross_relation_tpsl_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_relation_tpsl_order(3456678123))
        print(result)
        loop.close()

    def test_swap_cross_track_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_track_order("buy", 100, 0.01, 1670,
                                            "optimal_5"))
        print(result)
        loop.close()

    def test_swap_cross_track_cancel(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_track_cancel("456457123"))
        print(result)
        loop.close()

    def test_swap_cross_track_cancelall(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_track_cancelall())
        print(result)
        loop.close()

    def test_get_swap_cross_track_openorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_track_openorders())
        print(result)
        loop.close()

    def test_swap_cross_track_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_track_hisorders(0, 0, 30))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
