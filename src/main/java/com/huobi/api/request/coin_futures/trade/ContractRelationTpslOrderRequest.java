package com.huobi.api.request.coin_futures.trade;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContractRelationTpslOrderRequest {
    private String symbol;
    private Long orderId;
}
