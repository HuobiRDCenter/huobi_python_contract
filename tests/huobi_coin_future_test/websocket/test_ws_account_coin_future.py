import sys
import time
import unittest
from alpha.platforms.huobi_coin_future.websocket.ws_account_coin_future import WsAccount
from alpha.utils import logger
from tests.config import config

sys.path.append('..')


class TestWsAccountCoinFuture(unittest.TestCase):
    def _callback_1(self, jdata):
        logger.info('_callback_1:{}'.format(jdata))

    def test_sub(self):
        ws1 = WsAccount(access_key=config['access_key'], secret_key=config['secret_key'],sign=config['sign'])
        data = {"op": "sub", "topic": "accounts.btc"}
        ws1.sub(data, self._callback_1)

        time.sleep(30)
        data = {"op": "unsub", "topic": "accounts.btc"}
        ws1.unsub(data)
        logger.info('unsub')

        time.sleep(10)
        ws1.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
