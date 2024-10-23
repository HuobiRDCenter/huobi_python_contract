package com.huobi.api.response.coin_swap.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class SwapFinancialRecordV3Response {
    private Integer code;
    private String msg;
    private Long ts;
    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("query_id")
        private Long queryId;
        private String id;
        private Long ts;
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        private Integer type;
        private BigDecimal amount;
    }
}
