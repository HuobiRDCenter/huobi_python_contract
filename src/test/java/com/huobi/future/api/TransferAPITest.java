package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.request.coin_futures.transfer.AccountTransferRequest;
import com.huobi.api.response.coin_futures.transfer.AccountTransferResponse;
import com.huobi.api.response.coin_futures.transfer.FuturesTransferResponse;
import com.huobi.api.service.coin_futures.transfer.TransferApiServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

/**
 * 合约划转接口
 */
@FixMethodOrder(MethodSorters.JVM)
public class

TransferAPITest implements BaseTest {


    TransferApiServiceImpl transferApiService = new TransferApiServiceImpl("", "");

    @Test
    public void transfer() {
        //从合约账户到现货账户：“futures-to-pro”，从现货账户到合约账户： “pro-to-futures”
        BigDecimal amount = BigDecimal.valueOf(50);//注意划转的金额精度
        FuturesTransferResponse response =
                transferApiService.transfer("ada", amount, "pro-to-futures");
        logger.debug("1.现货-合约账户间进行资金的划转：{}", JSON.toJSONString(response));
    }

    @Test
    public void accountTransfer(){
        AccountTransferRequest request = AccountTransferRequest.builder()
                .from("spot")
                .to("futures")
                .currency("usdt")
                .amount(new BigDecimal(100))
                .marginAccount("USDT")
                .build();
        AccountTransferResponse response = transferApiService.accountTransfer(request);
        logger.debug("2.【通用】现货-合约账户进行资金的划转：{}", JSON.toJSONString(response));
    }
}
