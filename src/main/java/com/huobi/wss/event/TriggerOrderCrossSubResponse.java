package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TriggerOrderCrossSubResponse {
    private String op;
    private String topic;
    private Long ts;
    private String uid;
    private String event;
    private List<DataBean> data;
    @Data
    @Builder
    @AllArgsConstructor
    public static class DataBean {
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("margin_mode")
        private String marginMode;
        @SerializedName("margin_account")
        private String marginAccount;
        @SerializedName("trigger_type")
        private String triggerType;
        private BigDecimal volume;
        @SerializedName("order_type")
        private Integer orderType;
        private String direction;
        private String offset;
        @SerializedName("lever_rate")
        private Integer leverRate;
        @SerializedName("order_id")
        private BigDecimal orderId;
        @SerializedName("order_id_str")
        private String orderIdStr;
        @SerializedName("relation_order_id")
        private String relationOrderId;
        @SerializedName("order_price_type")
        private String orderPriceType;
        private Integer status;
        @SerializedName("order_source")
        private String orderSource;
        @SerializedName("trigger_price")
        private BigDecimal triggerPrice;
        @SerializedName("triggered_price")
        private BigDecimal triggeredPrice;
        @SerializedName("order_price")
        private BigDecimal orderPrice;
        @SerializedName("created_at")
        private Long createdAt;
        @SerializedName("triggered_at")
        private Long triggeredAt;
        @SerializedName("order_insert_at")
        private Long orderInsertAt;
        @SerializedName("canceled_at")
        private Long canceledAt;
        @SerializedName("fail_code")
        private Integer failCode;
        @SerializedName("fail_reason")
        private String failReason;
        @SerializedName("contract_type")
        private String contractType;
        private String pair;
        @SerializedName("business_type")
        private String businessType;
        @SerializedName("reduce_only")
        private Integer reduceOnly;
    }
}
