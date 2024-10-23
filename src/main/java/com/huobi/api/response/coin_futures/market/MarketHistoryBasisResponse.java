package com.huobi.api.response.coin_futures.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class MarketHistoryBasisResponse {
    private String ch;
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        private Long id;
        @SerializedName("contract_price")
        private String contractPrice;
        @SerializedName("index_price")
        private String indexPrice;
        private String basis;
        @SerializedName("basis_rate")
        private String basisRate;
    }
}
