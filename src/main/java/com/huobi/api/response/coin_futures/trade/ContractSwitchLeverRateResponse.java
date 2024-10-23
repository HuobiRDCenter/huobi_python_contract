package com.huobi.api.response.coin_futures.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class ContractSwitchLeverRateResponse {
    private String status;
    private Long ts;
    @SerializedName("err_code")
    private Integer errCode;
    @SerializedName("err_msg")
    private String errMsg;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        private String symbol;
        @SerializedName("lever_rate")
        private Integer leverRate;
    }
}
