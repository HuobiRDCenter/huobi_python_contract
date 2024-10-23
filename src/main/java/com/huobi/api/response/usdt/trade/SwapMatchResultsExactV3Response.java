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
public class SwapMatchResultsExactV3Response {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;

    @Builder
    @Data
    @AllArgsConstructor
    public static class DataBean{
        private String id;
        @SerializedName("query_id")
        private Long queryId;
        @SerializedName("match_id")
        private Long matchId;
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
        private String direction;
        private String offset;
        @SerializedName("trade_volume")
        private BigDecimal tradeVolume;
        @SerializedName("trade_price")
        private BigDecimal tradePrice;
        @SerializedName("trade_turnover")
        private BigDecimal tradeTurnover;
        @SerializedName("create_date")
        private Long createDate;
        @SerializedName("offset_profitloss")
        private BigDecimal offsetProfitloss;
        @SerializedName("real_profit")
        private BigDecimal realProfit;
        @SerializedName("trade_fee")
        private BigDecimal tradeFee;
        private String role;
        @SerializedName("feeAsset")
        private String feeAsset;
        @SerializedName("ht_price")
        private String htPrice;
        @SerializedName("order_source")
        private String orderSource;
        @SerializedName("reduce_only")
        private Integer reduceOnly;
    }
}
