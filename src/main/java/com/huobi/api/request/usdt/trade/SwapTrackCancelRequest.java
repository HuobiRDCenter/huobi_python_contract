package com.huobi.api.request.usdt.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class SwapTrackCancelRequest {
    private String contractCode;
    private String orderId;
    private String pair;
    private String contractType;
}
