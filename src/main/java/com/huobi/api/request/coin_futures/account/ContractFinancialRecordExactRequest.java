package com.huobi.api.request.coin_futures.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ContractFinancialRecordExactRequest {
    private String symbol;
    private String type;
    private Long startTime;
    private Long endTime;
    private Long fromId;
    private Integer size;
    private String direct;
}
