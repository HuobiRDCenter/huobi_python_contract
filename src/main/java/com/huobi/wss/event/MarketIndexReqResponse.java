package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class MarketIndexReqResponse {
    private String id;
    private String req;
    private Long wsid;
    private String status;
    private String ts;
    private List<DataBean> data;
    @Data
    @AllArgsConstructor
    public static class DataBean {
        private Long id;
        private BigDecimal open;
        private BigDecimal close;
        private BigDecimal low;
        private BigDecimal high;
        private BigDecimal amount;
        private BigDecimal vol;
        private BigDecimal count;
    }
}
