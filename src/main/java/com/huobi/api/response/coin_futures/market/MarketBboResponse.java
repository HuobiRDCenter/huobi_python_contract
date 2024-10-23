package com.huobi.api.response.coin_futures.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class MarketBboResponse {
    private String status;
    private Long ts;
    private List<TicksBean> ticks;

    @Builder
    @Data
    @AllArgsConstructor
    public static class TicksBean{
        private String symbol;
        private Long mrid;
        private BigDecimal[] ask;
        private BigDecimal[] bid;
        private Long ts;
    }
}
