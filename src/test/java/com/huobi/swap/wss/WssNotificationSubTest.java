package com.huobi.swap.wss;

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
    private String url = "/swap-notification";//注意地址前面要带上"/"
    private String sign="256";
    WssNotificationHandle wssNotificationHandle = new WssNotificationHandle(host, url, "", "",sign);

    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("orders.btc");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅订单成交数据（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            OrdersSubResponse event = JSON.parseObject(response, OrdersSubResponse.class);
            logger.info("订阅订单成交数据（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test2() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("accounts.BTC-USD");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("资产变动数据（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            AccountsSubResponse event = JSON.parseObject(response, AccountsSubResponse.class);
            logger.info("资产变动数据（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test3() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("positions.BTC-USD");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("持仓变动更新数据（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PositionsSubResponse event = JSON.parseObject(response, PositionsSubResponse.class);
            logger.info("持仓变动更新数据（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test4() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("matchOrders.BTC-USD");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅合约订单撮合数据（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MatchOrdersSubResponse event = JSON.parseObject(response, MatchOrdersSubResponse.class);
            logger.info("订阅合约订单撮合数据（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test5() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.BTC-USD.liquidation_orders");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅强平订单数据(免鉴权)（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicSubResponse event = JSON.parseObject(response, PublicSubResponse.class);
            logger.info("订阅强平订单数据(免鉴权)（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test6() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.btc-usd.funding_rate");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅资金费率推送(免鉴权)（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicFundingRateResponse event = JSON.parseObject(response, PublicFundingRateResponse.class);
            logger.info("订阅资金费率推送(免鉴权)（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test7() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.btc-usd.contract_info");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅合约信息变动(免鉴权)（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicContractInfoFutureSubResponse event = JSON.parseObject(response, PublicContractInfoFutureSubResponse.class);
            logger.info("订阅合约信息变动(免鉴权)（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test8() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("trigger_order.BTC-USD");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅计划委托订单更新(sub)用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            TriggerOrderSubResponse event = JSON.parseObject(response, TriggerOrderSubResponse.class);
            logger.info("订阅计划委托订单更新(sub)的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
