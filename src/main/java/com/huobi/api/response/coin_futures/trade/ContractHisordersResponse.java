package com.huobi.api.response.coin_futures.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
public class ContractHisordersResponse {
    /**
     * status : ok
     * data : {"orders":[{"symbol":"BTC","contract_type":"this_week","contract_code":"BTC180914","volume":111,"price":1111,"order_price_type":"limit","direction":"buy","offset":"open","lever_rate":10,"order_id":106837,"order_source":"web","created_at":1408076414000,"trade_volume":1,"trade_turnover":1200,"fee":0,"trade_avg_price":10,"margin_frozen":10,"profit":10,"status":1,"order_type":1}],"total_page":15,"current_page":3,"total_size":3}
     * ts : 1490759594752
     */

    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * orders : [{"symbol":"BTC","contract_type":"this_week","contract_code":"BTC180914","volume":111,"price":1111,"order_price_type":"limit","direction":"buy","offset":"open","lever_rate":10,"order_id":106837,"order_source":"web","created_at":1408076414000,"trade_volume":1,"trade_turnover":1200,"fee":0,"trade_avg_price":10,"margin_frozen":10,"profit":10,"status":1,"order_type":1}]
         * total_page : 15
         * current_page : 3
         * total_size : 3
         */

        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_size")
        private Integer totalSize;
        private List<OrdersBean> orders;

        @Data
        @AllArgsConstructor
        public static class OrdersBean {
            /**
             * symbol : BTC
             * contract_type : this_week
             * contract_code : BTC180914
             * volume : 111
             * price : 1111
             * order_price_type : limit
             * direction : buy
             * offset : open
             * lever_rate : 10
             * order_id : 106837
             * order_source : web
             * create_date : 1408076414000
             * trade_volume : 1
             * trade_turnover : 1200
             * fee : 0
             * trade_avg_price : 10
             * margin_frozen : 10
             * profit : 10
             * status : 1
             * order_type : 1
             */

            private String symbol;
            @SerializedName("contract_type")
            private String contractType;
            @SerializedName("contract_code")
            private String contractCode;
            private BigDecimal volume;
            private BigDecimal price;
            @SerializedName("order_price_type")
            private String orderPriceType;
            private String direction;
            private String offset;
            @SerializedName("lever_rate")
            private Integer leverRate;
            @SerializedName("order_id")
            private Long orderId;
            @SerializedName("order_id_str")
            private String orderIdStr;
            @SerializedName("order_source")
            private String orderSource;
            @SerializedName("create_date")
            private Long createDate;
            @SerializedName("trade_volume")
            private BigDecimal tradeVolume;
            @SerializedName("trade_turnover")
            private BigDecimal tradeTurnover;
            private BigDecimal fee;
            @SerializedName("trade_avg_price")
            private BigDecimal tradeAvgPrice;
            @SerializedName("margin_frozen")
            private BigDecimal marginFrozen;
            private BigDecimal profit;
            private Integer status;
            @SerializedName("order_type")
            private Integer orderType;
            @SerializedName("is_tpsl")
            private Integer isTpsl;
            @SerializedName("update_time")
            private Long updateTime;
            @SerializedName("real_profit")
            private BigDecimal realProfit;
        }
    }
}
