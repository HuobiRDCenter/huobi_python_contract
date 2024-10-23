package com.huobi.api.response.usdt.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SwapUnifiedAccountTypeResponse {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Data
    public static class DataBean {
        @SerializedName("account_type")
        private Integer accountType;
    }
}
