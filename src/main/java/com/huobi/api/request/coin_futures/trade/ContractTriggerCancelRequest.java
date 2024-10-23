package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractTriggerCancelRequest {
    private String symbol;
    private String orderId;
}
