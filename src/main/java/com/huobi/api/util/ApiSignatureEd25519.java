package com.huobi.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
public class ApiSignatureEd25519 {

    final Logger log = LoggerFactory.getLogger(getClass());

    static final DateTimeFormatter DT_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");

    static final ZoneId ZONE_GMT = ZoneId.of("Z");


    public void createSignature(String base64PublicKey, String base64PrivateKey, String method, String uri,
                                Map<String, Object> params) {
        // 加载 BouncyCastle 提供者
        Security.addProvider(new BouncyCastleProvider());
        Ed25519PrivateKeyParameters privateKey = null;

        // 从 PEM 格式中提取私钥
        try (PEMParser pemParser = new PEMParser(new StringReader(base64PrivateKey))) {
            Object object = pemParser.readObject();
            if (object instanceof PrivateKeyInfo) {
                PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) object;
                JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
                java.security.PrivateKey javaPrivateKey = converter.getPrivateKey(privateKeyInfo);
                privateKey = (Ed25519PrivateKeyParameters) PrivateKeyFactory.createKey(javaPrivateKey.getEncoded());
            } else {
                throw new IllegalArgumentException("Invalid PEM format: not a private key");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error loading private key: " + e.getMessage(), e);
        }

        StringBuilder sb = new StringBuilder(1024);
        sb.append(method.toUpperCase()).append('\n');

        // 提取主机名和 URI
        int index = uri.indexOf("//");
        String subString = uri.substring(index + 2);
        int index2 = subString.indexOf("/");
        String host = subString.substring(0, index2);
        String constant = subString.substring(index2);

        sb.append(host.toLowerCase()).append('\n') // Host
                .append(constant).append('\n'); // /path

        // 添加请求参数
        params.remove("Signature");
        params.put("AccessKeyId", base64PublicKey); // 使用公共密钥
        params.put("SignatureVersion", "2");
        params.put("SignatureMethod", "Ed25519");
        params.put("Timestamp", gmtNow());

        // 构建签名字符串
        SortedMap<String, Object> map = new TreeMap<>(params);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            sb.append(key).append('=').append(urlEncode(value)).append('&');
        }
        // 去掉最后的 '&'
        sb.deleteCharAt(sb.length() - 1);
System.out.println(sb.toString());
        // 使用 Ed25519 进行签名
        Ed25519Signer signer = new Ed25519Signer();
        signer.init(true, privateKey);
        signer.update(sb.toString().getBytes(StandardCharsets.UTF_8), 0, sb.length());
        byte[] signatureBytes = signer.generateSignature();
        String actualSign = Base64.getEncoder().encodeToString(signatureBytes);

        params.put("Signature", actualSign); // 将签名放入参数中
    }

    /**
     * 使用标准URL Encode编码。注意和JDK默认的不同，空格被编码为%20而不是+。
     *
     * @param s String字符串
     * @return URL编码后的字符串
     */
    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("UTF-8 encoding not supported!");
        }
    }

    /**
     * Return epoch seconds
     */
    long epochNow() {
        return Instant.now().getEpochSecond();
    }

    String gmtNow() {
        return Instant.ofEpochSecond(epochNow()).atZone(ZONE_GMT).format(DT_FORMAT);
    }
}
