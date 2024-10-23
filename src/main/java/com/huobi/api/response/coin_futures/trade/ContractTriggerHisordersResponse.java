package com.huobi.api.response.coin_futures.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class ContractTriggerHisordersResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_size")
        private Integer totalSize;
        private List<OrdersBean> orders;

        @AllArgsConstructor
        @Builder
        @Data
        public static class OrdersBean{
            private String Symbol;
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("contract_type")
            private String contractType;
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
            private Integer orderId;
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
            @SerializedName("update_time")
            private Long updateTime;
        }
    }
}
