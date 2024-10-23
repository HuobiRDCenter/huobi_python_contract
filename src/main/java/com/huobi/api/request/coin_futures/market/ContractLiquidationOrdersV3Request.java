package com.huobi.api.request.coin_futures.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractLiquidationOrdersV3Request {
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
    private String symbol;
    private Integer tradeType;
}
