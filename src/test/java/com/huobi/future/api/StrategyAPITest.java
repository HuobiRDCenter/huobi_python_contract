package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import com.huobi.api.request.coin_futures.trade.*;
import com.huobi.api.response.coin_futures.trade.*;
import com.huobi.api.service.coin_futures.account.AccountAPIServiceImpl;
import com.huobi.api.service.coin_futures.strategy.StrategyAPIServiceImpl;
import com.huobi.usdt.api.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.JVM)
public class StrategyAPITest implements BaseTest {
    StrategyAPIServiceImpl huobiAPIService = new StrategyAPIServiceImpl("", "");

    @Test
    public void contractTriggerOrderRequest() {
        ContractTriggerOrderRequest request = ContractTriggerOrderRequest.builder()
                .symbol("eth")
                .contractType("quarter")
                //.contractCode("btc200925")
                .triggerType("le")
                .triggerPrice(BigDecimal.valueOf(340.442))
                .orderPrice(BigDecimal.valueOf(340.24))
                .orderPriceType("limit")
                .volume(1l)
                .direction(DirectionEnum.valueOf("SELL"))
                .offset(OffsetEnum.valueOf("CLOSE"))
                .leverRate(20)
                .build();
        ContractTriggerOrderResponse response = huobiAPIService.contractTriggerOrderRequest(request);
        logger.debug("1.请求的参数：{}", JSON.toJSONString(request));
        logger.debug("1.合约计划委托下单：{}", JSON.toJSONString(response));

    }

