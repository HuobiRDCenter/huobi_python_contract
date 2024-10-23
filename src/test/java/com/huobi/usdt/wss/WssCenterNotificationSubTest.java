package com.huobi.usdt.wss;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.huobi.wss.event.PublicHeartbeatSubResponse;
import com.huobi.wss.handle.WssNotificationHandle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.List;

public class WssCenterNotificationSubTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String host = "api.hbdm.com";
    private String url = "/center-notification";
    private String sign="256";
    WssNotificationHandle wssNotificationHandle = new WssNotificationHandle(host, url, "", "",sign);

    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.linear-swap.heartbeat");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicHeartbeatSubResponse event = JSON.parseObject(response, PublicHeartbeatSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
