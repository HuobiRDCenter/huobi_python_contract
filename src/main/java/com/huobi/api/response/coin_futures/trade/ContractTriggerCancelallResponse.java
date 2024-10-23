package com.huobi.api.response.coin_futures.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ContractTriggerCancelallResponse {
    private String status;
    private List<DataBean> data;
    private Long ts;

    @AllArgsConstructor
    @Data
    @Builder
    public  static class DataBean{
        private String successes;
        private List<ErrorsData> errors;

        @AllArgsConstructor
        @Data
        @Builder
        public  static class ErrorsData{
            @SerializedName("order_id")
            private String orderID;
            @SerializedName("err_code")
            private Integer errCode;
            @SerializedName("err_msg")
            private String errMsg;
        }

    }
}
