import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_swap.restapi.rest_market_coin_swap import HuobiCoinSwapRestMarketAPI
from tests.config import config

sys.path.append('..')


class TestRestMarketCoinSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinSwapRestMarketAPI(config["host"], config["access_key"], config["secret_key"])

    def test_get_orderbook(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_orderbook("BTC_CQ", "step5"))
        print(result)
        loop.close()

    def test_get_bbo(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_bbo())
        print(result)
        loop.close()

    def test_get_klines(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_klines("BTC_CQ", "1min"))
        print(result)
        loop.close()

    def test_get_swap_mark_price_kline(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_mark_price_kline("BTC_CW", "15min", 100))
        print(result)
        loop.close()

    def test_get_merged(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_merged("BTC_CQ"))
        print(result)
        loop.close()

    def test_get_batch_merged(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_batch_merged())
        print(result)
        loop.close()

    def test_get_trade(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_trade())
        print(result)
        loop.close()

    def test_get_history_trade(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_history_trade("BTC_CQ", 100))
        print(result)
        loop.close()

    def test_get_swap_premium_index_kline(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_premium_index_kline("BTC-USD", "1min", 1))
        print(result)
        loop.close()

    def test_get_swap_estimated_rate_kline(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_estimated_rate_kline("BTC-USD", "1min", 1))
        print(result)
        loop.close()

    def test_get_swap_basis(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_basis("BTC-USD", "1min", 1))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
