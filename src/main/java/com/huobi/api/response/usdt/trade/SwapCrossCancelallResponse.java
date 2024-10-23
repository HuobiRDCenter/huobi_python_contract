package com.huobi.api.response.usdt.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SwapCrossCancelallResponse {
    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {

        private List<ErrorsBean> errors;
        private String successes;

        @Data
        @AllArgsConstructor
        public static class ErrorsBean {

            @SerializedName("order_id")
            private String orderId;
            @SerializedName("err_code")
            private Integer errCode;
            @SerializedName("err_msg")
            private String errMsg;

        }
    }
}
