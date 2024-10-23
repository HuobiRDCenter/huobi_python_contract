package com.huobi.api.response.usdt.market;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SwapQueryElementsResponse {
    private String status;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean {
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
        @SerializedName("transfer_profit_ratio")
        private Integer transferProfitRatio;
        @SerializedName("cross_transfer_profit_ratio")
        private Integer crossTransferProfitRatio;
        @SerializedName("instrument_type")
        private List<Integer> instrumentType;
        @SerializedName("trade_partition")
        private String tradePartition;
        @SerializedName("min_level")
        private Integer minLevel;
        @SerializedName("max_level")
        private Integer maxLevel;
        @SerializedName("open_order_limit")
        private BigDecimal openOrderLimit;
        @SerializedName("offset_order_limit")
        private BigDecimal offsetOrderLimit;
        @SerializedName("long_position_limit")
        private BigDecimal longPositionLimit;
        @SerializedName("short_position_limit")
        private BigDecimal shortPositionLimit;
        @SerializedName("price_tick")
        private BigDecimal priceTick;
        @SerializedName("price_ticks")
        private List<PriceTicks> priceTicks;
        @SerializedName("instrument_values")
        private List<InstrumentValues> instrumentValues;
        @SerializedName("instrument_value")
        private BigDecimal instrumentValue;
        @SerializedName("settle_period")
        private Integer settlePeriod;
        @SerializedName("funding_rate_cap")
        private BigDecimal fundingRateCap;
        @SerializedName("funding_rate_floor")
        private BigDecimal fundingRateFloor;
        @SerializedName("hig_normal_limit")
        private BigDecimal higNormalLimit;
        @SerializedName("min_normal_limit")
        private BigDecimal minNormalLimit;
        @SerializedName("hig_open_limit")
        private BigDecimal higOpenLimit;
        @SerializedName("min_open_limit")
        private BigDecimal minOpenLimit;
        @SerializedName("hig_trade_limit")
        private BigDecimal higTradeLimit;
        @SerializedName("min_trade_limit")
        private BigDecimal minTradeLimit;
        @SerializedName("contract_infos")
        private List<ContractInfos> contractInfos;
        @SerializedName("order_limits")
        private List<OrderLimits> orderLimits;
        @SerializedName("normal_limits")
        private List<NormalLimits> normalLimits;
        @SerializedName("open_limits")
        private List<OpenLimits> openLimits;
        @SerializedName("trade_limits")
        private List<TradeLimits> tradeLimits;
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
        @AllArgsConstructor
        @Builder
        @Data
        public static class PriceTicks {
            @SerializedName("business_type")
            private Integer businessType;
            private String price;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class InstrumentValues {
            @SerializedName("business_type")
            private Integer businessType;
            private String price;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class OrderLimits {
            @SerializedName("instrument_type")
            private Integer instrumentType;
            private String open;
            private String close;
            @SerializedName("open_after_closing")
            private String openAfterClosing;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class NormalLimits {
            @SerializedName("instrument_type")
            private Integer instrumentType;
            private String open;
            private String close;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class OpenLimits {
            @SerializedName("instrument_type")
            private Integer instrumentType;
            private String open;
            private String close;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class TradeLimits {
            @SerializedName("instrument_type")
            private Integer instrumentType;
            private String open;
            private String close;
        }
    }
}
