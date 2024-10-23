package com.huobi.api.response.coin_swap.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class SwapSwitchLeverRateResponse {
    private String status;
    private Long ts;
    @SerializedName("err_code")
    private Integer errCode;
    @SerializedName("err_mag")
    private String err_mag;

    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("lever_rate")
        private Integer leverRate;
    }
}
