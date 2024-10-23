package com.huobi.api.service.usdt.trade;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.usdt.trade.*;
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

public class TradeAPIServiceImpl implements TradeAPIService {


    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String sign = "";
    String url_prex = "https://api.hbdm.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    public TradeAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }


    @Override
    public SwapSwitchPositionModeResponse swapSwitchPositionModeResponse(String marginAccount, String positionMode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("margin_account", marginAccount);
            params.put("position_mode", positionMode);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SWITCH_POSITION_MODE, params,sign);
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
    public SwapOrderResponse swapOrderRequest(SwapOrderRequest request) {
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
            params.put("contract_code", request.getContractCode().toUpperCase());
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
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_ORDER, params,sign);
            logger.debug("body:{}", body);
            SwapOrderResponse response = JSON.parseObject(body, SwapOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapBatchorderResponse swapBatchorderRequest(SwapBatchorderRequest request) {
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
                        params.put("contract_code", e.getContractCode());

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

            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_BATCHORDER, params,sign);
            logger.debug("body:{}", body);
            SwapBatchorderResponse response = JSON.parseObject(body, SwapBatchorderResponse.class);
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
     */
    @Override
    public SwapCancelResponse swapCancelRequest(SwapCancelRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            params.put("contract_code", request.getContractCode().toUpperCase());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_CANCEL, params,sign);
            logger.debug("body:{}", body);
            SwapCancelResponse response = JSON.parseObject(body, SwapCancelResponse.class);
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
     */
    @Override
    public SwapCancelallResponse swapCancelallRequest(SwapCancelallRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode());
            if (request.getDirection() != null) {
                params.put("direction", request.getDirection());
            }
            if (request.getOffset() != null) {
                params.put("offset", request.getOffset());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_CANCELALL, params,sign);
            logger.debug("body:{}", body);
            SwapCancelallResponse response = JSON.parseObject(body, SwapCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapOrderInfoResponse swapOrderInfoRequest(SwapOrderInfoRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode().toUpperCase());
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_ORDER_INFO, params,sign);
            logger.debug("body:{}", body);
            SwapOrderInfoResponse response = JSON.parseObject(body, SwapOrderInfoResponse.class);
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
     */
    @Override
    public SwapOrderDetailResponse swapOrderDetailRequest(SwapOrderDetailRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", request.getContractCode().toUpperCase());
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
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_ORDER_DETAIL, params,sign);
            logger.debug("body:{}", body);
            SwapOrderDetailResponse response = JSON.parseObject(body, SwapOrderDetailResponse.class);
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
     */
    @Override
    public SwapOpenordersResponse swapOpenordersRequest(SwapOpenordersRequest request) {
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
            params.put("contract_code", request.getContractCode().toUpperCase());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_OPENORDERS, params,sign);
            logger.debug("body:{}", body);
            SwapOpenordersResponse response = JSON.parseObject(body, SwapOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapLightningClosePositionResponse swapLightningClosePositionRequest(SwapLightningClosePositionRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getOrderPriceType())) {
                params.put("order_price_type", request.getOrderPriceType());
            }
            params.put("contract_code", request.getContractCode().toUpperCase());
            params.put("direction", request.getDirection());
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_LIGHTNING_CLOSE_POSITION, params,sign);
            logger.debug("body:{}", body);
            SwapLightningClosePositionResponse response = JSON.parseObject(body, SwapLightningClosePositionResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSwitchLeverRateResponse getSwapSwitchLeverRate(String contractCode, Integer leverRate) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code", contractCode.toUpperCase());
            params.put("lever_rate", leverRate);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SWITCH_LEVER_RATE, params,sign);
            logger.debug("body:{}", body);
            SwapSwitchLeverRateResponse response = JSON.parseObject(body, SwapSwitchLeverRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }



    @Override
    public LinearCancelAfterResponse linearCancelAfterResponse(LinearCancelAfterRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (request.getOnOff() != null) {
                params.put("on_off", request.getOnOff());
            }
            if (request.getTimeOut() != null) {
                params.put("time_out", request.getTimeOut());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.LINEAR_CANCEL_AFTER, params,sign);
            logger.debug("body:{}", body);
            LinearCancelAfterResponse response = JSON.parseObject(body, LinearCancelAfterResponse.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapHisordersV3Response swapHisordersV3Response(SwapHisordersV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContract())) {
                params.put("contract", request.getContract().toUpperCase());
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
            if (request.getType() != null) {
                params.put("type", request.getType());
            }
            if (StringUtils.isNotEmpty(request.getStatus())) {
                params.put("status", request.getStatus());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_HISORDERS_V3, params,sign);
            logger.debug("body:{}", body);
            SwapHisordersV3Response response = JSON.parseObject(body, SwapHisordersV3Response.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapHisordersExactV3Response swapHisordersExactV3Response(SwapHisordersExactV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContract())) {
                params.put("contract", request.getContract().toUpperCase());
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
            if (request.getType() != null) {
                params.put("type", request.getType());
            }
            if (StringUtils.isNotEmpty(request.getStatus())) {
                params.put("status", request.getStatus());
            }
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair());
            }
            if (StringUtils.isNotEmpty(request.getPriceType())) {
                params.put("price_type", request.getPriceType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_HISORDERS_EXACT_V3, params,sign);
            logger.debug("body:{}", body);
            SwapHisordersExactV3Response response = JSON.parseObject(body, SwapHisordersExactV3Response.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapMatchResultsV3Response swapMatchResultsV3Response(SwapMatchResultsV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContract())) {
                params.put("contract", request.getContract().toUpperCase());
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
            if (StringUtils.isNotEmpty(request.getPair())) {
                params.put("pair", request.getPair());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_MATCHRESULTS_V3, params,sign);
            logger.debug("body:{}", body);
            SwapMatchResultsV3Response response = JSON.parseObject(body, SwapMatchResultsV3Response.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapMatchResultsExactV3Response swapMatchResultsExactV3Response(SwapMatchResultsExactV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContract())) {
                params.put("contract", request.getContract().toUpperCase());
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
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_MATCHRESULTS_EXACT_V3, params,sign);
            logger.debug("body:{}", body);
            SwapMatchResultsExactV3Response response = JSON.parseObject(body, SwapMatchResultsExactV3Response.class);
            if (response.getCode() != null && response.getCode() == 200){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapPositionSideResponse swapPositionSideResponse(SwapPositionSideRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getMarginAccount())) {
                params.put("margin_account", request.getMarginAccount());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapAPIConstants.SWAP_POSITION_SIDE, params);
            logger.debug("body:{}", body);
            SwapPositionSideResponse response = JSON.parseObject(body, SwapPositionSideResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())){
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
