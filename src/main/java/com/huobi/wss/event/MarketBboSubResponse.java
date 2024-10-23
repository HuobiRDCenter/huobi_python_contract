package com.huobi.wss.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class MarketBboSubResponse {
    private String ch;
    private Long ts;
    private TickBean tick;

    @Data
    @AllArgsConstructor
    public static class TickBean {
        private Long mrid;
        private Long id;
        private Long ts;
        private Long version;
        private String ch;
        private List<BigDecimal[]> bids;
        private List<BigDecimal[]> asks;
        private String event;
    }
}
