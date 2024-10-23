package com.huobi.api.service.coin_futures.strategy;

import com.huobi.api.request.coin_futures.trade.*;
import com.huobi.api.response.coin_futures.trade.*;

public interface StrategyAPIService {
    public ContractTriggerOrderResponse contractTriggerOrderRequest(ContractTriggerOrderRequest request);// 1.合约计划委托下单

    public ContractTriggerCancelResponse contractTriggerCancelRequest(ContractTriggerCancelRequest request);// 2.合约计划委托撤单

    public ContractTriggerCancelallResponse contractTriggerCancelallRequest(ContractTriggerCancelallRequest request);// 3.合约订单委托全部撤单

    public ContractTriggerOpenordersResponse contractTriggerOpenordersRequest(ContractTriggerOpenordersRequest request);// 4.获取计划委托当前委托

    public ContractTriggerHisordersResponse contractTriggerHisorders(ContractTriggerHisordersRequest request);// 5.获取计划委托历史委托

    public ContractTpslOrderResponse contractTpslOrder(ContractTpslOrderRequest request);// 6.对仓位设置止盈止损订单

    public ContractTpslCancelResponse contractTpslCancelResponse(ContractTpslCancelRequest request);// 7.止盈止损订单撤单

    public ContractTpslCancelallResponse contractTpslCancelallResponse(ContractTpslCancelallRequest request);// 8.止盈止损订单全部撤单

    public ContractTpslOpenordersResponse contractTpslOpenordersResponse(ContractTpslOpenordersRequest request);// 9.查询止盈止损订单当前委托

    public ContractTpslHisordersResponse contractTpslHisordersResponse(ContractTpslHisordersRequset request);// 10.查询止盈止损订单历史委托

    public ContractRelationTpslOrderResponse contractRelationTpslOrderResponse(ContractRelationTpslOrderRequest request);// 11.查询开仓单关联的止盈止损订单详情

    public ContractTrackOrderResponse contractTrackOrderResponse(ContractTrackOrderRequest request); // 12.跟踪委托订单下单

    public ContractTrackCancelResponse contractTrackCancelResponse(ContractTrackCancelRequest request);// 13.跟踪委托订单撤单

    public ContractTrackCancelallResponse contractTrackCancelallResponse(ContractTrackCancelallRequest request);// 14.跟踪委托订单全部撤单

    public ContractTrackOpenordersResponse contractTrackOpenordersResponse(ContractTrackOpenordersRequest request);// 15.跟踪委托订单当前委托

    public ContractTrackHisordersResponse contractTrackHisordersResponse(ContractTrackHisordersRequest request);// 16.跟踪委托订单历史委托
}
