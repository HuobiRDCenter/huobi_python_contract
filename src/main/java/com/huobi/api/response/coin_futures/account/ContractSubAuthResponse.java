package com.huobi.api.response.coin_futures.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class ContractSubAuthResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @Builder
    @Data
    @AllArgsConstructor
    public static class DataBean{
        private String successes;
        private List<ErrorsBean> errors;

        @Builder
        @Data
        @AllArgsConstructor
        public static class ErrorsBean{
            @SerializedName("sub_uid")
            private String subUid;
            @SerializedName("err_code")
            private Integer errCode;
            @SerializedName("err_msg")
            private String errMsg;
        }
    }
}
