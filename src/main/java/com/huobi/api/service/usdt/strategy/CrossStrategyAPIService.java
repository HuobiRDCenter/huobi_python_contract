package com.huobi.api.service.usdt.strategy;

import com.huobi.api.request.usdt.trade.*;
import com.huobi.api.response.usdt.trade.*;

public interface CrossStrategyAPIService {
    public SwapCrossTriggerOrderResponse swapCrossTriggerOrderResponse(SwapCrossTriggerOrderRequest request);// 1、计划委托下单(全仓模式)

    public SwapCrossTriggerCancelResponse swapCrossTriggerCancelResponse(SwapCrossTriggerCancelRequest request);// 2、计划委托撤单(全仓模式)

    public SwapCrossTriggerCancelallResponse swapCrossTriggerCancelallResponse(SwapCrossTriggerCancelallRequest request);// 3、计划委托全部撤单(全仓模式)

    public SwapCrossTriggerOpenordersResponse swapCrossTriggerOpenordersResponse(SwapCrossTriggerOpenordersRequest request);// 4、获取计划委托当前委托(全仓模式)

    public SwapCrossTriggerHisordersResponse swapCrossTriggerHisordersResponse(SwapCrossTriggerHisordersRequest request);// 5、获取计划委托历史委托(全仓模式)

    public SwapTpslOrderResponse swapCrossTpslOrderResponse(SwapTpslOrderRequest request);// 6.对仓位设置止盈止损订单

    public SwapTpslCancelResponse swapCrossTpslCancelResponse(SwapTpslCancelRequest request);// 7.止盈止损订单撤单

    public SwapTpslCancelallResponse swapCrossTpslCancelallResponse(SwapTpslCancelallRequest request);// 8.止盈止损订单全部撤单

    public SwapTpslOpenordersResponse swapCrossTpslOpenordersResponse(SwapTpslOpenordersRequest request);// 9.查询止盈止损订单当前委托

    public SwapTpslHisordersResponse swapCrossTpslHisordersResponse(SwapTpslHisordersRequset request);// 10.查询止盈止损订单历史委托

    public SwapRelationTpslOrderResponse swapCrossRelationTpslOrderResponse(SwapRelationTpslOrderRequest request);// 11.查询开仓单关联的止盈止损订单详情

    public SwapTrackOrderResponse swapCrossTrackOrderResponse(SwapTrackOrderRequest request);// 12.跟踪委托订单下单

    public SwapTrackCancelResponse swapCrossTrackCancelResponse(SwapTrackCancelRequest request);// 13.跟踪委托订单撤单

    public SwapTrackCancelallResponse swapCrossTrackCancelallResponse(SwapTrackCancelallRequest request);// 14.跟踪委托订单全部撤单

    public SwapTrackOpenordersResponse swapCrossTrackOpenordersResponse(SwapTrackOpenordersRequest request);// 15.跟踪委托订单当前委托

    public SwapTrackHisordersResponse swapCrossTrackHisordersResponse(SwapTrackHisordersRequest request);// 16.跟踪委托订单历史委托
}
