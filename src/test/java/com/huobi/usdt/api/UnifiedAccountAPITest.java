package com.huobi.usdt.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.request.usdt.account.FixPositionMarginChangeRecordRequest;
import com.huobi.api.request.usdt.account.FixPositionMarginChangeRequest;
import com.huobi.api.response.usdt.account.*;
import com.huobi.api.service.usdt.unified_account.UnifiedAccountAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class UnifiedAccountAPITest implements BaseTest{
    UnifiedAccountAPIServiceImpl huobiAPIService  = new UnifiedAccountAPIServiceImpl("", "");

    @Test
    public void getUnifiedAccountInfo(){
        UnifiedAccountInfoResponse response = huobiAPIService.getUnifiedAccountInfo("BTC-USDT");
        logger.debug("1.查询统一账户资产:{}", JSON.toJSONString(response));
    }

    @Test
    public void getLinearSwapOverviewAccountInfo(){
        LinearSwapOverviewAccountInfoResponse response = huobiAPIService.getLinearSwapOverviewAccountInfo();
        logger.debug("2.可抵扣HT资产查询:{}", JSON.toJSONString(response));
    }

    @Test
    public void getLinearSwapFeeSwitch(){
        LinearSwapFeeSwitchResponse response = huobiAPIService.getLinearSwapFeeSwitch(1);
        logger.debug("3.设置U本位合约手续费抵扣方式:{}", JSON.toJSONString(response));
    }

    @Test
    public void getFixPositionMarginChange(){
        FixPositionMarginChangeRequest request = FixPositionMarginChangeRequest.builder().amount(1.0).asset("USDT").contractCode("BTC-USDT").type(1).direction(1).build();
        FixPositionMarginChangeResponse response = huobiAPIService.getFixPositionMarginChange(request);
        logger.debug("4.调整逐仓持仓保证金:{}", JSON.toJSONString(response));
    }

    @Test
    public void getFixPositionMarginChangeRecord(){
        FixPositionMarginChangeRecordRequest request = FixPositionMarginChangeRecordRequest.builder().asset("USDT").contractCode("BTC-USDT").build();
        FixPositionMarginChangeRecordResponse response = huobiAPIService.getFixPositionMarginChangeRecord(request);
        logger.debug("5.查询调整逐仓持仓保证金记录:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapUnifiedAccountType(){
        SwapUnifiedAccountTypeResponse response = huobiAPIService.getSwapUnifiedAccountType();
        logger.debug("6.账户类型查询:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapSwitchAccountType(){
        SwapSwitchAccountTypeResponse response = huobiAPIService.getSwapSwitchAccountType(1);
        logger.debug("7.账户类型更改接口:{}", JSON.toJSONString(response));
    }
}
