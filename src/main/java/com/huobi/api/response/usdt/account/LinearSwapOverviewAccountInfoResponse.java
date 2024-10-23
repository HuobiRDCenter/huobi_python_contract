package com.huobi.api.response.usdt.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class LinearSwapOverviewAccountInfoResponse {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;
    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("margin_asset")
        private String marginAsset;
        @SerializedName("margin_balance")
        private BigDecimal marginBalance;
        @SerializedName("margin_available")
        private BigDecimal marginAvailable;
    }
}
