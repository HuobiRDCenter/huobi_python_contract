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


class Depth:
    """ Depth object."""

    def __init__(self, platform=None, symbol=None, asks=None, bids=None, timestamp=None, ch=None, event=None, id=None,
                 mrid=None, version=None):
        """ Initialize. """
        self.platform = platform
        self.symbol = symbol
        self.asks = asks
        self.bids = bids
        self.timestamp = timestamp
        self.ch = ch
        self.event = event
        self.id = id
        self.mrid = mrid
        self.version = version


    @property
    def data(self):
        d = {
            "platform": self.platform,
            "symbol": self.symbol,
            "asks": self.asks,
            "bids": self.bids,
            "timestamp": self.timestamp,
            "ch": self.ch,
            "event": self.event,
            "id": self.id,
            "mrid": self.mrid,
            "version": self.version
        }
        return d

    def __str__(self):
        info = json.dumps(self.data)
        return info

    def __repr__(self):
        return str(self)