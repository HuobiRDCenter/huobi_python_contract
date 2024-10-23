package com.huobi.api.service.coin_swap.market;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiCoinMarginedSwapAPIOptions;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.coin_swap.account.LinearSwapBasisRequest;
import com.huobi.api.request.coin_swap.account.SwapLiquidationOrdersRequest;
import com.huobi.api.request.coin_swap.account.SwapMarketHistoryKlineRequest;
import com.huobi.api.request.coin_swap.market.SwapSettlementRecordsRequest;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersV3Request;
import com.huobi.api.response.coin_swap.market.*;
import com.huobi.api.response.usdt.account.SwapLiquidationOrdersV3Response;
import com.huobi.api.response.usdt.market.BatchMergedV2Response;
import com.huobi.api.response.usdt.market.SwapQueryElementsResponse;
import com.huobi.api.response.usdt.market.SwapSettlementRecordsResponse;
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_MARKET_DEPTH, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_MARKET_HISTORY_KLINE, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_MARKET_DETAIL_MERGED, params);
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
    public SwapMarketTradeResponse getSwapMarketTrade(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_MARKET_TRADE, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_MARKET_HISTORY_TRADE, params);
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
    public LinearSwapPremiumIndexKlineResponse getLinearSwapPremiumIndexKline(String contractCode, String period, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            params.put("size", size);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.LINEAR_SWAP_PREMIUM_INDEX_KLINE, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.LINEAR_SWAP_ESTIMATED_RATE_KLINE, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.LINEAR_SWAP_BASIS, params);
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
    public SwapMarkPriceKlineResponse getSwapMarkPriceKline(String contractCode, String period, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            params.put("size", size);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_MARK_PRICE_KLINE, params);
            logger.debug("body:{}", body);
            SwapMarkPriceKlineResponse response = JSON.parseObject(body, SwapMarkPriceKlineResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public MarketBboResponse getMarketBbo(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.MARKET_BBO, params);
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
    public BatchMergedV2Response getBatchMergedV2(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.BATCH_MERGED_V2, params);
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