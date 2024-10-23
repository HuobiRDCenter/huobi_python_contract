package com.huobi.api.response.usdt.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class SwapFinancialRecordExactV3Response {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;
    @AllArgsConstructor
    @Data
    @Builder
    public static class DataBean {
        @SerializedName("query_id")
        private Long queryId;
        @SerializedName("id")
        private Long id;
        private Long ts;
        private String asset;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("margin_account")
        private String marginAccount;
        @SerializedName("face_margin_account")
        private String faceMarginAccount;
        private Integer type;
        private BigDecimal amount;
    }
}
