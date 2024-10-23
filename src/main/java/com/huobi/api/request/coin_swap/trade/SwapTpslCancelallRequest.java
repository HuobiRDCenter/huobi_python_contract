package com.huobi.api.request.coin_swap.trade;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SwapTpslCancelallRequest {
    private String contractCode;
    private String direction;
}
