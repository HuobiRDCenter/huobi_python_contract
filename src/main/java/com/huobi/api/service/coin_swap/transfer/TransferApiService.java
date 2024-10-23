package com.huobi.api.service.coin_swap.transfer;


import com.huobi.api.request.coin_swap.transfer.UsdtSwapTransferRequest;
import com.huobi.api.response.coin_swap.transfer.UsdtSwapTransferResponse;

public interface TransferApiService {
    UsdtSwapTransferResponse transfer(UsdtSwapTransferRequest request);// 1.现货-USDT永续账户间进行资金的划转
}
