package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MarketBasisPriceTypeReqResponse {
    private String id;
    private String req;
    private Long wsid;
    private String status;
    private String ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
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
