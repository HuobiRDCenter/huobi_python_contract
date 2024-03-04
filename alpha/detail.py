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


class Detail:
    """ Detail object."""

    def __init__(self, platform=None, symbol=None, asks=None, bids=None, timestamp=None, id=None, mrid=None, open=None,
                 close=None, high=None, low=None, amount=None, vol=None, trade_turnover=None, count=None):
        """ Initialize. """
        self.platform = platform
        self.symbol = symbol
        self.asks = asks
        self.bids = bids
        self.timestamp = timestamp
        self.id = id
        self.mrid = mrid
        self.open = open
        self.close = close
        self.high = high
        self.low = low
        self.amount = amount
        self.vol = vol
        self.trade_turnover = trade_turnover
        self.count = count


    @property
    def data(self):
        d = {
            "platform": self.platform,
            "symbol": self.symbol,
            "asks": self.asks,
            "bids": self.bids,
            "timestamp": self.timestamp,
            "id": self.id,
            "mrid": self.mrid,
            "open": self.open,
            "close": self.close,
            "high": self.high,
            "low": self.low,
            "amount": self.amount,
            "vol": self.vol,
            "trade_turnover": self.trade_turnover,
            "count": self.count

        }
        return d

    def __str__(self):
        info = json.dumps(self.data)
        return info

    def __repr__(self):
        return str(self)