package com.huobi.usdt.wss;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.huobi.wss.event.*;
import com.huobi.wss.handle.WssNotificationHandle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.List;


public class WssNotificationSubTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String host = "api.hbdm.com";
    private String url = "/linear-swap-notification";
    private String sign="256";
    WssNotificationHandle wssNotificationHandle = new WssNotificationHandle(host, url, "", "",sign);

    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("orders.btc-usdt");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            OrdersSubResponse event = JSON.parseObject(response, OrdersSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test2() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("orders_cross.btc-usdt");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            OrdersSubResponse event = JSON.parseObject(response, OrdersSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test3() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("accounts.BTC-USDT");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            AccountsSubResponse event = JSON.parseObject(response, AccountsSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test4() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("accounts_cross.USDT");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            AccountCrossSubResponse event = JSON.parseObject(response, AccountCrossSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test5() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("positions.BTC-USDT");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PositionsSubResponse event = JSON.parseObject(response, PositionsSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test6() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("positions_cross.BTC-USDT");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PositionsSubResponse event = JSON.parseObject(response, PositionsSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test7() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.BTC-USDT.liquidation_orders");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicSubResponse event = JSON.parseObject(response, PublicSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test8() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.btc-usdt.funding_rate");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicFundingRateResponse event = JSON.parseObject(response, PublicFundingRateResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test9() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.btc-usdt.contract_info");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicContractInfoResponse event = JSON.parseObject(response, PublicContractInfoResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test10() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("trigger_order.BTC-USDT");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            TriggerOrderSubResponse event = JSON.parseObject(response, TriggerOrderSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test11() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("trigger_order_cross.BTC-USDT");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            TriggerOrderCrossSubResponse event = JSON.parseObject(response, TriggerOrderCrossSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test12() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("matchOrders.BTC-USDT");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MatchOrdersSubResponse event = JSON.parseObject(response, MatchOrdersSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test13() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("matchOrders_cross.BTC-USDT");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MatchOrdersCrossSubResponse event = JSON.parseObject(response, MatchOrdersCrossSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
