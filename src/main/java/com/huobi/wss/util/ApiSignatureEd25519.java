package com.huobi.wss.util;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
	public static String op = "op";
	public static String opValue = "auth";
	public static String accessKeyId = "AccessKeyId";
	public static String signatureMethod = "SignatureMethod";
	public static String signatureMethodValue = "HmacSHA256";
	public static String signatureVersion = "SignatureVersion";
	public static String signatureVersionValue = "2";
	public static String timestamp = "Timestamp";
	public static String signature = "Signature";
	/**
	 * API 签名， 签名标准： API Signature, the standard
	 */

	static final DateTimeFormatter DT_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
	static final ZoneId ZONE_GMT = ZoneId.of("Z");

	public void createSignature(String base64PublicKey, String base64PrivateKey, String method, String host, String uri,
								Map<String, String> params) {
		StringBuilder sb = new StringBuilder(1024);

		// 1.请求方法 (GET or POST) 在后边加上`\n`.
		sb.append(method.toUpperCase()).append('\n')
				// 2. 小写的host 在后边加上 `\n`.
				.append(host.toLowerCase()).append('\n')
				// 3. 请求路径, 在后边加上 `\n`.
				.append(uri).append('\n');

		// 4.将签名按ASCII 排名
		params.remove("Signature");
		params.put("AccessKeyId", base64PublicKey);
		params.put("SignatureVersion", "2");
		params.put("SignatureMethod", "ED25519");
		params.put("Timestamp", gmtNow());

		// 按照上面的顺序，将每个参数与字符“&”连接。
		SortedMap<String, String> map = new TreeMap<>(params);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key).append('=').append(urlEncode(value)).append('&');
		}
		// 删除最后的 `&`
		sb.deleteCharAt(sb.length() - 1);

		// 使用 ED25519 进行签名
		Ed25519PrivateKeyParameters privateKey = null;

		// 从 PEM 格式中提取私钥
		try (PEMParser pemParser = new PEMParser(new StringReader(base64PrivateKey))) {
			Object object = pemParser.readObject();
			if (object instanceof PrivateKeyInfo) {
				JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
				java.security.PrivateKey javaPrivateKey = converter.getPrivateKey((PrivateKeyInfo) object);
				privateKey = (Ed25519PrivateKeyParameters) PrivateKeyFactory.createKey(javaPrivateKey.getEncoded());
			} else {
				throw new IllegalArgumentException("Invalid PEM format: not a private key");
			}
		} catch (Exception e) {
			throw new RuntimeException("Error loading private key: " + e.getMessage(), e);
		}

		// 使用 ED25519 进行签名
		Ed25519Signer signer = new Ed25519Signer();
		signer.init(true, privateKey);
		signer.update(sb.toString().getBytes(StandardCharsets.UTF_8), 0, sb.length());
		byte[] signatureBytes = signer.generateSignature();
		String actualSign = Base64.getEncoder().encodeToString(signatureBytes);

		// 将签名放入params
		params.put(signature, actualSign);
	}


	public static String urlEncode(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("UTF-8 encoding not supported!");
		}
	}

	/**
	 * 返回秒数
	 * Return epoch second
	 */
	long epochNow() {
		return Instant.now().getEpochSecond();
	}

	String gmtNow() {
		return Instant.ofEpochSecond(epochNow()).atZone(ZONE_GMT).format(DT_FORMAT);
	}

}
