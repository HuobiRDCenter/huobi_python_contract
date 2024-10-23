package com.huobi.api.service.usdt.account;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.usdt.account.*;
import com.huobi.api.response.usdt.account.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountAPIServiceImpl implements AccountAPIService {

    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String sign = "";
    String url_prex = "https://api.hbdm.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    public AccountAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }


    @Override
    public SwapAccountInfoResponse getSwapAccountInfo(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase().toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_ACCOUNT_INFO, params,sign);
            logger.debug("body:{}", body);
            SwapAccountInfoResponse response = JSON.parseObject(body, SwapAccountInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapPositionInfoResponse getSwapPositionInfo(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase().toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_POSITION_INFO, params,sign);
            logger.debug("body:{}", body);
            SwapPositionInfoResponse response = JSON.parseObject(body, SwapPositionInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapAccountPositionInfoResponse getSwapAccountPositionInfo(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract_code", contractCode.toUpperCase().toUpperCase());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_ACCOUNT_POSITION_INFO, params,sign);
            logger.debug("body:{}", body);
            SwapAccountPositionInfoResponse response = JSON.parseObject(body, SwapAccountPositionInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSubAccountListResponse getSwapSubAccountList(String contractCode, String direct, Long fromId) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase().toUpperCase());
            }
            if (StringUtils.isNotEmpty(direct)) {
                params.put("direct", direct);
            }
            if (fromId != null) {
                params.put("from_id", fromId);
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SUB_ACCOUNT_LIST, params,sign);
            logger.debug("body:{}", body);
            SwapSubAccountListResponse response = JSON.parseObject(body, SwapSubAccountListResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSubAccountInfoResponse getSwapSubAccountInfo(String contractCode, Long subUid) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase().toUpperCase());
            }
            params.put("sub_uid", subUid);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SUB_ACCOUNT_INFO, params,sign);
            logger.debug("body:{}", body);
            SwapSubAccountInfoResponse response = JSON.parseObject(body, SwapSubAccountInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSubPositionInfoResponse getSwapSubPositionInfo(String contractCode, Long subUid) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase().toUpperCase());
            }
            params.put("sub_uid", subUid);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SUB_POSITION_INFO, params,sign);
            logger.debug("body:{}", body);
            SwapSubPositionInfoResponse response = JSON.parseObject(body, SwapSubPositionInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapOrderLimitResponse getSwapOrderLimitResponse(String contractCode, String orderPriceType,String pair,String contractType,String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if(StringUtils.isNotEmpty(pair)){
                params.put("pair",pair.toUpperCase());
            }
            if(contractType!=null){
                params.put("contrat_type",contractType);
            }
            if (businessType!=null){
                params.put("business_type",businessType);
            }
            params.put("order_price_type", orderPriceType);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_ORDER_LIMIT, params,sign);
            logger.debug("body:{}", body);
            SwapOrderLimitResponse response = JSON.parseObject(body, SwapOrderLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapFeeResponse getSwapFeeResponse(String contractCode,String pair,String contractType,String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if(StringUtils.isNotEmpty(pair)){
                params.put("pair",pair.toUpperCase());
            }
            if(contractType!=null){
                params.put("contrat_type",contractType);
            }
            if (businessType!=null){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_FEE, params,sign);
            logger.debug("body:{}", body);
            SwapFeeResponse response = JSON.parseObject(body, SwapFeeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTransferLimitResponse getSwapTransferLimitResponse(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_TRANSFER_LIMIT, params,sign);
            logger.debug("body:{}", body);
            SwapTransferLimitResponse response = JSON.parseObject(body, SwapTransferLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapPositionLimitResponse getSwapPositionLimitResponse(String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_POSITION_LIMIT, params,sign);
            logger.debug("body:{}", body);
            SwapPositionLimitResponse response = JSON.parseObject(body, SwapPositionLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapMasterSubTransferResponse getSwapMasterSubTransferResponse(SwapMasterSubTransferRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("sub_uid", request.getSubUid());
            params.put("asset", request.getAsset().toUpperCase());
            params.put("from_margin_account", request.getFromMarginAccount().toUpperCase());
            params.put("to_margin_account", request.getToMarginAccount().toUpperCase());
            params.put("amount", request.getAmount());
            params.put("type", request.getType());
            if (request.getClientOrderId()!=null && request.getClientOrderId()!=0){
                params.put("client_order_id",request.getClientOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_MASTER_SUB_TRANSFER, params,sign);
            logger.debug("body:{}", body);
            SwapMasterSubTransferResponse response = JSON.parseObject(body, SwapMasterSubTransferResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapMasterSubTransferRecordResponse getSwapMasterSubTransferRecordResponse(SwapMasterSubTransferRecordRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("margin_account", request.getMarginAccount().toUpperCase());
            if (request.getTransferType() != null) {
                params.put("transfer_type", request.getTransferType());
            }
            params.put("create_date", request.getCreateDate());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_MASTER_SUB_TRANSFER_RECORD, params,sign);
            logger.debug("body:{}", body);
            SwapMasterSubTransferRecordResponse response = JSON.parseObject(body, SwapMasterSubTransferRecordResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapTransferInnerResponse getSwapTransferInner(String asset, String fromMarginAccount, String toMarginAccount, BigDecimal amount, Long clientOrderId) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("asset", asset);
            params.put("from_margin_account", fromMarginAccount);
            params.put("to_margin_account", toMarginAccount);
            params.put("amount", amount);
            if (clientOrderId!=null && clientOrderId!=0){
                params.put("client_order_id",clientOrderId);
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_TRANSFER_INNER, params,sign);
            logger.debug("body:{}", body);
            SwapTransferInnerResponse response = JSON.parseObject(body, SwapTransferInnerResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapApiTradingStatusResponse getSwapApiTradingStatusResponse() {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_API_TRADING_STATUS, params);
            logger.debug("body:{}", body);
            SwapApiTradingStatusResponse response = JSON.parseObject(body, SwapApiTradingStatusResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapAvailableLevelRateResponse getSwapAvailableLevelRate(String contractCode) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_AVAILABLE_LEVEL_RATE, params,sign);
            logger.debug("body:{}", body);
            SwapAvailableLevelRateResponse response = JSON.parseObject(body, SwapAvailableLevelRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSubAuthResponse getSwapSubAuth(String subUid, Integer subAuth) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("sub_uid", subUid);
            params.put("sub_auth", subAuth);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SUB_AUTH, params,sign);
            logger.debug("body:{}", body);
            SwapSubAuthResponse response = JSON.parseObject(body, SwapSubAuthResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSubAccountInfoListResponse getSwapSubAccountInfoList(String contractCode, Integer pageIndex, Integer pageSize) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            params.put("contract_code", contractCode);
            if (pageIndex != null) {
                params.put("page_index", pageIndex);
            }
            if (pageSize != null) {
                params.put("page_size", pageSize);
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SUB_ACCOUNT_INFO_LIST, params,sign);
            logger.debug("body:{}", body);
            SwapSubAccountInfoListResponse response = JSON.parseObject(body, SwapSubAccountInfoListResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapBalanceValuationResponse getSwapBalanceValuation(String ValuationAsset) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(ValuationAsset)){
                params.put("valuation_asset",ValuationAsset.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_BALANCE_VALUATION, params,sign);
            logger.debug("body:{}", body);
            SwapBalanceValuationResponse response = JSON.parseObject(body, SwapBalanceValuationResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapLeverPositionLimitResponse getSwapLeverPositionLimit(String contractCode, Integer leverRate) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(contractCode)){
                params.put("contract_code",contractCode.toUpperCase());
            }
            if (leverRate!=null && leverRate!=0){
                params.put("lever_rate",leverRate);
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_LEVER_POSITION_LIMIT, params,sign);
            logger.debug("body:{}", body);
            SwapLeverPositionLimitResponse response = JSON.parseObject(body, SwapLeverPositionLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapFinancialRecordV3Response getSwapFinancialRecordV3(SwapFinancialRecordV3Request request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("contract", request.getContract().toUpperCase());
            if (StringUtils.isNoneEmpty(request.getMarAcct())) {
                params.put("mar_acct", request.getMarAcct());
            }
            if (StringUtils.isNotEmpty(request.getType())) {
                params.put("type", request.getType());
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
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_FINANCIAL_RECORD_V3, params,sign);
            logger.debug("body:{}", body);
            SwapFinancialRecordV3Response response = JSON.parseObject(body, SwapFinancialRecordV3Response.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapFinancialRecordExactV3Response getSwapFinancialRecordExactV3(SwapFinancialRecordExactV3Request request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getContract())) {
                params.put("contract", request.getContract().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getMarAcct())) {
                params.put("mar_acct", request.getMarAcct());
            }
            if (StringUtils.isNotEmpty(request.getType())) {
                params.put("type", request.getType());
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
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_FINANCIAL_RECORD_EXACT_V3, params,sign);
            logger.debug("body:{}", body);
            SwapFinancialRecordExactV3Response response = JSON.parseObject(body, SwapFinancialRecordExactV3Response.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSubAuthListResponse getSwapSubAuthList(SwapSubAuthListRequest request) {
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
            if (StringUtils.isNotEmpty(request.getSubUid())) {
                params.put("sub_uid", request.getSubUid());
            }
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SUB_AUTH_LIST, params);
            logger.debug("body:{}", body);
            SwapSubAuthListResponse response = JSON.parseObject(body, SwapSubAuthListResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

}
