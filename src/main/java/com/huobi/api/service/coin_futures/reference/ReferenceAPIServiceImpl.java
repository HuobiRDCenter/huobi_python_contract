package com.huobi.api.service.coin_futures.reference;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.coin_futures.account.ContractSettlementRecordsRequest;
import com.huobi.api.request.coin_futures.market.ContractLiquidationOrdersV3Request;
import com.huobi.api.response.coin_futures.market.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ReferenceAPIServiceImpl implements ReferenceAPIService{
    String url_prex = "https://api.hbdm.com";
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ContractRiskInfoResponse getContractRiskInfo(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_RISK_INFO, params);
            ContractRiskInfoResponse response = JSON.parseObject(body, ContractRiskInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractInsuranceFundResponse getContractInsuranceFund(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_INSURANCE_FUND, params);
            ContractInsuranceFundResponse response = JSON.parseObject(body, ContractInsuranceFundResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractAdjustfactorResponse getContractAdjustfactor(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_ADJUSTFACTOR, params);
            ContractAdjustfactorResponse response = JSON.parseObject(body, ContractAdjustfactorResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractHisOpenInterestResponse getContractHisOpenInterest(String symbol, String contractType, TimePeriodTypeEnum timePeriodType, Integer size, Integer amountType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            if (StringUtils.isNotEmpty(contractType)) {
                params.put("contract_type", contractType);
            }
            if (timePeriodType != null) {
                params.put("period", timePeriodType.getValue());
            }

            if (size != null) {
                params.put("size", size);
            }
            if (amountType != null) {
                params.put("amount_type", amountType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_HIS_OPEN_INTEREST, params);
            ContractHisOpenInterestResponse response = JSON.parseObject(body, ContractHisOpenInterestResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractLadderMarginResponse getContractLadderMargin(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)){
                params.put("symbol",symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_LADDER_MARGIN, params);
            logger.debug("body:{}",body);
            ContractLadderMarginResponse response = JSON.parseObject(body, ContractLadderMarginResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractEliteAccountRatioResponse getContractEliteAccountRatio(String symbol, String period) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol);
            params.put("period", period);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_ELITE_ACCOUNT_RATIO, params);
            ContractEliteAccountRatioResponse response = JSON.parseObject(body, ContractEliteAccountRatioResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractElitePositionRatioResponse getContractElitePositionRatio(String symbol, String period) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol);
            params.put("period", period);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_ELITE_POSITION_RATIO, params);
            ContractElitePositionRatioResponse response = JSON.parseObject(body, ContractElitePositionRatioResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractLiquidationOrdersV3Response getContractLiquidationOrdersV3(ContractLiquidationOrdersV3Request request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (request.getStartTime() != null) {
                params.put("start_time", request.getStartTime());
            }
            if (request.getEndTime() != null) {
                params.put("end_time", request.getEndTime());
            }
            if (StringUtils.isNotEmpty(request.getDirect())) {
                params.put("direct", request.getDirect());
            }
            if (request.getFromId() != null) {
                params.put("from_id", request.getFromId());
            }
            if (request.getTradeType() != null) {
                params.put("trade_type", request.getTradeType());
            }
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_LIQUIDATION_ORDERS_V3, params);
            logger.debug("body:{}",body);
            ContractLiquidationOrdersV3Response response = JSON.parseObject(body, ContractLiquidationOrdersV3Response.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSettlementRecordsResponse getContractSettlementRecords(ContractSettlementRecordsRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getStartTime()!=null){
                params.put("start_time",request.getStartTime());
            }
            if (request.getEndTime()!=null){
                params.put("end_time",request.getEndTime());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_SETTLEMENT_RECORDS, params);
            logger.debug("body:{}",body);
            ContractSettlementRecordsResponse response = JSON.parseObject(body, ContractSettlementRecordsResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractPriceLimitResponse getContractPriceLimit(String symbol, String contractType, String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            if (StringUtils.isNotEmpty(contractType)) {
                params.put("contract_type", contractType);
            }
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_PRICE_LIMIT, params);
            ContractPriceLimitResponse response = JSON.parseObject(body, ContractPriceLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    /**
     * 获取当前可用合约总持仓量
     *
     * @param symbol       "BTC","ETH"...
     * @param contractType 合约类型 (当周:"this_week", 次周:"next_week", 季度:"quarter")
     * @param contractCode BTC191018
     * @return
     */
    @Override
    public ContractOpenInterestResponse getContractOpenInterest(String symbol, String contractType, String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            if (StringUtils.isNotEmpty(contractType)) {
                params.put("contract_type", contractType);
            }
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_OPEN_INTEREST, params);
            ContractOpenInterestResponse response = JSON.parseObject(body, ContractOpenInterestResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractDeliveryPriceResponse getContractDeliveryPrice(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_DELIVERY_PRICE, params);
            ContractDeliveryPriceResponse response = JSON.parseObject(body, ContractDeliveryPriceResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractEstimatedSettlementPriceResponse getContractEstimatedSettlementPriceResponse(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)){
                params.put("symbol",symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_ESTIMATED_SETTLEMENT_PRICE, params);
            logger.debug("body:{}",body);
            ContractEstimatedSettlementPriceResponse response = JSON.parseObject(body, ContractEstimatedSettlementPriceResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractApiStateResponse getContractApiState(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_API_STATE, params);
            ContractApiStateResponse response = JSON.parseObject(body, ContractApiStateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractContractInfoResponse getContractContractInfo(String symbol, String contractType, String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            if (StringUtils.isNotEmpty(contractType)) {
                params.put("contract_type", contractType);
            }
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_CONTRACT_INFO, params);
            ContractContractInfoResponse response = JSON.parseObject(body, ContractContractInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractIndexResponse getContractIndex(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_INDEX, params);
            ContractIndexResponse response = JSON.parseObject(body, ContractIndexResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractQueryElementsResponse getContractQueryElements(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_QUERY_ELEMENTS, params);
            logger.debug("body:{}",body);
            ContractQueryElementsResponse response = JSON.parseObject(body, ContractQueryElementsResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }
}
