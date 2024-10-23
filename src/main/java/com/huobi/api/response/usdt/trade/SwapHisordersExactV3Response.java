package com.huobi.api.response.usdt.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SwapHisordersExactV3Response {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        @SerializedName("query_id")
        private Long queryId;
        @SerializedName("order_id")
        private Long orderId;
        @SerializedName("order_id_str")
        private String orderIdStr;
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("margin_mode")
        private String marginMode;
        @SerializedName("margin_account")
        private String marginAccount;
        @SerializedName("lever_rate")
        private Integer leverRate;
        private String direction;
        private String offset;
        private BigDecimal volume;
        private BigDecimal price;
        @SerializedName("create_date")
        private Long createDate;
        @SerializedName("order_source")
        private String orderSource;
        @SerializedName("order_price_type")
        private String orderPriceType;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        private BigDecimal profit;
        @SerializedName("real_profit")
        private BigDecimal realProfit;
        @SerializedName("trade_volume")
        private BigDecimal tradeVolume;
        @SerializedName("trade_turnover")
        private BigDecimal tradeTurnover;
        private BigDecimal fee;
        @SerializedName("trade_avg_price")
        private BigDecimal tradeAvgPrice;
        private Integer status;
        @SerializedName("order_type")
        private Integer orderType;
        @SerializedName("fee_asset")
        private String feeAsset;
        @SerializedName("liquidation_type")
        private String liquidationType;
        @SerializedName("is_tpsl")
        private Integer isTpsl;
        @SerializedName("reduce_only")
        private Integer reduceOnly;
        @SerializedName("canceled_source")
        private String canceledSource;
    }
}
