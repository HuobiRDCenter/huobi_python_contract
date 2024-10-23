package com.huobi.api.service.usdt.market;

import com.huobi.api.request.usdt.account.LinearSwapBasisRequest;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersRequest;
import com.huobi.api.request.usdt.account.SwapMarketHistoryKlineRequest;
import com.huobi.api.response.usdt.market.*;

public interface MarketAPIService {
    SwapMarketDepthResponse getSwapMarketDepth(String contractCode, String type);// 1.获取行情深度数据

    MarketBboResponse getMarketBbo(String contractCode,String businessType);// 2.获取市场最优挂单

    SwapMarketHistoryKlineResponse getSwapMarketHistoryKline(SwapMarketHistoryKlineRequest request);// 3.获取K线数据

    LinearSwapMarkPriceKlineResponse getLinearSwapMarkPriceKline(String contractCode, String period, Integer size);// 4.获取标记价格的 K 线数据

    SwapMarketDetailMergedResponse getSwapMarketDetailMerged(String contractCode); // 5.获取聚合行情

    BatchMergedV2Response getBatchMergedV2(String contractCode,String businessType);// 6.批量获取聚合行情（V2）

    SwapMarketTradeResponse getSwapMarketTrade(String contractCode,String businessType);// 7.获取市场最近成交记录

    SwapMarketHistoryTradeResponse getSwapMarketHistoryTrade(String contractCode, Integer size);// 8.批量获取最近的交易记录

    SwapHisOpenInterestResponse getSwapHisOpenInterest(String contractCode,String pair,String contractType, String period, Integer size, Integer amountType);// 9.平台持仓量的查询

    LinearSwapPremiumIndexKlineResponse getLinearSwapPremiumIndexKline(String contractCode, String period, Integer size);// 10.获取溢价指数K线数据

    LinearSwapEstimatedRateKlineResponse getLinearSwapEstimatedRateKline(String contractCode, String period, Integer size);// 11.获取预测资金费率的K线数据

    LinearSwapBasisResponse getLinearSwapBasis(LinearSwapBasisRequest request);// 12.获取基差数据
}
