package com.huobi.api.response.coin_swap.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class MarketBboResponse {
    private String status;
    private Long ts;
    private List<TicksBean> ticks;

    @Builder
    @Data
    @AllArgsConstructor
    public static class TicksBean{
        @SerializedName("contract_code")
        private String contract_code;
        private Long mrid;
        private BigDecimal[] ask;
        private BigDecimal[] bid;
        private Long ts;
    }
}
