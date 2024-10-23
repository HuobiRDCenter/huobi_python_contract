package com.huobi.api.service.coin_swap.strategy;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiCoinMarginedSwapAPIOptions;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.coin_swap.trade.*;
import com.huobi.api.response.coin_swap.trade.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StrategyAPIServiceImpl implements StrategyAPIService{
    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String sign = "";
    String url_prex = "https://api.hbdm.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    public StrategyAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }

    @Override
    public SwapTriggerOrderResponse swapTriggerOrderResponse(SwapTriggerOrderRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("trigger_type", request.getTriggerType());
            params.put("trigger_price", request.getTriggerPrice());
            params.put("volume", request.getVolume());
            params.put("direction", request.getDirection());
            params.put("offset", request.getOffset());
            if (request.getOrderPrice() != null) {
                params.put("order_price", request.getOrderPrice());
            }
            if (request.getOrderPriceType() != null) {
                params.put("order_price_type", request.getOrderPriceType());
            }
            if (request.getLeverRate() != null) {
                params.put("lever_rate", request.getLeverRate());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRIGGER_ORDER, params,sign);
            logger.debug("body:{}", body);
            SwapTriggerOrderResponse response = JSON.parseObject(body, SwapTriggerOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTriggerCancelResponse swapTriggerCancelResponse(SwapTriggerCancelRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("order_id", request.getOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRIGGER_CANCEL, params,sign);
            logger.debug("body:{}", body);
            SwapTriggerCancelResponse response = JSON.parseObject(body, SwapTriggerCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTriggerCancelallResponse swapTriggerCancelallResponse(SwapTriggerCancelallRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode());
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            if (request.getOffset()!=null){
                params.put("offset",request.getOffset());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRIGGER_CANCELALL, params,sign);
            logger.debug("body:{}", body);
            SwapTriggerCancelallResponse response = JSON.parseObject(body, SwapTriggerCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTriggerOpenordersResponse swapTriggerOpenordersResponse(SwapTriggerOpenordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode().toUpperCase());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (request.getTradeType()!=null){
                params.put("trade_type",request.getTradeType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRIGGER_OPENORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapTriggerOpenordersResponse response = JSON.parseObject(body, SwapTriggerOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTriggerHisordersResponse swapTriggerHisordersResponse(SwapTriggerHisordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("trade_type", request.getTradeType());
            params.put("status", request.getStatus());
            params.put("create_date", request.getCreateDate());

            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRIGGER_HISORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapTriggerHisordersResponse response = JSON.parseObject(body, SwapTriggerHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTpslOrderResponse swapTpslOrderResponse(SwapTpslOrderRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code",request.getContractCode().toUpperCase());
            params.put("direction",request.getDirection());
            params.put("volume",request.getVolume());
            if (request.getTpTriggerPrice()!=null && request.getTpTriggerPrice()!= BigDecimal.valueOf(0) ){
                params.put("tp_trigger_price",request.getTpTriggerPrice());
            }
            if (request.getTpOrderPrice()!=null && request.getTpOrderPrice()!= BigDecimal.valueOf(0) ){
                params.put("tp_order_price",request.getTpOrderPrice());
            }
            if (request.getTpOrderPriceType()!=null){
                params.put("tp_order_price_type",request.getTpOrderPriceType());
            }
            if (request.getSlTriggerPrice()!=null && request.getSlTriggerPrice()!=BigDecimal.valueOf(0)){
                params.put("sl_trigger_price",request.getSlTriggerPrice());
            }
            if (request.getSlOrderPrice()!=null && request.getSlOrderPrice()!=BigDecimal.valueOf(0)){
                params.put("sl_order_price",request.getSlOrderPrice());
            }
            if (request.getSlOrderPriceType()!=null){
                params.put("sl_order_price_type",request.getSlOrderPriceType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TPSL_ORDER, params,sign);
            logger.debug("body:{}", body);
            SwapTpslOrderResponse response = JSON.parseObject(body, SwapTpslOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTpslCancelResponse swapTpslCancelResponse(SwapTpslCancelRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code",request.getContractCode().toUpperCase());
            params.put("order_id",request.getOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TPSL_CANCEL, params,sign);
            logger.debug("body:{}", body);
            SwapTpslCancelResponse response = JSON.parseObject(body, SwapTpslCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTpslCancelallResponse swapTpslCancelallResponse(SwapTpslCancelallRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code",request.getContractCode().toUpperCase());
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TPSL_CANCELALL, params,sign);
            logger.debug("body:{}", body);
            SwapTpslCancelallResponse response = JSON.parseObject(body, SwapTpslCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTpslOpenordersResponse swapTpslOpenordersResponse(SwapTpslOpenordersRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code",request.getContractCode().toUpperCase());
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getTradeType()!=null){
                params.put("trade_type",request.getTradeType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TPSL_OPENORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapTpslOpenordersResponse response = JSON.parseObject(body, SwapTpslOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTpslHisordersResponse swapTpslHisordersResponse(SwapTpslHisordersRequset request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code",request.getContractCode().toUpperCase());
            params.put("status",request.getStatus());
            params.put("create_date",request.getCreateDate());
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (StringUtils.isNotEmpty(request.getSortBy())){
                params.put("sort_by",request.getSortBy());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TPSL_HISORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapTpslHisordersResponse response = JSON.parseObject(body, SwapTpslHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapRelationTpslOrderResponse swapRelationTpslOrderResponse(SwapRelationTpslOrderRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code",request.getContractCode().toUpperCase());
            params.put("order_id",request.getOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_RELATION_TPSL_ORDER, params,sign);
            logger.debug("body:{}", body);
            SwapRelationTpslOrderResponse response = JSON.parseObject(body, SwapRelationTpslOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTrackOrderResponse swapTrackOrderResponse(SwapTrackOrderRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("direction", request.getDirection());
            params.put("offset", request.getOffset());
            if (request.getLeverRate() != null && request.getLeverRate() != 0) {
                params.put("lever_rate", request.getLeverRate());
            }
            params.put("volume", request.getVolume());
            params.put("callback_rate", request.getCallbackRate());
            params.put("active_price", request.getActivePrice());
            params.put("order_price_type", request.getOrderPriceType());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRACK_ORDER, params,sign);
            logger.debug("body:{}", body);
            SwapTrackOrderResponse response = JSON.parseObject(body, SwapTrackOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTrackCancelResponse swapTrackCancelResponse(SwapTrackCancelRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("order_id", request.getOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRACK_CANCEL, params,sign);
            logger.debug("body:{}", body);
            SwapTrackCancelResponse response = JSON.parseObject(body, SwapTrackCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTrackCancelallResponse swapTrackCancelallResponse(SwapTrackCancelallRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code", request.getContractCode().toUpperCase());
            if (request.getDirection()!=null) {
                params.put("direction", request.getDirection());
            }
            if (request.getOffset()!=null) {
                params.put("offset", request.getOffset());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRACK_CANCELALL, params,sign);
            logger.debug("body:{}", body);
            SwapTrackCancelallResponse response = JSON.parseObject(body, SwapTrackCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTrackOpenordersResponse swapTrackOpenordersResponse(SwapTrackOpenordersRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code", request.getContractCode().toUpperCase());
            if (request.getTradeType()!=null) {
                params.put("trade_type", request.getTradeType());
            }
            if (request.getPageIndex()!=null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRACK_OPENORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapTrackOpenordersResponse response = JSON.parseObject(body, SwapTrackOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTrackHisordersResponse swapTrackHisordersResponse(SwapTrackHisordersRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("status",request.getStatus());
            params.put("trade_type", request.getTradeType());
            params.put("create_date",request.getCreateDate());
            if (request.getPageIndex()!=null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.SWAP_TRACK_HISORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapTrackHisordersResponse response = JSON.parseObject(body, SwapTrackHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
