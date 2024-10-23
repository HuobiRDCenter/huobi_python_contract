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
public class SwapHisordersV3Response {
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
        @SerializedName("lever_rate")
        private Integer leverRate;
        private String direction;
        private String offset;
        private BigDecimal volume;
        private BigDecimal price;
        @SerializedName("create_date")
        private Long createDate;
        @SerializedName("update_time")
        private Long updateTime;
        @SerializedName("order_source")
        private String orderSource;
        @SerializedName("order_price_type")
        private String orderPriceType;
        @SerializedName("margin_asset")
        private String marginAsset;
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
        private Integer order_type;
        @SerializedName("fee_asset")
        private String feeAsset;
        @SerializedName("liquidation_type")
        private String liquidationType;
        @SerializedName("margin_mode")
        private String marginMode;
        @SerializedName("margin_account")
        private String marginAccount;
        @SerializedName("is_tpsl")
        private Integer isTpsl;
        @SerializedName("reduce_only")
        private Integer reduceOnly;
        private String canceledSource;


    }
}
