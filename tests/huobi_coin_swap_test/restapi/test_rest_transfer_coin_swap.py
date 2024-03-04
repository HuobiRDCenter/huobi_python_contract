import asyncio
import sys
import unittest

from alpha.platforms.huobi_coin_swap.restapi.rest_transfer_coin_swap import HuobiCoinSwapRestTransferAPI
from tests.config import config

sys.path.append('..')


class TestRestTransferCoinSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiCoinSwapRestTransferAPI(config["host"], config["access_key"], config["secret_key"])

    def test_transfer_between_spot_swap(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.transfer_between_spot_swap("spot", "swap", "btc", 1))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
