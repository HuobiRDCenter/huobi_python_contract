package com.huobi.api.request.coin_swap.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class SwapHisordersExectRequest {
    private String contractCode;
    private Integer tradeType;
    private Integer type;
    private String status;
    private String orderPriceType;
    private Long startTime;
    private Long endTime;
    private Long fromId;
    private Integer size;
    private String direct;
}
