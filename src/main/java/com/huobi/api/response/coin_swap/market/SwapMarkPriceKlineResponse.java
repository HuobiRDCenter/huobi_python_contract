package com.huobi.api.response.coin_swap.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class SwapMarkPriceKlineResponse {
    private String status;
    private Long ts ;
    private List<DataBean> data;

    @Builder
    @Data
    @AllArgsConstructor
    public static class DataBean{
        private Long id;
        private String vol;
        private String count;
        private String open;
        private String close;
        private String low;
        private String high;
        private String amount;
        @SerializedName("trade_turnover")
        private String tradeTurnover;

    }
}
