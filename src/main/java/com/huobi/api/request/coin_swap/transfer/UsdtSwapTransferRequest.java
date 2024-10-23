package com.huobi.api.request.coin_swap.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/*
* 现货-期权合约账户间进行资金的划转
* */

@Data
@AllArgsConstructor
@Builder
public class UsdtSwapTransferRequest {
    private String from;//来源业务线账户，取值：spot(币币)、swap(币本位永续)	e.g. spot
    private String to;//目标业务线账户，取值：spot(币币)、swap(币本位永续)	e.g. swap
    private String currency;//币种,支持大小写	e.g. btc
    private BigDecimal amount;//划转金额
}
