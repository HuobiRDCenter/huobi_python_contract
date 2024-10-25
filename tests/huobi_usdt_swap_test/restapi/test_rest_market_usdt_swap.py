import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_market_usdt_swap import HuobiUsdtSwapRestMarketAPI
from tests.config import config

sys.path.append('..')


class TestRestMarketUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestMarketAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_get_orderbook(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_orderbook("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_market_bbo(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_market_bbo())
        print(result)
        loop.close()

    def test_get_klines(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_klines("BTC-USDT", 1))
        print(result)
        loop.close()

    def test_get_linear_swap_mark_price_kline(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_linear_swap_mark_price_kline("BTC-USDT", 5,100))
        print(result)
        loop.close()

    def test_get_merged_data(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_merged_data("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_batch_merged(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_batch_merged())
        print(result)
        loop.close()

    def test_get_market_trade(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_market_trade())
        print(result)
        loop.close()

    def test_get_market_history_trade(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_market_history_trade("BTC-USDT", 100))
        print(result)
        loop.close()

    def test_get_swap_his_open_interest(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_his_open_interest("60min", 1,
                                                                             "BTC-USDT"))
        print(result)
        loop.close()

    def test_get_linear_swap_premium_index_kline(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_linear_swap_premium_index_kline("BTC-USDT","1min", 1))
        print(result)
        loop.close()

    def test_get_linear_swap_estimated_rate_kline(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_linear_swap_estimated_rate_kline("BTC-USDT","1min", 1))
        print(result)
        loop.close()

    def test_get_linear_swap_basis(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_linear_swap_basis("BTC-USDT", "1min", 1))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
