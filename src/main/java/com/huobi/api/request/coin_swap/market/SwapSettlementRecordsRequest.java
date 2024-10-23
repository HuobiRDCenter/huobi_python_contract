package com.huobi.api.request.coin_swap.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SwapSettlementRecordsRequest {

    private String contractCode;
    private Long startTime;
    private Long endTime;
    private Integer pageIndex;
    private Integer pageSize;
}
