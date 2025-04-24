import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_cross_transfer_usdt_swap import HuobiUsdtSwapRestCrossTransferAPI
from tests.config import config

sys.path.append('..')


class TestRestCrossTransferUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestCrossTransferAPI(config["host"], config["access_key"], config["secret_key"],config["sign"])

    def test_get_swap_cross_transfer_state(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.get_swap_cross_transfer_state())
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
