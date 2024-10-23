package com.huobi.api.service.coin_swap.transfer;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiCoinMarginedSwapAPIOptions;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.coin_swap.transfer.UsdtSwapTransferRequest;
import com.huobi.api.response.coin_swap.transfer.UsdtSwapTransferResponse;
import com.huobi.api.util.HbdmHttpClient;

import java.util.HashMap;
import java.util.Map;

public class TransferApiServiceImpl implements TransferApiService {

    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String sign = "";
    String url_prex = "https://api.huobi.pro";

    public TransferApiServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }


    /**

     */
    @Override
    public UsdtSwapTransferResponse transfer(UsdtSwapTransferRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("from", request.getFrom());
            params.put("to", request.getTo());
            params.put("currency",request.getCurrency());
            params.put("amount",request.getAmount());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiCoinMarginedSwapAPIOptions.USDT_SWAP_TRANSFER, params,sign);
            UsdtSwapTransferResponse response = JSON.parseObject(body, UsdtSwapTransferResponse.class);
            return response;

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
