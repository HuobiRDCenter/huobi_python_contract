package com.huobi.api.response.coin_futures.market;

import com.google.gson.annotations.SerializedName;
import com.huobi.api.response.usdt.market.SwapQueryElementsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ContractQueryElementsResponse {
    private String status;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("mode_type")
        private Integer modeType;
        @SerializedName("swap_delivery_type")
        private Integer swapDeliveryType;
        @SerializedName("instrument_index_code")
        private String instrumentIndexCode;
        @SerializedName("real_time_settlement")
        private Integer realTimeSettlement;
        @SerializedName("contract_infos")
        private List<ContractInfos> contractInfos;
        @SerializedName("transfer_profit_ratio")
        private BigDecimal transferProfitRatio;
        @SerializedName("cross_transfer_profit_ratio")
        private BigDecimal crossTransferProfitRatio;
        @SerializedName("instrument_type")
        private List<Integer> instrumentType;
        @SerializedName("trade_partition")
        private String tradePartition;
        @SerializedName("min_level")
        private Integer minLevel;
        @SerializedName("max_level")
        private Integer maxLevel;
        @SerializedName("settle_period")
        private Integer settlePeriod;
        @SerializedName("funding_rate_cap")
        private BigDecimal fundingRateCap;
        @SerializedName("funding_rate_floor")
        private BigDecimal fundingRateFloor;
        @SerializedName("long_position_limit")
        private BigDecimal longPositionLimit;
        @SerializedName("offset_order_limit")
        private BigDecimal offsetOrderLimit;
        @SerializedName("open_order_limit")
        private BigDecimal openOrderLimit;
        @SerializedName("short_position_limit")
        private BigDecimal shortPositionLimit;
        @SerializedName("week_hig_normal_limit")
        private Integer weekHigNormalLimit;
        @SerializedName("week_min_normal_limit")
        private Integer weekMinNormalLimit;
        @SerializedName("week_hig_open_limit")
        private Integer weekHigOpenLimit;
        @SerializedName("week_min_open_limit")
        private Integer weekMinOpenLimit;
        @SerializedName("week_hig_trade_limit")
        private Integer weekHigTradeLimit;
        @SerializedName("week_min_trade_limit")
        private Integer weekMinTradeLimit;
        @SerializedName("biweek_hig_normal_limit")
        private Integer biweekHigNormalLimit;
        @SerializedName("biweek_min_normal_limit")
        private Integer biweekMinNormalLimit;
        @SerializedName("biweek_hig_open_limit")
        private Integer biweekHigOpenLimit;
        @SerializedName("biweek_min_open_limit")
        private Integer biweekMinOpenLimit;
        @SerializedName("biweek_hig_trade_limit")
        private Integer biweekHigTradeLimit;
        @SerializedName("biweek_min_trade_limit")
        private Integer biweekMinTradeLimit;
        @SerializedName("quarter_hig_normal_limit")
        private Integer quarterHigNormalLimit;
        @SerializedName("quarter_min_normal_limit")
        private Integer quarterMinNormalLimit;
        @SerializedName("quarter_hig_open_limit")
        private Integer quarterHigOpenLimit;
        @SerializedName("quarter_min_open_limit")
        private Integer quarterMinOpenLimit;
        @SerializedName("quarter_hig_trade_limit")
        private Integer quarterHigTradeLimit;
        @SerializedName("quarter_min_trade_limit")
        private Integer quarterMinTradeLimit;
        @SerializedName("biquarter_hig_normal_limit")
        private Integer biquarterHigNormalLimit;
        @SerializedName("biquarter_min_normal_limit")
        private Integer biquarterMinNormalLimit;
        @SerializedName("biquarter_hig_open_limit")
        private Integer biquarterHigOpenLimit;
        @SerializedName("biquarter_min_open_limit")
        private Integer biquarterMinOpenLimit;
        @SerializedName("biquarter_hig_trade_limit")
        private Integer biquarterHigTradeLimit;
        @SerializedName("biquarter_min_trade_limit")
        private Integer biquarterMinTradeLimit;
        @SerializedName("order_limits")
        private List<OrderLimits> orderLimits;
        private Long ts;
        @AllArgsConstructor
        @Builder
        @Data
        public static class OrderLimits{
            @SerializedName("instrument_type")
            private Integer instrumentType;
            private String open;
            private String close;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class ContractInfos {
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("instrument_type")
            private List<Integer> instrumentType;
            @SerializedName("settlement_date")
            private String settlementDate;
            @SerializedName("create_date")
            private String createDate;
            @SerializedName("contract_status")
            private Integer contractStatus;
        }
    }
}
