package com.huobi.api.request.coin_swap.account;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class SwapMasterSubTransferRequest {
    private Long subUid;//子账号uid
    private String contractCode;//品种代码
    private BigDecimal amount;//划转金额
    private String type;//划转类型	master_to_sub：母账户划转到子账户， sub_to_master：子账户划转到母账户
    private Long clientOrderId;

}
