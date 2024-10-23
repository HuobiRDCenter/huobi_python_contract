package com.huobi.api.constants;

public class HuobiCoinMarginedSwapAPIOptions {
    //基础信息
    public static final String SWAP_RISK_INFO = "/swap-api/v1/swap_risk_info";// 1.查询合约风险准备金和预估分摊比例
    public static final String SWAP_INSURANCE_FUND = "/swap-api/v1/swap_insurance_fund"; // 2.获取风险准备金历史数据
    public static final String SWAP_ADJUSTFACTOR = "/swap-api/v1/swap_adjustfactor";  // 3.查询平台阶梯调整系数
    public static final String SWAP_HIS_OPEN_INTEREST = "/swap-api/v1/swap_his_open_interest"; // 4.平台持仓量的查询
    public static final String SWAP_LADDER_MARGIN = "/swap-api/v1/swap_ladder_margin"; // 5.获取平台阶梯保证金
    public static final String SWAP_ELITE_ACCOUNT_RATIO = "/swap-api/v1/swap_elite_account_ratio";  // 6.精英账户多空持仓对比-账户数
    public static final String SWAP_ELITE_POSITION_RATIO = "/swap-api/v1/swap_elite_position_ratio";  // 7.精英账户多空持仓对比-持仓量
    public static final String SWAP_ESTIMATED_SETTLEMENT_PRICE = "/swap-api/v1/swap_estimated_settlement_price"; // 8.获取预估结算价
    public static final String SWAP_API_STATE = "/swap-api/v1/swap_api_state"; // 9.查询系统状态
    public static final String SWAP_FUNDING_RATE = "/swap-api/v1/swap_funding_rate";  // 10.获取合约的资金费率
    public static final String SWAP_BATCH_FUNDING_RATE = "/swap-api/v1/swap_batch_funding_rate";  // 11.批量获取合约资金费率
    public static final String SWAP_HISTORICAL_FUNDING_RATE = "/swap-api/v1/swap_historical_funding_rate";  // 12.获取合约的历史资金费率
    public static final String SWAP_LIQUIDATION_ORDERS_V3 = "/swap-api/v3/swap_liquidation_orders"; // 13.获取强平订单(新)
    public static final String SWAP_SETTLEMENT_RECORDS = "/swap-api/v1/swap_settlement_records"; // 14.查询平台历史结算记录
    public static final String SWAP_CONTRACT_INFO = "/swap-api/v1/swap_contract_info"; // 15.获取合约信息
    public static final String SWAP_INDEX = "/swap-api/v1/swap_index"; // 16.获取合约指数信息
    public static final String SWAP_QUERY_ELEMENTS = "/swap-api/v1/swap_query_elements"; // 17.合约要素
    public static final String SWAP_PRICE_LIMIT = "/swap-api/v1/swap_price_limit"; // 18.获取合约最高限价和最低限价
    public static final String SWAP_OPEN_INTEREST = "/swap-api/v1/swap_open_interest";// 19.获取当前可用合约总持仓量
    public static final String TIMESTAMP = "/api/v1/timestamp"; // 20.获取当前系统时间戳
    public static final String HEARTBEAT = "/heartbeat/"; // 21.查询系统是否可用
    public static final String SUMMARY = "https://status-swap.huobigroup.com/api/v2/summary.json"; // 22.获取当前系统状态

    //合约市场行情接口
    public static final String SWAP_MARKET_DEPTH = "/swap-ex/market/depth";// 1.获取行情深度数据
    public static final String MARKET_BBO = "/swap-ex/market/bbo";  // 2.获取市场最优挂单
    public static final String SWAP_MARKET_HISTORY_KLINE = "/swap-ex/market/history/kline";// 3.获取K线数据
    public static final String SWAP_MARK_PRICE_KLINE = "/index/market/history/swap_mark_price_kline"; // 4.获取标记价格的 K 线数据
    public static final String SWAP_MARKET_DETAIL_MERGED = "/swap-ex/market/detail/merged"; // 5.获取聚合行情
    public static final String BATCH_MERGED_V2 = "/v2/swap-ex/market/detail/batch_merged"; // 6.批量获取聚合行情（V2）
    public static final String SWAP_MARKET_TRADE = "/swap-ex/market/trade";// 7.获取市场最近成交记录
    public static final String SWAP_MARKET_HISTORY_TRADE = "/swap-ex/market/history/trade";  // 8.批量获取最近的交易记录
    public static final String LINEAR_SWAP_PREMIUM_INDEX_KLINE = "/index/market/history/swap_premium_index_kline";  // 9.获取溢价指数K线数据
    public static final String LINEAR_SWAP_ESTIMATED_RATE_KLINE = "/index/market/history/swap_estimated_rate_kline";  // 10.获取预测资金费率的K线数据
    public static final String LINEAR_SWAP_BASIS = "/index/market/history/swap_basis";  // 11.获取基差数据

