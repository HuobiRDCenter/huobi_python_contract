package com.huobi.api.service.usdt.transfer;

import com.huobi.api.response.usdt.market.SwapCrossTransferStateResponse;

public interface CrossTransferAPIService {
    public SwapCrossTransferStateResponse getSwapCrossTransferState(String marginAccount);// 1.【全仓】查询用户当前的划转限制
}
