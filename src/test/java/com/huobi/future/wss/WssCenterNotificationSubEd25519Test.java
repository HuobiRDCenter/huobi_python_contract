package com.huobi.future.wss;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.huobi.wss.event.PublicHeartbeatSubResponse;
import com.huobi.wss.handle.WssNotificationHandle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.List;

public class WssCenterNotificationSubEd25519Test {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String host = "api.hbdm.com";
    private String url = "/center-notification";
    private String sign="25519";
    //    这里的sign代表着是使用hmac256签名方法还是Ed25519签名方法。这里的publickey和privatekey公钥和私钥
//    The sign indicates whether to use the hmac256 signature method or the Ed25519 signature method. Here are the publickey and privatekey public and private keys
    private String publicKey="";
    private String privateKey="";
    WssNotificationHandle wssNotificationHandle = new WssNotificationHandle(host, url, publicKey, privateKey,sign);

    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("public.futures.heartbeat");
        wssNotificationHandle.sub(channels, response -> {
            logger.info("用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            PublicHeartbeatSubResponse event = JSON.parseObject(response, PublicHeartbeatSubResponse.class);
            logger.info("ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
