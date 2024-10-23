package com.huobi.api.service.coin_futures.trade;

import com.huobi.api.request.coin_futures.trade.*;
import com.huobi.api.response.coin_futures.trade.*;

public interface TradeAPIService {
    ContractCancelAfterResponse contractCancelAfterResponse(ContractCancelAfterRequest request);// 1.自动撤单

    ContractOrderResponse contractOrderRequest(ContractOrderRequest request);// 2.合约下单

    ContractBatchorderResponse contractBatchorderRequest(ContractBatchorderRequest request);// 3.合约批量下单

    ContractCancelResponse contractCancelRequest(ContractCancelRequest request);// 4.撤销订单

    ContractCancelallResponse contractCancelallRequest(ContractCancelallRequest request);// 5.全部撤单

    ContractSwitchLeverRateResponse contractSwitchLeverRateRequest(String symbol,Integer leverRate);// 6.切换杠杆

    ContractOrderInfoResponse contractOrderInfoRequest(ContractOrderInfoRequest request);// 7.获取合约订单信息

    ContractOrderDetailResponse contractOrderDetailRequest(ContractOrderDetailRequest request);// 8.获取订单明细信息

    ContractOpenordersResponse contractOpenordersRequest(ContractOpenordersRequest request);// 9.获取合约当前未成交委托

    ContractHisordersV3Response contractHisordersV3Response(ContractHisordersV3Request request);// 10.获取合约历史委托(新)

    ContractHisordersExactV3Response contractHisordersExactV3Response(ContractHisordersExactV3Request request);// 11.组合查询合约历史委托(新)

    ContractMatchResultsV3Response contractMatchResultsV3Response(ContractMatchResultsV3Request request);// 12.获取历史成交记录(新)

    ContractMatchResultsExactV3Response contractMatchResultsExactV3Response(ContractMatchResultsExactV3Request request);// 13.组合查询历史成交记录接口(新)

    LightningClosePositionResponse lightningClosePositionRequest(LightningClosePositionRequest request);// 14.闪电平仓下单
}
