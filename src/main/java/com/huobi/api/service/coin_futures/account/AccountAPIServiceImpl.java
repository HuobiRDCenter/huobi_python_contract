package com.huobi.api.service.coin_futures.account;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.exception.ApiException;

import com.huobi.api.request.coin_futures.account.*;

import com.huobi.api.response.coin_futures.account.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class AccountAPIServiceImpl implements AccountAPIService {

    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
//    这里的sign代表着是使用hmac256签名方法还是Ed25519签名方法。这里的key和secret代表了公钥和私钥。也就是hmac签名里面的accesskey和secretkey。在ed25519签名就是publickey和privatekey
//    The sign indicates whether to use the hmac256 signature method or the Ed25519 signature method.Here key and secret stand for public and private keys. The accesskey and secretkey in the hmac signature. In ed25519, signatures are PublicKeys and privateKeys

    String sign = "256";
    String url_prex = "https://api.hbdm.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    public AccountAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }

    @Override
    public ContractAccountInfoResponse getContractAccountInfo(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ACCOUNT_INFO, params,sign);
            ContractAccountInfoResponse response = JSON.parseObject(body, ContractAccountInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractPositionInfoResponse getContractPositionInfo(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_POSITION_INFO, params,sign);
            ContractPositionInfoResponse response = JSON.parseObject(body, ContractPositionInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSubAccountListResponse getContractSubAccountList(String symbol, String direct, Long fromId) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            if (StringUtils.isNotEmpty(direct)) {
                params.put("direct", direct);
            }
            if (fromId != null) {
                params.put("from_id", fromId);
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_SUB_ACCOUNT_LIST, params,sign);
            ContractSubAccountListResponse response = JSON.parseObject(body, ContractSubAccountListResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSubAccountInfoResponse getContractSubAccountInfo(String symbol, Long subUid) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            params.put("sub_uid", subUid);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_SUB_ACCOUNT_INFO, params,sign);
            ContractSubAccountInfoResponse response = JSON.parseObject(body, ContractSubAccountInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSubPositionInfoResponse getContractSubPositionInfo(String symbol, Long subUid) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            params.put("sub_uid", subUid);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_SUB_POSITION_INFO, params,sign);
            ContractSubPositionInfoResponse response = JSON.parseObject(body, ContractSubPositionInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractOrderLimitResponse getContractOrderLimitResponse(String symbol, String orderPriceType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            params.put("order_price_type", orderPriceType);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER_LIMIT, params,sign);
            ContractOrderLimitResponse response = JSON.parseObject(body, ContractOrderLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractFeeResponse getContractFeeResponse(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_FEE, params,sign);
            ContractFeeResponse response = JSON.parseObject(body, ContractFeeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractTransferLimitResponse getContractTransferLimitResponse(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_TRANSFER_LIMIT, params,sign);
            ContractTransferLimitResponse response = JSON.parseObject(body, ContractTransferLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractPositionLimitResponse getContractPositionLimitResponse(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_POSITION_LIMIT, params,sign);
            ContractPositionLimitResponse response = JSON.parseObject(body, ContractPositionLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractMasterSubTransferResponse getContractMasterSubTransfer(ContractMasterSubTransferRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("sub_uid", request.getSubUid());
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("amount", request.getAmount());
            params.put("type", request.getType());
            params.put("client_order_id", request.getClientOrderId());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_MASTER_SUB_TRANSFER, params,sign);
            ContractMasterSubTransferResponse response = JSON.parseObject(body, ContractMasterSubTransferResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractAccountPositionInfoResponse getContractAccountPositionInfo(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol.toUpperCase());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ACCOUNT_POSITION_INFO, params,sign);
            ContractAccountPositionInfoResponse response = JSON.parseObject(body, ContractAccountPositionInfoResponse.class);
            logger.debug("body:{}", body);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractUserSettlementRecordsResponse getContractUserSettlementRecords(ContractUserSettlementRecordsRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getStartTime() != null) {
                params.put("start_time", request.getStartTime());
            }
            if (request.getEndTime() != null) {
                params.put("end_time", request.getEndTime());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_USER_SETTLEMENT_RECORDS, params,sign);
            ContractUserSettlementRecordsResponse response = JSON.parseObject(body, ContractUserSettlementRecordsResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractMasterSubTransferRecordResponse getContractMasterSubTransferRecord(ContractMasterSubTransferRecordRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
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
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_MASTER_SUB_TRANSFER_RECORD, params,sign);
            ContractMasterSubTransferRecordResponse response = JSON.parseObject(body, ContractMasterSubTransferRecordResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractApiTradingStatusResponse getContractApiTradingStatus() {
        String body;
        Map<String, Object> params = new HashMap<>();
        try {
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_API_TRADING_STATUS, params);
            logger.debug("body:{}", body);
            ContractApiTradingStatusResponse response = JSON.parseObject(body, ContractApiTradingStatusResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractAvailableLevelRateResponse getContractAvailableLevelRate(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol.toUpperCase());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_AVAILABLE_LEVEL_RATE, params,sign);
            ContractAvailableLevelRateResponse response = JSON.parseObject(body, ContractAvailableLevelRateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSubAuthResponse getContractSubAuth(String subUid, Integer subAuth) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("sub_uid", subUid);
            params.put("sub_auth",subAuth);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_SUB_AUTH, params,sign);
            logger.debug("body:{}",body);
            ContractSubAuthResponse response = JSON.parseObject(body, ContractSubAuthResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSubAccountInfoListResponse getContractSubAccountInfoList(ContractSubAccountInfoListRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())){
                params.put("symbol",request.getSymbol().toUpperCase());
            }
            if (request.getPageIndex()!=null){
                params.put("page_index",request.getPageIndex());
            }
            if (request.getPageSize()!=null){
                params.put("page_size",request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_SUB_ACCOUNT_INFO_LIST, params,sign);
            logger.debug("body:{}",body);
            ContractSubAccountInfoListResponse response = JSON.parseObject(body, ContractSubAccountInfoListResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractBalanceValuationResponse getContractBalanceValuation(String ValuationAsset) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(ValuationAsset)){
                params.put("valuation_asset",ValuationAsset.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_BALANCE_VALUATION, params,sign);
            logger.debug("body:{}",body);
            ContractBalanceValuationResponse response = JSON.parseObject(body, ContractBalanceValuationResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractFinancialRecordV3Response getContractFinancialRecordV3(ContractFinancialRecordV3Request request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
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
            if (StringUtils.isNotEmpty(request.getType())) {
                params.put("type", request.getType());
            }
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_FINANCIAL_RECORD_V3, params,sign);
            logger.debug("body:{}",body);
            ContractFinancialRecordV3Response response = JSON.parseObject(body, ContractFinancialRecordV3Response.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractFinancialRecordExactV3Response getContractFinancialRecordExactV3(ContractFinancialRecordExactV3Request request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
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
            if (StringUtils.isNotEmpty(request.getType())) {
                params.put("type", request.getType());
            }
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_FINANCIAL_RECORD_EXACT_V3, params,sign);
            logger.debug("body:{}",body);
            ContractFinancialRecordExactV3Response response = JSON.parseObject(body, ContractFinancialRecordExactV3Response.class);
            if (response.getCode() != null && response.getCode() == 200) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractSubAuthListResponse getContractSubAuthList(ContractSubAuthListRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
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
            body = HbdmHttpClient.getInstance().doGetKey(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_SUB_AUTH_LIST, params);
            logger.debug("body:{}",body);
            ContractSubAuthListResponse response = JSON.parseObject(body, ContractSubAuthListResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
