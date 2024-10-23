package com.huobi.api.service.usdt.reference;

import com.huobi.api.request.usdt.account.SwapLiquidationOrdersV3Request;
import com.huobi.api.response.usdt.account.SwapLiquidationOrdersV3Response;
import com.huobi.api.response.usdt.account.SwapSwitchAccountTypeResponse;
import com.huobi.api.response.usdt.account.SwapUnifiedAccountTypeResponse;
import com.huobi.api.response.usdt.market.*;

public interface ReferenceAPIService {
    public SwapFundingRateResponse getSwapFundingRate(String contractCode);// 1.获取合约的资金费率

    public SwapBatchFundingRateResponse getSwapBatchFundingRate(String contractCode);// 2.批量获取合约资金费率

    public SwapHistoricalFundingRateResponse getSwapHistoricalFundingRate(String contractCode, Integer pageIndex, Integer pageSize);// 3.获取合约的历史资金费率

    public SwapLiquidationOrdersV3Response getSwapLiquidationOrdersV3(SwapLiquidationOrdersV3Request request);// 4.获取强平订单(新)

    public SwapSettlementRecordsResponse getSwapSettlementRecords(String contractCode, Long startTime, Long endTime, Integer pageIndex, Integer pageSize);// 5.查询平台历史结算记录

    public SwapEliteAccountRatioResponse getSwapEliteAccountRatio(String contractCode, String period);// 6.精英账户多空持仓对比-账户数

    public SwapElitePositionRatioResponse getSwapElitePositionRatio(String contractCode, String period);// 7.精英账户多空持仓对比-持仓量

    public SwapApiStateResponse getSwapApiState(String contractCode);// 8.查询系统状态

    public SwapLadderMarginResponse getSwapLadderMargin(String contractCode);// 9.获取平台阶梯保证金

    public SwapEstimatedSettlementPriceResponse getSwapEstimatedSettlementPrice(String contractCode,String pair,String contractType,String businessType);// 10.获取预估结算价

    public SwapAdjustfactorResponse getSwapAdjustfactor(String contractCode);// 11.查询平台阶梯调整系数

    public SwapInsuranceFundResponse getSwapInsuranceFund(String contractCode, Integer pageIndex, Integer pageSize);// 12.获取风险准备金历史数据

    public SwapRiskInfoResponse getSwapRiskInfo(String contractCode,String businessType);// 13.查询合约风险准备金和预估分摊比例

    public SwapPriceLimitResponse getSwapPriceLimit(String contractCode, String pair, String contractType, String businessType);// 14.获取合约最高限价和最低限价

    public SwapOpenInterestResponse getSwapOpenInterest(String contractCode, String pair, String contractType, String businessType);// 15.获取当前可用合约总持仓量

    public SwapContractInfoResponse getSwapContractInfo(String contractCode, String supportMarginMode, String pair, String contractType, String businessType);// 16.获取合约信息

    public SwapIndexResponse getSwapIndex(String contractCode);// 17.获取合约指数信息

    public SwapQueryElementsResponse getSwapQueryElements(String contractCode);// 18.合约要素
}
