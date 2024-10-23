package com.huobi.api.response.coin_futures.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class MarketHistoryIndexResponse {
    private String ch;
    private String status;
    private Long ts;
    public List<DataBean> data;

    @AllArgsConstructor
    @Data
    @Builder
    public static class DataBean{
        private BigDecimal id;
        private BigDecimal vol;
        private BigDecimal count;
        private BigDecimal open;
        private BigDecimal close;
        private BigDecimal low;
        private BigDecimal high;
        private BigDecimal amount;
    }
}
