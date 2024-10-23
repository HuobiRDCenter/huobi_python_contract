package com.huobi.wss.constants;

public class HuobiFutureWSSConstants {

    //市场行情接口 订阅
    public static final String MARKET_KLINE_PERIOD_SUB = "market.$symbol.kline.$period"; // 1.订阅 KLine 数据
    public static final String MARKET_DEPTH_SUB = "market.$symbol.depth.$type"; // 2.订阅 Market Depth 数据
    public static final String MARKET_DETAIL_SUB = "market.$symbol.detail";// 3.订阅 Market detail 数据
    public static final String MARKET_TRADE_DETAIL_SUB = "market.$symbol.trade.detail";// 4.订阅TradeDetail数据
    public static final String MARKET_DEPTH_DIFF_SUB = "market.$symbol.depth.size_${size}.high_freq"; // 5.订阅MarketDepth增量数据
    public static final String MARKET_BBO_SUB = "market.$symbol.bbo"; // 6.订阅买一卖一逐笔行情数据(BBO)


    //市场行情接口 请求
    public static final String MARKET_KLINE_PERIOD_REQ = "market.$symbol.kline.$period"; // 1.请求 KLine 数据
    public static final String MARKET_TRADE_DETAIL_REQ = "market.$symbol.trade.detail";// 2.请求TradeDetail数据


    //订单和用户数据接口
    public static final String ORDERS_SYMBOL = "orders.$symbol"; // 1.订阅订单成交数据
    public static final String ACCOUNTS_SYMBOL = "accounts.$symbol"; // 2.订阅某个品种下的资产变动信息
    public static final String POSITIONS_SYMBOL = "positions.$symbol"; // 3.订阅某个品种下的持仓变动信息
    public static final String PUBLIC_LIQUIDATION_ORDERS = "public.$symbol.liquidation_orders";// 4.订阅强平订单数据(免鉴权)（sub）
    public static final String PUBLIC_CONTRACT_INFO = "public.$symbol.contract_info";// 5.订阅合约信息变动(免鉴权)（sub）
    public static final String TRIGGER_ORDER_SYMBOL = "trigger_order.$symbol";// 6.订阅计划委托订单更新
    public static final String MATCHORDERS_SYMBOL = "matchOrders.$symbol";// 7.订阅订单撮合数据（sub）

    //系统状态更新接口
    public static final String PUBLIC_HEARTBEAT = "public.$service.heartbeat";// 1.订阅系统状态更新

    //指数与基差数据接口 订阅
    public static final String MARKET_INDEX_SUB = "market.$symbol.index.$period"; // 1.订阅(sub)指数K线数据
    public static final String MARKET_BASIS_PRICE_TYPE_SUB = "market.$symbol.basis.$period.$basis_price_type"; // 2.订阅(sub)基差数据
    public static final String MARKET_MARK_PRICE_SUB = "market.$symbol.mark_price.$period"; // 3.请求标记价格K线数据

    //指数与基差数据接口 请求
    public static final String MARKET_INDEX_REQ = "market.$symbol.index.$period"; // 1.请求(req)指数K线数据
    public static final String MARKET_BASIS_PRICE_TYPE_REQ = "market.$symbol.basis.$period.$basis_price_type";// 2.请求(req)基差数据
    public static final String MARKET_MARK_PRICE_REQ = "market.$symbol.mark_price.$period";// 3.请求标记价格K线数据

}
