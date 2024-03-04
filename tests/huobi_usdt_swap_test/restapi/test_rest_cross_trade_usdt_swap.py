import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_cross_trade_usdt_swap import HuobiUsdtSwapRestCrossTradeAPI
from tests.config import config

sys.path.append('..')


class TestRestCrossTradeUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestCrossTradeAPI(config["host"], config["access_key"], config["secret_key"])

    def test_get_swap_cross_trade_state(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_trade_state())
        print(result)
        loop.close()

    def test_swap_cross_switch_position_mode(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_switch_position_mode("BTC-USDT", "dual_side"))
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

    def test_revoke_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_orders("BTC-USDT", "456789133445,456789133446"))
        print(result)
        loop.close()

    def test_revoke_order_all(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_order_all("BTC-USDT"))
        print(result)
        loop.close()

    def test_swap_cross_switch_lever_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_switch_lever_rate(20))
        print(result)
        loop.close()

    def test_get_order_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_order_info())
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

    def test_get_swap_cross_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_hisorders(0, 1, 0))
        print(result)
        loop.close()

    def test_get_swap_cross_hisorders_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_hisorders_exact(0, 1, 0))
        print(result)
        loop.close()

    def test_get_swap_cross_matchresults(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_matchresults("BTC-USDT", 0))
        print(result)
        loop.close()

    def test_get_swap_cross_matchresults_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_matchresults_exact("BTC-USDT", 0))
        print(result)
        loop.close()

    def test_swap_cross_lightning_close_position(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cross_lightning_close_position("buy"))
        print(result)
        loop.close()

    def test_get_swap_cross_position_side(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_position_side("BTC-USDT"))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
