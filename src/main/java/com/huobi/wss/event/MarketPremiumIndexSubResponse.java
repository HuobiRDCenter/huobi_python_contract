package com.huobi.wss.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MarketPremiumIndexSubResponse {
    private String ch;
    private long ts;
    private TickBean tick;

    @Data
    @AllArgsConstructor
    public static class TickBean {
        private Long id;
        private String vol;
        private BigDecimal count;
        private String open;
        private String close;
        private String low;
        private String high;
        private String amount;
    }
}
