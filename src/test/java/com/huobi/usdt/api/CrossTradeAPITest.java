package com.huobi.usdt.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import com.huobi.api.request.usdt.trade.*;
import com.huobi.api.response.usdt.market.SwapCrossTradeStateResponse;
import com.huobi.api.response.usdt.trade.*;
import com.huobi.api.service.usdt.trade.CrossTradeAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.JVM)
public class CrossTradeAPITest implements BaseTest {

    CrossTradeAPIServiceImpl huobiCrossAPIService = new CrossTradeAPIServiceImpl("", "");

    @Test
    public void getSwapCrossTradeState() {
        SwapCrossTradeStateResponse response = huobiCrossAPIService.getSwapCrossTradeState("btc-usdt-220325","","","all");
        logger.debug("1.查询系统交易权限:{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossSwitchPositionMode(){
        SwapSwitchPositionModeResponse response=huobiCrossAPIService.swapCrossSwitchPositionModeResponse("usdt","dual_side");
        logger.debug("2.切换持仓模式:{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossOrderRequest() {
        SwapCrossOrderRequest request = SwapCrossOrderRequest.builder()
                .contractCode("BTC-USDT")
                .volume(1l)
                //.price(BigDecimal.valueOf(455))
                .direction(DirectionEnum.BUY)
                .offset(OffsetEnum.CLOSE)
                .leverRate(50)
                .orderPriceType("optimal_10_ioc")
                .build();
        SwapCrossOrderResponse response =
                huobiCrossAPIService.swapCrossOrderRequest(request);
        logger.debug("3.合约下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossBatchorderRequest() {
        List<SwapCrossOrderRequest> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            SwapCrossOrderRequest request = SwapCrossOrderRequest.builder()
                    .contractCode("ETH-USDT")
                    .volume(1l)
                    .price(BigDecimal.valueOf(456))
                    .direction(DirectionEnum.SELL)
                    .offset(OffsetEnum.OPEN)
                    .leverRate(30)
                    .orderPriceType("limit")
                    .build();
            list.add(request);
            request = SwapCrossOrderRequest.builder()
                    .contractCode("BTC-USDT")
                    .volume(1l)
                    .price(BigDecimal.valueOf(45600))
                    .direction(DirectionEnum.SELL)
                    .offset(OffsetEnum.OPEN)
                    .leverRate(50)
                    .orderPriceType("limit")
                    .build();
            list.add(request);
        }
        SwapCrossBatchorderRequest request = SwapCrossBatchorderRequest.builder()
                .list(list)
                .build();
        SwapCrossBatchorderResponse response =
                huobiCrossAPIService.swapCrossBatchorderRequest(request);
        logger.debug("4.合约批量下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossCancelRequest() {
        SwapCrossCancelRequest request = SwapCrossCancelRequest.builder()
                .contractCode("btc-usdt")
                .orderId("786547455839219712")
                //.clientOrderId("")
                .build();
        SwapCrossCancelResponse response =
                huobiCrossAPIService.swapCrossCancelRequest(request);
        logger.debug("5.撤销订单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossCancelallRequest() {
        SwapCrossCancelallRequest request = SwapCrossCancelallRequest.builder()
                .contractCode("eth-usdt")
                .build();
        SwapCrossCancelallResponse response =
                huobiCrossAPIService.swapCrossCancelallRequest(request);
        logger.debug("6.全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapCrossSwitchLeverRateResponse() {
        SwapCrossSwitchLeverRateResponse response = huobiCrossAPIService.getSwapCrossSwitchLeverRate("ETH-USDT", 10,"","");
        logger.debug("7.切换杠杆：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossOrderInfoRequest() {
        SwapCrossOrderInfoRequest request = SwapCrossOrderInfoRequest.builder()
                .contractCode("ETH-USDT")
                //.clientOrderId("")
                .orderId("786547455839219712")
                .build();
        SwapCrossOrderInfoResponse response =
                huobiCrossAPIService.swapCrossOrderInfoRequest(request);
        logger.debug("8.获取合约订单信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapOrderDetailRequest() {
        SwapCrossOrderDetailRequest request = SwapCrossOrderDetailRequest.builder()
                .contractCode("ETH-USDT")
                .orderId(786550830160982016l)
                //.createdAt(System.currentTimeMillis())
                //.orderType(1)
                //.pageIndex(1)
                //.pageSize(20)
                .build();
        SwapCrossOrderDetailResponse response =
                huobiCrossAPIService.swapCrossOrderDetailRequest(request);
        logger.debug("9.获取订单明细信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossOpenordersRequest() {
        SwapCrossOpenordersRequest request = SwapCrossOpenordersRequest.builder()
                .contractCode("eth-usdt")
                .pageIndex(1)
                .pageSize(20)
                .build();
        SwapCrossOpenordersResponse response =
                huobiCrossAPIService.swapCrossOpenordersRequest(request);
        logger.debug("10.获取合约当前未成交委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossHisordersV3Response(){
        SwapCrossHisordersV3Request request = SwapCrossHisordersV3Request.builder()
                .tradeType(0)
                .type(1)
                .status("0")
                .build();
        SwapCrossHisordersV3Response response = huobiCrossAPIService.swapCrossHisordersV3Response(request);
        logger.debug("11.【全仓】获取合约历史委托(新)：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossHisordersExactV3Response(){
        SwapCrossHisordersExactV3Request request = SwapCrossHisordersExactV3Request.builder()
                .contract("BTC-USDT")
                .tradeType(0)
                .pair("BTC-USDT")
                .status("0")
                .type(1)
                .priceType("opponent")
                .startTime(1660119810000L)
                .endTime(1660274746031L)
                .direct("next")
                .fromId(1110L)
                .build();
        SwapCrossHisordersExactV3Response response = huobiCrossAPIService.swapCrossHisordersExactV3Response(request);
        logger.debug("12.【全仓】组合查询合约历史委托(新)：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossMatchResultsV3Response(){
        SwapCrossMatchResultsV3Request request = SwapCrossMatchResultsV3Request.builder()
                .contract("BTC-USDT")
                .build();
        SwapCrossMatchResultsV3Response response = huobiCrossAPIService.swapCrossMatchResultsV3Response(request);
        logger.debug("13.【全仓】获取历史成交记录(新)：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossMatchResultsExactV3Response(){
        SwapCrossMatchResultsExactV3Request request = SwapCrossMatchResultsExactV3Request.builder()
                .contract("BTC-USDT")
                .build();
        SwapCrossMatchResultsExactV3Response response = huobiCrossAPIService.swapCrossMatchResultsExactV3Response(request);
        logger.debug("14.【全仓】获取历史成交记录(新)：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossLightningClosePositionRequest() {
        SwapCrossLightningClosePositionRequest request = SwapCrossLightningClosePositionRequest.builder()
                .contractCode("ETH-USDT")
                .direction("buy")
                .volume(1)
                .build();
        SwapCrossLightningClosePositionResponse response =
                huobiCrossAPIService.swapCrossLightningClosePositionRequest(request);
        logger.debug("15.闪电平仓下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossPositionSideResponse(){
        SwapCrossPositionSideResponse response = huobiCrossAPIService.swapCrossPositionSideResponse("USDT");
        logger.debug("16.【全仓】查询持仓模式：{}", JSON.toJSONString(response));
    }
}
