package com.huobi.api.request.usdt.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.temporal.TemporalAmount;

@AllArgsConstructor
@Data
@Builder
public class FixPositionMarginChangeRequest {
    private Double amount;
    private String asset;
    @SerializedName("contract_code")
    private String contractCode;
    private Integer type;
    private Integer direction;
    private Long clientOrderId;
}
