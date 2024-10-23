package com.huobi.wss.event;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class SymbolContractElementSubResponse {
    private String op;
    private String topic;
    private Long ts;
    private List<Data> data;
    public static class Data {
        private String contract_code;
        private String instrument_index_code;
        private Integer real_time_settlement;
        private Number transfer_profit_ratio;
        private Integer min_level;
        private Integer max_level;
        private List<ContractInfo> contract_infos;
        private String delivery_time;
        private String create_date;
        private Integer contract_status;
        private String delivery_date;
        private Integer open_order_limit;
        private Integer offset_order_limit;
        private Integer long_position_limit;
        private Integer short_position_limit;
        private Integer week_hig_normal_limit;
        private Integer week_min_normal_limit;
        private Integer week_hig_open_limit;
        private Integer week_min_open_limit;
        private Integer week_hig_trade_limit;
        private Integer week_min_trade_limit;
        private Integer biweek_hig_normal_limit;
        private Integer biweek_min_normal_limit;
        private Integer biweek_hig_open_limit;
        private Integer biweek_min_open_limit;
        private Integer biweek_hig_trade_limit;
        private Integer biweek_min_trade_limit;
        private Integer quarter_hig_normal_limit;
        private Integer quarter_min_normal_limit;
        private Integer quarter_hig_open_limit;
        private Integer quarter_min_open_limit;
        private Integer quarter_hig_trade_limit;
        private Integer quarter_min_trade_limit;
        private Integer biquarter_hig_normal_limit;
        private Integer biquarter_min_normal_limit;
        private Integer biquarter_hig_open_limit;
        private Integer biquarter_min_open_limit;
        private Integer biquarter_hig_trade_limit;
        private Integer biquarter_min_trade_limit;
        private List<Integer> instrument_type;
        private List<OrderLimit> order_limits;
    }

    public static class ContractInfo {
        private String contract_code;
        private List<Integer> instrument_type;
        private String delivery_time;
        private String create_date;
        private Integer contract_status;
        private String delivery_date;

        // Getters and setters
    }

    public static class OrderLimit {
        private Integer instrument_type;
        private String open;
        private String close;

        // Getters and setters
    }
}