    //合约资产接口
    public static final String SWAP_BALANCE_VALUATION = "/swap-api/v1/swap_balance_valuation"; // 1.获取账户总资产估值
    public static final String SWAP_ACCOUNT_INFO = "/swap-api/v1/swap_account_info"; // 2.获取用户账户信息
    public static final String SWAP_POSITION_INFO = "/swap-api/v1/swap_position_info"; // 3.获取用户持仓信息
    public static final String SWAP_ACCOUNT_POSITION_INFO = "/swap-api/v1/swap_account_position_info";// 4.获取用户资产和持仓信息
    public static final String SWAP_SUB_AUTH = "/swap-api/v1/swap_sub_auth";// 5.批量设置子账户交易权限
    public static final String SWAP_SUB_AUTH_LIST = "/swap-api/v1/swap_sub_auth_list"; // 6.查询子账户交易权限
    public static final String SWAP_SUB_ACCOUNT_LIST = "/swap-api/v1/swap_sub_account_list"; // 7.查询母账户下所有子账户资产信息
    public static final String SWAP_SUB_ACCOUNT_INFO_LIST = "/swap-api/v1/swap_sub_account_info_list";// 8.批量获取子账户资产信息
    public static final String SWAP_SUB_ACCOUNT_INFO = "/swap-api/v1/swap_sub_account_info"; // 9.查询单个子账户资产信息
    public static final String SWAP_SUB_POSITION_INFO = "/swap-api/v1/swap_sub_position_info"; // 10.查询单个子账户持仓信息
    public static final String SWAP_FINANCIAL_RECORD_V3 = "/swap-api/v3/swap_financial_record"; // 11.查询用户财务记录(新)
    public static final String SWAP_FINANCIAL_RECORD_EXACT_V3 = "/swap-api/v3/swap_financial_record_exact"; // 12.组合查询用户财务记录(新)
    public static final String SWAP_USER_SETTLEMENT_RECORDS = "/swap-api/v1/swap_user_settlement_records";// 13.获取用户API指标禁用信息
    public static final String SWAP_AVAILABLE_LEVEL_RATE = "/swap-api/v1/swap_available_level_rate";// 14.获取合约可用杠杆倍数
    public static final String SWAP_ORDER_LIMIT = "/swap-api/v1/swap_order_limit"; // 15.查询用户当前的下单量限制
    public static final String SWAP_FEE = "/swap-api/v1/swap_fee"; // 16.查询用户当前的手续费费率
    public static final String SWAP_TRANSFER_LIMIT = "/swap-api/v1/swap_transfer_limit"; // 17.查询用户当前的划转限制
    public static final String SWAP_POSITION_LIMIT = "/swap-api/v1/swap_position_limit"; // 18.用户持仓量限制的查询
    public static final String SWAP_MASTER_SUB_TRANSFER = "/swap-api/v1/swap_master_sub_transfer";// 19.母子账户划转
    public static final String SWAP_MASTER_SUB_TRANSFER_RECORD = "/swap-api/v1/swap_master_sub_transfer_record";// 20.获取母账户下的所有母子账户划转记录
    public static final String SWAP_API_TRADING_STATUS = "/swap-api/v1/swap_api_trading_status";// 21.获取用户API指标禁用信息


