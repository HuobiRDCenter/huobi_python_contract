package com.huobi.api.service.coin_swap.account;


import com.huobi.api.request.coin_swap.account.*;
import com.huobi.api.request.usdt.account.SwapSubAuthListRequest;
import com.huobi.api.response.coin_swap.account.*;
import com.huobi.api.response.usdt.account.SwapSubAuthListResponse;

public interface AccountAPIService {
    SwapBalanceValuationResponse getSwapBalanceValuation(String ValuationAsset);// 1.获取账户总资产估值

    SwapAccountInfoResponse getSwapAccountInfo(String contractCode);// 2.获取用户账户信息

    SwapPositionInfoResponse getSwapPositionInfo(String contractCode);// 3.获取用户持仓信息

    SwapAccountPositionInfoResponse getSwapAccountPositionInfo(String contractCode);// 4.查询用户账户和持仓信息

    SwapSubAuthResponse getSwapSubAuth(String subUid,Integer subAuth);// 5.批量设置子账户交易权限

    SwapSubAuthListResponse getSwapSubAuthList(SwapSubAuthListRequest request);// 6.查询子账户交易权限

    SwapSubAccountListResponse getSwapSubAccountList(String contractCode, String direct, Long fromId);// 7.查询母账户下所有子账户资产信息

    SwapSubAccountInfoListResponse getSwapSubAccountInfoList(String contractCode,Integer pageIndex,Integer pageSize);// 8.批量获取子账户资产信息

    SwapSubAccountInfoResponse getSwapSubAccountInfo(String contractCode, Long subUid);// 9.查询单个子账户资产信息

    SwapSubPositionInfoResponse getSwapSubPositionInfo(String contractCode , Long subUid);// 10.查询单个子账户持仓信息

    SwapFinancialRecordV3Response getSwapFinancialRecordV3(SwapFinancialRecordV3Request request);// 11.查询用户财务记录(新)

    SwapFinancialRecordExactV3Response getSwapFinancialRecordExactV3(SwapFinancialRecordExactV3Request request);// 12.组合查询用户财务记录(新)

    SwapUserSettlementRecordsResponse getSwapUserSettlementRecords(SwapUserSettlementRecordsRequest request);// 13.获取用户API指标禁用信息

    SwapAvailableLevelRateResponse getSwapAvailableLevelRate(String contractCode);// 14.获取合约可用杠杆倍数

    SwapOrderLimitResponse getSwapOrderLimitResponse(String contractCode, String orderPriceType);// 15.查询用户当前的下单量限制

    SwapFeeResponse getSwapFeeResponse(String contractCode);// 16.查询用户当前的手续费费率

    SwapTransferLimitResponse getSwapTransferLimitResponse(String contractCode);// 17.查询用户当前的划转限制

    SwapPositionLimitResponse getSwapPositionLimitResponse(String contractCode);// 18.用户持仓量限制的查询

    SwapMasterSubTransferResponse getSwapMasterSubTransferResponse(SwapMasterSubTransferRequest request);// 19.母子账户划转

    SwapMasterSubTransferRecordResponse getSwapMasterSubTransferRecordResponse(SwapMasterSubTransferRecordRequest request);// 20.获取母账户下的所有母子账户划转记录

    SwapApiTradingStatusResponse getSwapApiTradingStatusResponse();// 21.获取用户API指标禁用信息
}
