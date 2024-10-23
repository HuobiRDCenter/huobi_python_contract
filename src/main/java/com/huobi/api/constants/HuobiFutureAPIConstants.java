package com.huobi.api.constants;

public class HuobiFutureAPIConstants {
    //基础信息
    public static final String CONTRACT_RISK_INFO = "/api/v1/contract_risk_info";// 1.查询合约风险准备金余额和预估分摊比例
    public static final String CONTRACT_INSURANCE_FUND = "/api/v1/contract_insurance_fund"; // 2.查询合约风险准备金余额历史数据
    public static final String CONTRACT_ADJUSTFACTOR = "/api/v1/contract_adjustfactor";// 3.查询平台阶梯调整系数
    public static final String CONTRACT_HIS_OPEN_INTEREST = "/api/v1/contract_his_open_interest"; // 4.平台持仓量的查询
    public static final String CONTRACT_LADDER_MARGIN = "/api/v1/contract_ladder_margin"; // 5.获取平台阶梯保证金
    public static final String CONTRACT_ELITE_ACCOUNT_RATIO = "/api/v1/contract_elite_account_ratio"; // 6.精英账户多空持仓对比-账户数
    public static final String CONTRACT_ELITE_POSITION_RATIO = "/api/v1/contract_elite_position_ratio"; // 7.精英账户多空持仓对比-持仓量
    public static final String CONTRACT_LIQUIDATION_ORDERS_V3  = "/api/v3/contract_liquidation_orders"; // 8.获取强平订单(新)
    public static final String CONTRACT_SETTLEMENT_RECORDS = "/api/v1/contract_settlement_records"; // 9.查询平台历史结算记录
    public static final String CONTRACT_PRICE_LIMIT = "/api/v1/contract_price_limit"; // 10.获取合约最高限价和最低限价
    public static final String CONTRACT_OPEN_INTEREST = "/api/v1/contract_open_interest";// 11.获取当前可用合约总持仓量
    public static final String CONTRACT_DELIVERY_PRICE = "/api/v1/contract_delivery_price"; // 12.获取预估交割价
    public static final String CONTRACT_ESTIMATED_SETTLEMENT_PRICE = "/api/v1/contract_estimated_settlement_price"; // 13.获取预估结算价
    public static final String CONTRACT_API_STATE = "/api/v1/contract_api_state"; // 14.查询系统状态
    public static final String CONTRACT_CONTRACT_INFO = "/api/v1/contract_contract_info"; // 15.获取合约信息
    public static final String CONTRACT_INDEX = "/api/v1/contract_index"; // 16.获取合约指数信息
    public static final String CONTRACT_QUERY_ELEMENTS = "/api/v1/contract_query_elements"; // 17.合约要素

    //合约市场行情接口
    public static final String MARKET_DEPTH = "/market/depth";// 1.获取行情深度数据
    public static final String MARKET_BBO = "/market/bbo"; // 2.获取市场最优挂单
    public static final String MARKET_HISTORY_KLINE = "/market/history/kline";// 3.获取K线数据
    public static final String MARK_PRICE_KLINE = "/index/market/history/mark_price_kline"; // 4.获取标记价格的K线数据
    public static final String MARKET_DETAIL_MERGED = "/market/detail/merged"; // 5.获取聚合行情
    public static final String BATCH_MERGED_V2 = "/v2/market/detail/batch_merged"; // 6.批量获取聚合行情（V2）
    public static final String MARKET_TRADE = "/market/trade";// 7.获取市场最近成交记录
    public static final String MARKET_HISTORY_TRADE = "/market/history/trade";  // 8.批量获取最近的交易记录
    public static final String MARKET_HISTORY_INDEX = "/index/market/history/index"; // 9.获取指数K线数据
    public static final String MARKET_HISTORY_BASIS = "/index/market/history/basis"; // 10.获取基差数据

    //合约资产接口
    public static final String CONTRACT_BALANCE_VALUATION = "/api/v1/contract_balance_valuation"; // 1.获取账户总资产估值
    public static final String CONTRACT_ACCOUNT_INFO = "/api/v1/contract_account_info"; // 2.获取用户账户信息
    public static final String CONTRACT_POSITION_INFO = "/api/v1/contract_position_info"; // 3.获取用户持仓信息
    public static final String CONTRACT_SUB_AUTH="/api/v1/contract_sub_auth"; // 4、批量设置子账户交易权限
    public static final String CONTRACT_SUB_AUTH_LIST = "/api/v1/contract_sub_auth_list"; // 5.查询子账户交易权限
    public static final String CONTRACT_SUB_ACCOUNT_LIST = "/api/v1/contract_sub_account_list"; // 6.查询母账户下所有子账户资产信息
    public static final String CONTRACT_SUB_ACCOUNT_INFO_LIST="/api/v1/contract_sub_account_info_list"; // 7、批量获取子账户资产信息
    public static final String CONTRACT_SUB_ACCOUNT_INFO = "/api/v1/contract_sub_account_info"; // 8.查询单个子账户资产信息
    public static final String CONTRACT_SUB_POSITION_INFO = "/api/v1/contract_sub_position_info"; // 9.查询单个子账户持仓信息
    public static final String CONTRACT_FINANCIAL_RECORD_V3 = "/api/v3/contract_financial_record"; // 10.查询用户财务记录(新)
    public static final String CONTRACT_FINANCIAL_RECORD_EXACT_V3 = "/api/v3/contract_financial_record_exact"; // 11.组合查询用户财务记录(新)
    public static final String CONTRACT_USER_SETTLEMENT_RECORDS = "/api/v1/contract_user_settlement_records";// 12、查询用户结算记录
    public static final String CONTRACT_ORDER_LIMIT = "/api/v1/contract_order_limit"; // 13.查询用户当前的下单量限制
    public static final String CONTRACT_FEE = "/api/v1/contract_fee"; // 14.查询用户当前的手续费费率
    public static final String CONTRACT_TRANSFER_LIMIT = "/api/v1/contract_transfer_limit"; // 15.查询用户当前的划转限制
    public static final String CONTRACT_POSITION_LIMIT = "/api/v1/contract_position_limit"; // 16.用户持仓量限制的查询
    public static final String CONTRACT_ACCOUNT_POSITION_INFO = "/api/v1/contract_account_position_info";// 17、查询用户账户和持仓信息
    public static final String CONTRACT_MASTER_SUB_TRANSFER = "/api/v1/contract_master_sub_transfer";// 18、母子账户划转
    public static final String CONTRACT_MASTER_SUB_TRANSFER_RECORD = "/api/v1/contract_master_sub_transfer_record";// 19、获取母账户下的所有母子账户划转记录
    public static final String CONTRACT_API_TRADING_STATUS="/api/v1/contract_api_trading_status"; // 20、获取用户的API指标禁用信息
    public static final String CONTRACT_AVAILABLE_LEVEL_RATE="/api/v1/contract_available_level_rate"; // 21、查询用户可用杠杆倍数


