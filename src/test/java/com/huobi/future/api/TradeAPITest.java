package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import com.huobi.api.request.coin_futures.trade.*;
import com.huobi.api.response.coin_futures.trade.*;
import com.huobi.api.service.coin_futures.trade.TradeAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.JVM)
public class TradeAPITest implements BaseTest {


    TradeAPIServiceImpl huobiAPIService = new TradeAPIServiceImpl("", "");

    @Test
    public void contractCancelAfterResponse(){
        ContractCancelAfterRequest request = ContractCancelAfterRequest.builder()
                .onOff(1)
                .build();
        ContractCancelAfterResponse response = huobiAPIService.contractCancelAfterResponse(request);
        logger.debug("1.自动撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractOrderRequest() {

        ContractOrderRequest request = ContractOrderRequest.builder()
                .symbol("btc")
                .contractType("quarter")
                .volume(1l)
                .price(BigDecimal.valueOf(7450.01))
                .direction(DirectionEnum.BUY)
                .offset(OffsetEnum.OPEN)
                .leverRate(10)
                .orderPriceType("limit")
                .build();
        ContractOrderResponse response =
                huobiAPIService.contractOrderRequest(request);
        logger.debug("2.合约下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractBatchorderRequest() {
        List<ContractOrderRequest> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ContractOrderRequest request = ContractOrderRequest.builder()
                    .symbol("btc")
                    .contractType("quarter")
                    .volume(1l)
                    .price(BigDecimal.valueOf(7450.01))
                    .direction(DirectionEnum.SELL)
                    .offset(OffsetEnum.OPEN)
                    .leverRate(10)
                    .orderPriceType("limit")
                    .build();
            list.add(request);

        }
        ContractBatchorderRequest request = ContractBatchorderRequest.builder()
                .list(list)
                .build();
        ContractBatchorderResponse response =
                huobiAPIService.contractBatchorderRequest(request);
        logger.debug("3.合约批量下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractCancelRequest() {
        ContractCancelRequest request = ContractCancelRequest.builder()
                .symbol("btc")
                .orderId("634696656176029696,634693443368525824")
                .build();
        ContractCancelResponse response =
                huobiAPIService.contractCancelRequest(request);
        logger.debug("4.撤销订单：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractCancelallRequest() {
        ContractCancelallRequest request = ContractCancelallRequest.builder()
                .symbol("btc")
                .build();
        ContractCancelallResponse response =
                huobiAPIService.contractCancelallRequest(request);
        logger.debug("5.全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractSwitchLeverRateRequest() {
        ContractSwitchLeverRateResponse response = huobiAPIService.contractSwitchLeverRateRequest("ada", 10);
        logger.debug("6.切换杠杆:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractOrderInfoRequest() {
        ContractOrderInfoRequest request = ContractOrderInfoRequest.builder()
                .symbol("btc")
                .orderId("634696656176029696")
                .build();
        ContractOrderInfoResponse response =
                huobiAPIService.contractOrderInfoRequest(request);
        logger.debug("7.获取合约订单信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractOrderDetailRequest() {
        ContractOrderDetailRequest request = ContractOrderDetailRequest.builder()
                .symbol("BTC")
                .orderId(634693443251085312l)
                .createdAt(System.currentTimeMillis())
                .orderType(1)
                .build();
        ContractOrderDetailResponse response =
                huobiAPIService.contractOrderDetailRequest(request);
        logger.debug("8.获取订单明细信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractOpenordersRequest() {
        ContractOpenordersRequest request = ContractOpenordersRequest.builder()
                .symbol("btc")
                .build();
        ContractOpenordersResponse response =
                huobiAPIService.contractOpenordersRequest(request);
        logger.debug("9.获取合约当前未成交委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void contractHisordersV3Response(){
        ContractHisordersV3Request request = ContractHisordersV3Request.builder()
                .symbol("BTC")
                .tradeType(0)
                .type(1)
                .status("0")
                .build();
        ContractHisordersV3Response response = huobiAPIService.contractHisordersV3Response(request);
        logger.debug("10.获取合约历史委托(新):{}",JSON.toJSONString(response));
    }

    @Test
    public void contractHisordersExactV3Response(){
        ContractHisordersExactV3Request request = ContractHisordersExactV3Request.builder()
                .symbol("BTC")
                .tradeType(0)
                .type(1)
                .status("0")
                .build();
        ContractHisordersExactV3Response response = huobiAPIService.contractHisordersExactV3Response(request);
        logger.debug("11.组合查询合约历史委托(新):{}",JSON.toJSONString(response));
    }

    @Test
    public void contractMatchResultsV3Response(){
        ContractMatchResultsV3Request request = ContractMatchResultsV3Request.builder()
                .symbol("BTC")
                .tradeType(0)
                .build();
        ContractMatchResultsV3Response response = huobiAPIService.contractMatchResultsV3Response(request);
        logger.debug("12.获取历史成交记录(新):{}",JSON.toJSONString(response));
    }

    @Test
    public void contractMatchResultsExactV3Response(){
        ContractMatchResultsExactV3Request request = ContractMatchResultsExactV3Request.builder()
                .symbol("BTC")
                .contract("BTC-USD")
                .tradeType(0)
                .build();
        ContractMatchResultsExactV3Response response = huobiAPIService.contractMatchResultsExactV3Response(request);
        logger.debug("13.组合查询历史成交记录接口(新):{}",JSON.toJSONString(response));
    }

    @Test
    public void lightningClosePositionRequest() {
        LightningClosePositionRequest request = LightningClosePositionRequest.builder()
                .symbol("btc")
                .contractType("quarter")
                .direction("sell")
                .volume(1)
                .build();
        LightningClosePositionResponse response =
                huobiAPIService.lightningClosePositionRequest(request);
        logger.debug("14.闪电平仓下单：{}", JSON.toJSONString(response));
    }
}
