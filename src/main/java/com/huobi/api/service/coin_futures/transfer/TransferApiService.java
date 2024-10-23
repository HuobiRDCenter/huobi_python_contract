package com.huobi.api.service.coin_futures.transfer;

import com.huobi.api.request.coin_futures.transfer.AccountTransferRequest;
import com.huobi.api.response.coin_futures.transfer.AccountTransferResponse;
import com.huobi.api.response.coin_futures.transfer.FuturesTransferResponse;

import java.math.BigDecimal;

public interface TransferApiService {

    FuturesTransferResponse transfer(String currency, BigDecimal amount, String type);// 1.现货-合约账户间进行资金的划转

    AccountTransferResponse accountTransfer(AccountTransferRequest request);// 2.现货-合约账户进行资金的划转
}
