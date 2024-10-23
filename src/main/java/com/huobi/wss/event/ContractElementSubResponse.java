package com.huobi.wss.event;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractElementSubResponse {
    private String op;
    private String topic;
    private long ts;
    private List<DataEntry> data;
    public static class DataEntry {
        private String contract_code;
        private int mode_type;
        private int swap_delivery_type;
        private String instrument_index_code;
        private int real_time_settlement;
        private double transfer_profit_ratio;
        private double cross_transfer_profit_ratio;
        private List<String> instrument_type;
        private String trade_partition;
        private int min_level;
        private int max_level;
        private int settle_period;
        private int funding_rate_cap;
        private int funding_rate_floor;
        private ContractInfos contract_infos;
        private List<PriceTick> price_ticks;
        private List<InstrumentValue> instrument_values;
        private List<OrderLimit> order_limits;
        private NormalLimit normal_limits;
        private OpenLimit open_limits;
        private TradeLimit trade_limits;

        // Getters and setters
    }

    public static class ContractInfos {
        private String contract_code;
        private String instrument_type;
        private String settlement_date;
        private String delivery_time;
        private String create_date;
        private int contract_status;
        private String delivery_date;
        private ContractInfoDetails contract_infos;

        // Getters and setters
    }

    public static class ContractInfoDetails {
        private int long_position_limit;
        private int offset_order_limit;
        private int open_order_limit;
        private int short_position_limit;

        // Getters and setters
    }

    public static class PriceTick {
        private int business_type;
        private String price;

        // Getters and setters
    }

    public static class InstrumentValue {
        private int business_type;
        private String price;

        // Getters and setters
    }

    public static class OrderLimit {
        private int instrument_type;
        private String open;
        private String close;
        private String open_after_closing;

        // Getters and setters
    }

    public static class NormalLimit {
        private int instrument_type;
        private String open;
        private String close;

        // Getters and setters
    }

    public static class OpenLimit {
        private int instrument_type;
        private String open;
        private String close;

        // Getters and setters
    }

    public static class TradeLimit {
        private int instrument_type;
        private String open;
        private String close;

        // Getters and setters
    }
}
