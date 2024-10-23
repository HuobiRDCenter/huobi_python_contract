package com.huobi.api.response.usdt.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class LinearSwapFeeSwitchResponse {
    private Integer code;
    private String msg;
    private Long ts;
    private List<DataBean> data;

    @AllArgsConstructor
    @Builder
    @Data
    public static class DataBean {

    }
}
