package com.huobi.api.response.coin_swap.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class SwapAvailableLevelRateResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Data
    @Builder
    public static class DataBean{
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("available_level_rate")
        private String availableLevelRate;
    }

}
