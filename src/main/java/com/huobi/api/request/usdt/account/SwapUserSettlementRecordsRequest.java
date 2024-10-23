package com.huobi.api.request.usdt.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class SwapUserSettlementRecordsRequest {
    private String contractCode;
    private Long startTime;
    private Long endTime;
    private Integer pageIndex;
    private Integer pageSize;
}
