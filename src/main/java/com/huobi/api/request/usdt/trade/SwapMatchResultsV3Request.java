package com.huobi.api.request.usdt.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SwapMatchResultsV3Request {
    private String contract;
    private String pair;
    private Integer tradeType;
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
}
