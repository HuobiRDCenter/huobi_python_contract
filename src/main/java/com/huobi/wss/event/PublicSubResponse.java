package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class PublicSubResponse {
    private String op;
    private String topic;
    private long ts;
    private List<DataBean> data;
    @Data
    @AllArgsConstructor
    public static class DataBean {
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        private String direction;
        private String offset;
        private BigDecimal volume;
        private BigDecimal amount;
        @SerializedName("trade_turnover")
        private BigDecimal tradeTurnover;
        private BigDecimal price;
        @SerializedName("created_at")
        private long createdAt;
        @SerializedName("contract_type")
        private String contractType;
        private String pair;
        @SerializedName("business_type")
        private String businessType;
    }
}
