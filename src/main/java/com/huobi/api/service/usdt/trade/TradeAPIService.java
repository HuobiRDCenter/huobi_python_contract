package com.huobi.api.service.usdt.trade;


import com.huobi.api.request.usdt.trade.*;
import com.huobi.api.response.usdt.trade.*;

public interface TradeAPIService {
    LinearCancelAfterResponse linearCancelAfterResponse(LinearCancelAfterRequest request);// 1.自动撤单

    SwapSwitchPositionModeResponse swapSwitchPositionModeResponse(String marginAccount, String positionMode);// 2.切换持仓模式

    SwapOrderResponse swapOrderRequest(SwapOrderRequest request);// 3.合约下单

    SwapBatchorderResponse swapBatchorderRequest(SwapBatchorderRequest request);// 4.合约批量下单

    SwapCancelResponse swapCancelRequest(SwapCancelRequest request);// 5.撤销订单

    SwapCancelallResponse swapCancelallRequest(SwapCancelallRequest request);// 6.全部撤单

    SwapSwitchLeverRateResponse getSwapSwitchLeverRate(String contractCode, Integer lever_rate);// 7.切换杠杆

    SwapOrderInfoResponse swapOrderInfoRequest(SwapOrderInfoRequest request);// 8.获取合约订单信息

    SwapOrderDetailResponse swapOrderDetailRequest(SwapOrderDetailRequest request);// 9.获取订单明细信息

    SwapOpenordersResponse swapOpenordersRequest(SwapOpenordersRequest request);// 10.获取合约当前未成交委托

    SwapHisordersV3Response swapHisordersV3Response(SwapHisordersV3Request request);// 11.获取合约历史委托(新)

    SwapHisordersExactV3Response swapHisordersExactV3Response(SwapHisordersExactV3Request request);// 12.组合查询合约历史委托(新)

    SwapMatchResultsV3Response swapMatchResultsV3Response(SwapMatchResultsV3Request request);// 13.获取历史成交记录(新)

    SwapMatchResultsExactV3Response swapMatchResultsExactV3Response(SwapMatchResultsExactV3Request request);// 14.组合查询用户历史成交记录(新)

    SwapLightningClosePositionResponse swapLightningClosePositionRequest(SwapLightningClosePositionRequest request);// 15.闪电平仓下单

    SwapPositionSideResponse swapPositionSideResponse(SwapPositionSideRequest request); // 16.查询持仓模式
}
