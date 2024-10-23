package com.huobi.api.response.usdt.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class FixPositionMarginChangeResponse {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean {
        @SerializedName("amount")
        private Double amount;
        @SerializedName("asset")
        private String asset;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("type")
        private Integer type;
        @SerializedName("direction")
        private Integer direction;
        @SerializedName("order_id")
        private String orderId;
        @SerializedName("client_order_id")
        private Long clientOrderId;
    }
}
