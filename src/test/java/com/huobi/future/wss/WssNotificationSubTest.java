package com.huobi.future.wss;

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
    private String host="api.hbdm.com";
    private String url="/notification";//注意地址上一定要带上"/"。
    private String sign="256";
    private String key="";
    private String secret="";
    //private String URL = "wss://api.hbdm.com/notification";//订单推送访问地址.更换请求的域名时，需将WssNotificationHandle类中的addAuth()方法里面的域名也一起替换掉。
    WssNotificationHandle wssNotificationHandle = new WssNotificationHandle( host , url , key, secret,sign);


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
        channels.add("accounts.btc");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅资产变动数据（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            AccountsSubResponse event = JSON.parseObject(response, AccountsSubResponse.class);
            logger.info("订阅资产变动数据（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test3() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("positions.btc");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅持仓变动更新数据（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PositionsSubResponse event = JSON.parseObject(response, PositionsSubResponse.class);
            logger.info("订阅持仓变动更新数据（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test4() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.BTC.liquidation_orders");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅强平订单数据(免鉴权)（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicSubResponse event = JSON.parseObject(response, PublicSubResponse.class);
            logger.info("订阅强平订单数据(免鉴权)（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test5() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.btc.contract_info");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅合约信息变动(免鉴权)（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicContractInfoFutureSubResponse event = JSON.parseObject(response, PublicContractInfoFutureSubResponse.class);
            logger.info("订阅合约信息变动(免鉴权)（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test6() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("trigger_order.BTC");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅计划委托订单更新用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            TriggerOrderSubResponse event = JSON.parseObject(response, TriggerOrderSubResponse.class);
            logger.info("订阅计划委托订单更新的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test7() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("matchOrders.btc");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("订阅订单撮合数据（sub）用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MatchOrdersSubResponse event = JSON.parseObject(response, MatchOrdersSubResponse.class);
            logger.info("订阅订单撮合数据（sub）的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }


}
