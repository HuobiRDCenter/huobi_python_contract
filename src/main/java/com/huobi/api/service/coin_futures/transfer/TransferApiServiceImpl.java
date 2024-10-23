package com.huobi.api.service.coin_futures.transfer;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.coin_futures.transfer.AccountTransferRequest;
import com.huobi.api.response.coin_futures.transfer.AccountTransferResponse;
import com.huobi.api.response.coin_futures.transfer.FuturesTransferResponse;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.Struct;
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
     * @param currency 币
     * @param amount   金额  注意划转的金额精度
     * @param type     从合约账户到现货账户：“futures-to-pro”，从现货账户到合约账户： “pro-to-futures”
     * @return
     */
    @Override
    public FuturesTransferResponse transfer(String currency, BigDecimal amount, String type) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("currency", currency.toLowerCase());
            params.put("amount", amount);
            params.put("type", type);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.FUTURES_TRANSFER, params,sign);
            FuturesTransferResponse response = JSON.parseObject(body, FuturesTransferResponse.class);
            return response;

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    @Override
    public AccountTransferResponse accountTransfer(AccountTransferRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getFrom())) {
                params.put("from", request.getFrom());
            }
            if (StringUtils.isNotEmpty(request.getTo())) {
                params.put("to", request.getTo());
            }
            if (StringUtils.isNotEmpty(request.getCurrency())) {
                params.put("currency", request.getCurrency());
            }
            if (request.getAmount() !=  null) {
                params.put("amount", request.getAmount());
            }
            if (StringUtils.isNotEmpty(request.getMarginAccount())) {
                params.put("margin-account", request.getMarginAccount());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.ACCOUNT_TRANSFER, params,sign);
            AccountTransferResponse response = JSON.parseObject(body, AccountTransferResponse.class);
            return response;

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
