import sys
import time
import unittest

from alpha.platforms.huobi_coin_future.websocket.ws_market_coin_future import WsMarket
from alpha.utils import logger
from tests.config import config
sys.path.append('..')


class TestWsMarketCoinFuture(unittest.TestCase):
    def _callback_1(self, jdata):
        logger.info('_callback_1:{}'.format(jdata))

    def _callback_2(self, jdata):
        logger.info('_callback_2:{}'.format(jdata))

    def test_sub(self):
        ws1 = WsMarket(sign=config['sign'])
        data = {"sub": "market.BTC_CQ.kline.1min"}
        ws1.sub(data, self._callback_1)

        ws2 = WsMarket(sign=config['sign'])
        data = {"sub": "market.BTC_CQ.trade.detail"}
        ws2.sub(data, self._callback_2)

        time.sleep(60)
        ws1.close()
        ws2.close()

    def test_req(self):
        ws1 = WsMarket()
        data = {"req": "market.BTC_CQ.kline.1min",
                "from": 1614320780, "to": 1614321780}
        ws1.req(data, self._callback_1)

        ws2 = WsMarket()
        data = {"req": "market.BTC_CQ.trade.detail",
                "from": 1614321780, "to": 1614321780}
        ws2.req(data, self._callback_2)

        time.sleep(60)
        ws1.close()
        ws2.close()


if __name__ == '__main__':
    unittest.main(verbosity=2)
