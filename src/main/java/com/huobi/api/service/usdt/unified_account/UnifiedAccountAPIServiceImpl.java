package com.huobi.api.service.usdt.unified_account;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.usdt.account.FixPositionMarginChangeRecordRequest;
import com.huobi.api.request.usdt.account.FixPositionMarginChangeRequest;
import com.huobi.api.response.usdt.account.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class UnifiedAccountAPIServiceImpl implements UnifiedAccountAPIService{
    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String sign = "";
    String url_prex = "https://api.hbdm.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    public UnifiedAccountAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }

    @Override
    public UnifiedAccountInfoResponse getUnifiedAccountInfo(String contractCode) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.UNIFIED_ACCOUNT_INFO, params);
            logger.debug("body:{}", body);
            UnifiedAccountInfoResponse response = JSON.parseObject(body, UnifiedAccountInfoResponse.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LinearSwapOverviewAccountInfoResponse getLinearSwapOverviewAccountInfo() {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.LINEAR_SWAP_OVERVIEW_ACCOUNT_INFO, params);
            logger.debug("body:{}", body);
            LinearSwapOverviewAccountInfoResponse response = JSON.parseObject(body, LinearSwapOverviewAccountInfoResponse.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LinearSwapFeeSwitchResponse getLinearSwapFeeSwitch(Integer feeOption) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.LINEAR_SWAP_FEE_SWITCH, params,sign);
            logger.debug("body:{}", body);
            LinearSwapFeeSwitchResponse response = JSON.parseObject(body, LinearSwapFeeSwitchResponse.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public FixPositionMarginChangeResponse getFixPositionMarginChange(FixPositionMarginChangeRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (request.getAmount() != null) {
                params.put("amount", request.getAmount());
            }
            if (StringUtils.isNotEmpty(request.getAsset())) {
                params.put("asset", request.getAsset());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (request.getType() != null) {
                params.put("type" ,request.getType());
            }
            if (request.getDirection() != null) {
                params.put("direction", request.getDirection());
            }
            if (request.getClientOrderId() != null) {
                params.put("clientOrderId", request.getClientOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.FIX_POSITION_MARGIN_CHANGE, params,sign);
            logger.debug("body:{}", body);
            FixPositionMarginChangeResponse response = JSON.parseObject(body, FixPositionMarginChangeResponse.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public FixPositionMarginChangeRecordResponse getFixPositionMarginChangeRecord(FixPositionMarginChangeRecordRequest request) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(request.getAsset())) {
                params.put("asset", request.getAsset());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
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
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.FIX_POSITION_MARGIN_CHANGE_RECORD, params);
            logger.debug("body:{}", body);
            FixPositionMarginChangeRecordResponse response = JSON.parseObject(body, FixPositionMarginChangeRecordResponse.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapUnifiedAccountTypeResponse getSwapUnifiedAccountType() {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_UNIFIED_ACCOUNT_TYPE, params);
            logger.debug("body:{}", body);
            SwapUnifiedAccountTypeResponse response = JSON.parseObject(body, SwapUnifiedAccountTypeResponse.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public SwapSwitchAccountTypeResponse getSwapSwitchAccountType(Integer accountType) {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            if (accountType != null) {
                params.put("account_type", accountType);
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiLinearSwapAPIConstants.SWAP_SWITCH_ACCOUNT_TYPE, params,sign);
            logger.debug("body:{}", body);
            SwapSwitchAccountTypeResponse response = JSON.parseObject(body, SwapSwitchAccountTypeResponse.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
