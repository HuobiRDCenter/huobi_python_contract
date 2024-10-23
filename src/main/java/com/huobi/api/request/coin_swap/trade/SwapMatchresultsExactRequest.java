package com.huobi.api.request.coin_swap.trade;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SwapMatchresultsExactRequest {
    private String contractCode;
    private Integer tradeType;
    private Long startTime;
    private Long endTime;
    private Long fromId;
    private Integer size;
    private String direct;
}
