package com.huobi.swap.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.request.coin_swap.transfer.UsdtSwapTransferRequest;
import com.huobi.api.response.coin_swap.transfer.UsdtSwapTransferResponse;
import com.huobi.api.service.coin_swap.transfer.TransferApiServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

/**
 * 现货-币本位永续划转接口
 */
@FixMethodOrder(MethodSorters.JVM)
public class TransferAPITest implements BaseTest {


    TransferApiServiceImpl transferApiService = new TransferApiServiceImpl("", "");

    @Test
    public void transfer() {
        /**
         * 参数名称	是否必须	类型	    描述	                                        取值范围
         * from	    true	string	来源业务线账户，取值：spot(币币)、swap(币本位永续)	e.g. spot
         * to	    true	string	目标业务线账户，取值：spot(币币)、swap(币本位永续)	e.g. swap
         * currency	true	string	币种,支持大小写	                            e.g. btc
         * amount	true	Decimal	划转金额
         */

        UsdtSwapTransferRequest request = UsdtSwapTransferRequest.builder()
                .from("swap")
                .to("spot")
                .currency("theta")
                .amount(BigDecimal.valueOf(10))
                .build();
        UsdtSwapTransferResponse response = transferApiService.transfer(request);
        logger.debug("1.现货-币本位永续账户间进行资金的划转：{}", JSON.toJSONString(response));
    }


}
