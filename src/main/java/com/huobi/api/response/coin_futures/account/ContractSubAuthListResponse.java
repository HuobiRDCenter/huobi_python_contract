package com.huobi.api.response.coin_futures.account;

import com.google.gson.annotations.SerializedName;
import com.huobi.api.response.usdt.account.SwapSubAuthListResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ContractSubAuthListResponse {
    private String status;
    private Long ts;
    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean {
        private List<Error> errors;
        private List<Success> successes;
        @AllArgsConstructor
        @Builder
        @Data
        public static class Error {
            @SerializedName("sub_uid")
            private String subUid;

            @SerializedName("err_code")
            private String errCode;

            @SerializedName("err_msg")
            private String errMsg;
        }
        @AllArgsConstructor
        @Builder
        @Data
        public static class Success {
            @SerializedName("sub_uid")
            private String subUid;

            @SerializedName("sub_auth")
            private String subAuth;
            @SerializedName("query_id")
            private Long queryId;
        }
    }
}
