package com.huobi.api.request.coin_futures.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ContractSettlementRecordsRequest {
    private String symbol;
    private Long startTime;
    private Long endTime;
    private Integer pageIndex;
    private Integer pageSize;
}
