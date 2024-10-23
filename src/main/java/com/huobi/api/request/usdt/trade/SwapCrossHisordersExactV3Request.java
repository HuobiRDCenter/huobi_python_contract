package com.huobi.api.request.usdt.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SwapCrossHisordersExactV3Request {
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
    private Integer type;
    private Integer tradeType;
    private String contract;
    private String pair;
    private String status;
    private String priceType;
}
