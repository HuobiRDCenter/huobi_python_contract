# -*- coding:utf-8 -*-


import json

from alpha import const
from alpha.utils import logger


class ContractElements:

    def __init__(self, contract_code=None, mode_type=None, swap_delivery_type=None, instrument_index_code=None, real_time_settlement=None, transfer_profit_ratio=None, cross_transfer_profit_ratio=None,
                 instrument_type=None, trade_partition=None, min_level=None, max_level=None, settle_period=None, funding_rate_cap=None, funding_rate_floor=None,
                 contract_infos=None, long_position_limit=None, offset_order_limit=None,open_order_limit=None,short_position_limit=None,price_ticks=None,instrument_values=None,
                 order_limits=None, normal_limits=None, open_limits=None,trade_limits=None):
        """ Initialize. """
        self.contract_code = contract_code
        self.mode_type = mode_type
        self.swap_delivery_type = swap_delivery_type
        self.instrument_index_code = instrument_index_code
        self.real_time_settlement = real_time_settlement
        self.transfer_profit_ratio = transfer_profit_ratio
        self.cross_transfer_profit_ratio = cross_transfer_profit_ratio
        self.instrument_type = instrument_type
        self.trade_partition = trade_partition
        self.min_level = min_level
        self.max_level = max_level
        self.settle_period = settle_period
        self.funding_rate_cap = funding_rate_cap
        self.funding_rate_floor = funding_rate_floor
        self.contract_infos = contract_infos
        self.long_position_limit = long_position_limit
        self.offset_order_limit = offset_order_limit
        self.open_order_limit = open_order_limit
        self.short_position_limit = short_position_limit
        self.price_ticks = price_ticks
        self.instrument_values = instrument_values
        self.order_limits = order_limits
        self.normal_limits = normal_limits
        self.open_limits = open_limits
        self.trade_limits = trade_limits

    @property
    def data(self):
        d = {
            "contract_code": self.contract_code,
            "mode_type": self.mode_type,
            "swap_delivery_type": self.swap_delivery_type,
            "instrument_index_code": self.instrument_index_code,
            "real_time_settlement": self.real_time_settlement,
            "transfer_profit_ratio": self.transfer_profit_ratio,
            "cross_transfer_profit_ratio": self.cross_transfer_profit_ratio,
            "instrument_type": self.instrument_type,
            "trade_partition": self.trade_partition,
            "min_level": self.min_level,
            "max_level": self.max_level,
            "settle_period": self.settle_period,
            "funding_rate_cap": self.funding_rate_cap,
            "funding_rate_floor": self.funding_rate_floor,
            "contract_infos": self.contract_infos,
            "long_position_limit": self.long_position_limit,
            "offset_order_limit": self.offset_order_limit,
            "open_order_limit": self.open_order_limit,
            "short_position_limit": self.short_position_limit,
            "price_ticks": self.price_ticks,
            "instrument_values": self.instrument_values,
            "order_limits": self.order_limits,
            "normal_limits": self.normal_limits,
            "open_limits": self.open_limits,
            "trade_limits": self.trade_limits,
        }
        return d

    def __str__(self):
        info = json.dumps(self.data)
        return info

    def __repr__(self):
        return str(self)
