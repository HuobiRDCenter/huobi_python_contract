package com.huobi.api.request.coin_futures.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class ContractMasterSubTransferRequest {
    private Long subUid;
    private String symbol;
    private String type;
    private BigDecimal amount;
    private Long clientOrderId;
}
