package com.huobi.api.service.usdt.trade;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapCrossAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.usdt.trade.*;
import com.huobi.api.response.usdt.market.SwapCrossTradeStateResponse;
import com.huobi.api.response.usdt.trade.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrossTradeAPIServiceImpl implements CrossTradeAPIService {


    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String sign = "";
    String url_prex = "https://api.hbdm.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    public CrossTradeAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }

    @Override
    public SwapCrossTradeStateResponse getSwapCrossTradeState(String contractCode, String contractType, String pair, String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(contractType)){
                params.put("contract_type",contractType);
            }
            if (StringUtils.isNotEmpty(pair)){
                params.put("pair",pair.toUpperCase());
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRADE_STATE, params);
            logger.debug("body:{}", body);
            SwapCrossTradeStateResponse response = JSON.parseObject(body, SwapCrossTradeStateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSwitchPositionModeResponse swapCrossSwitchPositionModeResponse(String marginAccount, String positionMode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("margin_account", marginAccount);
            params.put("position_mode", positionMode);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_SWITCH_POSITION_MODE, params,sign);
            logger.debug("body:{}", body);
            SwapSwitchPositionModeResponse response = JSON.parseObject(body, SwapSwitchPositionModeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossOrderResponse swapCrossOrderRequest(SwapCrossOrderRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("volume", request.getVolume());
            params.put("direction", request.getDirection().getValue());
            if (request.getOffset()!=null) {
                params.put("offset", request.getOffset().getValue());
            }
            params.put("order_price_type", request.getOrderPriceType());
            params.put("lever_rate", request.getLeverRate());
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair().toUpperCase());
            }
            if (request.getContractType() != null) {
                params.put("contract_type", request.getContractType());
            }
            if (request.getPrice() != null) {
                params.put("price", request.getPrice());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
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
            if(request.getReduceOnly()!=null){
                params.put("reduce_only",request.getReduceOnly());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_ORDER, params,sign);
            logger.debug("body:{}", body);
            SwapCrossOrderResponse response = JSON.parseObject(body, SwapCrossOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossBatchorderResponse swapCrossBatchorderRequest(SwapCrossBatchorderRequest request) {
        List<Map<String, Object>> listMap = new ArrayList<>();
        String body;
        try {

            request.getList().stream()
                    .forEach(e -> {
                        Map<String, Object> params = new HashMap<>();
                        params.put("volume", e.getVolume());
                        params.put("direction", e.getDirection().getValue());
                        if (e.getOffset()!=null) {
                            params.put("offset", e.getOffset().getValue());
                        }
                        params.put("order_price_type", e.getOrderPriceType());
                        params.put("lever_rate", e.getLeverRate());
                        if (StringUtils.isNotEmpty(e.getContractCode())) {
                            params.put("contract_code", e.getContractCode().toUpperCase());
                        }
                        if (StringUtils.isNotEmpty(e.getPair())) {
                            params.put("pair", e.getPair().toUpperCase());
                        }
                        if (e.getContractType() != null) {
                            params.put("contract_type", e.getContractType());
                        }
                        if (e.getPrice() != null) {
                            params.put("price", e.getPrice());
                        }
                        if (e.getClientOrderId() != null) {
                            params.put("client_order_id", e.getClientOrderId());
                        }
                        if (e.getTpTriggerPrice() != null && e.getTpTriggerPrice() != BigDecimal.valueOf(0)) {
                            params.put("tp_trigger_price", e.getTpTriggerPrice());
                        }
                        if (e.getTpOrderPrice() != null && e.getTpOrderPrice() != BigDecimal.valueOf(0)) {
                            params.put("tp_order_price", e.getTpOrderPrice());
                        }
                        if (e.getTpOrderPriceType() != null) {
                            params.put("tp_order_price_type", e.getTpOrderPriceType());
                        }
                        if (e.getSlTriggerPrice() != null && e.getSlTriggerPrice() != BigDecimal.valueOf(0)) {
                            params.put("sl_trigger_price", e.getSlTriggerPrice());
                        }
                        if (e.getSlOrderPrice() != null && e.getSlOrderPrice() != BigDecimal.valueOf(0)) {
                            params.put("sl_order_price", e.getSlOrderPrice());
                        }
                        if (e.getSlOrderPriceType() != null) {
                            params.put("sl_order_price_type", e.getSlOrderPriceType());
                        }
                        if(e.getReduceOnly()!=null){
                            params.put("reduce_only",e.getReduceOnly());
                        }
                        listMap.add(params);
                    });
            Map<String, Object> params = new HashMap<>();

            params.put("orders_data", listMap);

            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_BATCHORDER, params,sign);
            logger.debug("body:{}", body);
            SwapCrossBatchorderResponse response = JSON.parseObject(body, SwapCrossBatchorderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 撤销订单（全仓模式）
     */
    @Override
    public SwapCrossCancelResponse swapCrossCancelRequest(SwapCrossCancelRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair().toUpperCase());
            }
            if (request.getContractType() != null) {
                params.put("contract_type", request.getContractType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_CANCEL, params,sign);
            logger.debug("body:{}", body);
            SwapCrossCancelResponse response = JSON.parseObject(body, SwapCrossCancelResponse.class);
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
     * 全部撤单（全仓模式）
     */
    @Override
    public SwapCrossCancelallResponse swapCrossCancelallRequest(SwapCrossCancelallRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair().toUpperCase());
            }
            if (request.getContractType() != null) {
                params.put("contract_type", request.getContractType());
            }
            if (request.getDirection() != null) {
                params.put("direction", request.getDirection());
            }
            if (request.getOffset() != null) {
                params.put("offset", request.getOffset());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_CANCELALL, params,sign);
            logger.debug("body:{}", body);
            SwapCrossCancelallResponse response = JSON.parseObject(body, SwapCrossCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossOrderInfoResponse swapCrossOrderInfoRequest(SwapCrossOrderInfoRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair().toUpperCase());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_ORDER_INFO, params,sign);
            logger.debug("body:{}", body);
            SwapCrossOrderInfoResponse response = JSON.parseObject(body, SwapCrossOrderInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 获取订单明细信息（全仓模式）
     */
    @Override
    public SwapCrossOrderDetailResponse swapCrossOrderDetailRequest(SwapCrossOrderDetailRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair().toUpperCase());
            }
            params.put("order_id", request.getOrderId());
            if (request.getCreatedAt() != null) {
                params.put("created_at", request.getCreatedAt());
            }
            if (request.getOrderType() != null) {
                params.put("order_type", request.getOrderType());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_ORDER_DETAIL, params,sign);
            logger.debug("body:{}", body);
            SwapCrossOrderDetailResponse response = JSON.parseObject(body, SwapCrossOrderDetailResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 获取合约当前未成交委托（全仓模式）
     */
    @Override
    public SwapCrossOpenordersResponse swapCrossOpenordersRequest(SwapCrossOpenordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (request.getSortBy() != null) {
                params.put("sort_by", request.getSortBy());
            }
            if (request.getTradeType() != null) {
                params.put("trade_type", request.getTradeType());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getTradePartition())){
                params.put("trade_partition",request.getTradePartition());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_OPENORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapCrossOpenordersResponse response = JSON.parseObject(body, SwapCrossOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossLightningClosePositionResponse swapCrossLightningClosePositionRequest(SwapCrossLightningClosePositionRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getOrderPriceType())) {
                params.put("order_price_type", request.getOrderPriceType());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair().toUpperCase());
            }
            if (request.getContractType() != null) {
                params.put("contract_type", request.getContractType());
            }
            params.put("direction", request.getDirection());
            params.put("volume", request.getVolume());
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_LIGHTNING_CLOSE_POSITION, params,sign);
            logger.debug("body:{}", body);
            SwapCrossLightningClosePositionResponse response = JSON.parseObject(body, SwapCrossLightningClosePositionResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }



    @Override
    public SwapCrossSwitchLeverRateResponse getSwapCrossSwitchLeverRate(String contractCode, Integer leverRate, String pair, String contractType) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(pair)) {
                params.put("pair", pair.toUpperCase());
            }
            if (contractType != null) {
                params.put("contract_type", contractType);
            }
            params.put("lever_rate", leverRate);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_SWITCH_LEVER_RATE, params,sign);
            logger.debug("body:{}", body);
            SwapCrossSwitchLeverRateResponse response = JSON.parseObject(body, SwapCrossSwitchLeverRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossHisordersExactV3Response swapCrossHisordersExactV3Response(SwapCrossHisordersExactV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
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
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair());
            }
            if (request.getType() != null) {
                params.put("type", request.getType());
            }
            if (StringUtils.isNotEmpty(request.getStatus())) {
                params.put("status", request.getStatus());
            }
            if (StringUtils.isNotEmpty(request.getPriceType())) {
                params.put("price_type", request.getPriceType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_HISORDERS_EXACT_V3, params,sign);
            logger.debug("body:{}", body);
            SwapCrossHisordersExactV3Response response = JSON.parseObject(body, SwapCrossHisordersExactV3Response.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossHisordersV3Response swapCrossHisordersV3Response(SwapCrossHisordersV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
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
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair());
            }
            if (request.getType() != null) {
                params.put("type", request.getType());
            }
            if (StringUtils.isNotEmpty(request.getStatus())) {
                params.put("status", request.getStatus());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_HISORDERS_V3, params,sign);
            logger.debug("body:{}", body);
            SwapCrossHisordersV3Response response = JSON.parseObject(body, SwapCrossHisordersV3Response.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossMatchResultsV3Response swapCrossMatchResultsV3Response(SwapCrossMatchResultsV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
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
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_MATCHRESULTS_V3, params,sign);
            logger.debug("body:{}", body);
            SwapCrossMatchResultsV3Response response = JSON.parseObject(body, SwapCrossMatchResultsV3Response.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossMatchResultsExactV3Response swapCrossMatchResultsExactV3Response(SwapCrossMatchResultsExactV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
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
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_MATCHRESULTS_EXACT_V3, params,sign);
            logger.debug("body:{}", body);
            SwapCrossMatchResultsExactV3Response response = JSON.parseObject(body, SwapCrossMatchResultsExactV3Response.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapCrossPositionSideResponse swapCrossPositionSideResponse(String marginAccount) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(marginAccount)) {
                params.put("margin_account", marginAccount);
            }
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_POSITION_SIDE, params);
            logger.debug("body:{}", body);
            SwapCrossPositionSideResponse response = JSON.parseObject(body, SwapCrossPositionSideResponse.class);
            if ("ok".equals(response.getStatus())){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
