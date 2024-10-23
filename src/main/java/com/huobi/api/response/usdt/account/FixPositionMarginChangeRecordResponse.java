package com.huobi.api.response.usdt.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class FixPositionMarginChangeRecordResponse {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean {
        @SerializedName("query_id")
        private Long queryId;
        @SerializedName("order_id")
        private String orderId;
        private Double amount;
        private String asset;
        private String symbol;
        private Integer type;
        private Integer direction;
    }
}
