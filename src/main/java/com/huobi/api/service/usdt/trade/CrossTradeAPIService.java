package com.huobi.api.service.usdt.trade;


import com.huobi.api.request.usdt.trade.*;
import com.huobi.api.response.usdt.market.SwapCrossTradeStateResponse;
import com.huobi.api.response.usdt.trade.*;

public interface CrossTradeAPIService {
    public SwapCrossTradeStateResponse getSwapCrossTradeState(String contractCode, String contractType, String pair, String businessType);// 1.【全仓】查询系统交易权限
    SwapSwitchPositionModeResponse swapCrossSwitchPositionModeResponse(String marginAccount, String positionMode);// 2.切换持仓模式

    SwapCrossOrderResponse swapCrossOrderRequest(SwapCrossOrderRequest request);// 3.合约下单（全仓模式）

    SwapCrossBatchorderResponse swapCrossBatchorderRequest(SwapCrossBatchorderRequest request);// 4.合约批量下单（全仓模式）

    SwapCrossCancelResponse swapCrossCancelRequest(SwapCrossCancelRequest request);// 5.撤销订单（全仓模式）

    SwapCrossCancelallResponse swapCrossCancelallRequest(SwapCrossCancelallRequest request);// 6.全部撤单（全仓模式）

    SwapCrossSwitchLeverRateResponse getSwapCrossSwitchLeverRate(String contractCode, Integer lever_rate,String pair,String contractType);// 7.切换杠杆（全仓模式）

    SwapCrossOrderInfoResponse swapCrossOrderInfoRequest(SwapCrossOrderInfoRequest request);// 8.获取合约订单信息（全仓模式）

    SwapCrossOrderDetailResponse swapCrossOrderDetailRequest(SwapCrossOrderDetailRequest request);// 9.获取订单明细信息（全仓模式）

    SwapCrossOpenordersResponse swapCrossOpenordersRequest(SwapCrossOpenordersRequest request);// 10.获取合约当前未成交委托（全仓模式）

    SwapCrossHisordersV3Response swapCrossHisordersV3Response(SwapCrossHisordersV3Request request);// 11.获取合约历史委托(新)

    SwapCrossHisordersExactV3Response swapCrossHisordersExactV3Response(SwapCrossHisordersExactV3Request request);// 12.组合查询合约历史委托(新)

    SwapCrossMatchResultsV3Response swapCrossMatchResultsV3Response(SwapCrossMatchResultsV3Request request);// 13.获取历史成交记录(新)

    SwapCrossMatchResultsExactV3Response swapCrossMatchResultsExactV3Response(SwapCrossMatchResultsExactV3Request request);// 14.组合查询用户历史成交记录(新)

    SwapCrossLightningClosePositionResponse swapCrossLightningClosePositionRequest(SwapCrossLightningClosePositionRequest request);// 15.闪电平仓下单（全仓模式）

    SwapCrossPositionSideResponse swapCrossPositionSideResponse(String marginAccount);// 16.查询持仓模式

}
