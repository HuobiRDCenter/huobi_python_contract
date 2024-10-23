package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ContractMatchresultsExactRequest {
    private String symbol;
    private Integer tradeType;
    private String contractCode;
    private Long startTime;
    private Long endTime;
    private Long fromId;
    private Integer size;
    private String direct;
}
