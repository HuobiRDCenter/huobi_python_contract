package com.huobi.api.response.coin_futures.trade;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class ContractTpslOrderResponse {
    private String status;
    private Long ts;
    private Integer errCode;
    private String errMsg;
    private List<BeanData> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class BeanData{
        @SerializedName("tp_order")
        private List<BeanTpOrder> tpOrder;
        @SerializedName("sl_order")
        private List<BeanSlOrder> slOrder;

        @AllArgsConstructor
        @Builder
        @Data
        public static class BeanTpOrder{
            @SerializedName("order_id")
            private Long orderId;
            @SerializedName("order_id_str")
            private String orderIdStr;
        }

        @AllArgsConstructor
        @Builder
        @Data
        public static class BeanSlOrder{
            @SerializedName("order_id")
            private Long orderId;
            @SerializedName("order_id_str")
            private String orderIdStr;
        }

    }
}
