package com.huobi.api.request.usdt.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class SwapTrackCancelallRequest {
    private String contractCode;
    private String direction;
    private String offset;
    private String pair;
    private String contractType;
}
