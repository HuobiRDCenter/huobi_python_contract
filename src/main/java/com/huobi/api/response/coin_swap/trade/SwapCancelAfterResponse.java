package com.huobi.api.response.coin_swap.trade;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SwapCancelAfterResponse {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;
    @Data
    @AllArgsConstructor
    public static class DataBean {
        @SerializedName("current_time")
        private Long currentTime;
        @SerializedName("trigger_time")
        private Long triggerTime;
    }
}
