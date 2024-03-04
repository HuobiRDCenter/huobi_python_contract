import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_swap.restapi.rest_trade_coin_swap import HuobiCoinSwapRestTradeAPI
from tests.config import config

sys.path.append('..')


class TestRestTradeCoinSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinSwapRestTradeAPI(config["host"], config["access_key"], config["secret_key"])

    def test_swap_cancel_after(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_cancel_after(1))
        print(result)
        loop.close()

    def test_get_swap_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_order("BTC-USD", 1, "buy", 	"open", 10,
                                    "limit"))
        print(result)
        loop.close()

    def test_create_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.create_orders({
              "orders_data": [
                {
                  "contract_code": "ltc-usd",
                  "direction": "sell",
                  "offset": "open",
                  "price": "136",
                  "lever_rate": 5,
                  "volume": 1,
                  "order_price_type": "opponent",
                  "tp_trigger_price": 133,
                  "tp_order_price": 133,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": "139",
                  "sl_order_price": "139",
                  "sl_order_price_type": "optimal_5"
                },
                {
                  "contract_code": "ltc-usd",
                  "direction": "buy",
                  "offset": "open",
                  "price": "136",
                  "lever_rate": 5,
                  "volume": 1,
                  "order_price_type": "post_only",
                  "tp_trigger_price": 139,
                  "tp_order_price": 139,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": "133",
                  "sl_order_price": "133",
                  "sl_order_price_type": "optimal_5"
                }
              ]
            }))
        print(result)
        loop.close()

    def test_revoke_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_order("BTC-USD"))
        print(result)
        loop.close()

    def test_revoke_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_orders("BTC-USD"))
        print(result)
        loop.close()

    def test_revoke_order_all(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_order_all("BTC-USD"))
        print(result)
        loop.close()

    def test_swap_switch_lever_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.swap_switch_lever_rate("BTC-USD", 10))
        print(result)
        loop.close()

    def test_get_order_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_order_info("BTC-USD"))
        print(result)
        loop.close()

    def test_get_swap_order_detail(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_order_detail("BTC-USD", 1))
        print(result)
        loop.close()

    def test_get_open_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_open_orders("BTC-USD"))
        print(result)
        loop.close()

    def test_get_swap_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_hisorders("BTC-USD", 0, 1, 0))
        print(result)
        loop.close()

    def test_get_swap_hisorders_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_hisorders_exact("BTC-USD", 0, 1, 0))
        print(result)
        loop.close()

    def test_get_swap_matchresults(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_matchresults("BTC-USDT", 0))
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
            self.api.swap_lightning_close_position("BTC-USDT", 1, "buy"))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
