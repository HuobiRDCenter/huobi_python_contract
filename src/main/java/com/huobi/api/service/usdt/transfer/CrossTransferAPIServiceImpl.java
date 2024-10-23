package com.huobi.api.service.usdt.transfer;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiLinearSwapCrossAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.response.usdt.market.SwapCrossTransferStateResponse;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CrossTransferAPIServiceImpl implements CrossTransferAPIService{
    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String url_prex = "https://api.hbdm.com";
    Logger logger = LoggerFactory.getLogger(getClass());

    public CrossTransferAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }

    @Override
    public SwapCrossTransferStateResponse getSwapCrossTransferState(String marginAccount) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNoneEmpty(marginAccount)) {
                params.put("margin_account", marginAccount.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiLinearSwapCrossAPIConstants.SWAP_CROSS_TRANSFER_STATE, params);
            logger.debug("body:{}", body);
            SwapCrossTransferStateResponse response = JSON.parseObject(body, SwapCrossTransferStateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
