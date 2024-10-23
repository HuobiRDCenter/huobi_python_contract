package com.huobi.api.response.usdt.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SwapPositionSideResponse {
    private String status;
    private List<DataBean> data;

    @AllArgsConstructor
    @Data
    public static class DataBean {
        @SerializedName("margin_account")
        private String marginAccount;
        @SerializedName("position_mode")
        private String positionMode;
    }
}
