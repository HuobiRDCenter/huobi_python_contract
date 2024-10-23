package com.huobi.swap.api;

import com.alibaba.fastjson.JSON;
import com.google.errorprone.annotations.Var;
import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import com.huobi.api.request.coin_swap.trade.*;
import com.huobi.api.request.usdt.trade.SwapHisordersExactV3Request;
import com.huobi.api.request.usdt.trade.SwapHisordersV3Request;
import com.huobi.api.request.usdt.trade.SwapMatchResultsExactV3Request;
import com.huobi.api.request.usdt.trade.SwapMatchResultsV3Request;
import com.huobi.api.response.coin_swap.trade.*;
import com.huobi.api.response.usdt.trade.SwapHisordersExactV3Response;
import com.huobi.api.response.usdt.trade.SwapHisordersV3Response;
import com.huobi.api.response.usdt.trade.SwapMatchResultsExactV3Response;
import com.huobi.api.response.usdt.trade.SwapMatchResultsV3Response;
import com.huobi.api.service.coin_swap.trade.TradeAPIServiceImpl;
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
    public void swapCancelAfterResponse(){
        SwapCancelAfterRequest request = SwapCancelAfterRequest.builder()
                .onOff(1)
                .build();
        SwapCancelAfterResponse response = huobiAPIService.swapCancelAfterResponse(request);
        logger.debug("1.自动撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapOrderRequest() {
        SwapOrderRequest request = SwapOrderRequest.builder()
                .contractCode("xrp-usd")
                .volume(1l)
                .price(BigDecimal.valueOf(0.2))
                .direction(DirectionEnum.BUY)
                .offset(OffsetEnum.OPEN)
                .leverRate(10)
                .orderPriceType("opponent")
                .tpTriggerPrice(BigDecimal.valueOf(0.296))
                .tpOrderPrice(BigDecimal.valueOf(0.296))
                .tpOrderPriceType("limit")
                .slTriggerPrice(BigDecimal.valueOf(0.1))
                .slOrderPrice(BigDecimal.valueOf(0.1))
                .slOrderPriceType("limit")
                .build();
        SwapOrderResponse response = huobiAPIService.swapOrderRequest(request);
        logger.debug("2.合约下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapBatchorderRequest() {
        List<SwapOrderRequest> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            SwapOrderRequest request = SwapOrderRequest.builder()
                    .contractCode("THETA-USD")
                    .volume(1l)
                    .price(BigDecimal.valueOf(0.677))
                    .direction(DirectionEnum.SELL)
                    .offset(OffsetEnum.OPEN)
                    .leverRate(20)
                    .orderPriceType("limit")
                    .build();
            list.add(request);
        }
        SwapBatchorderRequest request = SwapBatchorderRequest.builder()
                .list(list)
                .build();
        SwapBatchorderResponse response =
                huobiAPIService.swapBatchorderRequest(request);
        logger.debug("3.合约批量下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCancelRequest() {
        SwapCancelRequest request = SwapCancelRequest.builder()
                .contractCode("theta-usd")
                .orderId("778677604210589696")
                //.clientOrderId("")
                .build();
        SwapCancelResponse response =
                huobiAPIService.swapCancelRequest(request);
        logger.debug("4.撤销订单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCancelallRequest() {
        SwapCancelallRequest request = SwapCancelallRequest.builder()
                .contractCode("theta-usd")
                .build();
        SwapCancelallResponse response =
                huobiAPIService.swapCancelallRequest(request);
        logger.debug("5.全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapSwitchLeverRateRequest(){
        SwapSwitchLeverRateResponse response=huobiAPIService.swapSwitchLeverRateResponse("ADA-USD",30);
        logger.debug("6.切换杠杆：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapOrderInfoRequest() {
        SwapOrderInfoRequest request = SwapOrderInfoRequest.builder()
                .contractCode("theta-USD")
                //.clientOrderId("")
                .orderId("778582198420418560")
                .build();
        SwapOrderInfoResponse response =
                huobiAPIService.swapOrderInfoRequest(request);
        logger.debug("7.获取合约订单信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapOrderDetailRequest() {
        SwapOrderDetailRequest request = SwapOrderDetailRequest.builder()
                .contractCode("theta-usd")
                .orderId(778582198420418560l)
                //.createdAt(System.currentTimeMillis())
                //.orderType(1)
                //.pageIndex(1)
                //.pageSize(20)
                .build();
        SwapOrderDetailResponse response =
                huobiAPIService.swapOrderDetailRequest(request);
        logger.debug("8.获取订单明细信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapOpenordersRequest() {
        SwapOpenordersRequest request = SwapOpenordersRequest.builder()
                .contractCode("theta-usd")
                .pageIndex(1)
                .pageSize(20)
                .build();
        SwapOpenordersResponse response =
                huobiAPIService.swapOpenordersRequest(request);
        logger.debug("9.获取合约当前未成交委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapHisordersV3Response(){
        SwapHisordersV3Request request = SwapHisordersV3Request.builder()
                .contract("BTC-USD")
                .tradeType(0)
                .type(1)
                .status("0")
                .build();
        SwapHisordersV3Response response = huobiAPIService.swapHisordersV3Response(request);
        logger.debug("10.获取合约历史委托(新)：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapHisordersExactV3Response(){
        SwapHisordersExactV3Request request = SwapHisordersExactV3Request.builder()
                .contract("BTC-USD")
                .tradeType(5)
                .type(1)
                .status("0")
                .build();
        SwapHisordersExactV3Response response = huobiAPIService.swapHisordersExactV3Response(request);
        logger.debug("11.组合查询合约历史委托(新)：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapMatchResultsV3Response(){
        SwapMatchResultsV3Request request = SwapMatchResultsV3Request.builder()
                .contract("BTC-USD")
                .tradeType(0)
                .build();
        SwapMatchResultsV3Response response = huobiAPIService.swapMatchResultsV3Response(request);
        logger.debug("12.获取历史成交记录（新）：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapMatchResultsExactV3Response(){
        SwapMatchResultsExactV3Request request = SwapMatchResultsExactV3Request.builder()
                .contract("BTC-USDT")
                .tradeType(0)
                .build();
        SwapMatchResultsExactV3Response response = huobiAPIService.swapMatchResultsExactV3Response(request);
        logger.debug("13.组合查询用户历史成交记录（新）：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapLightningClosePositionRequest() {
        SwapLightningClosePositionRequest request = SwapLightningClosePositionRequest.builder()
                .contractCode("ada-usd")
                .direction("sell")
                .volume(1)
                .build();
        SwapLightningClosePositionResponse response =
                huobiAPIService.swapLightningClosePositionRequest(request);
        logger.debug("14.闪电平仓下单：{}", JSON.toJSONString(response));
    }
}
