package com.huobi.api.service.usdt.strategy;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapCrossAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.usdt.trade.*;
import com.huobi.api.response.usdt.trade.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CrossStrategyAPIServiceImpl implements CrossStrategyAPIService{
    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String sign = "";
    String url_prex = "https://api.hbdm.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    public CrossStrategyAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }

    @Override
    public SwapCrossTriggerOrderResponse swapCrossTriggerOrderResponse(SwapCrossTriggerOrderRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            params.put("trigger_type", request.getTriggerType());
            params.put("trigger_price", request.getTriggerPrice());
            params.put("volume", request.getVolume());
            params.put("direction", request.getDirection());
            if (request.getOffset()!=null) {
                params.put("offset", request.getOffset());
            }
            if (request.getOrderPrice() != null) {
                params.put("order_price", request.getOrderPrice());
            }
            if (request.getOrderPriceType() != null) {
                params.put("order_price_type", request.getOrderPriceType());
            }
            if (request.getLeverRate() != null) {
                params.put("lever_rate", request.getLeverRate());
            }
            if(request.getReduceOnly()!=null){
                params.put("reduce_only",request.getReduceOnly());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRIGGER_ORDER, params,sign);
            logger.debug("body:{}", body);
            SwapCrossTriggerOrderResponse response = JSON.parseObject(body, SwapCrossTriggerOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossTriggerCancelResponse swapCrossTriggerCancelResponse(SwapCrossTriggerCancelRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            params.put("order_id", request.getOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRIGGER_CANCEL, params,sign);
            logger.debug("body:{}", body);
            SwapCrossTriggerCancelResponse response = JSON.parseObject(body, SwapCrossTriggerCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossTriggerCancelallResponse swapCrossTriggerCancelallResponse(SwapCrossTriggerCancelallRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getDirection() != null) {
                params.put("direction", request.getDirection());
            }
            if (request.getOffset() != null) {
                params.put("offset", request.getOffset());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRIGGER_CANCELALL, params,sign);
            logger.debug("body:{}", body);
            SwapCrossTriggerCancelallResponse response = JSON.parseObject(body, SwapCrossTriggerCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossTriggerOpenordersResponse swapCrossTriggerOpenordersResponse(SwapCrossTriggerOpenordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (request.getTradeType() != null) {
                params.put("trade_type", request.getTradeType());
            }
            if (StringUtils.isNotEmpty(request.getTradePartition())){
                params.put("trade_partition",request.getTradePartition());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRIGGER_OPENORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapCrossTriggerOpenordersResponse response = JSON.parseObject(body, SwapCrossTriggerOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossTriggerHisordersResponse swapCrossTriggerHisordersResponse(SwapCrossTriggerHisordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            params.put("trade_type", request.getTradeType());
            params.put("status", request.getStatus());
            params.put("create_date", request.getCreateDate());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (request.getSortBy() != null) {
                params.put("sort_by", request.getSortBy());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRIGGER_HISORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapCrossTriggerHisordersResponse response = JSON.parseObject(body, SwapCrossTriggerHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTpslOrderResponse swapCrossTpslOrderResponse(SwapTpslOrderRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            params.put("direction", request.getDirection());
            params.put("volume", request.getVolume());
            if (request.getTpTriggerPrice() != null && request.getTpTriggerPrice() != BigDecimal.valueOf(0)) {
                params.put("tp_trigger_price", request.getTpTriggerPrice());
            }
            if (request.getTpOrderPrice() != null && request.getTpOrderPrice() != BigDecimal.valueOf(0)) {
                params.put("tp_order_price", request.getTpOrderPrice());
            }
            if (request.getTpOrderPriceType() != null) {
                params.put("tp_order_price_type", request.getTpOrderPriceType());
            }
            if (request.getSlTriggerPrice() != null && request.getSlTriggerPrice() != BigDecimal.valueOf(0)) {
                params.put("sl_trigger_price", request.getSlTriggerPrice());
            }
            if (request.getSlOrderPrice() != null && request.getSlOrderPrice() != BigDecimal.valueOf(0)) {
                params.put("sl_order_price", request.getSlOrderPrice());
            }
            if (request.getSlOrderPriceType() != null) {
                params.put("sl_order_price_type", request.getSlOrderPriceType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TPSL_ORDER, params,sign);
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
    public SwapTpslCancelResponse swapCrossTpslCancelResponse(SwapTpslCancelRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            params.put("order_id", request.getOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TPSL_CANCEL, params,sign);
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
    public SwapTpslCancelallResponse swapCrossTpslCancelallResponse(SwapTpslCancelallRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getDirection() != null) {
                params.put("direction", request.getDirection());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TPSL_CANCELALL, params,sign);
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
    public SwapTpslOpenordersResponse swapCrossTpslOpenordersResponse(SwapTpslOpenordersRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (request.getTradeType() != null) {
                params.put("trade_type", request.getTradeType());
            }
            if (StringUtils.isNotEmpty(request.getTradePartition())){
                params.put("trade_partition",request.getTradePartition());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TPSL_OPENORDERS, params,sign);
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
    public SwapTpslHisordersResponse swapCrossTpslHisordersResponse(SwapTpslHisordersRequset request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            params.put("status", request.getStatus());
            params.put("create_date", request.getCreateDate());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (StringUtils.isNotEmpty(request.getSortBy())) {
                params.put("sort_by", request.getSortBy());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TPSL_HISORDERS, params,sign);
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
    public SwapRelationTpslOrderResponse swapCrossRelationTpslOrderResponse(SwapRelationTpslOrderRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            params.put("order_id", request.getOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_RELATION_TPSL_ORDER, params,sign);
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
    public SwapTrackOrderResponse swapCrossTrackOrderResponse(SwapTrackOrderRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair().toUpperCase());
            }
            if(request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            params.put("direction", request.getDirection());
            if (request.getOffset()!=null) {
                params.put("offset", request.getOffset());
            }
            if (request.getLeverRate() != null && request.getLeverRate() != 0) {
                params.put("lever_rate", request.getLeverRate());
            }
            params.put("volume", request.getVolume());
            params.put("callback_rate", request.getCallbackRate());
            params.put("active_price", request.getActivePrice());
            params.put("order_price_type", request.getOrderPriceType());
            if(request.getReduceOnly()!=null){
                params.put("reduce_only",request.getReduceOnly());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRACK_ORDER, params,sign);
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
    public SwapTrackCancelResponse swapCrossTrackCancelResponse(SwapTrackCancelRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            params.put("order_id", request.getOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRACK_CANCEL, params,sign);
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
    public SwapTrackCancelallResponse swapCrossTrackCancelallResponse(SwapTrackCancelallRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getDirection()!=null) {
                params.put("direction", request.getDirection());
            }
            if (request.getOffset()!=null) {
                params.put("offset", request.getOffset());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRACK_CANCELALL, params,sign);
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
    public SwapTrackOpenordersResponse swapCrossTrackOpenordersResponse(SwapTrackOpenordersRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
            if (request.getTradeType()!=null) {
                params.put("trade_type", request.getTradeType());
            }
            if (request.getPageIndex()!=null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (StringUtils.isNotEmpty(request.getTradePartition())){
                params.put("trade_partition",request.getTradePartition());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRACK_OPENORDERS, params,sign);
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
    public SwapTrackHisordersResponse swapCrossTrackHisordersResponse(SwapTrackHisordersRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())){
                params.put("pair",request.getPair().toUpperCase());
            }
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
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRACK_HISORDERS, params,sign);
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
