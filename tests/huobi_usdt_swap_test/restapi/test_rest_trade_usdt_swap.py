import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_trade_usdt_swap import HuobiUsdtSwapRestTradeAPI
from tests.config import config

sys.path.append('..')


class TestRestTradeUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestTradeAPI(config["host"], config["access_key"], config["secret_key"])

    def test_linear_cancel_after(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.linear_cancel_after(1))
        print(result)
        loop.close()

    def test_swap_switch_position_mode(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_switch_position_mode("BTC-USDT", "dual_side"))
        print(result)
        loop.close()

    def test_create_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.create_order(1, "buy", 5, "opponent"))
        print(result)
        loop.close()

    def test_create_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.create_orders({
              "orders_data": [
                {
                  "contract_code": "btc-usdt",
                  "direction": "sell",
                  "offset": "open",
                  "price": "29999",
                  "lever_rate": 5,
                  "volume": 1,
                  "order_price_type": "opponent",
                  "tp_trigger_price": 27000,
                  "tp_order_price": 27000,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": "30100",
                  "sl_order_price": "30100",
                  "sl_order_price_type": "optimal_5"
                },
                {
                  "contract_code": "btc-usdt",
                  "direction": "buy",
                  "offset": "open",
                  "price": "29999",
                  "lever_rate": 5,
                  "volume": 1,
                  "order_price_type": "post_only",
                  "tp_trigger_price": 31000,
                  "tp_order_price": 31000,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": "29100",
                  "sl_order_price": "29100",
                  "sl_order_price_type": "optimal_5"
                }
              ]
            }))
        print(result)
        loop.close()

    def test_revoke_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_order("BTC-USDT"))
        print(result)
        loop.close()

    def test_revoke_order_all(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_order_all("BTC-USDT"))
        print(result)
        loop.close()

    def test_swap_switch_lever_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_switch_lever_rate("BTC-USDT", 20))
        print(result)
        loop.close()

    def test_get_order_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_order_info("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_order_detail(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_order_detail("BTC-USDT", "456234321"))
        print(result)
        loop.close()

    def test_get_open_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_open_orders("BTC-USDT"))
        print(result)
        loop.close()

    def test_get_swap_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_hisorders("BTC-USDT", 1, 0))
        print(result)
        loop.close()

    def test_get_swap_hisorders_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_hisorders_exact(0, 1, 0))
        print(result)
        loop.close()

    def test_get_swap_matchresults(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_matchresults("limit"))
        print(result)
        loop.close()

    def test_get_swap_matchresults_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_matchresults_exact("BTC-USDT", 0))
        print(result)
        loop.close()

    def test_swap_lightning_close_position(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_lightning_close_position("BTC-USDT", "buy"))
        print(result)
        loop.close()

    def test_get_swap_position_side(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_position_side("BTC-USDT"))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
