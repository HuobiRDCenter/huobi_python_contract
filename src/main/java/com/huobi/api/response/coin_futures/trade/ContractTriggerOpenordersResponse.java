package com.huobi.api.response.coin_futures.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ContractTriggerOpenordersResponse {
    private String status;
    private List<DataBean> data;
    private Long ts;

    @Data
    @AllArgsConstructor
    @Builder
    public static class DataBean{
        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_size")
        private Integer totalSize;
        private List<OrdersBean> orders;

        @Data
        @AllArgsConstructor
        @Builder
        public static  class OrdersBean{
            private String symbol;
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
            private Integer orderID;
            @SerializedName("order_id_str")
            private String orderIdStr;
            @SerializedName("order_source")
            private String orderSource;
            @SerializedName("trigger_price")
            private BigDecimal triggerPrice;
            @SerializedName("order_price")
            private BigDecimal orderPrice;
            @SerializedName("created_at")
            private Long createdAt;
            @SerializedName("order_price_type")
            private String orderPriceType;
            private Integer status;

        }
    }
}
