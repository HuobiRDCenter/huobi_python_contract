package com.huobi.api.response.coin_futures.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ContractHisordersExactV3Response {
    private Integer code;
    private String msg;
    private Long ts;
    private List<ContractHisordersV3Response.DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("query_id")
        private Long queryId;
        @SerializedName("order_id")
        private Long orderId;
        @SerializedName("order_id_str")
        private String orderIdStr;
        private String symbol;
        @SerializedName("contract_type")
        private String contractType;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("lever_rate")
        private Integer leverRate;
        private String direction;
        private String offset;
        private BigDecimal volume;
        private BigDecimal price;
        @SerializedName("create_date")
        private Long createData;
        @SerializedName("order_source")
        private String orderSource;
        @SerializedName("order_price_type")
        private String orderPriceType;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        private BigDecimal profit;
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
        @SerializedName("real_profit")
        private BigDecimal realProfit;
        @SerializedName("canceled_source")
        private String canceledSource;
    }
}
