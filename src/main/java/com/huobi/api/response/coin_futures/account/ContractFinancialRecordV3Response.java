package com.huobi.api.response.coin_futures.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ContractFinancialRecordV3Response {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;
    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("query_id")
        private Long queryId;
        private Long id;
        private Long ts;
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        private Integer type;
        private BigDecimal amount;
    }
}
