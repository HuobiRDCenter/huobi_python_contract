package com.huobi.api.response.coin_futures.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class AccountTransferResponse {
    private Boolean success;
    private Long data;
    private Long code;
    private String message;
}
