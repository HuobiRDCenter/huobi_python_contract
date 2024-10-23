package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractHisordersExactV3Request {
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
    private Integer type;
    private String symbol;
    private Integer tradeType;
    private String status;
    private String contract;
    private String orderType;
}
