package com.huobi.api.service.usdt.reference;

import com.huobi.api.response.usdt.market.SwapCrossAdjustfactorResponse;
import com.huobi.api.response.usdt.market.SwapLadderMarginResponse;

public interface CrossReferenceAPIService {
    public SwapLadderMarginResponse getSwapCrossLadderMargin(String contractCode, String contractType, String pair, String businessType);// 1.【全仓】获取平台阶梯保证金

    public SwapCrossAdjustfactorResponse getSwapCrossAdjustfactor(String contractCode, String contractType, String pair, String businessType);// 2.【全仓】查询平台阶梯调整系数


}
