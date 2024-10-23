package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ContractTrackCancelRequest {
    private String symbol;
    private String orderId;
}
