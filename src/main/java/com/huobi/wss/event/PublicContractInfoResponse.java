package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class PublicContractInfoResponse {
    private String op;
    private String topic;
    private Long ts;
    private String event;
    private List<DataBean> data;
    @Data
    @AllArgsConstructor
    public static class DataBean {
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("contract_size")
        private BigDecimal contractSize;
        @SerializedName("price_tick")
        private BigDecimal priceTick;
        @SerializedName("settlement_date")
        private String settlementDate;
        @SerializedName("delivery_time")
        private String deliveryTime;
        @SerializedName("create_date")
        private String createDate;
        @SerializedName("contract_status")
        private int contractStatus;
        @SerializedName("support_margin_mode")
        private String supportMarginMode;
        @SerializedName("contract_type")
        private String contractType;
        private String pair;
        @SerializedName("business_type")
        private String businessType;
        @SerializedName("delivery_date")
        private String deliveryDate;
    }
}
