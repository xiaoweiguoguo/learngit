package com.jemmyee.core.utils;

import com.jemmyee.core.web.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/**
 * 文件名称                ：HttpUtil
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-7
 * 编写时间                : 17:22
 * 程序功能（类）描述       ：<p>
 */
public class HttpUtil<T>{

//    public static String doPost(String url, String jsonstr, String charset){
//        HttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try{
////            httpClient = new SSLClient();
//            httpPost = new HttpPost(url);
//            httpPost.addHeader("Content-Type", "application/json");
//            StringEntity se = new StringEntity(jsonstr);
//            se.setContentType("text/json");
//            se.setContentEncoding(new BasicHeader("Content-Type", "application/json"));
//            httpPost.setEntity(se);
//            HttpResponse response = httpClient.execute(httpPost);
//            if(response != null){
//                HttpEntity resEntity = response.getEntity();
//                if(resEntity != null){
//                    result = EntityUtils.toString(resEntity,"UTF-8");
//                }
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    public static String post(String url,String t){
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpPost httpPost=new HttpPost(url);
//        httpPost.addHeader("Content-Type","application/json; charset=utf-8");
//        httpPost.setHeader("Accept", "application/json");
//        httpPost.setEntity(new StringEntity(t, Charset.forName("UTF-8")));
//        try {
//            HttpResponse response = httpClient.execute(httpPost);
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode != HttpStatus.SC_OK) {
//                System.err.println("Method failed:" + response.getStatusLine());
//            }else{
//                String resultStr = EntityUtils.toString(response.getEntity());
//                return resultStr;
//             }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    /**
     * httpPost
     * @param url  路径
     * @param jsonParam 参数
     * @return
     */
//    public  JSONObject httpPost(String url,JSONObject jsonParam){
//        return httpPost(url, jsonParam, false);
//    }

    /**
     * post请求
     * @param url         url地址
     * @param json     参数
     * @return
     */
    public Response<T> httpPost(String url,String json){
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost method = new HttpPost(url);
        try {
            if (null != json) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(json, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }

            HttpResponse result = httpClient.execute(method);
            Response<T> JSON=new Response<T>();
            JSON.setcode(String.valueOf(result.getStatusLine().getStatusCode()));
            JSON.setmsg(result.getStatusLine().getReasonPhrase());
            JSON.setData((T) EntityUtils.toString(result.getEntity()));
            return JSON;
//            /**请求发送成功，并得到响应**/
//            if (result.getStatusLine().getStatusCode() == 200) {
//                String str = "";
//                try {
//                    /**读取服务器返回过来的json字符串数据**/
//                    str = EntityUtils.toString(result.getEntity());
//                    if (noNeedResponse) {
//                        return null;
//                    }
//                    /**把json字符串转换成json对象**/
//                    jsonResult = JSONObject.fromObject(str);
//                } catch (Exception e) {
//                    logger.error("post请求提交失败:" + url, e);
//                }
//            }
        } catch (IOException e) {
            return  null;
        }
    }


    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public  Response<T> httpGet(String url){
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            Response<T> JSON=new Response<T>();
            JSON.setcode(String.valueOf(response.getStatusLine().getStatusCode()));
            JSON.setmsg(response.getStatusLine().getReasonPhrase());
            JSON.setData((T) EntityUtils.toString(response.getEntity()));
            return JSON;
//            /**请求发送成功，并得到响应**/
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                /**读取服务器返回过来的json字符串数据**/
//                String strResult = EntityUtils.toString(response.getEntity());
//                /**把json字符串转换成json对象**/
//                jsonResult = JSONObject.fromObject(strResult);
//                url = URLDecoder.decode(url, "UTF-8");
//            } else {
//                logger.error("get请求提交失败:" + url);
//            }
        } catch (IOException e) {
           return null;
        }
//        return jsonResult;
    }
}
