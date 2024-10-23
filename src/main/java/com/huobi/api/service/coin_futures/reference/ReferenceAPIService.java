package com.huobi.api.service.coin_futures.reference;

import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.request.coin_futures.account.ContractSettlementRecordsRequest;
import com.huobi.api.request.coin_futures.market.ContractLiquidationOrdersV3Request;
import com.huobi.api.response.coin_futures.market.*;

public interface ReferenceAPIService {
    public ContractRiskInfoResponse getContractRiskInfo(String symbol);// 1.查询合约风险准备金余额和预估分摊比例

    public ContractInsuranceFundResponse getContractInsuranceFund(String symbol);// 2.查询合约风险准备金余额历史数据

    public ContractAdjustfactorResponse getContractAdjustfactor(String symbol);// 3.查询平台阶梯调整系数

    public ContractHisOpenInterestResponse getContractHisOpenInterest(String symbol, String contractType, TimePeriodTypeEnum timePeriodType, Integer size, Integer amountType);// 4.平台持仓量的查询

    public ContractLadderMarginResponse getContractLadderMargin(String symbol);// 5.获取平台阶梯保证金

    public ContractEliteAccountRatioResponse getContractEliteAccountRatio(String symbol, String period);// 6.精英账户多空持仓对比-账户数

    public ContractElitePositionRatioResponse getContractElitePositionRatio(String symbol, String period);// 7.精英账户多空持仓对比-持仓量

    public ContractLiquidationOrdersV3Response getContractLiquidationOrdersV3(ContractLiquidationOrdersV3Request request);// 8.获取强平订单(新)

    public ContractSettlementRecordsResponse getContractSettlementRecords(ContractSettlementRecordsRequest request);// 9.查询平台历史结算记录

    public ContractPriceLimitResponse getContractPriceLimit(String symbol, String contractType, String contractCode);// 10.获取合约最高限价和最低限价

    public ContractOpenInterestResponse getContractOpenInterest(String symbol, String contractType, String contractCode);// 11.获取当前可用合约总持仓量

    public ContractDeliveryPriceResponse getContractDeliveryPrice(String symbol);// 12.获取预估交割价

    public ContractEstimatedSettlementPriceResponse getContractEstimatedSettlementPriceResponse(String symbol);// 13.获取预估结算价

    public ContractApiStateResponse getContractApiState(String symbol);// 14.查询系统状态

    public ContractContractInfoResponse getContractContractInfo(String symbol, String contractType, String contractCode);// 15.获取合约信息

    public ContractIndexResponse getContractIndex(String symbol);// 16.获取合约指数信息

    public ContractQueryElementsResponse getContractQueryElements(String contractCode);// 17.合约要素
}
