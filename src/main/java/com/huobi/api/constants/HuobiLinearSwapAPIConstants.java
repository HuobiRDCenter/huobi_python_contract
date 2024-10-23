package com.huobi.api.constants;

public class HuobiLinearSwapAPIConstants {
    //基础信息
    public static final String SWAP_FUNDING_RATE = "/linear-swap-api/v1/swap_funding_rate";  // 1.获取合约的资金费率
    public static final String SWAP_BATCH_FUNDING_RATE = "/linear-swap-api/v1/swap_batch_funding_rate";  // 2.批量获取合约资金费率
    public static final String SWAP_HISTORICAL_FUNDING_RATE = "/linear-swap-api/v1/swap_historical_funding_rate";  // 3.获取合约的历史资金费率
    public static final String SWAP_LIQUIDATION_ORDERS_V3 = "/linear-swap-api/v3/swap_liquidation_orders"; // 4.获取强平订单(新)
    public static final String SWAP_SETTLEMENT_RECORDS="/linear-swap-api/v1/swap_settlement_records";// 5.查询平台历史结算记录
    public static final String SWAP_ELITE_ACCOUNT_RATIO = "/linear-swap-api/v1/swap_elite_account_ratio";  // 6.精英账户多空持仓对比-账户数
    public static final String SWAP_ELITE_POSITION_RATIO = "/linear-swap-api/v1/swap_elite_position_ratio";  // 7.精英账户多空持仓对比-持仓量
    public static final String SWAP_API_STATE = "/linear-swap-api/v1/swap_api_state"; // 8.查询系统状态
    public static final String SWAP_LADDER_MARGIN = "/linear-swap-api/v1/swap_ladder_margin";  // 9.获取平台阶梯保证金
    public static final String SWAP_ESTIMATED_SETTLEMENT_PRICE = "/linear-swap-api/v1/swap_estimated_settlement_price"; // 10.获取预估结算价
    public static final String SWAP_ADJUSTFACTOR = "/linear-swap-api/v1/swap_adjustfactor";  // 11.查询平台阶梯调整系数
    public static final String SWAP_INSURANCE_FUND = "/linear-swap-api/v1/swap_insurance_fund"; // 12.获取风险准备金历史数据
    public static final String SWAP_RISK_INFO = "/linear-swap-api/v1/swap_risk_info";// 13.查询合约风险准备金和预估分摊比例
    public static final String SWAP_PRICE_LIMIT = "/linear-swap-api/v1/swap_price_limit"; // 14.获取合约最高限价和最低限价
    public static final String SWAP_OPEN_INTEREST = "/linear-swap-api/v1/swap_open_interest";// 15.获取当前可用合约总持仓量
    public static final String SWAP_CONTRACT_INFO = "/linear-swap-api/v1/swap_contract_info"; // 16.获取合约信息
    public static final String SWAP_INDEX = "/linear-swap-api/v1/swap_index"; // 17.获取合约指数信息
    public static final String SWAP_QUERY_ELEMENTS = "/linear-swap-api/v1/swap_query_elements"; // 18.合约要素

    //合约市场行情接口
    public static final String SWAP_MARKET_DEPTH = "/linear-swap-ex/market/depth";// 1.获取行情深度数据
    public static final String MARKET_BBO = "/linear-swap-ex/market/bbo";  // 2.获取市场最优挂单
    public static final String SWAP_MARKET_HISTORY_KLINE = "/linear-swap-ex/market/history/kline";// 3.获取K线数据
    public static final String LINEAR_SWAP_MARK_PRICE_KLINE = "/index/market/history/linear_swap_mark_price_kline";  // 4.获取标记价格的 K 线数据
    public static final String SWAP_MARKET_DETAIL_MERGED = "/linear-swap-ex/market/detail/merged"; // 5.获取聚合行情
    public static final String BATCH_MERGED_V2 = "/v2/linear-swap-ex/market/detail/batch_merged"; // 6.批量获取聚合行情（V2）
    public static final String SWAP_MARKET_TRADE = "/linear-swap-ex/market/trade";// 7.获取市场最近成交记录
    public static final String SWAP_MARKET_HISTORY_TRADE = "/linear-swap-ex/market/history/trade";  // 8.批量获取最近的交易记录
    public static final String SWAP_HIS_OPEN_INTEREST = "/linear-swap-api/v1/swap_his_open_interest"; // 9.平台持仓量的查询
    public static final String LINEAR_SWAP_PREMIUM_INDEX_KLINE = "/index/market/history/linear_swap_premium_index_kline";  // 10.获取溢价指数K线数据
    public static final String LINEAR_SWAP_ESTIMATED_RATE_KLINE = "/index/market/history/linear_swap_estimated_rate_kline";  // 11.获取预测资金费率的K线数据
    public static final String LINEAR_SWAP_BASIS = "/index/market/history/linear_swap_basis";  // 12.获取基差数据

