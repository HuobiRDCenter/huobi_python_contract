package com.huobi.api.response.coin_futures.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ContractApiTradingStatusResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Data
    @Builder
    public static class DataBean{
        @SerializedName("is_disable")
        private Long isDisable;
        @SerializedName("order_price_types")
        private String orderPriceType;
        @SerializedName("disable_reason")
        private String disableReason;
        @SerializedName("disable_interval")
        private Long disableInterval;
        @SerializedName("recovery_time")
        private Long recoveryTime;
        private List<CORBean> cor;
        private List<TDNBean> tdn;

        @AllArgsConstructor
        @Data
        @Builder
        public static class CORBean{
            @SerializedName("orders_threshold")
            private Long ordersThreshold;
            private Long orders;
            @SerializedName("invalid_cancel_orders")
            private Long invalidCancelOrders;
            @SerializedName("cancel_ratio_threshold")
            private BigDecimal cancelRatioThreshold;
            @SerializedName("cancel_ratio")
            private BigDecimal cancelRatio;
            @SerializedName("is_trigger")
            private Integer isTrigger;
            @SerializedName("is_active")
            private Integer isActive;
        }

        @AllArgsConstructor
        @Data
        @Builder
        public static class TDNBean{
            @SerializedName("disables_threshold")
            private Long disablesThreshold;
            private Long disables;
            @SerializedName("is_trigger")
            private Long isTrigger;
            @SerializedName("is_active")
            private Long isActive;

        }
    }
}
