package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import com.huobi.api.response.coin_swap.market.SwapBatchFundingRateResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PublicFundingRateResponse {
    private String op;
    private String topic;
    private Long ts;
    private List<DataBean> data;

    @Data
    @Builder
    @AllArgsConstructor
    public static class DataBean{
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("fee_asset")
        private String feeAsset;
        @SerializedName("funding_time")
        private String fundingTime;
        @SerializedName("funding_rate")
        private String fundingRate;
        @SerializedName("estimated_rate")
        private String estimatedRate;
        @SerializedName("settlement_time")
        private String settlementTime;
    }
}
