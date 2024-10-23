package com.huobi.api.request.usdt.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class LinearCancelAfterRequest {
    private Integer onOff;
    private Integer timeOut;

}
