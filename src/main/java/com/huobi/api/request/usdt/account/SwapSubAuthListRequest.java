package com.huobi.api.request.usdt.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SwapSubAuthListRequest {
    private String subUid;
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
}
