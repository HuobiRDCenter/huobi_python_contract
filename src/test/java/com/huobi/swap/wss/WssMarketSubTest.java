package com.huobi.swap.wss;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.huobi.wss.event.*;
import com.huobi.wss.handle.WssMarketHandle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.List;

public class WssMarketSubTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String URL = "wss://api.hbdm.com/swap-ws";//合约站行情请求以及订阅地址
    WssMarketHandle wssMarketHandle = new WssMarketHandle(URL);


    /**
     * 订阅 KLine 数据
     *
     * 注：一个webSocket 可以一次订阅多个
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USD.kline.1min");
       // channels.add("market.BTC-USD.kline.5min");
       // channels.add("market.BTC-USD.kline.15min");
       // channels.add("market.BTC-USD.kline.30min");
       // channels.add("market.BTC-USD.kline.60min");
       // channels.add("market.BTC-USD.kline.4hour");
       // channels.add("market.BTC-USD.kline.1day");
       // channels.add("market.BTC-USD.kline.1week");
       // channels.add("market.BTC-USD.kline.1mon");

        wssMarketHandle.sub(channels, response -> {
            logger.info("kLineEvent用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketKLineSubResponse event = JSON.parseObject(response, MarketKLineSubResponse.class);
            logger.info("kLineEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);


    }


    /**
     * 订阅 Market Depth 数据
    *
     * 注：一个webSocket 可以一次订阅多个
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void test2() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USD.depth.step6");
        //channels.add("market.BTC-USD.depth.size_20.high_freq");
        wssMarketHandle.sub(channels, response -> {
            logger.info("depthEvent用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketDepthSubResponse event = JSON.parseObject(response, MarketDepthSubResponse.class);
            logger.info("depthEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
            logger.info("数据大小为:{}", event.getTick().getAsks().size());
        });
        Thread.sleep(Integer.MAX_VALUE);

    }


    /**
     * 订阅 Market detail 数据
     *
     * 注：一个webSocket 可以一次订阅多个
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void test3() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USD.detail");
        wssMarketHandle.sub(channels, response -> {
            logger.info("detailEvent用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketDetailSubResponse event = JSON.parseObject(response, MarketDetailSubResponse.class);
            logger.info("detailEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }


    /**
     * 订阅 Trade Detail 数据
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void test4() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USD.trade.detail");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅TradeDetail数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketTradeDetailSubResponse event = JSON.parseObject(response, MarketTradeDetailSubResponse.class);
            logger.info("tradeDetailEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
                  });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test5() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USD.depth.size_20.high_freq");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅Market Depth增量数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketDepthDiffSubResponse event = JSON.parseObject(response, MarketDepthDiffSubResponse.class);
            logger.info("订阅Market Depth增量数据的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test6() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC-USD.bbo");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅买一卖一逐笔行情推送用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketBboSubResponse event = JSON.parseObject(response, MarketBboSubResponse.class);
            logger.info("订阅买一卖一逐笔行情推送的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
