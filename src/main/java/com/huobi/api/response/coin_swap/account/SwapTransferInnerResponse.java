package com.huobi.api.response.coin_swap.account;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SwapTransferInnerResponse {
    private String status;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean{
        private Long orderId;
    }
}
