import sys
import time
import unittest

from alpha.platforms.huobi_coin_swap.websocket.ws_account_coin_swap import WsAccount
from alpha.utils import logger
from tests.config import config

sys.path.append('..')


class TestWsAccountCoinSwap(unittest.TestCase):
    def _callback_1(self, jdata):
        logger.info('_callback_1:{}'.format(jdata))

    def _callback_2(self, jdata):
        logger.info('_callback_2:{}'.format(jdata))

    def test_sub(self):
        ws1 = WsAccount(access_key=config['access_key'], secret_key=config['secret_key'],sign=config['sign'])
        data = {"op": "sub", "topic": "accounts.BTC-USDT"}
        ws1.sub(data, self._callback_1)

        time.sleep(30)
        data = {"op": "unsub", "topic": "accounts.BTC-USDT"}
        ws1.unsub(data)
        logger.info('unsub')

        time.sleep(10)
        ws1.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
