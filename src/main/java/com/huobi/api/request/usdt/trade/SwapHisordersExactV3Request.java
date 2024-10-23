package com.huobi.api.request.usdt.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SwapHisordersExactV3Request {
    private String contract;
    private String pair;
    private Integer tradeType;
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
    private Integer type;
    private String status;
    private String priceType;

}
