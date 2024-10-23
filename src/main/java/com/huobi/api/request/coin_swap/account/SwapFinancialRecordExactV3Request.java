package com.huobi.api.request.coin_swap.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SwapFinancialRecordExactV3Request {
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
    private String type;
    private String contract;
}