    //合約交易接口
    public static final String CONTRACT_CANCEL_AFTER = "/api/v1/contract-cancel-after"; // 1.自动撤单
    public static final String CONTRACT_ORDER = "/api/v1/contract_order"; // 2.合约下单
    public static final String CONTRACT_BATCHORDER = "/api/v1/contract_batchorder"; // 3.合约批量下单
    public static final String CONTRACT_CANCEL = "/api/v1/contract_cancel"; // 4.撤销订单
    public static final String CONTRACT_CANCELALL = "/api/v1/contract_cancelall"; // 5.全部撤单
    public static final String CONTRACT_SWITCH_LEVER_RATE="/api/v1/contract_switch_lever_rate"; // 6.切换杠杆
    public static final String CONTRACT_ORDER_INFO = "/api/v1/contract_order_info"; // 7.获取合约订单信息
    public static final String CONTRACT_ORDER_DETAIL = "/api/v1/contract_order_detail"; // 8.获取订单明细信息
    public static final String CONTRACT_OPENORDERS = "/api/v1/contract_openorders"; // 9.获取合约当前未成交委托
    public static final String CONTRACT_HISORDERS_V3 = "/api/v3/contract_hisorders"; // 10.获取合约历史委托(新)
    public static final String CONTRACT_HISORDERS_EXACT_V3 = "/api/v3/contract_hisorders_exact"; // 11.组合查询合约历史委托(新)
    public static final String CONTRACT_MATCHRESULTS_V3 = "/api/v3/contract_matchresults"; // 12.获取历史成交记录(新)
    public static final String CONTRACT_MATCHRESULTS_EXACT_V3 = "/api/v3/contract_matchresults_exact"; // 13.组合查询历史成交记录接口(新)
    public static final String LIGHTNING_CLOSE_POSITION = "/api/v1/lightning_close_position"; // 14.闪电平仓下单


    //合约策略订单接口
    public static final String CONTRACT_TRIGGER_ORDER = "/api/v1/contract_trigger_order";// 1.合约计划委托下单
    public static final String CONTRACT_TRIGGER_CANCEL="/api/v1/contract_trigger_cancel"; // 2.合约计划委托撤单
    public static final String CONTRACT_TRIGGER_CANCELALL="/api/v1/contract_trigger_cancelall";// 3.合约订单委托全部撤单
    public static final String CONTRACT_TRIGGER_OPENORDERS="/api/v1/contract_trigger_openorders"; // 4.获取计划委托当前委托
    public static final String CONTRACT_TRIGGER_HISORDERS="/api/v1/contract_trigger_hisorders"; // 5.获取计划委托历史委托
    public static final String CONTRACT_TPSL_ORDER="/api/v1/contract_tpsl_order"; // 6.对仓位设置止盈止损订单
    public static final String CONTRACT_TPSL_CANCEL="/api/v1/contract_tpsl_cancel"; // 7.止盈止损订单撤单
    public static final String CONTRACT_TPSL_CANCELALL="/api/v1/contract_tpsl_cancelall"; // 8.止盈止损订单全部撤单
    public static final String CONTRACT_TPSL_OPENORDERS="/api/v1/contract_tpsl_openorders"; // 9.查询止盈止损订单当前委托
    public static final String CONTRACT_TPSL_HISORDERS="/api/v1/contract_tpsl_hisorders"; // 10.查询止盈止损订单历史委托
    public static final String CONTRACT_RELATION_TPSL_ORDER="/api/v1/contract_relation_tpsl_order"; // 11.查询开仓单关联的止盈止损订单详情
    public static final String CONTRACT_TRACK_ORDER = "/api/v1/contract_track_order"; // 12.跟踪委托订单下单
    public static final String CONTRACT_TRACK_CANCEL= "/api/v1/contract_track_cancel"; // 13.跟踪委托订单撤单
    public static final String CONTRACT_TRACK_CANCELALL = "/api/v1/contract_track_cancelall"; // 14.跟踪委托订单全部撤单
    public static final String CONTRACT_TRACK_OPENORDERS = "/api/v1/contract_track_openorders"; // 15.跟踪委托订单当前委托
    public static final String CONTRACT_TRACK_HISORDERS = "/api/v1/contract_track_hisorders"; // 16.跟踪委托订单历史委托


    //合约划转接口
    public static final String FUTURES_TRANSFER = "/v1/futures/transfer"; // 1.现货-合约账户间进行资金的划转
    public static final String ACCOUNT_TRANSFER = "/v2/account/transfer"; // 2.现货-合约账户进行资金的划转

}
