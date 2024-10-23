package com.huobi.api.response.coin_futures.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ContractMasterSubTransferRecordResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Data
    @Builder
    public static class DataBean{
        @SerializedName("total_page")
        private Integer total_page;
        @SerializedName("total_page")
        private Integer current_page;
        @SerializedName("total_size")
        private Integer total_size;
        @SerializedName("transfer_record")
        private List<TransferRecordBean> transferRecord;

        @AllArgsConstructor
        @Data
        @Builder
        public static class TransferRecordBean{
            private Long id;
            private Long ts;
            private String symbol;
            @SerializedName("sub_uid")
            private String subUid;
            @SerializedName("sub_account_name")
            private String subAccountName;
            @SerializedName("transfer_type")
            private Integer transferType;
            private BigDecimal amount;
        }
    }
}
