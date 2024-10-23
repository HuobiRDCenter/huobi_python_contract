package com.huobi.api.service.usdt.reference;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapCrossAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.response.usdt.market.SwapCrossAdjustfactorResponse;
import com.huobi.api.response.usdt.market.SwapLadderMarginResponse;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CrossReferenceAPIServiceImpl implements CrossReferenceAPIService{
    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String url_prex = "https://api.hbdm.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    public CrossReferenceAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }

    @Override
    public SwapLadderMarginResponse getSwapCrossLadderMargin(String contractCode, String contractType, String pair, String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(pair)){
                params.put("pair",pair.toUpperCase());
            }
            if (StringUtils.isNotEmpty(contractType)){
                params.put("contract_type",contractType);
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_LADDER_MARGIN, params);
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
    public SwapCrossAdjustfactorResponse getSwapCrossAdjustfactor(String contractCode, String contractType, String pair, String businessType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(contractCode)) {
                params.put("contract_code", contractCode.toUpperCase());
            }
            if (StringUtils.isNotEmpty(pair)){
                params.put("pair",pair.toUpperCase());
            }
            if (StringUtils.isNotEmpty(contractType)){
                params.put("contract_type",contractType);
            }
            if (StringUtils.isNotEmpty(businessType)){
                params.put("business_type",businessType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_ADJUSTFACTOR, params);
            logger.debug("body:{}", body);
            SwapCrossAdjustfactorResponse response = JSON.parseObject(body, SwapCrossAdjustfactorResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
