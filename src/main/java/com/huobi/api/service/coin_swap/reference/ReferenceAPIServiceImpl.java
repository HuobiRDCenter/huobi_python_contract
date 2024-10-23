package com.huobi.api.service.coin_swap.reference;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiCoinMarginedSwapAPIOptions;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.coin_swap.market.SwapSettlementRecordsRequest;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersV3Request;
import com.huobi.api.response.coin_swap.market.*;
import com.huobi.api.response.usdt.account.SwapLiquidationOrdersV3Response;
import com.huobi.api.response.usdt.market.SwapQueryElementsResponse;
import com.huobi.api.response.usdt.market.SwapSettlementRecordsResponse;
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
    public SwapRiskInfoResponse getSwapRiskInfo(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_RISK_INFO, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_INSURANCE_FUND, params);
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
    public SwapAdjustfactorResponse getSwapAdjustfactor(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_ADJUSTFACTOR, params);
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
    public SwapHisOpenInterestResponse getSwapHisOpenInterest(String contractCode, String period, Integer size, Integer amountType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            if (size != null) {
                params.put("size", size);
            }
            if (amountType != null) {
                params.put("amount_type", amountType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_HIS_OPEN_INTEREST, params);
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
    public SwapLadderMarginResponse getSwapLadderMargin(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (contractCode!=null) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_LADDER_MARGIN, params);
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
    public SwapEliteAccountRatioResponse getSwapEliteAccountRatio(String contractCode, String period) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            params.put("period", period);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_ELITE_ACCOUNT_RATIO, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_ELITE_POSITION_RATIO, params);
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
    public SwapEstimatedSettlementPriceResponse getSwapEstimatedSettlementPrice(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_ESTIMATED_SETTLEMENT_PRICE, params);
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
    public SwapApiStateResponse getSwapApiState(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_API_STATE, params);
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
    public SwapFundingRateResponse getSwapFundingRate(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_FUNDING_RATE, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_BATCH_FUNDING_RATE, params);
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

    @Override
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_HISTORICAL_FUNDING_RATE, params);
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
            if (StringUtils.isNotEmpty(request.getContract())) {
                params.put("contract", request.getContract().toUpperCase());
            }
            if (request.getTradeType() != null) {
                params.put("trade_type", request.getTradeType());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_LIQUIDATION_ORDERS_V3, params);
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
    public SwapSettlementRecordsResponse getSwapSettlementRecords(SwapSettlementRecordsRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (request.getStartTime() != null) {
                params.put("start_time", request.getStartTime());
            }
            if (request.getEndTime() != null) {
                params.put("end_time", request.getEndTime());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_SETTLEMENT_RECORDS, params);
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
    public SwapContractInfoResponse getSwapContractInfo(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_CONTRACT_INFO, params);
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
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_INDEX, params);
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
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_QUERY_ELEMENTS, params);
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

    @Override
    public SwapPriceLimitResponse getSwapPriceLimit(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase());
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_PRICE_LIMIT, params);
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
    public SwapOpenInterestResponse getSwapOpenInterest(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_OPEN_INTEREST, params);
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
    public TimestampReponse getTimestamp() {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.TIMESTAMP, params);
            logger.debug("body:{}", body);
            TimestampReponse response = JSON.parseObject(body, TimestampReponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public HeartBeatResponse getHeartBeat() {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiCoinMarginedSwapAPIOptions.HEARTBEAT, params);
            logger.debug("body:{}", body);
            HeartBeatResponse response = JSON.parseObject(body, HeartBeatResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SummaryResponse getSummary() {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            body = HbdmHttpClient.getInstance().doGet(HuobiCoinMarginedSwapAPIOptions.SUMMARY, params);
            logger.debug("body:{}", body);
            SummaryResponse response = JSON.parseObject(body, SummaryResponse.class);
            return response;
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

}
