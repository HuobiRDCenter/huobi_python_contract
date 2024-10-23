package com.huobi.api.request.coin_futures.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractFinancialRecordExactV3Request {
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
    private String type;
    private String symbol;
}
