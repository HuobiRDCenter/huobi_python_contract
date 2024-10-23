package com.huobi.api.request.coin_swap.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SwapCancelAfterRequest {
    private Integer onOff;
    private Integer timeOut;
}
