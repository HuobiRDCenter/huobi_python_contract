package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class PublicContractInfoFutureSubResponse {
    private String op;
    private String topic;
    private long ts;
    private String event;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public class DataBean {
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("contract_type")
        private String contractType;
        @SerializedName("contract_size")
        private BigDecimal contractSize;
        @SerializedName("price_tick")
        private BigDecimal priceTick;
        @SerializedName("delivery_date")
        private String deliveryDate;
        @SerializedName("create_date")
        private String createDate;
        @SerializedName("settlement_time")
        private Long settlementTime;
        @SerializedName("delivery_time")
        private Long deliveryTime;
        @SerializedName("contract_status")
        private Integer contractStatus;
    }

}
