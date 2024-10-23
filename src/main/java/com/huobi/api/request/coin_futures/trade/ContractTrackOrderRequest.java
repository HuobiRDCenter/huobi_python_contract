package com.huobi.api.request.coin_futures.trade;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
public class ContractTrackOrderRequest {
    private String symbol;
    private String contractType;
    private String contractCode;
    private String direction;
    private String offset;
    private Integer leverRate;
    private BigDecimal volume;
    private BigDecimal callbackRate;
    private BigDecimal activePrice;
    private String orderPriceType;
}
