package com.huobi.api.response.coin_futures.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class ContractEstimatedSettlementPriceResponse {
    private String status;
    private Long ts;
    private List<BeanData> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class  BeanData{
        private String symbol;
        private List<BeanList> list;

        @AllArgsConstructor
        @Builder
        @Data
        public static class BeanList{
            @SerializedName("contract_type")
            private String contractType;
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("estimated_settlement_price")
            private BigDecimal estimatedSettlementPrice;
            @SerializedName("settlement_type")
            private String settlementType;
        }
    }
}
