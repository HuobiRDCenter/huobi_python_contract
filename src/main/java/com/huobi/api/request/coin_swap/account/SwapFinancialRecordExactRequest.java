package com.huobi.api.request.coin_swap.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SwapFinancialRecordExactRequest {
    private String contractCode;
    private String type;
    private Long startTime;
    private Long endTime;
    private Long fromId;
    private Integer size;
    private String direct;
}
