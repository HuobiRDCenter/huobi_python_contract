package com.huobi.usdt.wss;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.huobi.wss.event.*;
import com.huobi.wss.handle.WssMarketHandle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.List;

public class WssIndexSubTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String URL = "wss://api.hbdm.com/ws_index";
    WssMarketHandle wssMarketHandle = new WssMarketHandle(URL);
    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USDT.index.1min");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅(sub)指数K线数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketIndexSubResponse event = JSON.parseObject(response, MarketIndexSubResponse.class);
            logger.info("订阅(sub)指数K线数据的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test2() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USDT.premium_index.1min");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅溢价指数K线数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketPremiumIndexSubResponse event = JSON.parseObject(response, MarketPremiumIndexSubResponse.class);
            logger.info("订阅溢价指数K线数据的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test3() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.btc-usdt.estimated_rate.1min");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅预测资金费率K线数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketEstimatedRateSubResponse event = JSON.parseObject(response, MarketEstimatedRateSubResponse.class);
            logger.info("订阅预测资金费率K线数据的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test4() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USDT.basis.1min.open");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅基差数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketBasisPriceTypeSubResponse event = JSON.parseObject(response, MarketBasisPriceTypeSubResponse.class);
            logger.info("订阅基差数据的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test5() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USDT.mark_price.1min");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅标记价格K线数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketMarkPriceSubResponse event = JSON.parseObject(response, MarketMarkPriceSubResponse.class);
            logger.info("订阅标记价格K线数据的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
