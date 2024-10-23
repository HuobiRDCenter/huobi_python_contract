package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountCrossSubResponse {
    private String op;
    private String topic;
    private Long ts;
    private String uid;
    private String event;
    private List<DataBean> data;
    @Data
    @AllArgsConstructor
    public static class DataBean {
        @SerializedName("margin_mode")
        private String marginMode;
        @SerializedName("margin_account")
        private String marginAccount;
        @SerializedName("margin_asset")
        private String marginAsset;
        @SerializedName("margin_balance")
        private BigDecimal marginBalance;
        @SerializedName("margin_static")
        private BigDecimal marginStatic;
        @SerializedName("margin_position")
        private BigDecimal marginPosition;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        @SerializedName("profit_real")
        private BigDecimal profitReal;
        @SerializedName("profit_unreal")
        private BigDecimal profitUnreal;
        @SerializedName("withdraw_available")
        private BigDecimal withdrawAvailable;
        @SerializedName("risk_rate")
        private BigDecimal riskRate;
        @SerializedName("position_mode")
        private String positionMode;
        @SerializedName("contract_detail")
        private List<ContractDetailItem> contractDetail;
        @SerializedName("futures_contract_detail")
        private List<FuturesContractDetailItem> futuresContractDetail;
    }
    @Data
    @AllArgsConstructor
    public static class ContractDetailItem {
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("margin_position")
        private BigDecimal marginPosition;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        @SerializedName("margin_available")
        private BigDecimal marginAvailable;
        @SerializedName("profit_unreal")
        private BigDecimal profitUnreal;
        @SerializedName("liquidation_price")
        private BigDecimal liquidationPrice;
        @SerializedName("lever_rate")
        private BigDecimal leverRate;
        @SerializedName("adjust_factor")
        private BigDecimal adjustFactor;
        @SerializedName("contract_type")
        private String contractType;
        private String pair;
        @SerializedName("business_type")
        private String businessType;
    }
    @Data
    @AllArgsConstructor
    public static class FuturesContractDetailItem {
        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("margin_position")
        private BigDecimal marginPosition;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        @SerializedName("margin_available")
        private BigDecimal marginAvailable;
        @SerializedName("profit_unreal")
        private BigDecimal profitUnreal;
        @SerializedName("liquidation_price")
        private BigDecimal liquidationPrice;
        @SerializedName("lever_rate")
        private BigDecimal leverRate;
        @SerializedName("adjust_factor")
        private BigDecimal adjustFactor;
        @SerializedName("contract_type")
        private String contractType;
        private String pair;
        @SerializedName("business_type")
        private String businessType;
    }
}
