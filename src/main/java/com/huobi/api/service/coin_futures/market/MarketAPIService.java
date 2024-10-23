package com.huobi.api.service.coin_futures.market;

import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.request.coin_futures.account.ContractSettlementRecordsRequest;
import com.huobi.api.request.coin_futures.market.ContractLiquidationOrdersV3Request;
import com.huobi.api.response.coin_futures.market.*;
import com.huobi.api.response.usdt.market.BatchMergedV2Response;


public interface MarketAPIService {
    MarketDepthResponse getMarketDepth(String symbol, String contractType);// 1.获取行情深度数据

    MarketBboResponse getMarketBbo(String symbol);// 2.获取市场最优挂单

    MarketHistoryKlineResponse getMarketHistoryKline(String symbol, String period, Integer size, Long from, Long to);// 3.获取K线数据

    MarkPriceKlineResponse getMarkPriceKline(String symbol,String period,Integer size);// 4.获取标记价格的K线数据

    MarketDetailMergedResponse getMarketDetailMerged(String symbol);// 5.获取聚合行情

    BatchMergedV2Response getBatchMergedV2(String symbol);// 6.批量获取聚合行情（V2）

    MarketTradeResponse getMarketTrade(String symbol);// 7.获取市场最近成交记录

    MarketHistoryTradeResponse getMarketHistoryTrade(String symbol, Integer size);// 8.批量获取最近的交易记录

    MarketHistoryIndexResponse getMarketHistoryIndex(String symbol,String period,Integer size);// 9.获取指数K线数据

    MarketHistoryBasisResponse getMarketHistoryBasis(String symbol,String period,String basisPriceType,Integer size);// 10.获取基差数据
}
