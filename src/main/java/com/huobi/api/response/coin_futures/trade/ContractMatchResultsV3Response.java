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
public class ContractMatchResultsV3Response {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;
    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        private String id;
        @SerializedName("query_id")
        private Long queryId;
        @SerializedName("match_id")
        private Long matchId;
        @SerializedName("order_id")
        private Long orderID;
        @SerializedName("order_id_str")
        private String orderIdStr;
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
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
        private BigDecimal offsetProfrtloss;
        @SerializedName("traded_fee")
        private BigDecimal tradedFee;
        private String role;
        @SerializedName("fee_asset")
        private String feeAsset;
        @SerializedName("order_source")
        private String orderSource;
        @SerializedName("real_profit")
        private String realProfit;
    }

}
