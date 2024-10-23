package com.huobi.api.response.coin_futures.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class ContractSubAccountInfoListResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @Builder
    @Data
    @AllArgsConstructor
    public static class DataBean{
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("total_size")
        private Integer totalSize;
        @SerializedName("sub_list")
        private List<SubListBean> subList;

        @Builder
        @Data
        @AllArgsConstructor
        public static class SubListBean{
            @SerializedName("sub_uid")
            private Long subUid;
            @SerializedName("account_info_list")
            private List<AccountInfoList> accountInfoList;

            @Builder
            @Data
            @AllArgsConstructor
            public static class AccountInfoList{
                private String symbol;
                @SerializedName("margin_balance")
                private BigDecimal marginBalance;
                @SerializedName("liquidation_price")
                private BigDecimal liquidationPrice;
                @SerializedName("risk_rate")
                private BigDecimal riskRate;
            }
        }
    }
}
