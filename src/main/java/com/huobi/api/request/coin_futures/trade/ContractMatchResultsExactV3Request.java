package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractMatchResultsExactV3Request {
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
    private Integer tradeType;
    private String symbol;
    private String contract;
}
