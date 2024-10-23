package com.huobi.wss.event;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class SwapContractElementSubResponse {
    public String op;
    public String topic;
    public long ts;
    public Data data;

    public static class Data {
        public String contract_code;
        public String instrument_index_code;
        public Integer real_time_settlement;
        public BigDecimal transfer_profit_ratio;
        public Integer min_level;
        public Integer max_level;
        public List<ContractInfo> contract_infos;
        public Integer open_order_limit;
        public Integer offset_order_limit;
        public Integer long_position_limit;
        public Integer short_position_limit;
        public String price_tick;
        public String instrument_value;
        public Integer settle_period;
        public Integer funding_rate_cap;
        public Integer funding_rate_floor;
        public Integer hig_normal_limit;
        public Integer min_normal_limit;
        public Integer hig_open_limit;
        public Integer min_open_limit;
        public Integer hig_trade_limit;
        public Integer min_trade_limit;
    }

    public static class ContractInfo {
        public String contract_code;
        public String delivery_time;
        public String create_date;
        public Integer contract_status;
        public String settlement_date;
    }
}
