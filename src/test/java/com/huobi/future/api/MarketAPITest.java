package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.request.coin_futures.account.ContractSettlementRecordsRequest;
import com.huobi.api.request.coin_futures.market.ContractLiquidationOrdersV3Request;
import com.huobi.api.response.coin_futures.market.*;
import com.huobi.api.response.usdt.market.BatchMergedV2Response;
import com.huobi.api.service.coin_futures.market.MarketAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class MarketAPITest implements BaseTest {

    MarketAPIServiceImpl huobiAPIService = new MarketAPIServiceImpl();

    @Test
    public void getMarketDepth() {
        MarketDepthResponse result =
                huobiAPIService.getMarketDepth("BTC_CW", "step0");
        logger.debug("1.获取行情深度数据：{}", JSON.toJSONString(result));
    }

    @Test
    public void getMarketBbo(){
        MarketBboResponse response=huobiAPIService.getMarketBbo("");
        logger.debug("2.获取市场最优挂单: {}",JSON.toJSONString(response));
    }

    @Test
    public void getMarketHistoryKline() {
        MarketHistoryKlineResponse result =
                huobiAPIService.getMarketHistoryKline("btc_cw", "1min", 10, null, null);
        logger.debug("3.获取K线数据：{}", JSON.toJSONString(result));
    }

    @Test
    public void getMarkPriceKline(){
        MarkPriceKlineResponse response=huobiAPIService.getMarkPriceKline("btc_cq","5min",10);
        logger.debug("4.获取标记价格的K线数据: {}",JSON.toJSONString(response));
    }

    @Test
    public void getMarketDetailMerged() {
        MarketDetailMergedResponse result =
                huobiAPIService.getMarketDetailMerged("btc_cw");
        logger.debug("5.获取聚合行情：{}", JSON.toJSONString(result));
    }

    @Test
    public void getBatchMergedV2(){
        BatchMergedV2Response response = huobiAPIService.getBatchMergedV2(null);
        logger.debug("6.批量获取聚合行情（V2）: {}",JSON.toJSONString(response));
    }

    @Test
    public void getMarketTrade() {
        MarketTradeResponse result =
                huobiAPIService.getMarketTrade("btc_cw");
        logger.debug("7.获取市场最近成交记录：{}", JSON.toJSONString(result));
    }

    @Test
    public void getMarketHistoryTrade() {
        MarketHistoryTradeResponse result =
                huobiAPIService.getMarketHistoryTrade("btc_cw", 10);
        logger.debug("8.批量获取最近的交易记录：{}", JSON.toJSONString(result));
    }

    @Test
    public void getMarketHistoryIndexResponse() {
        MarketHistoryIndexResponse response = huobiAPIService.getMarketHistoryIndex("btc-usd", "5min", 20);
        logger.debug("9.获取指线K线数据：{}", JSON.toJSONString(response));
    }

    @Test
    public void getMarketHistoryBasisResponse() {
        MarketHistoryBasisResponse response = huobiAPIService.getMarketHistoryBasis("btc_cq", "5min", "", 20);
        logger.debug("10.获取基差数据：{}", JSON.toJSONString(response));
    }
}
