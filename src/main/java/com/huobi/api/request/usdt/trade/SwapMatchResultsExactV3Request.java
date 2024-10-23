package com.huobi.api.request.usdt.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SwapMatchResultsExactV3Request {
    private String contract;
    private Integer tradeType;
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
}
