package com.huobi.api.response.coin_swap.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class BatchMergedResponse {
    private String status;
    private Long ts;
    private List<TicksBean> ticks;

    @Builder
    @AllArgsConstructor
    @Data
    public static class TicksBean{
        @SerializedName("contract_code")
        private String contractCode;
        private Long id;
        private String amount;
        private BigDecimal[] ask;
        private BigDecimal[] bid;
        private String open;
        private String close;
        private BigDecimal count;
        private String high;
        private String low;
        private String vol;
        private Long ts;
    }
}
