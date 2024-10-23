package com.huobi.api.service.usdt.reference;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersV3Request;
import com.huobi.api.response.usdt.account.SwapLiquidationOrdersV3Response;
import com.huobi.api.response.usdt.account.SwapSwitchAccountTypeResponse;
import com.huobi.api.response.usdt.account.SwapUnifiedAccountTypeResponse;
import com.huobi.api.response.usdt.market.*;
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
    public SwapFundingRateResponse getSwapFundingRate(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_FUNDING_RATE, params);
            logger.debug("body:{}", body);
            SwapFundingRateResponse response = JSON.parseObject(body, SwapFundingRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapBatchFundingRateResponse getSwapBatchFundingRate(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_BATCH_FUNDING_RATE, params);
            logger.debug("body:{}", body);
            SwapBatchFundingRateResponse response = JSON.parseObject(body, SwapBatchFundingRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    public SwapHistoricalFundingRateResponse getSwapHistoricalFundingRate(String contractCode, Integer pageIndex, Integer pageSize) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            if (pageIndex != null) {
                params.put("page_index", pageIndex);
            }
            if (pageSize != null) {
                params.put("page_size", pageSize);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_HISTORICAL_FUNDING_RATE, params);
            logger.debug("body:{}", body);
            SwapHistoricalFundingRateResponse response = JSON.parseObject(body, SwapHistoricalFundingRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapLiquidationOrdersV3Response getSwapLiquidationOrdersV3(SwapLiquidationOrdersV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContract())) {
                params.put("contract", request.getContract());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair());
            }
            if (request.getTradeType() != null) {
                params.put("trade_type", request.getTradeType());
            }
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_LIQUIDATION_ORDERS_V3, params);
            logger.debug("body:{}", body);
            SwapLiquidationOrdersV3Response response = JSON.parseObject(body, SwapLiquidationOrdersV3Response.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSettlementRecordsResponse getSwapSettlementRecords(String contractCode, Long startTime, Long endTime, Integer pageIndex, Integer pageSize) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            if (startTime!=null&startTime!=Long.valueOf(0)){
                params.put("start_time",startTime);
            }
            if (endTime!=null&endTime!=Long.valueOf(0)){
                params.put("end_time",endTime);
            }
            if (pageIndex!=null){
                params.put("page_index",pageIndex);
            }
            if (pageSize!=null){
                params.put("page_size",pageSize);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_SETTLEMENT_RECORDS, params);
            logger.debug("body:{}", body);
            SwapSettlementRecordsResponse response = JSON.parseObject(body, SwapSettlementRecordsResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapEliteAccountRatioResponse getSwapEliteAccountRatio(String contractCode, String period) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_ELITE_ACCOUNT_RATIO, params);
            logger.debug("body:{}", body);
            SwapEliteAccountRatioResponse response = JSON.parseObject(body, SwapEliteAccountRatioResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapElitePositionRatioResponse getSwapElitePositionRatio(String contractCode, String period) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_ELITE_POSITION_RATIO, params);
            logger.debug("body:{}", body);
            SwapElitePositionRatioResponse response = JSON.parseObject(body, SwapElitePositionRatioResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapApiStateResponse getSwapApiState(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_API_STATE, params);
            logger.debug("body:{}", body);
            SwapApiStateResponse response = JSON.parseObject(body, SwapApiStateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapLadderMarginResponse getSwapLadderMargin(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_LADDER_MARGIN, params);
            logger.debug("body:{}", body);
            SwapLadderMarginResponse response = JSON.parseObject(body, SwapLadderMarginResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapEstimatedSettlementPriceResponse getSwapEstimatedSettlementPrice(String contractCode,String pair,String contractType,String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(pair)){
                params.put("pair",pair.toUpperCase());
            }
            if (StringUtils.isNotEmpty(contractType)){
                params.put("contract_type",contractType);
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_ESTIMATED_SETTLEMENT_PRICE, params);
            logger.debug("body:{}", body);
            SwapEstimatedSettlementPriceResponse response = JSON.parseObject(body, SwapEstimatedSettlementPriceResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapAdjustfactorResponse getSwapAdjustfactor(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_ADJUSTFACTOR, params);
            logger.debug("body:{}", body);
            SwapAdjustfactorResponse response = JSON.parseObject(body, SwapAdjustfactorResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapInsuranceFundResponse getSwapInsuranceFund(String contractCode, Integer pageIndex, Integer pageSize) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            if (pageIndex != null) {
                params.put("page_index", pageIndex);
            }
            if (pageSize != null) {
                params.put("page_size", pageSize);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_INSURANCE_FUND, params);
            logger.debug("body:{}", body);
            SwapInsuranceFundResponse response = JSON.parseObject(body, SwapInsuranceFundResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapRiskInfoResponse getSwapRiskInfo(String contractCode,String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_RISK_INFO, params);
            logger.debug("body:{}", body);
            SwapRiskInfoResponse response = JSON.parseObject(body, SwapRiskInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapPriceLimitResponse getSwapPriceLimit(String contractCode, String pair, String contractType, String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(pair)){
                params.put("pair",pair.toUpperCase());
            }
            if (StringUtils.isNotEmpty(contractType)){
                params.put("contract_type",contractType);
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_PRICE_LIMIT, params);
            logger.debug("body:{}", body);
            SwapPriceLimitResponse response = JSON.parseObject(body, SwapPriceLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapOpenInterestResponse getSwapOpenInterest(String contractCode, String pair, String contractType, String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(pair)){
                params.put("pair",pair.toUpperCase());
            }
            if (StringUtils.isNotEmpty(contractType)){
                params.put("contract_type",contractType);
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_OPEN_INTEREST, params);
            logger.debug("body:{}", body);
            SwapOpenInterestResponse response = JSON.parseObject(body, SwapOpenInterestResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapContractInfoResponse getSwapContractInfo(String contractCode, String supportMarginMode, String pair, String contractType, String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(supportMarginMode)) {
                params.put("support_margin_mode", supportMarginMode);
            }
            if(StringUtils.isNotEmpty(pair)){
                params.put("pair",pair);
            }
            if (StringUtils.isNotEmpty(contractType)){
                params.put("contract_type",contractType);
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_CONTRACT_INFO, params);
            logger.debug("body:{}", body);
            SwapContractInfoResponse response = JSON.parseObject(body, SwapContractInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapIndexResponse getSwapIndex(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_INDEX, params);
            logger.debug("body:{}", body);
            SwapIndexResponse response = JSON.parseObject(body, SwapIndexResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapQueryElementsResponse getSwapQueryElements(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_QUERY_ELEMENTS, params);
            logger.debug("body:{}", body);
            SwapQueryElementsResponse response = JSON.parseObject(body, SwapQueryElementsResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
