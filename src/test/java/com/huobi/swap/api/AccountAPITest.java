package com.huobi.swap.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.request.coin_swap.account.*;
import com.huobi.api.request.usdt.account.SwapSubAuthListRequest;
import com.huobi.api.response.coin_swap.account.*;
import com.huobi.api.response.usdt.account.SwapSubAuthListResponse;
import com.huobi.api.service.coin_swap.account.AccountAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;


@FixMethodOrder(MethodSorters.JVM)
public class AccountAPITest implements BaseTest {


    AccountAPIServiceImpl huobiAPIService = new AccountAPIServiceImpl("", "");

    @Test
    public void getSwapBalanceValuation(){
        SwapBalanceValuationResponse response=huobiAPIService.getSwapBalanceValuation("cny");
        logger.debug("1.获取账户总资产估值：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapAccountInfoResponse() {
        SwapAccountInfoResponse response = huobiAPIService.getSwapAccountInfo("theta-usd");
        logger.debug("2.获取用户账户信息：{}", JSON.toJSONString(response));
        response = huobiAPIService.getSwapAccountInfo("");
        logger.debug("2.获取用户账户信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapPositionInfo() {
        SwapPositionInfoResponse response = huobiAPIService.getSwapPositionInfo("theta-usd");
        logger.debug("3.获取用户持仓信息：{}", JSON.toJSONString(response));
        response = huobiAPIService.getSwapPositionInfo("");
        logger.debug("3.获取用户持仓信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapAccountPositionInfo() {
        SwapAccountPositionInfoResponse response = huobiAPIService.getSwapAccountPositionInfo("theta-usd");
        logger.debug("4.查询用户账户和持仓信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapSubAuth(){
        SwapSubAuthResponse response=huobiAPIService.getSwapSubAuth("146190163,12345",1);
        logger.debug("5.批量设置子账户交易权限：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapSubAuthList(){
        SwapSubAuthListRequest request = SwapSubAuthListRequest.builder()
                .build();
        SwapSubAuthListResponse response = huobiAPIService.getSwapSubAuthList(request);
        logger.debug("6.查询子账户交易权限：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapSubAccountList() {
        SwapSubAccountListResponse response = huobiAPIService.getSwapSubAccountList("theta-usd", "next", null);
        logger.debug("7.查询母账户下所有子账户资产信息：{}", JSON.toJSONString(response));
        response = huobiAPIService.getSwapSubAccountList("","",null);
        logger.debug("7.查询母账户下所有子账户资产信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapSubAccountInfoList(){
        SwapSubAccountInfoListResponse response=huobiAPIService.getSwapSubAccountInfoList("",1,0);
        logger.debug("8.批量获取子账户资产信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapSubAccountInfo() {
        SwapSubAccountInfoResponse response = huobiAPIService.getSwapSubAccountInfo("theta-usd", 1l);
        logger.debug("9.查询单个子账户资产信息：{}", JSON.toJSONString(response));
        logger.debug(response.getStatus());
    }

    @Test
    public void getSwapSubPositionInfo() {
        SwapSubPositionInfoResponse response = huobiAPIService.getSwapSubPositionInfo("BTC-USD", 1l);
        logger.debug("10.查询单个子账户持仓信息：{}", JSON.toJSONString(response));
        logger.debug(response.getStatus());
    }

    @Test
    public void getSwapFinancialRecordV3(){
        SwapFinancialRecordV3Request request = SwapFinancialRecordV3Request.builder()
                .contract("BTC-USDT")
                .build();
        SwapFinancialRecordV3Response response = huobiAPIService.getSwapFinancialRecordV3(request);
        logger.debug("11.查询用户财务记录(新)：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapFinancialRecordExactV3(){
        SwapFinancialRecordExactV3Request request = SwapFinancialRecordExactV3Request.builder()
                .contract("BTC-USD")
                .build();
        SwapFinancialRecordExactV3Response response = huobiAPIService.getSwapFinancialRecordExactV3(request);
        logger.debug("12.组合查询用户财务记录(新)：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapUserSettlementRecords(){
        SwapUserSettlementRecordsRequest request= SwapUserSettlementRecordsRequest.builder()
                .contractCode("theta-usd")
                // .startTime()
                // .endTime()
                // .pageIndex()
                // .pageSize()
                .build();
        SwapUserSettlementRecordsResponse response=huobiAPIService.getSwapUserSettlementRecords(request);
        logger.debug("13.查询用户结算记录：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapAvailableLevelRate(){
        SwapAvailableLevelRateResponse response=huobiAPIService.getSwapAvailableLevelRate("theta-usd");
        logger.debug("14.查询用户可用杠杆倍数：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapOrderLimitResponse() {
        SwapOrderLimitResponse response = huobiAPIService.getSwapOrderLimitResponse("theta-usd", "limit");
        logger.debug("15.查询用户当前的下单量限制：{}", JSON.toJSONString(response));
        response = huobiAPIService.getSwapOrderLimitResponse("", "limit");
        logger.debug("15.查询用户当前的下单量限制：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapFeeResponse() {
        SwapFeeResponse response = huobiAPIService.getSwapFeeResponse("theta-USD");
        logger.debug("16.查询用户当前的手续费费率：{}", JSON.toJSONString(response));
        response = huobiAPIService.getSwapFeeResponse("");
        logger.debug("16.查询用户当前的手续费费率：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapTransferLimitResponse() {
        SwapTransferLimitResponse response = huobiAPIService.getSwapTransferLimitResponse("theta-usd");
        logger.debug("17.查询用户当前的划转限制：{}", JSON.toJSONString(response));
        response = huobiAPIService.getSwapTransferLimitResponse("");
        logger.debug("17.查询用户当前的划转限制：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapPositionLimitResponse() {
        SwapPositionLimitResponse response = huobiAPIService.getSwapPositionLimitResponse("theta-usd");
        logger.debug("18.用户持仓量限制的查询：{}", JSON.toJSONString(response));
        response = huobiAPIService.getSwapPositionLimitResponse("");
        logger.debug("18.用户持仓量限制的查询：{}", JSON.toJSONString(response));
    }

    @Test
    public void getOptionMasterSubTransferResponse() {
        SwapMasterSubTransferRequest request = SwapMasterSubTransferRequest.builder()
                .subUid(1l)
                .contractCode("THETA-USD")
                .amount(BigDecimal.valueOf(10))
                .type("sub_to_master")
                .build();
        SwapMasterSubTransferResponse response = huobiAPIService.getSwapMasterSubTransferResponse(request);
        logger.debug("19.母子账户划转：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapMasterSubTransferRecordResponse() {
        SwapMasterSubTransferRecordRequest request = SwapMasterSubTransferRecordRequest.builder()
                .contractCode("theta-USD")
                //.transferType("")
                .createDate(10)
                .pageIndex(1)
                .pageSize(20)
                .build();
        SwapMasterSubTransferRecordResponse response = huobiAPIService.getSwapMasterSubTransferRecordResponse(request);
        logger.debug("20.获取母账户下的所有母子账户划转记录：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapApiTradingStatusResponse() {
        SwapApiTradingStatusResponse response = huobiAPIService.getSwapApiTradingStatusResponse();
        logger.debug("21.获取用户API指标禁用信息：{}", JSON.toJSONString(response));
    }
}
