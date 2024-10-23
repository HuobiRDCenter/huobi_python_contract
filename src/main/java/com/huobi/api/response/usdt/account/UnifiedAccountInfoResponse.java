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
public class UnifiedAccountInfoResponse {
    @SerializedName("cross_max_available")
    private Integer crossMaxAvailable;
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;
    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("margin_balance")
        private BigDecimal marginBalance;
        @SerializedName("margin_static")
        private BigDecimal marginStatic;
        @SerializedName("cross_profit_unreal")
        private BigDecimal crossProfitUnreal;
        @SerializedName("cross_margin_static")
        private BigDecimal crossMarginStatic;
        @SerializedName("margin_asset")
        private String marginAsset;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        @SerializedName("withdraw_available")
        private BigDecimal withdrawAvailable;
        private BigDecimal crossRiskRate;
        private List<CrossSwap> cross_swap;
        private List<CrossFutures> crossFutures;
        private List<IsolatedSwap> isolatedSwap;
        @AllArgsConstructor
        @Builder
        @Data
        public static class CrossSwap{
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("margin_mode")
            private String marginMode;
            @SerializedName("margin_available")
            private BigDecimal marginAvailable;
            @SerializedName("lever_rate")
            private BigDecimal leverRate;
            @SerializedName("contract_type")
            private String contractType;
            @SerializedName("business_type")
            private String businessType;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class CrossFutures{
            private String symbol;
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("margin_mode")
            private String marginMode;
            @SerializedName("margin_available")
            private BigDecimal marginAvailable;
            @SerializedName("lever_rate")
            private BigDecimal leverRate;
            @SerializedName("contract_type")
            private String contractType;
            @SerializedName("business_type")
            private String businessType;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class IsolatedSwap{
            private String symbol;
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("margin_mode")
            private String marginMode;
            @SerializedName("margin_available")
            private BigDecimal marginAvailable;
            @SerializedName("lever_rate")
            private Integer leverRate;
            @SerializedName("withdraw_available")
            private BigDecimal withdrawAvailable;
            @SerializedName("position_mode")
            private String positionMode;
        }
    }
}
