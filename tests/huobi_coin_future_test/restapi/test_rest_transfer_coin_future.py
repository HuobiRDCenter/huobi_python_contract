import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_future.restapi.rest_transfer_coin_future import HuobiCoinFutureRestTransferAPI
from tests.config import config

sys.path.append('..')


class TestRestTransferCoinFuture(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinFutureRestTransferAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_transfer_between_spot_future(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.transfer_between_spot_future("btc", 10, "futures-to-pro"))
        print(result)
        loop.close()

    def test_account_transfer(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.account_transfer("spot", "futures", "usdt", 100, "USDT"))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
