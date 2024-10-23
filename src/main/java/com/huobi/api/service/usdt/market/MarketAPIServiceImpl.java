package com.huobi.api.service.usdt.market;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.usdt.account.LinearSwapBasisRequest;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersRequest;
import com.huobi.api.request.usdt.account.SwapMarketHistoryKlineRequest;
import com.huobi.api.response.usdt.market.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MarketAPIServiceImpl implements MarketAPIService {

    String url_prex = "https://api.hbdm.com";
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public SwapMarketDepthResponse getSwapMarketDepth(String contractCode, String type) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("type", type);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_MARKET_DEPTH, params);
            logger.debug("body:{}", body);
            SwapMarketDepthResponse response = JSON.parseObject(body, SwapMarketDepthResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapMarketHistoryKlineResponse getSwapMarketHistoryKline(SwapMarketHistoryKlineRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("period", request.getPeriod());
            if (request.getSize() != null) {
                params.put("size", request.getSize());
            }
            if (request.getTo() != null) {
                params.put("to", request.getTo());
            }
            if (request.getFrom() != null) {
                params.put("from", request.getFrom());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_MARKET_HISTORY_KLINE, params);
            logger.debug("body:{}", body);
            SwapMarketHistoryKlineResponse response = JSON.parseObject(body, SwapMarketHistoryKlineResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }


    @Override
    public SwapMarketDetailMergedResponse getSwapMarketDetailMerged(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_MARKET_DETAIL_MERGED, params);
            logger.debug("body:{}", body);
            SwapMarketDetailMergedResponse response = JSON.parseObject(body, SwapMarketDetailMergedResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);

    }

    @Override
    public SwapMarketTradeResponse getSwapMarketTrade(String contractCode,String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_MARKET_TRADE, params);
            logger.debug("body:{}", body);
            SwapMarketTradeResponse response = JSON.parseObject(body, SwapMarketTradeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapMarketHistoryTradeResponse getSwapMarketHistoryTrade(String contractCode, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            if (size != null) {
                params.put("size", size);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_MARKET_HISTORY_TRADE, params);
            logger.debug("body:{}", body);
            SwapMarketHistoryTradeResponse response = JSON.parseObject(body, SwapMarketHistoryTradeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }



    @Override
    public SwapHisOpenInterestResponse getSwapHisOpenInterest(String contractCode,String pair,String contractType, String period, Integer size, Integer amountType) {
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
            params.put("period", period);
            if (size != null) {
                params.put("size", size);
            }
            if (amountType != null) {
                params.put("amount_type", amountType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_HIS_OPEN_INTEREST, params);
            logger.debug("body:{}", body);
            SwapHisOpenInterestResponse response = JSON.parseObject(body, SwapHisOpenInterestResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LinearSwapPremiumIndexKlineResponse getLinearSwapPremiumIndexKline(String contractCode, String period, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            params.put("size", size);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.LINEAR_SWAP_PREMIUM_INDEX_KLINE, params);
            logger.debug("body:{}", body);
            LinearSwapPremiumIndexKlineResponse response = JSON.parseObject(body, LinearSwapPremiumIndexKlineResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LinearSwapEstimatedRateKlineResponse getLinearSwapEstimatedRateKline(String contractCode, String period, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            params.put("size", size);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.LINEAR_SWAP_ESTIMATED_RATE_KLINE, params);
            logger.debug("body:{}", body);
            LinearSwapEstimatedRateKlineResponse response = JSON.parseObject(body, LinearSwapEstimatedRateKlineResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LinearSwapBasisResponse getLinearSwapBasis(LinearSwapBasisRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("period", request.getPeriod());
            params.put("size", request.getSize());
            if (StringUtils.isNoneEmpty(request.getBasisPriceType())) {
                params.put("basis_price_type", request.getBasisPriceType());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.LINEAR_SWAP_BASIS, params);
            logger.debug("body:{}", body);
            LinearSwapBasisResponse response = JSON.parseObject(body, LinearSwapBasisResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LinearSwapMarkPriceKlineResponse getLinearSwapMarkPriceKline(String contractCode, String period, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            params.put("size", size);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.LINEAR_SWAP_MARK_PRICE_KLINE, params);
            logger.debug("body:{}", body);
            LinearSwapMarkPriceKlineResponse response = JSON.parseObject(body, LinearSwapMarkPriceKlineResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public MarketBboResponse getMarketBbo(String contractCode,String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.MARKET_BBO, params);
            logger.debug("body:{}", body);
            MarketBboResponse response = JSON.parseObject(body, MarketBboResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public BatchMergedV2Response getBatchMergedV2(String contractCode, String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.BATCH_MERGED_V2, params);
            logger.debug("body:{}", body);
            BatchMergedV2Response response = JSON.parseObject(body, BatchMergedV2Response.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }


}