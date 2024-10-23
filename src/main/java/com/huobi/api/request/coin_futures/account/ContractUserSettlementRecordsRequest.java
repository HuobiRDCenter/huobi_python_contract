package com.huobi.api.request.coin_futures.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ContractUserSettlementRecordsRequest {
    private String symbol;
    private Long startTime;
    private Long endTime;
    private Integer pageIndex;
    private Integer pageSize;
}
