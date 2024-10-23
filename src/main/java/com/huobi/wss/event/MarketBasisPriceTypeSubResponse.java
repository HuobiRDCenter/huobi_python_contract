package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarketBasisPriceTypeSubResponse {
    private String ch;
    private Long ts;
    private TickBean tick;

    @Data
    @AllArgsConstructor
    public static class TickBean {
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
