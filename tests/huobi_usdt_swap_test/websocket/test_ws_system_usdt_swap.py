import sys
import time
import unittest

from alpha.platforms.huobi_usdt_swap.websocket.ws_system_usdt_swap import WsSystem
from alpha.utils import logger

sys.path.append('..')


class TestWsSystemUsdtSwap(unittest.TestCase):
    def _callback(self, jdata):
        logger.info('_callback:{}'.format(jdata))

    def test_sub(self):
        ws = WsSystem()
        data = {"op": "sub", "topic": "public.linear-swap.heartbeat"}
        ws.sub(data, self._callback)

        time.sleep(60)
        ws.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