    //合约资产接口
    public static final String SWAP_BALANCE_VALUATION = "/linear-swap-api/v1/swap_balance_valuation"; // 1.获取账户总资产估值
    public static final String SWAP_ACCOUNT_INFO = "/linear-swap-api/v1/swap_account_info"; // 2.获取用户账户信息
    public static final String SWAP_POSITION_INFO = "/linear-swap-api/v1/swap_position_info"; // 3.获取用户持仓信息
    public static final String SWAP_ACCOUNT_POSITION_INFO = "/linear-swap-api/v1/swap_account_position_info";// 4.获取用户资产和持仓信息
    public static final String SWAP_SUB_AUTH = "/linear-swap-api/v1/swap_sub_auth"; // 5.批量设置子账户交易权限
    public static final String SWAP_SUB_AUTH_LIST = "/linear-swap-api/v1/swap_sub_auth_list"; // 6.【通用】查询子账户交易权限
    public static final String SWAP_SUB_ACCOUNT_LIST = "/linear-swap-api/v1/swap_sub_account_list"; // 7.查询母账户下所有子账户资产信息
    public static final String SWAP_SUB_ACCOUNT_INFO_LIST = "/linear-swap-api/v1/swap_sub_account_info_list"; // 8.批量获取子账户资产信息
    public static final String SWAP_SUB_ACCOUNT_INFO = "/linear-swap-api/v1/swap_sub_account_info"; // 9.查询单个子账户资产信息
    public static final String SWAP_SUB_POSITION_INFO = "/linear-swap-api/v1/swap_sub_position_info"; // 10.查询单个子账户持仓信息
    public static final String SWAP_FINANCIAL_RECORD_V3 = "/linear-swap-api/v3/swap_financial_record"; // 11.查询用户财务记录(新)
    public static final String SWAP_FINANCIAL_RECORD_EXACT_V3 = "/linear-swap-api/v3/swap_financial_record_exact"; // 12.组合查询用户财务记录 (新)
    public static final String SWAP_AVAILABLE_LEVEL_RATE = "/linear-swap-api/v1/swap_available_level_rate";// 13.查询用户可用杠杆倍数
    public static final String SWAP_ORDER_LIMIT = "/linear-swap-api/v1/swap_order_limit"; // 14.查询用户当前的下单量限制
    public static final String SWAP_FEE = "/linear-swap-api/v1/swap_fee"; // 15.查询用户当前的手续费费率
    public static final String SWAP_TRANSFER_LIMIT = "/linear-swap-api/v1/swap_transfer_limit"; // 16.查询用户当前的划转限制
    public static final String SWAP_POSITION_LIMIT = "/linear-swap-api/v1/swap_position_limit"; // 17.用户持仓量限制的查询
    public static final String SWAP_LEVER_POSITION_LIMIT="/linear-swap-api/v1/swap_lever_position_limit";// 18.查询用户所有杠杆持仓量限制
    public static final String SWAP_MASTER_SUB_TRANSFER = "/linear-swap-api/v1/swap_master_sub_transfer";// 19.母子账户划转
    public static final String SWAP_MASTER_SUB_TRANSFER_RECORD = "/linear-swap-api/v1/swap_master_sub_transfer_record";// 20.获取母账户下的所有母子账户划转记录
    public static final String SWAP_TRANSFER_INNER = "/linear-swap-api/v1/swap_transfer_inner";// 21.同账号不同保证金账户的划转
    public static final String SWAP_API_TRADING_STATUS = "/linear-swap-api/v1/swap_api_trading_status";// 22.获取用户API指标禁用信息

    //合约交易接口
    public static final String LINEAR_CANCEL_AFTER = "/linear-swap-api/v1/linear-cancel-after"; // 1.自动撤单
    public static final String SWAP_SWITCH_POSITION_MODE="/linear-swap-api/v1/swap_switch_position_mode";// 2.切换持仓模式
    public static final String SWAP_ORDER = "/linear-swap-api/v1/swap_order"; // 3.合约下单
    public static final String SWAP_BATCHORDER = "/linear-swap-api/v1/swap_batchorder"; // 4.合约批量下单
    public static final String SWAP_CANCEL = "/linear-swap-api/v1/swap_cancel"; // 5.撤销订单
    public static final String SWAP_CANCELALL = "/linear-swap-api/v1/swap_cancelall"; // 6.全部撤单
    public static final String SWAP_SWITCH_LEVER_RATE = "/linear-swap-api/v1/swap_switch_lever_rate";// 7.切换杠杆
    public static final String SWAP_ORDER_INFO = "/linear-swap-api/v1/swap_order_info"; // 8.获取合约订单信息
    public static final String SWAP_ORDER_DETAIL = "/linear-swap-api/v1/swap_order_detail"; // 9.获取订单明细信息
    public static final String SWAP_OPENORDERS = "/linear-swap-api/v1/swap_openorders"; // 10.获取合约当前未成交委托
    public static final String SWAP_HISORDERS_V3 = "/linear-swap-api/v3/swap_hisorders"; // 11.获取合约历史委托(新)
    public static final String SWAP_HISORDERS_EXACT_V3 = "/linear-swap-api/v3/swap_hisorders_exact"; // 12.组合查询合约历史委托(新)
    public static final String SWAP_MATCHRESULTS_V3 = "/linear-swap-api/v3/swap_matchresults"; // 13.获取历史成交记录(新)
    public static final String SWAP_MATCHRESULTS_EXACT_V3 = "/linear-swap-api/v3/swap_matchresults_exact"; // 14.组合查询用户历史成交记录(新)
    public static final String SWAP_LIGHTNING_CLOSE_POSITION = "/linear-swap-api/v1/swap_lightning_close_position"; // 15.闪电平仓下单
    public static final String SWAP_POSITION_SIDE = "/linear-swap-api/v1/swap_position_side"; // 16.查询持仓模式

