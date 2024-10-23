package com.huobi.api.response.usdt.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SwapAvailableLevelRateResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean{
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("available_level_rate")
        private String availableLevelRate;
        @SerializedName("margin_mode")
        private String marginMode;
        @SerializedName("trade_partition")
        private String tradePartition;
    }
}
