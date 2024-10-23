package com.huobi.swap.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.request.coin_swap.market.SwapSettlementRecordsRequest;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersV3Request;
import com.huobi.api.response.coin_swap.market.*;
import com.huobi.api.response.usdt.account.SwapLiquidationOrdersV3Response;
import com.huobi.api.response.usdt.market.SwapQueryElementsResponse;
import com.huobi.api.response.usdt.market.SwapSettlementRecordsResponse;
import com.huobi.api.service.coin_swap.reference.ReferenceAPIServiceImpl;
import com.huobi.usdt.api.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class ReferenceAPITest implements BaseTest {
    ReferenceAPIServiceImpl huobiAPIService = new ReferenceAPIServiceImpl();

    @Test
    public void getSwapRiskInfoResponse() {
        SwapRiskInfoResponse response = huobiAPIService.getSwapRiskInfo("");
        logger.debug("1.查询合约风险准备金余额和预估分摊比例:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapInsuranceFundResponse() {
        SwapInsuranceFundResponse response = huobiAPIService.getSwapInsuranceFund("BTC-USD", 1, 10);
        logger.debug("2.查询合约风险准备金余额历史数据:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapAdjustfactorResponse() {
        SwapAdjustfactorResponse response = huobiAPIService.getSwapAdjustfactor("BTC-USD");
        logger.debug("3.查询平台阶梯调整系数:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapHisOpenInterestResponse() {
        SwapHisOpenInterestResponse response = huobiAPIService.getSwapHisOpenInterest("BTC-USD", "60min", 10, 1);
        logger.debug("4.平台持仓量的查询:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapLadderMargin(){
        SwapLadderMarginResponse response=huobiAPIService.getSwapLadderMargin("btc-usd");
        logger.debug("5.获取平台阶梯保证金:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapEliteAccountRatioResponse() {
        SwapEliteAccountRatioResponse response = huobiAPIService.getSwapEliteAccountRatio("THETA-USD", "5min");
        logger.debug("6.精英账户多空持仓对比-账户数:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapElitePositionRatioResponse() {
        SwapElitePositionRatioResponse response = huobiAPIService.getSwapElitePositionRatio("THETA-USD", "5min");
        logger.debug("7.精英账户多空持仓对比-持仓量:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapEstimatedSettlementPriceResponse(){
        SwapEstimatedSettlementPriceResponse response=huobiAPIService.getSwapEstimatedSettlementPrice("btc-usd");
        logger.debug("8.获取预估结算价:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapApiStateResponse() {
        SwapApiStateResponse response = huobiAPIService.getSwapApiState("");
        logger.debug("9.查询系统状态:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapFundingRateResponse() {
        SwapFundingRateResponse response = huobiAPIService.getSwapFundingRate("BTC-USD");
        logger.debug("10.获取合约的资金费率:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapBatchFundingRate(){
        SwapBatchFundingRateResponse response=huobiAPIService.getSwapBatchFundingRate("");
        logger.debug("11.批量获取合约资金费率:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapHistoricalFundingRateResponse() {
        SwapHistoricalFundingRateResponse response = huobiAPIService.getSwapHistoricalFundingRate("BTC-USD", 1, 10);
        logger.debug("12.获取合约的历史资金费率:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapLiquidationOrdersV3(){
        SwapLiquidationOrdersV3Request request = SwapLiquidationOrdersV3Request.builder()
                .contract("BTC-USD")
                .tradeType(0)
                .build();
        SwapLiquidationOrdersV3Response response = huobiAPIService.getSwapLiquidationOrdersV3(request);
        logger.debug("13.获取强平订单(新):{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapSettlementRecords(){
        SwapSettlementRecordsRequest request = SwapSettlementRecordsRequest.builder()
                .contractCode("BTC-USD")
                .build();
        SwapSettlementRecordsResponse response = huobiAPIService.getSwapSettlementRecords(request);
        logger.debug("14.查询平台历史结算记录:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapContractInfo() {
        SwapContractInfoResponse result =
                huobiAPIService.getSwapContractInfo("BTC-USD");
        logger.debug("15.获取合约信息：{}", JSON.toJSONString(result));
        result =huobiAPIService.getSwapContractInfo("");
        logger.debug("15.获取合约信息：{}", JSON.toJSONString(result));
    }

    @Test
    public void getSwapIndex() {
        SwapIndexResponse result =
                huobiAPIService.getSwapIndex("btc-usd");
        logger.debug("16.获取合约指数信息：{}", JSON.toJSONString(result));
        result =
                huobiAPIService.getSwapIndex("");
        logger.debug("16.获取合约指数信息：{}", JSON.toJSONString(result));
    }

    @Test
    public void getSwapQueryElements(){
        SwapQueryElementsResponse response = huobiAPIService.getSwapQueryElements("BTC");
        logger.debug("17.合约要素:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapPriceLimit() {
        SwapPriceLimitResponse result =
                huobiAPIService.getSwapPriceLimit("BTC-USD");
        logger.debug("18.获取合约最高限价和最低限价：{}", JSON.toJSONString(result));
    }

    @Test
    public void getSwapOpenInterest() {
        SwapOpenInterestResponse result =
                huobiAPIService.getSwapOpenInterest("btc-usd");
        logger.debug("19.获取当前可用合约总持仓量:{}", JSON.toJSONString(result));
        result = huobiAPIService.getSwapOpenInterest("");
        logger.debug("19.获取当前可用合约总持仓量:{}", JSON.toJSONString(result));
    }

    @Test
    public void getTimestamp(){
        TimestampReponse response = huobiAPIService.getTimestamp();
        logger.debug("20.获取当前系统时间戳:{}", JSON.toJSONString(response));
    }

    @Test
    public void getHeartBeat(){
        HeartBeatResponse response = huobiAPIService.getHeartBeat();
        logger.debug("21.查询系统是否可用:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSummary(){
        SummaryResponse response = huobiAPIService.getSummary();
        logger.debug("22.获取当前系统状态:{}", JSON.toJSONString(response));
    }

}
