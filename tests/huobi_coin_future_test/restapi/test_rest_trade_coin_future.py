import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_future.restapi.rest_trade_coin_future import HuobiCoinFutureRestTradeAPI
from tests.config import config

sys.path.append('..')


class TestRestTradeCoinFuture(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinFutureRestTradeAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_contract_cancel_after(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_cancel_after(1))
        print(result)
        loop.close()

    def test_contract_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_order(1, "buy", "open", 75, "opponent"))
        print(result)
        loop.close()

    def test_create_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.create_orders({
              "orders_data": [
                {
                  "contract_code": "bch210326",
                  "direction": "buy",
                  "offset": "open",
                  "price": 360,
                  "lever_rate": 75,
                  "volume": 1,
                  "order_price_type": "opponent",
                  "tp_trigger_price": 450,
                  "tp_order_price": 450,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": 330,
                  "sl_order_price": 330,
                  "sl_order_price_type": "optimal_5"
                },
                {
                  "contract_code": "bch210326",
                  "direction": "buy",
                  "offset": "open",
                  "price": 360,
                  "lever_rate": 75,
                  "volume": 1,
                  "order_price_type": "post_only",
                  "tp_trigger_price": 450,
                  "tp_order_price": 450,
                  "tp_order_price_type": "optimal_5",
                  "sl_trigger_price": 330,
                  "sl_order_price": 330,
                  "sl_order_price_type": "optimal_5"
                }
              ]
            }))
        print(result)
        loop.close()

    def test_revoke_order(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_order)("btc")
        print(result)
        loop.close()

    def test_revoke_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_orders("btc"))
        print(result)
        loop.close()

    def test_revoke_order_all(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.revoke_order_all("BTC"))
        print(result)
        loop.close()

    def test_contract_switch_lever_rate(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.contract_switch_lever_rate("BTC", 10))
        print(result)
        loop.close()

    def test_get_order_info(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_order_info("btc"))
        print(result)
        loop.close()

    def test_get_contract_order_detail(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_order_detail("BTC", 727181510507044900))
        print(result)
        loop.close()

    def test_get_open_orders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_open_orders("BTC"))
        print(result)
        loop.close()

    def test_get_contract_hisorders(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_hisorders("BTC", 0, 1, "0"))
        print(result)
        loop.close()

    def test_get_contract_hisorders_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_hisorders_exact("BTC", 0, 1, "0"))
        print(result)
        loop.close()

    def test_get_contract_matchresults(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_matchresults("BTC", 0))
        print(result)
        loop.close()

    def test_get_contract_matchresults_exact(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_contract_matchresults_exact("BTC", "BTC-USD", 0))
        print(result)
        loop.close()

    def test_lightning_close_position(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.lightning_close_position("BTC", "this_week", "BTC190903", 1,
                                              "sell", "123456", "lightning"))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
