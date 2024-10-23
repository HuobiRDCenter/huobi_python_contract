package com.huobi.api.request.usdt.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class FixPositionMarginChangeRecordRequest {
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
    private String contractCode;
    private String asset;
}
