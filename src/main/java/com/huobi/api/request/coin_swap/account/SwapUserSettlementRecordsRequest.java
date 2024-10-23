package com.huobi.api.request.coin_swap.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class SwapUserSettlementRecordsRequest {
    private String contractCode;
    private Long startTime;
    private Long endTime;
    private Integer pageIndex;
    private Integer pageSize;
}