    //合约交易接口
    public static final String SWAP_CANCEL_AFTER = "/swap-api/v1/swap-cancel-after"; // 1.自动撤单
    public static final String SWAP_ORDER = "/swap-api/v1/swap_order"; // 2.合约下单
    public static final String SWAP_BATCHORDER = "/swap-api/v1/swap_batchorder"; // 3.合约批量下单
    public static final String SWAP_CANCEL = "/swap-api/v1/swap_cancel"; // 4.撤销订单
    public static final String SWAP_CANCELALL = "/swap-api/v1/swap_cancelall"; // 5.全部撤单
    public static final String SWAP_SWITCH_LEVER_RATE = "/swap-api/v1/swap_switch_lever_rate";// 6.切换杠杆
    public static final String SWAP_ORDER_INFO = "/swap-api/v1/swap_order_info"; // 7.获取合约订单信息
    public static final String SWAP_ORDER_DETAIL = "/swap-api/v1/swap_order_detail"; // 8.获取订单明细信息
    public static final String SWAP_OPENORDERS = "/swap-api/v1/swap_openorders"; // 9.获取合约当前未成交委托
    public static final String SWAP_HISORDERS_V3 = "/swap-api/v3/swap_hisorders"; // 10.获取合约历史委托(新)
    public static final String SWAP_HISORDERS_EXACT_V3 = "/swap-api/v3/swap_hisorders_exact"; // 11.组合查询合约历史委托(新)
    public static final String SWAP_MATCHRESULTS_V3 = "/swap-api/v3/swap_matchresults"; // 12.获取历史成交记录（新）
    public static final String SWAP_MATCHRESULTS_EXACT_V3 = "/swap-api/v3/swap_matchresults_exact"; // 13.组合查询用户历史成交记录（新）
    public static final String SWAP_LIGHTNING_CLOSE_POSITION = "/swap-api/v1/swap_lightning_close_position"; // 14.闪电平仓下单


    //合约策略订单接口
    public static final String SWAP_TRIGGER_ORDER = "/swap-api/v1/swap_trigger_order"; // 1.计划委托下单
    public static final String SWAP_TRIGGER_CANCEL = "/swap-api/v1/swap_trigger_cancel";// 2.计划委托撤单
    public static final String SWAP_TRIGGER_CANCELALL = "/swap-api/v1/swap_trigger_cancelall";// 3.计划委托全部撤单
    public static final String SWAP_TRIGGER_OPENORDERS = "/swap-api/v1/swap_trigger_openorders";// 4.获取计划委托当前委托
    public static final String SWAP_TRIGGER_HISORDERS = "/swap-api/v1/swap_trigger_hisorders";// 5.获取计划委托历史委托
    public static final String SWAP_TPSL_ORDER = "/swap-api/v1/swap_tpsl_order";// 6.对仓位设置止盈止损订单
    public static final String SWAP_TPSL_CANCEL = "/swap-api/v1/swap_tpsl_cancel";// 7.止盈止损订单撤单
    public static final String SWAP_TPSL_CANCELALL = "/swap-api/v1/swap_tpsl_cancelall";// 8.止盈止损订单全部撤单
    public static final String SWAP_TPSL_OPENORDERS = "/swap-api/v1/swap_tpsl_openorders";// 9.查询止盈止损订单当前委托
    public static final String SWAP_TPSL_HISORDERS = "/swap-api/v1/swap_tpsl_hisorders";// 10.查询止盈止损订单历史委托
    public static final String SWAP_RELATION_TPSL_ORDER = "/swap-api/v1/swap_relation_tpsl_order";// 11.查询开仓单关联的止盈止损订单详情
    public static final String SWAP_TRACK_ORDER = "/swap-api/v1/swap_track_order"; // 12.跟踪委托订单下单
    public static final String SWAP_TRACK_CANCEL= "/swap-api/v1/swap_track_cancel"; // 13.跟踪委托订单撤单
    public static final String SWAP_TRACK_CANCELALL = "/swap-api/v1/swap_track_cancelall"; // 14.跟踪委托订单全部撤单
    public static final String SWAP_TRACK_OPENORDERS = "/swap-api/v1/swap_track_openorders"; // 15.跟踪委托订单当前委托
    public static final String SWAP_TRACK_HISORDERS = "/swap-api/v1/swap_track_hisorders"; // 16.跟踪委托订单历史委托


    //合约划转接口
    public static final String USDT_SWAP_TRANSFER = "/v2/account/transfer"; // 1.现货-USDT永续账户间进行资金的划转

}
