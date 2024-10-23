package com.huobi.api.response.coin_futures.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class ContractFinancialRecordExactResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean{
        @SerializedName("remain_size")
        private Integer remainSize;
        @SerializedName("next_id")
        private Long nextId;
        @SerializedName("financial_record")
        private List<FinancialRecordBean> financialRecord;

        @AllArgsConstructor
        @Builder
        @Data
        public static class FinancialRecordBean{
            private Long id;
            private Long ts;
            private String symbol;
            @SerializedName("contract_code")
            private String contractCode;
            private Integer type;
            private BigDecimal amount;
        }
    }
}
