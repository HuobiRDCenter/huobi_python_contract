package com.huobi.api.service.usdt.transfer;


import com.huobi.api.request.usdt.transfer.UsdtSwapTransferRequest;
import com.huobi.api.response.usdt.transfer.UsdtSwapTransferResponse;

public interface TransferAPIService {

    UsdtSwapTransferResponse transfer(UsdtSwapTransferRequest request); // 1.现货-USDT永续账户间进行资金的划转
}
