package com.huobi.api.response.coin_swap.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class SwapFinancialRecordExactResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    @Builder
    public static class DataBean{
        private Integer remainSize;
        @SerializedName("next_id")
        private Long nextId;
        @SerializedName("financial_record")
        private List<FinancialRecordBean> financialRecord;

        @Data
        @AllArgsConstructor
        @Builder
        public static class FinancialRecordBean{
            private Long ts;
            private Long id;
            private String symbol;
            @SerializedName("contract_code")
            private String contractCode;
            private Integer type;
            private BigDecimal amount;
        }
    }
}
