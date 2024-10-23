package com.huobi.api.service.coin_futures.market;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.coin_futures.account.ContractSettlementRecordsRequest;
import com.huobi.api.request.coin_futures.market.ContractLiquidationOrdersV3Request;
import com.huobi.api.response.coin_futures.market.*;
import com.huobi.api.response.usdt.market.BatchMergedV2Response;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MarketAPIServiceImpl implements MarketAPIService {

    String url_prex = "https://api.hbdm.com";
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public MarketDepthResponse getMarketDepth(String symbol, String type) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            if (StringUtils.isNotEmpty(type)) {
                params.put("type", type);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_DEPTH, params);
            MarketDepthResponse response = JSON.parseObject(body, MarketDepthResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    /**
     * 获取K线数据
     *
     * @param symbol 合约名称 如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
     * @param period K线类型  1min, 5min, 15min, 30min, 60min,4hour,1day, 1mon
     * @param size   获取数量  默认： 150	 取值范围：[1,2000]
     * @return
     */
    @Override
    public MarketHistoryKlineResponse getMarketHistoryKline(String symbol, String period, Integer size, Long from, Long to) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol.toUpperCase());
            params.put("period", period);
            params.put("size", size);
            params.put("from", from);
            params.put("to", to);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_HISTORY_KLINE, params);
            MarketHistoryKlineResponse response = JSON.parseObject(body, MarketHistoryKlineResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketDetailMergedResponse getMarketDetailMerged(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_DETAIL_MERGED, params);
            MarketDetailMergedResponse response = JSON.parseObject(body, MarketDetailMergedResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketTradeResponse getMarketTrade(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_TRADE, params);
            MarketTradeResponse response = JSON.parseObject(body, MarketTradeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketHistoryTradeResponse getMarketHistoryTrade(String symbol, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            if (size != null) {
                params.put("size", size);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_HISTORY_TRADE, params);
            MarketHistoryTradeResponse response = JSON.parseObject(body, MarketHistoryTradeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    /**
     * 查询系统状态
     *
     * @param symbol 如果缺省，默认返回所有品种
     * @return
     */


    @Override
    public MarketHistoryIndexResponse getMarketHistoryIndex(String symbol, String period, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol.toUpperCase());
            params.put("period",period);
            params.put("size",size);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_HISTORY_INDEX, params);
            MarketHistoryIndexResponse response = JSON.parseObject(body, MarketHistoryIndexResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketHistoryBasisResponse getMarketHistoryBasis(String symbol, String period, String basisPriceType, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol.toUpperCase());
            params.put("period",period);
            params.put("size",size);
            if (basisPriceType!=null){
                params.put("basis_price_type",basisPriceType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_HISTORY_BASIS, params);
            MarketHistoryBasisResponse response = JSON.parseObject(body, MarketHistoryBasisResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarkPriceKlineResponse getMarkPriceKline(String symbol, String period, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol",symbol.toUpperCase());
            params.put("period",period);
            params.put("size",size);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARK_PRICE_KLINE, params);
            logger.debug("body:{}",body);
            MarkPriceKlineResponse response = JSON.parseObject(body, MarkPriceKlineResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketBboResponse getMarketBbo(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_BBO, params);
            logger.debug("body:{}",body);
            MarketBboResponse response = JSON.parseObject(body, MarketBboResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }



    @Override
    public BatchMergedV2Response getBatchMergedV2(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.BATCH_MERGED_V2, params);
            logger.debug("body:{}",body);
            BatchMergedV2Response response = JSON.parseObject(body, BatchMergedV2Response.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

}
