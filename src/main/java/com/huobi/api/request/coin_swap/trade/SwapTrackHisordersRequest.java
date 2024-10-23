package com.huobi.api.request.coin_swap.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class SwapTrackHisordersRequest {
    private String contractCode;
    private String status;
    private Integer tradeType;
    private Long createDate;
    private Integer pageIndex;
    private Integer pageSize;
    private String sortBy;

}
