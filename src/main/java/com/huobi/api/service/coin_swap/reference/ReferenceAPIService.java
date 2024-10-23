package com.huobi.api.service.coin_swap.reference;

import com.huobi.api.request.coin_swap.market.SwapSettlementRecordsRequest;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersV3Request;
import com.huobi.api.response.coin_swap.market.*;
import com.huobi.api.response.usdt.account.SwapLiquidationOrdersV3Response;
import com.huobi.api.response.usdt.market.SwapQueryElementsResponse;
import com.huobi.api.response.usdt.market.SwapSettlementRecordsResponse;

public interface ReferenceAPIService {
    public SwapRiskInfoResponse getSwapRiskInfo(String contractCode);// 1.查询合约风险准备金和预估分摊比例

    public SwapInsuranceFundResponse getSwapInsuranceFund(String contractCode, Integer pageIndex, Integer pageSize);// 2.获取风险准备金历史数据

    public SwapAdjustfactorResponse getSwapAdjustfactor(String contractCode);// 3.查询平台阶梯调整系数

    public SwapHisOpenInterestResponse getSwapHisOpenInterest(String contractCode, String period, Integer size, Integer amountType);// 4.平台持仓量的查询

    public SwapLadderMarginResponse getSwapLadderMargin(String contractCode);// 5.获取平台阶梯保证金

    public SwapEliteAccountRatioResponse getSwapEliteAccountRatio(String contractCode, String period);// 6.精英账户多空持仓对比-账户数

    public SwapElitePositionRatioResponse getSwapElitePositionRatio(String contractCode, String period);// 7.精英账户多空持仓对比-持仓量

    public SwapEstimatedSettlementPriceResponse getSwapEstimatedSettlementPrice(String contractCode);// 8.获取预估结算价

    public SwapApiStateResponse getSwapApiState(String contractCode);// 9.查询系统状态

    public SwapFundingRateResponse getSwapFundingRate(String contractCode);// 10.获取合约的资金费率

    public SwapBatchFundingRateResponse getSwapBatchFundingRate(String contractCode);// 11.批量获取合约资金费率

    public SwapHistoricalFundingRateResponse getSwapHistoricalFundingRate(String contractCode, Integer pageIndex, Integer pageSize);// 12.获取合约的历史资金费率

    public SwapLiquidationOrdersV3Response getSwapLiquidationOrdersV3(SwapLiquidationOrdersV3Request request);// 13.获取强平订单(新)

    public SwapSettlementRecordsResponse getSwapSettlementRecords(SwapSettlementRecordsRequest request);// 14.查询平台历史结算记录

    public SwapContractInfoResponse getSwapContractInfo(String contractCode);// 15.获取合约信息

    public SwapIndexResponse getSwapIndex(String contractCode);// 16.获取合约指数信息

    public SwapQueryElementsResponse getSwapQueryElements(String contractCode);// 17.合约要素

    public SwapPriceLimitResponse getSwapPriceLimit(String contractCode);// 18.获取合约最高限价和最低限价

    public SwapOpenInterestResponse getSwapOpenInterest(String contractCode);// 19.获取当前可用合约总持仓量

    public TimestampReponse getTimestamp();// 20.获取当前系统时间戳

    public HeartBeatResponse getHeartBeat();// 21.查询系统是否可用

    public SummaryResponse getSummary();// 22.获取当前系统状态
}
