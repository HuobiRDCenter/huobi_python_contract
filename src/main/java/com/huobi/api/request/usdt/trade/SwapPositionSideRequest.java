package com.huobi.api.request.usdt.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SwapPositionSideRequest {
    private String marginAccount;
}
