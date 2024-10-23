package com.huobi.api.request.coin_futures.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractSubAuthListRequest {
    private String subUid;
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
}
