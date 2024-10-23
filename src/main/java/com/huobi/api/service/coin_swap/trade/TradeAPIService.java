package com.huobi.api.service.coin_swap.trade;


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

public interface TradeAPIService {
    SwapCancelAfterResponse swapCancelAfterResponse(SwapCancelAfterRequest request);// 1.自动撤单

    SwapOrderResponse swapOrderRequest(SwapOrderRequest request);// 2.合约下单

    SwapBatchorderResponse swapBatchorderRequest(SwapBatchorderRequest request);// 3.合约批量下单

    SwapCancelResponse swapCancelRequest(SwapCancelRequest request);// 4.撤销订单

    SwapCancelallResponse swapCancelallRequest(SwapCancelallRequest request);// 5.全部撤单

    SwapSwitchLeverRateResponse swapSwitchLeverRateResponse(String contractCdoe,Integer leverRate);// 6.切换杠杆

    SwapOrderInfoResponse swapOrderInfoRequest(SwapOrderInfoRequest request);// 7.获取合约订单信息

    SwapOrderDetailResponse swapOrderDetailRequest(SwapOrderDetailRequest request);// 8.获取订单明细信息

    SwapOpenordersResponse swapOpenordersRequest(SwapOpenordersRequest request);// 9.获取合约当前未成交委托

    SwapHisordersV3Response swapHisordersV3Response(SwapHisordersV3Request request);// 10.获取合约历史委托(新)

    SwapHisordersExactV3Response swapHisordersExactV3Response(SwapHisordersExactV3Request request);// 11.组合查询合约历史委托(新)

    SwapMatchResultsV3Response swapMatchResultsV3Response(SwapMatchResultsV3Request request);// 12.获取历史成交记录（新）

    SwapMatchResultsExactV3Response swapMatchResultsExactV3Response(SwapMatchResultsExactV3Request request);// 13.组合查询用户历史成交记录（新）

    SwapLightningClosePositionResponse swapLightningClosePositionRequest(SwapLightningClosePositionRequest request); // 14.闪电平仓下单
}
