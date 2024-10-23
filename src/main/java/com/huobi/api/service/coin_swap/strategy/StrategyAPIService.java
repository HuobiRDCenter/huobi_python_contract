package com.huobi.api.service.coin_swap.strategy;

import com.huobi.api.request.coin_swap.trade.*;
import com.huobi.api.response.coin_swap.trade.*;

public interface StrategyAPIService {
    public SwapTriggerOrderResponse swapTriggerOrderResponse(SwapTriggerOrderRequest request);// 1.计划委托下单

    public SwapTriggerCancelResponse swapTriggerCancelResponse(SwapTriggerCancelRequest request);// 2.计划委托撤单

    public SwapTriggerCancelallResponse swapTriggerCancelallResponse(SwapTriggerCancelallRequest request);// 3.计划委托全部撤单

    public SwapTriggerOpenordersResponse swapTriggerOpenordersResponse(SwapTriggerOpenordersRequest request);// 4.获取计划委托当前委托

    public SwapTriggerHisordersResponse swapTriggerHisordersResponse(SwapTriggerHisordersRequest request);// 5.获取计划委托历史委托

    public SwapTpslOrderResponse swapTpslOrderResponse(SwapTpslOrderRequest request);// 6.对仓位设置止盈止损订单

    public SwapTpslCancelResponse swapTpslCancelResponse(SwapTpslCancelRequest request);// 7.止盈止损订单撤单

    public SwapTpslCancelallResponse swapTpslCancelallResponse(SwapTpslCancelallRequest request);// 8.止盈止损订单全部撤单

    public SwapTpslOpenordersResponse swapTpslOpenordersResponse(SwapTpslOpenordersRequest request);// 9.查询止盈止损订单当前委托

    public SwapTpslHisordersResponse swapTpslHisordersResponse(SwapTpslHisordersRequset request);// 10.查询止盈止损订单历史委托

    public SwapRelationTpslOrderResponse swapRelationTpslOrderResponse(SwapRelationTpslOrderRequest request);// 11.查询开仓单关联的止盈止损订单详情

    public SwapTrackOrderResponse swapTrackOrderResponse(SwapTrackOrderRequest request);// 12.跟踪委托订单下单

    public SwapTrackCancelResponse swapTrackCancelResponse(SwapTrackCancelRequest request);// 13.跟踪委托订单撤单

    public SwapTrackCancelallResponse swapTrackCancelallResponse(SwapTrackCancelallRequest request);// 14.跟踪委托订单全部撤单

    public SwapTrackOpenordersResponse swapTrackOpenordersResponse(SwapTrackOpenordersRequest request);// 15.跟踪委托订单当前委托

    public SwapTrackHisordersResponse swapTrackHisordersResponse(SwapTrackHisordersRequest request);// 16.跟踪委托订单历史委托
}
