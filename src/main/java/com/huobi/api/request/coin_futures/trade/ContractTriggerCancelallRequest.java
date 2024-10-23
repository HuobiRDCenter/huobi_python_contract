package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractTriggerCancelallRequest {
    private String symbol;
    private String contractCode;
    private String contractType;
    private String direction;
    private String offset;
}
