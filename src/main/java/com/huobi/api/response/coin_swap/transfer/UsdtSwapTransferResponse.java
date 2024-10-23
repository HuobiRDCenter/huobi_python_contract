package com.huobi.api.response.coin_swap.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsdtSwapTransferResponse {

    /**
     * 参数名称	    是否必须	类型  	描述
     * code	        true	long	响应码
     * success	    true	boolean	true/false
     * message	    true	string	响应消息
     * data	        true	long	划转流水ID
     */

    private Long code;
    private Boolean success;
    private String message;
    private Long data;

}
