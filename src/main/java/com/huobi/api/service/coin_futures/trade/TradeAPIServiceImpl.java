package com.huobi.api.service.coin_futures.trade;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.exception.ApiException;

import com.huobi.api.request.coin_futures.trade.*;
import com.huobi.api.response.coin_futures.trade.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.rtf.RTFEditorKit;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeAPIServiceImpl implements TradeAPIService {


    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String sign= "";
    String url_prex = "https://api.hbdm.com";
    Logger logger = LoggerFactory.getLogger(getClass());

    public TradeAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }


    @Override
    public ContractOrderResponse contractOrderRequest(ContractOrderRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("volume", request.getVolume());
            params.put("direction", request.getDirection().getValue());
            params.put("offset", request.getOffset().getValue());
            params.put("lever_rate", request.getLeverRate());
            params.put("order_price_type", request.getOrderPriceType());

            if (StringUtils.isNotEmpty(request.getSymbol()) && StringUtils.isNotEmpty(request.getContractType())) {
                params.put("symbol", request.getSymbol());
                params.put("contract_type", request.getContractType());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (request.getPrice() != null) {
                params.put("price", request.getPrice());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (request.getTpTriggerPrice()!=null && request.getTpTriggerPrice()!= BigDecimal.valueOf(0)){
                params.put("tp_trigger_price",request.getTpTriggerPrice());
            }
            if (request.getTpOrderPrice()!=null && request.getTpOrderPrice()!= BigDecimal.valueOf(0)){
                params.put("tp_order_price",request.getTpOrderPrice());
            }
            if (request.getTpOrderPriceType()!=null){
                params.put("tp_order_price_type",request.getTpOrderPriceType());
            }
            if (request.getSlTriggerPrice()!=null && request.getSlTriggerPrice()!= BigDecimal.valueOf(0)){
                params.put("sl_trigger_price",request.getSlTriggerPrice());
            }
            if (request.getSlOrderPrice()!=null && request.getSlOrderPrice()!= BigDecimal.valueOf(0)){
                params.put("sl_order_price",request.getSlOrderPrice());
            }
            if (request.getSlOrderPriceType()!=null){
                params.put("sl_order_price_type",request.getSlOrderPriceType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER, params,sign);
            ContractOrderResponse response = JSON.parseObject(body, ContractOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractBatchorderResponse contractBatchorderRequest(ContractBatchorderRequest request) {
        List<Map<String, Object>> listMap = new ArrayList<>();
        String body;
        try {

            request.getList().stream()
                    .forEach(e -> {
                        Map<String, Object> params = new HashMap<>();
                        params.put("volume", e.getVolume());
                        params.put("direction", e.getDirection().getValue());
                        params.put("offset", e.getOffset().getValue());
                        params.put("lever_rate", e.getLeverRate());
                        params.put("order_price_type", e.getOrderPriceType());
                        if (StringUtils.isNotEmpty(e.getSymbol()) && StringUtils.isNotEmpty(e.getContractType())) {
                            params.put("symbol", e.getSymbol());
                            params.put("contract_type", e.getContractType());
                        }
                        if (StringUtils.isNotEmpty(e.getContractCode())) {
                            params.put("contract_code", e.getContractCode());
                        }
                        if (e.getPrice() != null) {
                            params.put("price", e.getPrice());
                        }
                        if (e.getClientOrderId() != null) {
                            params.put("client_order_id", e.getClientOrderId());
                        }
                        if (e.getTpTriggerPrice()!=null && e.getTpTriggerPrice()!= BigDecimal.valueOf(0)){
                            params.put("tp_trigger_price",e.getTpTriggerPrice());
                        }
                        if (e.getTpOrderPrice()!=null && e.getTpOrderPrice()!= BigDecimal.valueOf(0)){
                            params.put("tp_order_price",e.getTpOrderPrice());
                        }
                        if (e.getTpOrderPriceType()!=null){
                            params.put("tp_order_price_type",e.getTpOrderPriceType());
                        }
                        if (e.getSlTriggerPrice()!=null && e.getSlTriggerPrice() != BigDecimal.valueOf(0)){
                            params.put("sl_trigger_price",e.getSlTriggerPrice());
                        }
                        if (e.getSlOrderPrice()!=null && e.getSlOrderPrice()!= BigDecimal.valueOf(0)){
                            params.put("sl_order_price",e.getSlOrderPrice());
                        }
                        if (e.getSlOrderPriceType()!=null){
                            params.put("sl_order_price_type",e.getSlOrderPriceType());
                        }
                        listMap.add(params);
                    });
            Map<String, Object> params = new HashMap<>();

            params.put("orders_data", listMap);

            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_BATCHORDER, params,sign);
            ContractBatchorderResponse response = JSON.parseObject(body, ContractBatchorderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 撤销订单
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractCancelResponse contractCancelRequest(ContractCancelRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            params.put("symbol", request.getSymbol().toUpperCase());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_CANCEL, params,sign);
            ContractCancelResponse response = JSON.parseObject(body, ContractCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            System.out.println("body:" + body);
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 全部撤单
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractCancelallResponse contractCancelallRequest(ContractCancelallRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (StringUtils.isNotEmpty(request.getContractType())) {
                params.put("contract_type", request.getContractType());
            }
            if (request.getDirection()!=null){
                params.put("direction",request.getDirection());
            }
            if (request.getOffset()!=null){
                params.put("offset",request.getOffset());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_CANCELALL, params,sign);
            ContractCancelallResponse response = JSON.parseObject(body, ContractCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractOrderInfoResponse contractOrderInfoRequest(ContractOrderInfoRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER_INFO, params,sign);
            ContractOrderInfoResponse response = JSON.parseObject(body, ContractOrderInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 获取订单明细信息
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractOrderDetailResponse contractOrderDetailRequest(ContractOrderDetailRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id", request.getOrderId());
            if (request.getCreatedAt() != null) {
                params.put("created_at", request.getCreatedAt());
            }
            params.put("order_type", request.getOrderType());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER_DETAIL, params,sign);
            ContractOrderDetailResponse response = JSON.parseObject(body, ContractOrderDetailResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 获取合约当前未成交委托
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractOpenordersResponse contractOpenordersRequest(ContractOpenordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (request.getSortBy()!=null){
                params.put("sort_by",request.getSortBy());
            }
            if (request.getTradeType()!=null){
                params.put("trade_type",request.getTradeType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_OPENORDERS, params,sign);
            ContractOpenordersResponse response = JSON.parseObject(body, ContractOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LightningClosePositionResponse lightningClosePositionRequest(LightningClosePositionRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (StringUtils.isNotEmpty(request.getContractType())) {
                params.put("contract_type", request.getContractType());
            }
            params.put("direction", request.getDirection());
            params.put("volume", request.getVolume());
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (request.getOrderPriceType() != null) {
                params.put("order_price_type", request.getOrderPriceType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.LIGHTNING_CLOSE_POSITION, params,sign);
            LightningClosePositionResponse response = JSON.parseObject(body, LightningClosePositionResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSwitchLeverRateResponse contractSwitchLeverRateRequest(String symbol, Integer leverRate) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("symbol",symbol.toUpperCase());
            params.put("lever_rate",leverRate);
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_SWITCH_LEVER_RATE,params,sign);
            logger.debug("body:{}",body);
            ContractSwitchLeverRateResponse response=JSON.parseObject(body,ContractSwitchLeverRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractCancelAfterResponse contractCancelAfterResponse(ContractCancelAfterRequest request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
            if (request.getOnOff()!=null) {
                params.put("on_off", request.getOnOff());
            }
            if (request.getTimeOut()!=null){
                params.put("time_out",request.getTimeOut());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_CANCEL_AFTER,params,sign);
            logger.debug("body:{}",body);
            ContractCancelAfterResponse response=JSON.parseObject(body,ContractCancelAfterResponse.class);
            if (response.getCode() !=  null && response.getCode() == 200){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractHisordersV3Response contractHisordersV3Response(ContractHisordersV3Request request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
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
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol());
            }
            if (request.getTradeType() != null) {
                params.put("type", request.getType());
            }
            if (StringUtils.isNotEmpty(request.getStatus())) {
                params.put("status", request.getStatus());
            }
            if (StringUtils.isNotEmpty(request.getOrderType())) {
                params.put("order_type", request.getOrderType());
            }
            if (StringUtils.isNotEmpty(request.getSortBy())) {
                params.put("sort_by", request.getSortBy());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_HISORDERS_V3,params,sign);
            logger.debug("body:{}",body);
            ContractHisordersV3Response response=JSON.parseObject(body,ContractHisordersV3Response.class);
            if (response.getCode() !=  null && response.getCode() == 200){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractHisordersExactV3Response contractHisordersExactV3Response(ContractHisordersExactV3Request request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
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
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol());
            }
            if (request.getTradeType() != null) {
                params.put("type", request.getType());
            }
            if (StringUtils.isNotEmpty(request.getStatus())) {
                params.put("status", request.getStatus());
            }
            if (StringUtils.isNotEmpty(request.getOrderType())) {
                params.put("order_type", request.getOrderType());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_HISORDERS_EXACT_V3,params,sign);
            logger.debug("body:{}",body);
            ContractHisordersExactV3Response response=JSON.parseObject(body,ContractHisordersExactV3Response.class);
            if (response.getCode() !=  null && response.getCode() == 200){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractMatchResultsV3Response contractMatchResultsV3Response(ContractMatchResultsV3Request request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
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
                params.put("symbol", request.getSymbol());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_MATCHRESULTS_V3,params,sign);
            logger.debug("body:{}",body);
            ContractMatchResultsV3Response response=JSON.parseObject(body,ContractMatchResultsV3Response.class);
            if (response.getCode() !=  null && response.getCode() == 200){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractMatchResultsExactV3Response contractMatchResultsExactV3Response(ContractMatchResultsExactV3Request request) {
        String body;
        try{
            Map<String,Object> params=new HashMap<>();
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
                params.put("symbol", request.getSymbol());
            }
            if (StringUtils.isNotEmpty(request.getContract())) {
                params.put("contract", request.getContract().toUpperCase());
            }
            body=HbdmHttpClient.getInstance().doPost(api_key,secret_key,url_prex + HuobiFutureAPIConstants.CONTRACT_MATCHRESULTS_EXACT_V3,params,sign);
            logger.debug("body:{}",body);
            ContractMatchResultsExactV3Response response=JSON.parseObject(body,ContractMatchResultsExactV3Response.class);
            if (response.getCode() !=  null && response.getCode() == 200){
                return response;
            }
        }catch(Exception e){
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

}
