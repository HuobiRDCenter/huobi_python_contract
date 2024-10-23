package com.huobi.api.request.coin_futures.trade;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
public class ContractTpslOrderRequest {
    private String symbol;
    private String contractType;
    private String contractCode;
    private String direction;
    private String volume;
    private BigDecimal tpTriggerPrice;
    private BigDecimal tpOrderPrice;
    private String tpOrderPriceType;
    private BigDecimal slTriggerPrice;
    private BigDecimal slOrderPrice;
    private String slOrderPriceType;
}
