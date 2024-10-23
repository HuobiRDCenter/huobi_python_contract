package com.huobi.api.service.usdt.account;


import com.huobi.api.request.usdt.account.SwapCrossLeverPositionLimitRequest;
import com.huobi.api.request.usdt.account.SwapCrossUserSettlementRecordsRequest;
import com.huobi.api.response.usdt.account.*;

public interface CrossAccountAPIService {

    SwapCrossAccountInfoResponse getSwapCrossAccountInfo(String marginAccount);// 1.获取用户账户信息（全仓模式）

    SwapCrossPositionInfoResponse getSwapCrossPositionInfo(String contractCode, String pair, String contractType);// 2.获取用户持仓信息（全仓模式）

    SwapCrossAccountPositionInfoResponse getSwapCrossAccountPositionInfo(String marginAccount);// 3.查询用户账户和持仓信息（全仓模式）

    SwapCrossSubAccountListResponse getSwapCrossSubAccountList(String marginAccount, String direct, Long fromId);// 4.查询母账户下所有子账户资产信息（全仓模式）

    SwapSubAccountInfoListResponse getSwapCrossSubAccountInfoList(String marginAccount, Integer pageIndex, Integer pagesize);// 5.批量获取子账户资产信息（全仓模式）

    SwapCrossSubAccountInfoResponse getSwapCrossSubAccountInfo(String marginAccount, Long subUid);// 6.查询单个子账户资产信息（全仓模式）

    SwapCrossSubPositionInfoResponse getSwapCrossSubPositionInfo(String contractCode, Long subUid, String pair, String contractType);// 7.查询单个子账户持仓信息（全仓模式）

    SwapCrossAvailableLevelRateResponse getSwapCrossAvailableLevelRate(String contractCode, String pair, String contractType, String businessType);// 8.查询当前可能杠杆倍数（全仓模式）

    SwapCrossTransferLimitResponse getSwapCrossTransferLimitResponse(String marginAccount);// 9.查询用户当前的划转限制（全仓模式）

    SwapCrossPositionLimitResponse getSwapCrossPositionLimitResponse(String contractCode, String pair, String contractType,String businessType);// 10.用户持仓量限制的查询（全仓模式）

    SwapLeverPositionLimitResponse getSwapCrossLeverPositionLimit(SwapCrossLeverPositionLimitRequest request);// 11.查询用户所有杠杆持仓量限制
}
