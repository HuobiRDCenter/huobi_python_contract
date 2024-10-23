package com.huobi.usdt.api;


import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import com.huobi.api.request.usdt.trade.*;
import com.huobi.api.response.usdt.trade.*;
import com.huobi.api.service.usdt.reference.CrossReferenceAPIServiceImpl;
import com.huobi.api.service.usdt.strategy.StrategyAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.JVM)
public class SrategyAPITest implements BaseTest{
    StrategyAPIServiceImpl huobiAPIService  = new StrategyAPIServiceImpl("", "");

    @Test
    public void swapTriggerOrderRequest() {
        SwapTriggerOrderRequest request = SwapTriggerOrderRequest.builder()
                .contractCode("ETH-USDT")
                .triggerType("ge")
                .triggerPrice(BigDecimal.valueOf(377))
                .orderPrice(BigDecimal.valueOf(377))
                .orderPriceType("limit")
                .volume(BigDecimal.valueOf(1))
                .direction(DirectionEnum.BUY)
                .offset(OffsetEnum.OPEN)
                .leverRate(5)
                .build();
        SwapTriggerOrderResponse response = huobiAPIService.swapTriggerOrderResponse(request);
        logger.debug("1.计划委托下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void optionTriggerCancelRequest() {
        SwapTriggerCancelRequest request = SwapTriggerCancelRequest.builder()
                .orderId("4699")
                .contractCode("eth-usdt")
                .build();
        SwapTriggerCancelResponse response = huobiAPIService.swapTriggerCancelResponse(request);
        logger.debug("2.计划委托撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void optionTriggerCancelallRequest() {
        SwapTriggerCancelallRequest request = SwapTriggerCancelallRequest.builder()
                .contractCode("eth-usdt")
                .build();
        SwapTriggerCancelallResponse response = huobiAPIService.swapTriggerCancelallResponse(request);
        logger.debug("3.计划委托全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void optionTriggerOpenordersRequest() {
        SwapTriggerOpenordersRequest request = SwapTriggerOpenordersRequest.builder()
                .contractCode("btc-usdt")
                .pageIndex(1)
                .pageSize(10)
                .build();
        SwapTriggerOpenordersResponse response = huobiAPIService.swapTriggerOpenordersResponse(request);
        logger.debug("4.获取计划委托当前委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void optionTriggerHisordersRequest() {
        SwapTriggerHisordersRequest request = SwapTriggerHisordersRequest.builder()
                .tradeType(0)
                .status("0")
                .createDate(10)
                .contractCode("btc-usdt")
                .pageIndex(1)
                .pageSize(1)
                .sortBy("update_time")
                .build();
        SwapTriggerHisordersResponse response = huobiAPIService.swapTriggerHisordersResponse(request);
        logger.debug("5.获取计划委托历史委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTpslOrderRequest() {
        SwapTpslOrderRequest request = SwapTpslOrderRequest.builder()
                .contractCode("xrp-usdt")
                .direction("buy")
                .volume(BigDecimal.valueOf(1))
                .tpTriggerPrice(BigDecimal.valueOf(0.2))
                .tpOrderPrice(BigDecimal.valueOf(0.2))
                .tpOrderPriceType("limit")
                .slTriggerPrice(BigDecimal.valueOf(0.5))
                .slOrderPrice(BigDecimal.valueOf(0.5))
                .slOrderPriceType("limit")
                .build();
        SwapTpslOrderResponse response = huobiAPIService.swapTpslOrderResponse(request);
        logger.debug("6.对仓位设置止盈止损订单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTpslCancelRequest() {
        SwapTpslCancelRequest request = SwapTpslCancelRequest.builder()
                .contractCode("xrp-usdt")
                .orderId("798593423673294849,798593423673294823")
                .build();
        SwapTpslCancelResponse response = huobiAPIService.swapTpslCancelResponse(request);
        logger.debug("7.止盈止损订单撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTpslCancelallRequest() {
        SwapTpslCancelallRequest request = SwapTpslCancelallRequest.builder()
                .contractCode("xrp-usdt")
                .build();
        SwapTpslCancelallResponse response = huobiAPIService.swapTpslCancelallResponse(request);
        logger.debug("8.止盈止损订单全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTpslOpenorderRequest() {
        SwapTpslOpenordersRequest request = SwapTpslOpenordersRequest.builder()
                .contractCode("xrp-usdt")
                .pageIndex(1)
                .pageSize(20)
                .build();
        SwapTpslOpenordersResponse response = huobiAPIService.swapTpslOpenordersResponse(request);
        logger.debug("9.查询止盈止损订单当前委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTpslHisordersRequest() {
        SwapTpslHisordersRequset requset = SwapTpslHisordersRequset.builder()
                .contractCode("xrp-usdt")
                .status("0")
                .createDate(10l)
                .pageIndex(1)
                .pageSize(20)
                .sortBy("update_time")
                .build();
        SwapTpslHisordersResponse response = huobiAPIService.swapTpslHisordersResponse(requset);
        logger.debug("10.查询止盈止损订单历史委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapRelationTpslOrder() {
        SwapRelationTpslOrderRequest request = SwapRelationTpslOrderRequest.builder()
                .contractCode("xrp-usdt")
                .orderId(798606585433096192l)
                .build();
        SwapRelationTpslOrderResponse response = huobiAPIService.swapRelationTpslOrderResponse(request);
        logger.debug("11.查询开仓单关联的止盈止损订单详情：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTrackOrders(){
        SwapTrackOrderRequest request=SwapTrackOrderRequest.builder()
                .contractCode("BTC-usdt")
                .direction("buy")
                .offset("open")
                .leverRate(5)
                .volume(BigDecimal.valueOf(1))
                .activePrice(BigDecimal.valueOf(48000))
                .callbackRate(BigDecimal.valueOf(0.1))
                .orderPriceType("optimal_10")
                .build();
        SwapTrackOrderResponse response=huobiAPIService.swapTrackOrderResponse(request);
        logger.debug("12.跟踪委托订单下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTrackCancel(){
        SwapTrackCancelRequest request= SwapTrackCancelRequest.builder()
                .orderId("827126893407870976,827126893407870977")
                .contractCode("btc-usdt")
                .build();
        SwapTrackCancelResponse response=huobiAPIService.swapTrackCancelResponse(request);
        logger.debug("13.跟踪委托订单撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTrackCancelall(){
        SwapTrackCancelallRequest request= SwapTrackCancelallRequest.builder()
                .contractCode("btc-usdt")
                .direction("buy")
                .offset("")
                .build();
        SwapTrackCancelallResponse response=huobiAPIService.swapTrackCancelallResponse(request);
        logger.debug("14.跟踪委托订单全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTrackOpenorders(){
        SwapTrackOpenordersRequest request=SwapTrackOpenordersRequest.builder()
                .contractCode("btc-usdt")
                .tradeType(0)
                .pageIndex(1)
                .pageSize(2)
                .build();
        SwapTrackOpenordersResponse response=huobiAPIService.swapTrackOpenordersResponse(request);
        logger.debug("15.跟踪委托订单当前委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTrackHisorders(){
        SwapTrackHisordersRequest request= SwapTrackHisordersRequest.builder()
                .contractCode("btc-usdt")
                .status("0")
                .tradeType(0)
                .createDate(10l)
                .pageIndex(1)
                .pageSize(1)
                .sortBy("")
                .build();
        SwapTrackHisordersResponse response=huobiAPIService.swapTrackHisordersResponse(request);
        logger.debug("16.跟踪委托订单当前委托：{}", JSON.toJSONString(response));
    }
}
