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

class Trade:
    """ Trade object.

    Args:
        platform: Exchange platform name, e.g. huobi_swap.
        symbol: Trade pair name, e.g. BTC-USD.
        action: Trade action, BUY or SELL.
        price: Order place price.
        quantity: Order place quantity.
        timestamp: Update time, millisecond.
    """

    def __init__(self, platform=None, symbol=None, action=None, price=None, quantity=None, timestamp=None, amount=None,
                 id=None, direction=None, trade_turnover=None):
        """ Initialize. """
        self.platform = platform
        self.symbol = symbol
        self.action = action
        self.price = price
        self.quantity = quantity
        self.timestamp = timestamp
        self.amount = amount
        self.id = id
        self.direction = direction
        self.trade_turnover = trade_turnover

    @property
    def data(self):
        d = {
            "platform": self.platform,
            "symbol": self.symbol,
            "action": self.action,
            "price": self.price,
            "quantity": self.quantity,
            "timestamp": self.timestamp,
            "amount": self.amount,
            "id": self.id,
            "direction": self.direction,
            "trade_turnover": self.trade_turnover
        }
        return d

    def __str__(self):
        info = json.dumps(self.data)
        return info

    def __repr__(self):
        return str(self)