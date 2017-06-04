package com.kou.utils;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by KouJiaxing on 2017-5-5.
 */
public class httpRequest {
    /**
     * 发起http请求并获取结果
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param requestParams 参数
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String requestParams) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        InputStream inputStream = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod(requestMethod);
            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            // 当有参数提交时
            if (null != requestParams) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                outputStream.write(requestParams.getBytes("UTF-8"));
                outputStream.close();
            }
            //将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("http request error:{}");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

    @Test
    public void apiTest() {
        String params = "app_key=12345678&params={\"dateType\": 1, \"dim\": \"corp_code\",  \"startDate\": 20170401, \"endDate\": 20170501, \"pageNo\": 1, \"pageSize\": 10, \"fitter\": [{\"dim\": \"corp_code\",\"value\": [\"A10001\",\"ZS8888\"]}]}&sign=8b0a071669ea54b4a058684fb9d1f0f4&ts = 2017-05-04 13:25:00";
        System.out.println(params);
        String url = "http://10.23.241.138:8889/v2/target/showing";
        String method = "POST";
        JSONObject jsonObject = httpRequest(url, method, params);
        System.out.println(jsonObject.getJSONObject("data").getJSONObject("mapping"));
        for (Map.Entry<String,Object> entry:jsonObject.getJSONObject("data").getJSONObject("mapping").entrySet()) {
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }


       /* String[] strings = new String[3];
        strings[0] = "123";
        strings[1] = "456";
        strings[2] = "789";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("defaultIndex", strings);
        System.out.println(jsonObject);*/
    }
}
