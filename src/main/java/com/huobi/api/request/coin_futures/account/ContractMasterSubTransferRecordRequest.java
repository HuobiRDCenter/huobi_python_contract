package com.huobi.api.request.coin_futures.account;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ContractMasterSubTransferRecordRequest {
    private String symbol;
    private String transferType;
    private Integer createDate;
    private Integer pageIndex;
    private Integer pageSize;
}
