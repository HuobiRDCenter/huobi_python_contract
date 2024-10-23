package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ContractHisordersExactRequest {
    private String symbol;
    private Integer tradeType;
    private Integer type;
    private String status;
    private String contractCode;
    private String orderPriceType;
    private Long startTime;
    private Long endTime;
    private Long fromId;
    private Integer size;
    private String direct;
}
