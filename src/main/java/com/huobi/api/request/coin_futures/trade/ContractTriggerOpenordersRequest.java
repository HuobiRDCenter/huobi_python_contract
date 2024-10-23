package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractTriggerOpenordersRequest {
    private String symbol;
    private String contractCode;
    private Integer pageIndex;
    private Integer pageSize;
    private Integer trade_type;
}
