package com.huobi.api.service.coin_futures.strategy;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.coin_futures.trade.*;
import com.huobi.api.response.coin_futures.trade.*;
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
    public ContractTriggerOrderResponse contractTriggerOrderRequest(ContractTriggerOrderRequest request){
        String body;
        try {
            Map<String,Object> params=new HashMap<>();
            if(StringUtils.isNotEmpty(request.getSymbol()) && StringUtils.isNotEmpty(request.getContractType())){
                params.put("symbol",request.getSymbol().toUpperCase());
                params.put("contract_type",request.getContractType());
            }
            if(StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            params.put("trigger_type",request.getTriggerType());
            params.put("trigger_price",request.getTriggerPrice());
            params.put("order_price",request.getOrderPrice());
            if (request.getOrderPriceType()!=null){
                params.put("order_price_type",request.getOrderPriceType());
            }
            params.put("volume",request.getVolume());
            params.put("direction",request.getDirection().getValue());
            params.put("offset",request.getOffset().getValue());
            params.put("lever_rate",request.getLeverRate());
            body= HbdmHttpClient.getInstance().doPost(api_key,secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_TRIGGER_ORDER,params,sign);
            ContractTriggerOrderResponse response= JSON.parseObject(body,ContractTriggerOrderResponse.class);
            if("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTriggerCancelResponse contractTriggerCancelRequest(ContractTriggerCancelRequest request){
        String body;
        try{
            Map<String,Object> params= new HashMap<>();
            if(StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol",request.getSymbol().toUpperCase());
            }
            params.put("order_id",request.getOrderId());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRIGGER_CANCEL,params,sign);
            logger.debug("body:{}",body);
            ContractTriggerCancelResponse response=JSON.parseObject(body,ContractTriggerCancelResponse.class);
            if("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
    @Override
    public ContractTriggerCancelallResponse contractTriggerCancelallRequest(ContractTriggerCancelallRequest request){
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if(StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol",request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            if (request.getOffset()!=null){
                params.put("offset",request.getOffset());
            }
            if (request.getContractType()!=null) {
                params.put("contract_type", request.getContractType());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex+HuobiFutureAPIConstants.CONTRACT_TRIGGER_CANCELALL,params,sign);
            ContractTriggerCancelallResponse response=JSON.parseObject(body,ContractTriggerCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTriggerOpenordersResponse contractTriggerOpenordersRequest(ContractTriggerOpenordersRequest request){
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol",request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            if(request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if(request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getTrade_type()!=null){
                params.put("trade_type",request.getTrade_type());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRIGGER_OPENORDERS,params,sign);
            ContractTriggerOpenordersResponse response=JSON.parseObject(body,ContractTriggerOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTriggerHisordersResponse contractTriggerHisorders(ContractTriggerHisordersRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol",request.getSymbol().toUpperCase());
            params.put("trade_type",request.getTradeType());
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            params.put("status",request.getStatus());
            params.put("create_date",request.getCreateDate());
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRIGGER_HISORDERS,params,sign);
            ContractTriggerHisordersResponse response=JSON.parseObject(body,ContractTriggerHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslOrderResponse contractTpslOrder(ContractTpslOrderRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if(StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractType())) {
                params.put("contract_type", request.getContractType());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode().toUpperCase());
            }
            params.put("direction",request.getDirection());
            params.put("volume",request.getVolume());
            if (request.getTpTriggerPrice()!=null && request.getTpTriggerPrice()!= BigDecimal.valueOf(0)){
                params.put("tp_trigger_price",request.getTpTriggerPrice());
            }
            if (request.getTpOrderPrice()!=null && request.getTpOrderPrice()!=BigDecimal.valueOf(0)){
                params.put("tp_order_price",request.getTpOrderPrice());
            }
            if (request.getTpOrderPriceType()!=null){
                params.put("tp_order_price_type",request.getTpOrderPriceType());
            }
            if (request.getSlOrderPrice()!=null && request.getSlOrderPrice()!=BigDecimal.valueOf(0)){
                params.put("sl_order_price",request.getSlOrderPrice());
            }
            if (request.getSlOrderPriceType()!=null){
                params.put("sl_order_price_type",request.getSlOrderPriceType());
            }
            if (request.getSlTriggerPrice()!=null && request.getSlTriggerPrice()!=BigDecimal.valueOf(0)){
                params.put("sl_trigger_price",request.getSlTriggerPrice());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_ORDER,params,sign);
            ContractTpslOrderResponse response=JSON.parseObject(body,ContractTpslOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslCancelResponse contractTpslCancelResponse(ContractTpslCancelRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id", request.getOrderId());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_CANCEL,params,sign);
            logger.debug("body:{}",body);
            ContractTpslCancelResponse response=JSON.parseObject(body,ContractTpslCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslCancelallResponse contractTpslCancelallResponse(ContractTpslCancelallRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_CANCELALL,params,sign);
            logger.debug("body:{}",body);
            ContractTpslCancelallResponse response=JSON.parseObject(body,ContractTpslCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTpslOpenordersResponse contractTpslOpenordersResponse(ContractTpslOpenordersRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getTrade_type()!=null){
                params.put("trade_type",request.getTrade_type());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_OPENORDERS,params,sign);
            ContractTpslOpenordersResponse response=JSON.parseObject(body,ContractTpslOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
    @Override
    public ContractTpslHisordersResponse contractTpslHisordersResponse(ContractTpslHisordersRequset request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("status",request.getStatus());
            params.put("create_date",request.getCreateDate());
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code",request.getContractCode());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TPSL_HISORDERS,params,sign);
            logger.debug("body:{}",body);
            ContractTpslHisordersResponse response=JSON.parseObject(body,ContractTpslHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractRelationTpslOrderResponse contractRelationTpslOrderResponse(ContractRelationTpslOrderRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id",request.getOrderId());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_RELATION_TPSL_ORDER,params,sign);
            logger.debug("body:{}",body);
            ContractRelationTpslOrderResponse response=JSON.parseObject(body,ContractRelationTpslOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackOrderResponse contractTrackOrderResponse(ContractTrackOrderRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())){
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getLeverRate()!=null){
                params.put("lever_rate",request.getLeverRate());
            }
            params.put("direction",request.getDirection());
            params.put("offset",request.getOffset());
            params.put("volume",request.getVolume());
            params.put("callback_rate",request.getCallbackRate());
            params.put("active_price",request.getActivePrice());
            params.put("order_price_type", request.getOrderPriceType());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_ORDER,params,sign);
            logger.debug("body:{}",body);
            ContractTrackOrderResponse response=JSON.parseObject(body,ContractTrackOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackCancelResponse contractTrackCancelResponse(ContractTrackCancelRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id",request.getOrderId());
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_CANCEL,params,sign);
            logger.debug("body:{}",body);
            ContractTrackCancelResponse response=JSON.parseObject(body,ContractTrackCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackCancelallResponse contractTrackCancelallResponse(ContractTrackCancelallRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getContractCode()!=null){
                params.put("contract_code",request.getContractCode());
            }
            if (request.getContractType()!=null){
                params.put("contract_type",request.getContractType());
            }
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            if (request.getOffset()!=null){
                params.put("offset",request.getOffset());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_CANCELALL,params,sign);
            logger.debug("body:{}",body);
            ContractTrackCancelallResponse response=JSON.parseObject(body,ContractTrackCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackOpenordersResponse contractTrackOpenordersResponse(ContractTrackOpenordersRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getContractCode()!=null) {
                params.put("contract_code", request.getContractCode());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getTradeType()!=null){
                params.put("trade_type",request.getTradeType());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_OPENORDERS,params,sign);
            logger.debug("body:{}",body);
            ContractTrackOpenordersResponse response=JSON.parseObject(body,ContractTrackOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTrackHisordersResponse contractTrackHisordersResponse(ContractTrackHisordersRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getContractCode()!=null) {
                params.put("contract_code", request.getContractCode());
            }
            if (request.getStatus()!=null){
                params.put("status",request.getStatus());
            }
            if (request.getTradeType()!=null){
                params.put("trade_type",request.getTradeType());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            if (request.getCreateDate()!=null){
                params.put("create_date",request.getCreateDate());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_TRACK_HISORDERS,params,sign);
            logger.debug("body:{}",body);
            ContractTrackHisordersResponse response=JSON.parseObject(body,ContractTrackHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
