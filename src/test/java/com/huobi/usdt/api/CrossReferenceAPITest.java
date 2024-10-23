package com.huobi.usdt.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.response.usdt.market.SwapCrossAdjustfactorResponse;
import com.huobi.api.response.usdt.market.SwapLadderMarginResponse;
import com.huobi.api.service.usdt.reference.CrossReferenceAPIServiceImpl;
import com.huobi.api.service.usdt.reference.ReferenceAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class CrossReferenceAPITest implements BaseTest{
    CrossReferenceAPIServiceImpl huobiCrossAPIService  = new CrossReferenceAPIServiceImpl("", "");

    @Test
    public void getSwapCrossLadderMargin() {
        SwapLadderMarginResponse response = huobiCrossAPIService.getSwapCrossLadderMargin("","","","");
        logger.debug("1.获取平台阶梯保证金:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapCrossAdjustfactor() {
        SwapCrossAdjustfactorResponse response = huobiCrossAPIService.getSwapCrossAdjustfactor("btc-usdt","","","");
        logger.debug("2.查询平台阶梯调整系数:{}", JSON.toJSONString(response));
    }

}
