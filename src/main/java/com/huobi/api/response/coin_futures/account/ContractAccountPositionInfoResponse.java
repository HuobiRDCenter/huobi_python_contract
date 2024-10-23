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
public class ContractAccountPositionInfoResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Data
    @Builder
    public static class DataBean{
        private String symbol;
        @SerializedName("margin_balance")
        private BigDecimal marginBalance;
        @SerializedName("margin_position")
        private BigDecimal marginPosition;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        @SerializedName("margin_available")
        private BigDecimal marginAvailable;
        @SerializedName("profit_real")
        private BigDecimal profitReal;
        @SerializedName("profit_unreal")
        private BigDecimal profitUnreal;
        @SerializedName("risk_rate")
        private BigDecimal riskRate;
        @SerializedName("withdraw_available")
        private BigDecimal withdrawAvailable;
        @SerializedName("liquidation_price")
        private BigDecimal liquidationPrice;
        @SerializedName("lever_rate")
        private Integer leverRate;
        @SerializedName("adjust_factor")
        private BigDecimal adjustFactor;
        @SerializedName("margin_static")
        private BigDecimal marginStatic;
        @SerializedName("new_risk_rate")
        private BigDecimal newRiskRate;
        @SerializedName("trade_partition")
        private String tradePartition;
        private List<PositionsBean>  positions;

        @AllArgsConstructor
        @Data
        @Builder
        public static class PositionsBean{
            private String symbol;
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("contract_type")
            private String contractType;
            private BigDecimal volume;
            private BigDecimal available;
            private BigDecimal frozen;
            @SerializedName("cost_open")
            private BigDecimal costOpen;
            @SerializedName("cost_hold")
            private BigDecimal costHold;
            @SerializedName("profit_unreal")
            private BigDecimal profitUnreal;
            @SerializedName("profit_rate")
            private BigDecimal profitRate;
            private BigDecimal profit;
            @SerializedName("position_margin")
            private BigDecimal positionMargin;
            @SerializedName("lever_rate")
            private Integer leverRate;
            private String direction;
            @SerializedName("last_price")
            private BigDecimal lastPrice;
            @SerializedName("adl_risk_percent")
            private BigDecimal adlRiskPercent;
        }
    }
}
