package com.huobi.api.request.usdt.trade;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SwapRelationTpslOrderRequest {
    private String contractCode;
    private Long orderId;
    private String pair;
}
