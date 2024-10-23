package com.huobi.api.response.coin_swap.market;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class SwapMarketDetailMergedResponse {

    /**
     * "ch":"market.BTC-USDT.detail.merged",
     * "status":"ok",
     * "tick":{"amount":"0.16","ask":[10329.11,26],"bid":[10328.993,814],"close":"10329.11","count":6,"high":"10329.11","id":1601018901,"low":"10329.11","open":"10329.11","trade_turnover":"1652.65526","ts":1601018902224,"vol":"16"},
     * "ts":1601018902224
     */

    private String ch;
    private String status;
    private List<TickBean> tick;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class TickBean {
        /**
         * "amount":"0.16",
         * "ask":[
         * 10329.11,
         * 26
         * ],
         * "bid":[
         * 10328.993,
         * 814
         * ],
         * "close":"10329.11",
         * "count":6,
         * "high":"10329.11",
         * "id":1601018901,
         * "low":"10329.11",
         * "open":"10329.11",
         * "trade_turnover":"1652.65526",
         * "ts":1601018902224,
         * "vol":"16"
         */

        private String amount;
        private String close;
        private Integer count;
        private String high;
        private Integer id;
        private String low;
        private String open;
        private Long ts;
        private String vol;
        private BigDecimal[] ask;
        private BigDecimal[] bid;
    }
}
