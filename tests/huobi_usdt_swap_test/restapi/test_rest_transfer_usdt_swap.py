import asyncio
import sys
import unittest

from alpha.platforms.huobi_usdt_swap.restapi.rest_transfer_usdt_swap import HuobiUsdtSwapRestTransferAPI
from tests.config import config

sys.path.append('..')


class TestRestTransferUsdtSwap(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.api = HuobiUsdtSwapRestTransferAPI(config["host"], config["access_key"], config["secret_key"])

    def test_transfer_between_spot_swap(self):
        loop = asyncio.get_event_loop()
        result = loop.run_until_complete(
            self.api.transfer_between_spot_swap("USDT", 100, "spot", "linear-swap",
                                                "usdt"))
        print(result)
        loop.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
