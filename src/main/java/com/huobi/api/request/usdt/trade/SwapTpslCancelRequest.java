package com.huobi.api.request.usdt.trade;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SwapTpslCancelRequest {
    private String contractCode;
    private String orderId;
    private String pair;
    private String contractType;
}
