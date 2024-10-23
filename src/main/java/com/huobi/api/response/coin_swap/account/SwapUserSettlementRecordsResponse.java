package com.huobi.api.response.coin_swap.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class SwapUserSettlementRecordsResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Data
    @Builder
    public static class DataBean{
        @SerializedName("total_size")
        private Integer totalPage;
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_size")
        private Integer totalSize;
        @SerializedName("settlement_records")
        private List<SettlementRecordsBean> settlementRecords;

        @AllArgsConstructor
        @Data
        @Builder
        public static class SettlementRecordsBean{
            private String symbol;
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("contract_code")
            private BigDecimal marginBalanceInit;
            @SerializedName("margin_balance")
            private BigDecimal marginBalance;
            @SerializedName("settlement_profit_real")
            private BigDecimal settlementProfitReal;
            @SerializedName("settlement_time")
            private Long settlementTime;
            private BigDecimal clawback;
            @SerializedName("funding_fee")
            private BigDecimal fundingFee;
            @SerializedName("offset_profitloss")
            private BigDecimal offsetProfitloss;
            private BigDecimal fee;
            @SerializedName("fee_asset")
            private String feeAsset;
            private List<PositionsBean> positions;

            @AllArgsConstructor
            @Data
            @Builder
            public static class PositionsBean{
                private String symbol;
                @SerializedName("contract_code")
                private String contractCode;
                private String direction;
                private BigDecimal volume;
                @SerializedName("cost_open")
                private BigDecimal costOpen;
                @SerializedName("cost_hold_pre")
                private BigDecimal costHoldPre;
                @SerializedName("cost_hold")
                private BigDecimal costHold;
                @SerializedName("settlement_profit_unreal")
                private BigDecimal settlementProfitUnreal;
                @SerializedName("settlement_price")
                private BigDecimal settlementPrice;
                @SerializedName("settlement_type")
                private String settlementType;
            }
        }
    }
}
