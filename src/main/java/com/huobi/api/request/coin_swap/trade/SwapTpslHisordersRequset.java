package com.huobi.api.request.coin_swap.trade;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SwapTpslHisordersRequset {
    private String contractCode;
    private String status;
    private Long createDate;
    private Integer pageIndex;
    private Integer pageSize;
    private String sortBy;
}
