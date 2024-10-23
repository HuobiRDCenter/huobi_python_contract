package com.huobi.api.request.coin_futures.trade;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContractTpslCancelRequest {
    private String symbol;
    private String orderId;
}
