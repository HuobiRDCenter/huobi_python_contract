package com.huobi.api.response.usdt.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SwapLiquidationOrdersV3Response {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        @SerializedName("query_id")
        private Long queryId;
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("created_at")
        private Long createdAt;
        private String direction;
        private String offset;
        private BigDecimal volume;
        private BigDecimal amount;
        private BigDecimal price;
        @SerializedName("trade_turnover")
        private BigDecimal tradeTurnover;
        private String pair;
        @SerializedName("business_type")
        private String businessType;

    }
}
