package com.huobi.api.service.coin_futures.account;



import com.huobi.api.request.coin_futures.account.*;

import com.huobi.api.response.coin_futures.account.*;

public interface AccountAPIService {
    ContractBalanceValuationResponse getContractBalanceValuation(String ValuationAsset);// 1.获取账户总资产估值
    ContractAccountInfoResponse getContractAccountInfo(String symbol);// 2.获取用户账户信息

    ContractPositionInfoResponse getContractPositionInfo(String symbol);// 3.获取用户持仓信息

    ContractSubAuthResponse getContractSubAuth(String subUid,Integer subAuth);// 4、批量设置子账户交易权限

    ContractSubAuthListResponse getContractSubAuthList(ContractSubAuthListRequest request);// 5.查询子账户交易权限

    ContractSubAccountListResponse getContractSubAccountList(String symbol, String direct, Long fromId);// 6.查询母账户下所有子账户资产信息

    ContractSubAccountInfoListResponse getContractSubAccountInfoList(ContractSubAccountInfoListRequest request);// 7、批量获取子账户资产信息

    ContractSubAccountInfoResponse getContractSubAccountInfo(String symbol, Long subUid);// 8.查询单个子账户资产信息

    ContractSubPositionInfoResponse getContractSubPositionInfo(String symbol, Long subUid);// 9.查询单个子账户持仓信息

    ContractFinancialRecordV3Response getContractFinancialRecordV3(ContractFinancialRecordV3Request request);// 10.查询用户财务记录(新)

    ContractFinancialRecordExactV3Response getContractFinancialRecordExactV3(ContractFinancialRecordExactV3Request request);// 11.组合查询用户财务记录(新)

    ContractUserSettlementRecordsResponse getContractUserSettlementRecords(ContractUserSettlementRecordsRequest request);// 12、查询用户结算记录

    ContractOrderLimitResponse getContractOrderLimitResponse(String symbol, String orderPriceType);// 13.查询用户当前的下单量限制

    ContractFeeResponse getContractFeeResponse(String symbol);// 14.查询用户当前的手续费费率

    ContractTransferLimitResponse getContractTransferLimitResponse(String symbol);// 15.查询用户当前的划转限制

    ContractPositionLimitResponse getContractPositionLimitResponse(String symbol);// 16.用户持仓量限制的查询

    ContractAccountPositionInfoResponse getContractAccountPositionInfo(String symbol);// 17、查询用户账户和持仓信息

    ContractMasterSubTransferResponse getContractMasterSubTransfer(ContractMasterSubTransferRequest request);// 18、母子账户划转

    ContractMasterSubTransferRecordResponse getContractMasterSubTransferRecord(ContractMasterSubTransferRecordRequest request);// 19、获取母账户下的所有母子账户划转记录

    ContractApiTradingStatusResponse getContractApiTradingStatus();// 20、获取用户的API指标禁用信息

    ContractAvailableLevelRateResponse getContractAvailableLevelRate(String symbol);// 21、查询用户可用杠杆倍数
}
