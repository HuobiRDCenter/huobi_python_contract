package com.huobi.usdt.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.request.usdt.account.LinearSwapBasisRequest;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersRequest;
import com.huobi.api.request.usdt.account.SwapMarketHistoryKlineRequest;
import com.huobi.api.response.usdt.account.*;
import com.huobi.api.response.usdt.market.*;
import com.huobi.api.service.usdt.market.MarketAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class MarketAPITest implements BaseTest {
    MarketAPIServiceImpl huobiAPIService = new MarketAPIServiceImpl();

    @Test
    public void getSwapMarketDepth() {
        SwapMarketDepthResponse result =
                huobiAPIService.getSwapMarketDepth("btc-usdt", "step15");
        logger.debug("1.获取行情深度数据：{}", JSON.toJSONString(result));
    }

    @Test
    public void getMarketBbo(){
        MarketBboResponse response= huobiAPIService.getMarketBbo("","");
        logger.debug("2、获取市场最优挂单:{}",JSON.toJSONString(response));
    }

    @Test
    public void getSwapMarketHistoryKline() {
        SwapMarketHistoryKlineRequest result = SwapMarketHistoryKlineRequest.builder()
                .contractCode("BTC-USDT")
                .period("15min")
                .size(1)
                //.from()
                //.to()
                .build();
        SwapMarketHistoryKlineResponse response = huobiAPIService.getSwapMarketHistoryKline(result);
        logger.debug("3.获取K线数据：{}", JSON.toJSONString(response));
    }

    @Test
    public void getLinearSwapMarkPriceKline() {
        LinearSwapMarkPriceKlineResponse response = huobiAPIService.getLinearSwapMarkPriceKline("btc-usdt", "1min", 10);
        logger.debug("4、获取标记价格的K线数据:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapMarketDetailMergedResponse() {
        SwapMarketDetailMergedResponse result =
                huobiAPIService.getSwapMarketDetailMerged("BTC-USDT");
        logger.debug("5.获取聚合行情：{}", JSON.toJSONString(result));
    }

    @Test
    public void getBatchMergedV2(){
        BatchMergedV2Response response = huobiAPIService.getBatchMergedV2(null, null);
        logger.debug("6、批量获取聚合行情（V2）:{}",JSON.toJSONString(response));
    }

    @Test
    public void getSwapMarketTradeResponse() {
        SwapMarketTradeResponse response = huobiAPIService.getSwapMarketTrade("BTC-USDT","");
        logger.debug("7.获取市场最近成交记录:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapMarketHistoryTradeResponse() {
        SwapMarketHistoryTradeResponse response = huobiAPIService.getSwapMarketHistoryTrade("BTC-USDT", 100);
        logger.debug("8.批量获取最近的交易记录:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapHisOpenInterestResponse() {
        SwapHisOpenInterestResponse response = huobiAPIService.getSwapHisOpenInterest("BTC-USDT", "", "", "60min",10,1);
        logger.debug("9.平台持仓量的查询:{}", JSON.toJSONString(response));
    }

    @Test
    public void getLinearSwapPremiumIndexKlineResponse() {
        LinearSwapPremiumIndexKlineResponse response =
                huobiAPIService.getLinearSwapPremiumIndexKline("BTC-USDT", "5min", 10);
        logger.debug("10.获取合约的溢价指数K线:{}", JSON.toJSONString(response));
    }

    @Test
    public void getLinearSwapEstimatedRateKlineResponse() {
        LinearSwapEstimatedRateKlineResponse response =
                huobiAPIService.getLinearSwapEstimatedRateKline("BTC-USDT", "5min", 10);
        logger.debug("11.获取实时预测资金费率的K线数据:{}", JSON.toJSONString(response));
    }

    @Test
    public void getLinearSwapBasisResponse() {
        LinearSwapBasisRequest request = LinearSwapBasisRequest.builder()
                .contractCode("BTC-USDT")
                .period("60min")
                .basisPriceType("open")
                .size(10)
                .build();
        LinearSwapBasisResponse response = huobiAPIService.getLinearSwapBasis(request);
        logger.debug("12.获取基差数据:{}", JSON.toJSONString(response));
    }
}
