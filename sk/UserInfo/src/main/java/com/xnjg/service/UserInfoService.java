package com.xnjg.service;

import com.xnjg.constant.Constants;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * ==========================
 * Created with IntelliJ IDEA.
 *
 * @Auth: weixw
 * @Date: 2019/4/24 10:25
 * @Version 1.0.0
 * ==========================
 */
@Service
public class UserInfoService {
    /**
     * 获取用户个人信息
     * @param httpArg 请求参数
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getUserInfo(String httpArg) throws Exception {
        String httpUrl = Constants.API_URL;
        //httpArg = URLEncoder.encode(httpArg, "utf-8");//中文字符参数需要进行编码
        String jsonResult = request(httpUrl, httpArg);
        System.out.println(jsonResult);
        return  jsonResult;
    }

    /**
     * 调用交管接口，返回用户个人信息
     * @param httpUrl 请求接口
     * @param httpArg 请求参数
     * @return
     */
    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            // 填入api的请求方法
            connection.setRequestMethod("GET");
            // 填入appkey到HTTP header
            connection.setRequestProperty("AppKey", Constants.APP_KEY);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
