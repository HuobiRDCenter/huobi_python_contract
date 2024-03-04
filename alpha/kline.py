# -*- coding:utf-8 -*-

"""
Market module.

Author: QiaoXiaofeng
Date:   2020/1/10
Email:  andyjoe318@gmail.com
"""

import json

from alpha import const
from alpha.utils import logger


class Kline:
    """ Kline object.

    Args:
        platform: Exchange platform name, e.g. huobi_swap.
        symbol: Trade pair name, e.g. BTC-USD.
        open: Open price.
        high: Highest price.
        low: Lowest price.
        close: Close price.
        volume: Total trade volume.
        timestamp: Update time, millisecond.
        kline_type: Kline type name, kline - 1min, kline_5min - 5min, kline_15min - 15min.
    """

    def __init__(self, platform=None, symbol=None, open=None, high=None, low=None, close=None, volume=None,
                 timestamp=None, kline_type=None, id=None, mrid=None, vol=None, count=None, amount=None,
                 trade_turnover=None):
        """ Initialize. """
        self.platform = platform
        self.symbol = symbol
        self.open = open
        self.high = high
        self.low = low
        self.close = close
        self.volume = volume
        self.timestamp = timestamp
        self.kline_type = kline_type
        self.id = id
        self.mrid = mrid
        self.vol = vol
        self.count = count
        self.amount = amount
        self.trade_turnover = trade_turnover

    @property
    def data(self):
        d = {
            "platform": self.platform,
            "symbol": self.symbol,
            "open": self.open,
            "high": self.high,
            "low": self.low,
            "close": self.close,
            "volume": self.volume,
            "timestamp": self.timestamp,
            "kline_type": self.kline_type,
            "id": self.id,
            "mrid": self.mrid,
            "vol": self.vol,
            "count": self.count,
            "amount": self.amount,
            "trade_turnover": self.trade_turnover,
        }
        return d

    def __str__(self):
        info = json.dumps(self.data)
        return info

    def __repr__(self):
        return str(self)
