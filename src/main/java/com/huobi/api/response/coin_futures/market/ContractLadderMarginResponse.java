package com.huobi.api.response.coin_futures.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ContractLadderMarginResponse {
    private String status;
    private Long ts ;
    private List<DataBean> data;

    @Builder
    @AllArgsConstructor
    @Data
    public static class DataBean{
        private String symbol;
        private List<ListBean> list;

        @Builder
        @AllArgsConstructor
        @Data
        public static class ListBean{
            @SerializedName("lever_rate")
            private Integer leverRate;
            private List<LaddersBean> ladders;

            @Builder
            @AllArgsConstructor
            @Data
            public static class LaddersBean{
                @SerializedName("min_margin_balance")
                private BigDecimal minMarginBalance;
                @SerializedName("max_margin_balance")
                private BigDecimal maxMarginBalance;
                @SerializedName("min_margin_available")
                private BigDecimal minMarginAvailable;
                @SerializedName("max_margin_available")
                private BigDecimal maxMarginAvailable;
            }
        }
    }
}
