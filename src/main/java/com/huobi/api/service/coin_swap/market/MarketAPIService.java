package com.huobi.api.service.coin_swap.market;


import com.huobi.api.request.coin_swap.account.LinearSwapBasisRequest;
import com.huobi.api.request.coin_swap.account.SwapLiquidationOrdersRequest;
import com.huobi.api.request.coin_swap.account.SwapMarketHistoryKlineRequest;
import com.huobi.api.request.coin_swap.market.SwapSettlementRecordsRequest;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersV3Request;
import com.huobi.api.response.coin_swap.market.*;
import com.huobi.api.response.usdt.account.SwapLiquidationOrdersV3Response;
import com.huobi.api.response.usdt.market.BatchMergedV2Response;
import com.huobi.api.response.usdt.market.SwapQueryElementsResponse;
import com.huobi.api.response.usdt.market.SwapSettlementRecordsResponse;

public interface MarketAPIService {
    SwapMarketDepthResponse getSwapMarketDepth(String contractCode, String type);// 1.获取行情深度数据

    MarketBboResponse getMarketBbo(String contractCode);// 2.获取市场最优挂单

    SwapMarketHistoryKlineResponse getSwapMarketHistoryKline(SwapMarketHistoryKlineRequest request);// 3.获取K线数据

    SwapMarkPriceKlineResponse getSwapMarkPriceKline(String contractCode,String period,Integer size);// 4.获取标记价格的 K 线数据

    SwapMarketDetailMergedResponse getSwapMarketDetailMerged(String contractCode);// 5.获取聚合行情

    BatchMergedV2Response getBatchMergedV2(String contractCode);// 6.批量获取聚合行情（V2）

    SwapMarketTradeResponse getSwapMarketTrade(String contractCode);// 7.获取市场最近成交记录

    SwapMarketHistoryTradeResponse getSwapMarketHistoryTrade(String contractCode,Integer size);// 8.批量获取最近的交易记录

    LinearSwapPremiumIndexKlineResponse getLinearSwapPremiumIndexKline(String contractCode,String period,Integer size);// 9.获取溢价指数K线数据

    LinearSwapEstimatedRateKlineResponse getLinearSwapEstimatedRateKline(String contractCode,String period,Integer size);// 10.获取预测资金费率的K线数据

    LinearSwapBasisResponse getLinearSwapBasis(LinearSwapBasisRequest request);// 11.获取基差数据
}
