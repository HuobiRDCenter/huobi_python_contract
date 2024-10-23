package com.huobi.usdt.wss;

import com.alibaba.fastjson.JSON;
import com.huobi.wss.event.*;
import com.huobi.wss.handle.WssMarketReqHandle;
import com.huobi.wss.request.WssRequest;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.Date;

public class WssIndexReqTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String URL = "wss://api.hbdm.com/ws_index";
    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        WssMarketReqHandle wssMarketReqHandle = new WssMarketReqHandle(URL, response -> {
            logger.info("请求(req)指数K线数据用户收到的原始数据:{}", response);
            MarketIndexReqResponse reqResponse = JSON.parseObject(response, MarketIndexReqResponse.class);
            logger.info("请求(req)指数K线数据解析之后的数据为:{}", JSON.toJSON(reqResponse));
        });
        while (true) {
            try {
                Date fromDate = DateUtils.parseDate("2020-09-15T00:00:00", "yyyy-MM-dd'T'HH:mm:ss");
                Date toDate = DateUtils.parseDate("2020-10-30T00:00:01", "yyyy-MM-dd'T'HH:mm:ss");
                WssRequest request = WssRequest.builder()
                        .req("market.btc-usdt.index.1min")
                        .from(fromDate.getTime() / 1000)
                        .to(toDate.getTime() / 1000)
                        .build();
                wssMarketReqHandle.doReq(JSON.toJSONString(request));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void test2() throws URISyntaxException, InterruptedException {
        WssMarketReqHandle wssMarketReqHandle = new WssMarketReqHandle(URL, response -> {
            logger.info("请求溢价指数K线数据用户收到的原始数据:{}", response);
            MarketPremiumIndexReqResponse reqResponse = JSON.parseObject(response, MarketPremiumIndexReqResponse.class);
            logger.info("请求溢价指数K线数据解析之后的数据为:{}", JSON.toJSON(reqResponse));
        });
        while (true) {
            try {
                Date fromDate = DateUtils.parseDate("2020-09-15T00:00:00", "yyyy-MM-dd'T'HH:mm:ss");
                Date toDate = DateUtils.parseDate("2020-10-30T00:00:01", "yyyy-MM-dd'T'HH:mm:ss");
                WssRequest request = WssRequest.builder()
                        .req("market.BTC-USDT.premium_index.1min")
                        .from(fromDate.getTime() / 1000)
                        .to(toDate.getTime() / 1000)
                        .build();
                wssMarketReqHandle.doReq(JSON.toJSONString(request));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void test3() throws URISyntaxException, InterruptedException {
        WssMarketReqHandle wssMarketReqHandle = new WssMarketReqHandle(URL, response -> {
            logger.info("请求预测资金费率K线数据用户收到的原始数据:{}", response);
            MarketEstimatedRateReqResponse reqResponse = JSON.parseObject(response, MarketEstimatedRateReqResponse.class);
            logger.info("请求预测资金费率K线数据解析之后的数据为:{}", JSON.toJSON(reqResponse));
        });
        while (true) {
            try {
                Date fromDate = DateUtils.parseDate("2020-09-15T00:00:00", "yyyy-MM-dd'T'HH:mm:ss");
                Date toDate = DateUtils.parseDate("2020-10-30T00:00:01", "yyyy-MM-dd'T'HH:mm:ss");
                WssRequest request = WssRequest.builder()
                        .req("market.BTC-USDT.estimated_rate.1min")
                        .from(fromDate.getTime() / 1000)
                        .to(toDate.getTime() / 1000)
                        .build();
                wssMarketReqHandle.doReq(JSON.toJSONString(request));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void test4() throws URISyntaxException, InterruptedException {
        WssMarketReqHandle wssMarketReqHandle = new WssMarketReqHandle(URL, response -> {
            logger.info("请求基差数据用户收到的原始数据:{}", response);
            MarketBasisPriceTypeReqResponse reqResponse = JSON.parseObject(response, MarketBasisPriceTypeReqResponse.class);
            logger.info("请求基差数据解析之后的数据为:{}", JSON.toJSON(reqResponse));
        });
        while (true) {
            try {
                Date fromDate = DateUtils.parseDate("2020-09-15T00:00:00", "yyyy-MM-dd'T'HH:mm:ss");
                Date toDate = DateUtils.parseDate("2020-10-30T00:00:01", "yyyy-MM-dd'T'HH:mm:ss");
                WssRequest request = WssRequest.builder()
                        .req("market.btc-usdt.basis.1min.open")
                        .from(fromDate.getTime() / 1000)
                        .to(toDate.getTime() / 1000)
                        .build();
                wssMarketReqHandle.doReq(JSON.toJSONString(request));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void test5() throws URISyntaxException, InterruptedException {
        WssMarketReqHandle wssMarketReqHandle = new WssMarketReqHandle(URL, response -> {
            logger.info("请求标记价格K线数据用户收到的原始数据:{}", response);
            MarketMarkPriceReqResponse reqResponse = JSON.parseObject(response, MarketMarkPriceReqResponse.class);
            logger.info("请求标记价格K线数据解析之后的数据为:{}", JSON.toJSON(reqResponse));
        });
        while (true) {
            try {
                Date fromDate = DateUtils.parseDate("2020-09-15T00:00:00", "yyyy-MM-dd'T'HH:mm:ss");
                Date toDate = DateUtils.parseDate("2020-10-30T00:00:01", "yyyy-MM-dd'T'HH:mm:ss");
                WssRequest request = WssRequest.builder()
                        .req("market.BTC-USDT.mark_price.5min")
                        .from(fromDate.getTime() / 1000)
                        .to(toDate.getTime() / 1000)
                        .build();
                wssMarketReqHandle.doReq(JSON.toJSONString(request));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.sleep(1000);
            }
        }
    }
}
