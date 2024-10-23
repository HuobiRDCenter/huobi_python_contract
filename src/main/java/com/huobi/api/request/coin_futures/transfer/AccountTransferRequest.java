package com.huobi.api.request.coin_futures.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class AccountTransferRequest {
    private String from;
    private String to;
    private String currency;
    private BigDecimal amount;
    private String marginAccount;
}
