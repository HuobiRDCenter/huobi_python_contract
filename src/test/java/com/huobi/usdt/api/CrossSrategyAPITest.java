package com.huobi.usdt.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import com.huobi.api.request.usdt.trade.*;
import com.huobi.api.response.usdt.trade.*;
import com.huobi.api.service.usdt.strategy.CrossStrategyAPIServiceImpl;
import com.huobi.api.service.usdt.strategy.StrategyAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.JVM)
public class CrossSrategyAPITest implements BaseTest{
    CrossStrategyAPIServiceImpl huobiCrossAPIService  = new CrossStrategyAPIServiceImpl("", "");

    @Test
    public void swapCrossTriggerOrderRequest() {
        SwapCrossTriggerOrderRequest request = SwapCrossTriggerOrderRequest.builder()
                .contractCode("ETH-USDT")
                .triggerType("ge")
                .triggerPrice(BigDecimal.valueOf(377))
                .orderPrice(BigDecimal.valueOf(377))
                .orderPriceType("limit")
                .volume(BigDecimal.valueOf(1))
                .direction(DirectionEnum.BUY)
                .offset(OffsetEnum.OPEN)
                .leverRate(30)
                .build();
        SwapCrossTriggerOrderResponse response = huobiCrossAPIService.swapCrossTriggerOrderResponse(request);
        logger.debug("1.计划委托下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTriggerCancelRequest() {
        SwapCrossTriggerCancelRequest request = SwapCrossTriggerCancelRequest.builder()
                .orderId("1884,1883")
                .contractCode("eth-usdt")
                .build();
        SwapCrossTriggerCancelResponse response = huobiCrossAPIService.swapCrossTriggerCancelResponse(request);
        logger.debug("2.计划委托撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTriggerCancelallRequest() {
        SwapCrossTriggerCancelallRequest request = SwapCrossTriggerCancelallRequest.builder()
                .contractCode("eth-usdt")
                .build();
        SwapCrossTriggerCancelallResponse response = huobiCrossAPIService.swapCrossTriggerCancelallResponse(request);
        logger.debug("3.计划委托全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTriggerOpenordersRequest() {
        SwapCrossTriggerOpenordersRequest request = SwapCrossTriggerOpenordersRequest.builder()
                .contractCode("eth-usdt")
                .pageIndex(1)
                .pageSize(10)
                .build();
        SwapCrossTriggerOpenordersResponse response = huobiCrossAPIService.swapCrossTriggerOpenordersResponse(request);
        logger.debug("4.获取计划委托当前委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTriggerHisordersRequest() {
        SwapCrossTriggerHisordersRequest request = SwapCrossTriggerHisordersRequest.builder()
                .tradeType(0)
                .status("0")
                .createDate(10)
                .contractCode("eth-usdt")
                .pageIndex(1)
                .pageSize(1)
                .sortBy("update_time")
                .build();
        SwapCrossTriggerHisordersResponse response = huobiCrossAPIService.swapCrossTriggerHisordersResponse(request);
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
        SwapTpslOrderResponse response = huobiCrossAPIService.swapCrossTpslOrderResponse(request);
        logger.debug("6.对仓位设置止盈止损订单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTpslCancelRequest() {
        SwapTpslCancelRequest request = SwapTpslCancelRequest.builder()
                .contractCode("xrp-usdt")
                .orderId("798618423818387460,798593423673294823")
                .build();
        SwapTpslCancelResponse response = huobiCrossAPIService.swapCrossTpslCancelResponse(request);
        logger.debug("7.止盈止损订单撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTpslCancelallRequest() {
        SwapTpslCancelallRequest request = SwapTpslCancelallRequest.builder()
                .contractCode("xrp-usdt")
                .build();
        SwapTpslCancelallResponse response = huobiCrossAPIService.swapCrossTpslCancelallResponse(request);
        logger.debug("8.止盈止损订单全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapTpslOpenorderRequest() {
        SwapTpslOpenordersRequest request = SwapTpslOpenordersRequest.builder()
                .contractCode("xrp-usdt")
                .pageIndex(1)
                .pageSize(20)
                .build();
        SwapTpslOpenordersResponse response = huobiCrossAPIService.swapCrossTpslOpenordersResponse(request);
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
        SwapTpslHisordersResponse response = huobiCrossAPIService.swapCrossTpslHisordersResponse(requset);
        logger.debug("10.查询止盈止损订单历史委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapRelationTpslOrder() {
        SwapRelationTpslOrderRequest request = SwapRelationTpslOrderRequest.builder()
                .contractCode("xrp-usdt")
                .orderId(798617480003518464l)
                .build();
        SwapRelationTpslOrderResponse response = huobiCrossAPIService.swapCrossRelationTpslOrderResponse(request);
        logger.debug("11.查询开仓单关联的止盈止损订单详情：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTrackOrders(){
        SwapTrackOrderRequest request=SwapTrackOrderRequest.builder()
                .contractCode("btc-usdt")
                .direction("buy")
                .offset("open")
                .leverRate(5)
                .volume(BigDecimal.valueOf(1))
                .activePrice(BigDecimal.valueOf(390))
                .callbackRate(BigDecimal.valueOf(0.1))
                .orderPriceType("optimal_5")
                .build();
        SwapTrackOrderResponse response=huobiCrossAPIService.swapCrossTrackOrderResponse(request);
        logger.debug("12.跟踪委托订单下单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTrackCancel(){
        SwapTrackCancelRequest request= SwapTrackCancelRequest.builder()
                .orderId("827232952382566400")
                .contractCode("btc-usdt")
                .build();
        SwapTrackCancelResponse response=huobiCrossAPIService.swapCrossTrackCancelResponse(request);
        logger.debug("13.跟踪委托订单撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTrackCancelall(){
        SwapTrackCancelallRequest request= SwapTrackCancelallRequest.builder()
                .contractCode("btc-usdt")
                .direction("")
                .offset("")
                .build();
        SwapTrackCancelallResponse response=huobiCrossAPIService.swapCrossTrackCancelallResponse(request);
        logger.debug("14.跟踪委托订单全部撤单：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTrackOpenorders(){
        SwapTrackOpenordersRequest request=SwapTrackOpenordersRequest.builder()
                .contractCode("btc-usdt")
                .tradeType(0)
                .pageIndex(1)
                .pageSize(2)
                .build();
        SwapTrackOpenordersResponse response=huobiCrossAPIService.swapCrossTrackOpenordersResponse(request);
        logger.debug("15.跟踪委托订单当前委托：{}", JSON.toJSONString(response));
    }

    @Test
    public void swapCrossTrackHisorders(){
        SwapTrackHisordersRequest request= SwapTrackHisordersRequest.builder()
                .contractCode("btc-usdt")
                .status("0")
                .tradeType(0)
                .createDate(10l)
                .pageIndex(1)
                .pageSize(1)
                .sortBy("")
                .build();
        SwapTrackHisordersResponse response=huobiCrossAPIService.swapCrossTrackHisordersResponse(request);
        logger.debug("16.跟踪委托订单当前委托：{}", JSON.toJSONString(response));
    }
}
