package com.huobi.future.wss;

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

    private String URL = "wss://api.hbdm.com/ws_index";//合约站行情请求以及订阅地址
    WssMarketHandle wssMarketHandle = new WssMarketHandle(URL);

    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USD.index.1min");
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
        channels.add("market.BTC_CW.basis.1min.open");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅(sub)基差数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketBasisPriceTypeSubResponse event = JSON.parseObject(response, MarketBasisPriceTypeSubResponse.class);
            logger.info("订阅(sub)基差数据的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test3() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC_CW.mark_price.1min");
        wssMarketHandle.sub(channels, response -> {
            logger.info("请求标记价格K线数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketMarkPriceSubResponse event = JSON.parseObject(response, MarketMarkPriceSubResponse.class);
            logger.info("请求标记价格K线数据的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }


}
