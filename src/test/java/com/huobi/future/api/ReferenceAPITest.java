package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.request.coin_futures.account.ContractSettlementRecordsRequest;
import com.huobi.api.request.coin_futures.market.ContractLiquidationOrdersV3Request;
import com.huobi.api.response.coin_futures.market.*;
import com.huobi.api.service.coin_futures.account.AccountAPIServiceImpl;
import com.huobi.api.service.coin_futures.reference.ReferenceAPIServiceImpl;
import com.huobi.usdt.api.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class ReferenceAPITest implements BaseTest {
    ReferenceAPIServiceImpl huobiAPIService = new ReferenceAPIServiceImpl();

    @Test
    public void getContractRiskInfoResponse() {
        ContractRiskInfoResponse result =
                huobiAPIService.getContractRiskInfo("btc");
        logger.debug("1.查询合约风险准备金余额和预估分摊比例：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractInsuranceFundResponse() {
        ContractInsuranceFundResponse result =
                huobiAPIService.getContractInsuranceFund("btc");
        logger.debug("2.查询合约风险准备金余额历史数据：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractAdjustfactorResponse() {
        ContractAdjustfactorResponse result =
                huobiAPIService.getContractAdjustfactor("btc");
        logger.debug("3.查询平台阶梯调整系数：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractHisOpenInterestResponse() {
        ContractHisOpenInterestResponse result =
                huobiAPIService.getContractHisOpenInterest("btc", "this_week", TimePeriodTypeEnum.ONE_DAY, 10, 1);
        logger.debug("4.平台持仓量的查询：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractLadderMargin(){
        ContractLadderMarginResponse response=huobiAPIService.getContractLadderMargin("btc");
        logger.debug("5.获取平台阶梯保证金: {}",JSON.toJSONString(response));
    }

    @Test
    public void getContractEliteAccountRatioResponse() {
        ContractEliteAccountRatioResponse result =
                huobiAPIService.getContractEliteAccountRatio("btc", "60min");
        logger.debug("6.精英账户多空持仓对比-账户数：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractElitePositionRatioResponse() {
        ContractElitePositionRatioResponse result =
                huobiAPIService.getContractElitePositionRatio("btc", "5min");
        logger.debug("7.精英账户多空持仓对比-持仓量：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractLiquidationOrdersV3(){
        ContractLiquidationOrdersV3Request request = ContractLiquidationOrdersV3Request.builder()
                .tradeType(5)
                .symbol("BTC")
                .build();
        ContractLiquidationOrdersV3Response response = huobiAPIService.getContractLiquidationOrdersV3(request);
        logger.debug("8.获取强平订单(新): {}",JSON.toJSONString(response));
    }

    @Test
    public void getContractSettlementRecordsResponse() {
        ContractSettlementRecordsRequest request = ContractSettlementRecordsRequest.builder()
                .symbol("ada")
                //.startTime()
                //.endTime()
                //.pageIndex()
                //.pageSize()
                .build();
        ContractSettlementRecordsResponse response = huobiAPIService.getContractSettlementRecords(request);
        logger.debug("9.查询平台历史结算记录：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractPriceLimit() {
        ContractPriceLimitResponse result =
                huobiAPIService.getContractPriceLimit("btc", "this_week", "");
        logger.debug("10.获取合约最高限价和最低限价：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractOpenInterest() {
        ContractOpenInterestResponse result =
                huobiAPIService.getContractOpenInterest("btc", "this_week", "");
        logger.debug("11.获取当前可用合约总持仓量：{}", JSON.toJSONString(result));
        result =
                huobiAPIService.getContractOpenInterest("", "", "");
        logger.debug("11.获取当前可用合约总持仓量：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractDeliveryPrice() {
        ContractDeliveryPriceResponse result = huobiAPIService.getContractDeliveryPrice("btc");
        logger.debug("12.获取预估交割价：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractEstimatedSettlementPriceResponse(){
        ContractEstimatedSettlementPriceResponse response=huobiAPIService.getContractEstimatedSettlementPriceResponse("btc");
        logger.debug("13.获取预估结算价: {}",JSON.toJSONString(response));
    }

    @Test
    public void getContractApiState() {
        ContractApiStateResponse result =
                huobiAPIService.getContractApiState("");
        logger.debug("14.查询系统状态：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractContractInfo() {
        ContractContractInfoResponse result =
                huobiAPIService.getContractContractInfo("", "", "");
        logger.debug("15.获取合约信息：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractIndex() {
        ContractIndexResponse result =
                huobiAPIService.getContractIndex("btc");
        logger.debug("16.获取合约指数信息：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractQueryElements(){
        ContractQueryElementsResponse response = huobiAPIService.getContractQueryElements(null);
        logger.debug("17.合约要素: {}",JSON.toJSONString(response));
    }

}