    //合约策略订单接口
    public static final String SWAP_TRIGGER_ORDER = "/linear-swap-api/v1/swap_trigger_order"; // 1.计划委托下单
    public static final String SWAP_TRIGGER_CANCEL = "/linear-swap-api/v1/swap_trigger_cancel";// 2.计划委托撤单
    public static final String SWAP_TRIGGER_CANCELALL = "/linear-swap-api/v1/swap_trigger_cancelall";// 3.计划委托全部撤单
    public static final String SWAP_TRIGGER_OPENORDERS = "/linear-swap-api/v1/swap_trigger_openorders";// 4.获取计划委托当前委托
    public static final String SWAP_TRIGGER_HISORDERS = "/linear-swap-api/v1/swap_trigger_hisorders";// 5.获取计划委托历史委托
    public static final String SWAP_TPSL_ORDER = "/linear-swap-api/v1/swap_tpsl_order";// 6.对仓位设置止盈止损订单
    public static final String SWAP_TPSL_CANCEL = "/linear-swap-api/v1/swap_tpsl_cancel";// 7.止盈止损订单撤单
    public static final String SWAP_TPSL_CANCELALL = "/linear-swap-api/v1/swap_tpsl_cancelall";// 8.止盈止损订单全部撤单
    public static final String SWAP_TPSL_OPENORDERS = "/linear-swap-api/v1/swap_tpsl_openorders";// 9.查询止盈止损订单当前委托
    public static final String SWAP_TPSL_HISORDERS = "/linear-swap-api/v1/swap_tpsl_hisorders";// 10.查询止盈止损订单历史委托
    public static final String SWAP_RELATION_TPSL_ORDER = "/linear-swap-api/v1/swap_relation_tpsl_order";// 11.查询开仓单关联的止盈止损订单详情
    public static final String SWAP_TRACK_ORDER = "/linear-swap-api/v1/swap_track_order"; // 12.跟踪委托订单下单
    public static final String SWAP_TRACK_CANCEL= "/linear-swap-api/v1/swap_track_cancel"; // 13.跟踪委托订单撤单
    public static final String SWAP_TRACK_CANCELALL = "/linear-swap-api/v1/swap_track_cancelall"; // 14.跟踪委托订单全部撤单
    public static final String SWAP_TRACK_OPENORDERS = "/linear-swap-api/v1/swap_track_openorders"; // 15.跟踪委托订单当前委托
    public static final String SWAP_TRACK_HISORDERS = "/linear-swap-api/v1/swap_track_hisorders"; // 16.跟踪委托订单历史委托

    //合约划转接口
    public static final String USDT_SWAP_TRANSFER = "/v2/account/transfer"; // 1.现货-USDT永续账户间进行资金的划转

    //合约统一账户
    public static final String UNIFIED_ACCOUNT_INFO = "/linear-swap-api/v3/unified_account_info"; // 1.查询统一账户资产
    public static final String LINEAR_SWAP_OVERVIEW_ACCOUNT_INFO = "/linear-swap-api/v3/linear_swap_overview_account_info"; // 2.可抵扣HT资产查询
    public static final String LINEAR_SWAP_FEE_SWITCH = "/linear-swap-api/v3/linear_swap_fee_switch"; // 3.设置U本位合约手续费抵扣方式
    public static final String FIX_POSITION_MARGIN_CHANGE = "/linear-swap-api/v3/fix_position_margin_change"; // 4.调整逐仓持仓保证金
    public static final String FIX_POSITION_MARGIN_CHANGE_RECORD = "/linear-swap-api/v3/fix_position_margin_change_record"; // 5.查询调整逐仓持仓保证金记录
    public static final String SWAP_UNIFIED_ACCOUNT_TYPE = "/linear-swap-api/v3/swap_unified_account_type"; // 6.账户类型查询
    public static final String SWAP_SWITCH_ACCOUNT_TYPE = "/linear-swap-api/v3/swap_switch_account_type"; // 7.账户类型更改接口
}
