package com.huobi.api.response.coin_swap.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class TimestampReponse {
    private String status;
    private Long ts;
}
