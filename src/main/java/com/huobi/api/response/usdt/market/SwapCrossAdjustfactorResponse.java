package com.huobi.api.response.usdt.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class SwapCrossAdjustfactorResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("margin_mode")
        private String marginMode;
        private String pair;
        @SerializedName("business_type")
        private String businessType;
        @SerializedName("contract_type")
        private String contractType;
        @SerializedName("trade_partition")
        private String tradePartition;
        private List<ListBean> list;

        @AllArgsConstructor
        @Builder
        @Data
        public static class ListBean{
            @SerializedName("lever_rate")
            private Integer LeverRate;
            private List<LaddersBean> ladders;

            @AllArgsConstructor
            @Builder
            @Data
            public static class LaddersBean{
                @SerializedName("min_size")
                private BigDecimal minSize;
                @SerializedName("max_size")
                private BigDecimal maxSize;
                private Integer ladder;
                @SerializedName("adjust_factor")
                private BigDecimal adjustFactor;
            }
        }
    }


}
