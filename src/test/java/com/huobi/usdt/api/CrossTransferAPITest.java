package com.huobi.usdt.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.response.usdt.market.SwapCrossTransferStateResponse;
import com.huobi.api.service.usdt.transfer.CrossTransferAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class CrossTransferAPITest implements BaseTest{
    CrossTransferAPIServiceImpl huobiCrossAPIService  = new CrossTransferAPIServiceImpl("", "");

    @Test
    public void getSwapCrossTransferState(){
        SwapCrossTransferStateResponse response = huobiCrossAPIService.getSwapCrossTransferState("USDT");
        logger.debug("1.获取合约的溢价指数K线:{}", JSON.toJSONString(response));
    }
}
