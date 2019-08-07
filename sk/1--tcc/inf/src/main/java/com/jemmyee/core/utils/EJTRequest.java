package com.jemmyee.core.utils;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

/**
 * @Title: 用于好停车或停车场调用E捷通使用
 *
 * @Description:
 *
 * @version 0.1
 *
 * @Date 2018年7月27日
 *
 */
public class EJTRequest {
	//private static String appKey = "VBk01QXW8cf3P8M";
	//private static String secretKey = "e6b88153a1d99f81b39e023ff70264aad6bf69e81a26695a6f34ba01d661ce6e";
	private static String appKey = "A27PNRk8pR0QK6A";
	private static String secretKey = "760f5da317bd6f4b33cf9b6abddecdda33be9bca3cb568c8738f634f25709eca";

	public static String callEJT(String requestUrl, Map<String, String> dataMap) throws Exception {

		if (StringUtils.isBlank(requestUrl) || dataMap == null || dataMap.isEmpty()) {
			return null;
		}

     	String noncestr = UUID.randomUUID().toString();
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);

		SortedMap<String, String> parameters = new TreeMap<String, String>();
		parameters.put("noncestr", noncestr);
		parameters.put("timestamp", timestamp);

		String paramsStr = SignatureUtils.createRequestParamsStr(parameters);
		String sign = SignatureUtils.createSign(paramsStr, appKey, secretKey);
		paramsStr = paramsStr.concat("&sign=").concat(sign);

		// 构建访问URL
		String accessUrl = requestUrl.concat("?").concat(paramsStr);
		System.out.println("......------> call ejt url is: " + accessUrl);
		// 发送请求
		String responseStr = sendPost(accessUrl, dataMap);

		return responseStr;

	}

	public static String sendPost(String accessUrl, Map<String, String> dataMap) throws Exception {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(accessUrl);
		httpPost.setHeader("appKey", appKey);
		httpPost.setHeader("Content-Type", "application/json");

		if(dataMap != null && !dataMap.isEmpty()){
			String data_json = JSON.toJSONString(dataMap);
			HttpEntity httpEntity = new StringEntity(data_json, "UTF-8");
			httpPost.setEntity(httpEntity);
		}
		
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity entity = httpResponse.getEntity();
		String result = EntityUtils.toString(entity);
		EntityUtils.consume(entity);

		return result;

	}

}
