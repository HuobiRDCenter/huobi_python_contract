package com.huobi.api.request.coin_futures.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ContractHisordersV3Request {
    private String symbol;//品种代码	"BTC","ETH"...
    private Integer tradeType;//交易类型	0:全部,1:买入开多,2: 卖出开空,3: 买入平空,4: 卖出平多,5: 卖出强平,6: 买入强平,7:交割平多,8: 交割平空
    private Integer type;//类型	1:所有订单,2:结束状态的订单
    private String status;
    private String contract;//合约代码
    private String orderType;//订单类型  1：限价单、3：对手价、4：闪电平仓、5：计划委托、6：post_only、7：最优5档、8：最优10档、9：最优20档、10：fok、11：ioc
    private String sortBy;
    private Long startTime;
    private Long endTime;
    private String direct;
    private Long fromId;
}
