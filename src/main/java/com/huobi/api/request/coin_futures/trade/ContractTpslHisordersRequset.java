package com.huobi.api.request.coin_futures.trade;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContractTpslHisordersRequset {
    private String symbol;
    private String contractCode;
    private String status;
    private Long createDate;
    private Integer pageIndex;
    private Integer pageSize;
    private String sortBy;
}