    @Test
    public void contractTriggerCancelRequest() {
        ContractTriggerCancelRequest request = ContractTriggerCancelRequest.builder()
                .symbol("btc")
                .orderId("18139221,18139220")
                .build();
        ContractTriggerCancelResponse response = huobiAPIService.contractTriggerCancelRequest(request);
        logger.debug("2.合约计划委托撤单:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTriggerCancelallRequest() {
        ContractTriggerCancelallRequest request = ContractTriggerCancelallRequest.builder()
                .symbol("btc")
                .contractCode("")
                .contractType("")
                .build();
        ContractTriggerCancelallResponse response = huobiAPIService.contractTriggerCancelallRequest(request);
        logger.debug("3.合约计划委托全部撤单:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTriggerOpenordersRequest() {
        ContractTriggerOpenordersRequest request = ContractTriggerOpenordersRequest.builder()
                .symbol("btc")
                .contractCode("btc200925")
                .pageIndex(1)
                .pageSize(20)
                .build();
        ContractTriggerOpenordersResponse response = huobiAPIService.contractTriggerOpenordersRequest(request);
        logger.debug("4.请求的参数:{}", JSON.toJSONString(request));
        logger.debug("4.获取计划委托当前委托:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTriggerHisordersRequest() {
        ContractTriggerHisordersRequest request = ContractTriggerHisordersRequest.builder()
                .symbol("ada")
                .contractCode("ada201225")
                .tradeType(0)
                .status("0")
                .createDate(90)
                .pageIndex(1)
                .pageSize(20)
                .sortBy("update_time")
                .build();
        ContractTriggerHisordersResponse response = huobiAPIService.contractTriggerHisorders(request);
        logger.debug("5.获取计划委托历史委托:{}", JSON.toJSONString(response));
    }

    @Test
    public void contractTpslOrderRequest(){
        ContractTpslOrderRequest request = ContractTpslOrderRequest.builder()
                .symbol("xrp")
                .contractCode("xrp210326")
                .contractType("quarter")
                .direction("buy")
                .volume("1")
                .tpTriggerPrice(BigDecimal.valueOf(0.2))
                .tpOrderPrice(BigDecimal.valueOf(0.2))
                .tpOrderPriceType("limit")
                .slOrderPrice(BigDecimal.valueOf(0.5))
                .slOrderPriceType("optimal_5")
                .slTriggerPrice(BigDecimal.valueOf(0.5))
                .build();
        ContractTpslOrderResponse response=huobiAPIService.contractTpslOrder(request);
        logger.debug("6.对仓位设置止盈止损订单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTpslCancelRequest(){
        ContractTpslCancelRequest request= ContractTpslCancelRequest.builder()
                .symbol("xrp")
                .orderId("799291000371585024")
                .build();
        ContractTpslCancelResponse response=huobiAPIService.contractTpslCancelResponse(request);
        logger.debug("7.止盈止损撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTpslCancelallRequest(){
        ContractTpslCancelallRequest request= ContractTpslCancelallRequest.builder()
                .symbol("xrp")
                .contractCode("xrp210326")
                .contractType("quarter")
                .build();
        ContractTpslCancelallResponse response=huobiAPIService.contractTpslCancelallResponse(request);
        logger.debug("8.止盈止损全部撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTpslOpenorderRequest(){
        ContractTpslOpenordersRequest request= ContractTpslOpenordersRequest.builder()
                .symbol("xrp")
                .contractCode("")
                .pageIndex(1)
                .pageSize(20)
                .build();
        ContractTpslOpenordersResponse response=huobiAPIService.contractTpslOpenordersResponse(request);
        logger.debug("9.查询止盈止损订单当前委托:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTpslHisorderRequest(){
        ContractTpslHisordersRequset requset= ContractTpslHisordersRequset.builder()
                .symbol("XRP")
                .contractCode("xrp210326")
                .status("0")
                .createDate(30l)
                .pageIndex(1)
                .pageSize(20)
                .sortBy("update_time")
                .build();
        ContractTpslHisordersResponse response=huobiAPIService.contractTpslHisordersResponse(requset);
        logger.debug("10.查询止盈止损订单历史委托:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractRelationTpslOrderRequest(){
        ContractRelationTpslOrderRequest request= ContractRelationTpslOrderRequest.builder()
                .symbol("xrp")
                .orderId(799289975731789824l)
                .build();
        ContractRelationTpslOrderResponse response=huobiAPIService.contractRelationTpslOrderResponse(request);
        logger.debug("11.查询开仓单关联的止盈止损订单详情:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackOrder(){
        ContractTrackOrderRequest request= ContractTrackOrderRequest.builder()
                .symbol("btc")
                .contractType("quarter")
                .contractCode("btc210326")
                .direction("buy")
                .offset("open")
                .leverRate(75)
                .volume(BigDecimal.valueOf(1))
                .activePrice(BigDecimal.valueOf(49111))
                .callbackRate(BigDecimal.valueOf(0.03))
                .orderPriceType("optimal_5")
                .build();
        ContractTrackOrderResponse response=huobiAPIService.contractTrackOrderResponse(request);
        logger.debug("12.跟踪委托订单下单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackCancel(){
        ContractTrackCancelRequest request= ContractTrackCancelRequest.builder()
                .orderId("826490322254073856")
                .symbol("btc")
                .build();
        ContractTrackCancelResponse response=huobiAPIService.contractTrackCancelResponse(request);
        logger.debug("13.跟踪委托订单撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackCancelall(){
        ContractTrackCancelallRequest request= ContractTrackCancelallRequest.builder()
                .symbol("btc")
                .contractCode("")
                .contractType("")
                .direction("")
                .offset("")
                .build();
        ContractTrackCancelallResponse response=huobiAPIService.contractTrackCancelallResponse(request);
        logger.debug("14.跟踪委托订单全部撤单:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackOpenorders(){
        ContractTrackOpenordersRequest request= ContractTrackOpenordersRequest.builder()
                .symbol("btc")
                .contractCode("")
                .tradeType(0)
                .pageIndex(1)
                .pageSize(1)
                .build();
        ContractTrackOpenordersResponse response=huobiAPIService.contractTrackOpenordersResponse(request);
        logger.debug("15.跟踪委托订单当前委托:{}",JSON.toJSONString(response));
    }

    @Test
    public void contractTrackHisorders(){
        ContractTrackHisordersRequest request= ContractTrackHisordersRequest.builder()
                .symbol("btc")
                .contractCode("")
                .createDate(1l)
                .tradeType(1)
                .status("0")
                .pageIndex(1)
                .pageSize(1)
                .sortBy("")
                .build();
        ContractTrackHisordersResponse response=huobiAPIService.contractTrackHisordersResponse(request);
        logger.debug("16.跟踪委托订单历史委托:{}",JSON.toJSONString(response));
    }
}
