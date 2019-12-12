package com.kou.utils;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

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


    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        try {
            nashorn.eval("function sum(a,b){return a+b;}");
            System.out.println(nashorn.eval("sum(1,2);"));
            Invocable invocable = (Invocable) nashorn;
            System.out.println(invocable.invokeFunction("sum", 1, 3));
        } catch (ScriptException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }

        String name = "Mahesh";

        Integer result = null;
        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException e) {
            System.out.println("Error executing script: " + e.getMessage());
        }
        System.out.println(result.toString());
    }


    @Test
    public void redisTest() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        System.out.println(jedis.get("kou"));

    }

    @Test
    public void apiTest() {
//        String p = "params={\"dateType\":\"1\",\"columnOrder\":[{\"code\":\"date\",\"sort\":\"asc\"}],\"endDate\":20170710,\"pageNo\":1,\"pageSize\":7,\"dim\":\"date\",\"startDate\":20170704}\n";
//        String params = "app_key=12345678&" + p + "&sign=8b0a071669ea54b4a058684fb9d1f0f4&ts = 2017-05-04 13:25:00";

        String params = "params=xinzengfangyuanliang,erkanzhanbi,keyuan30rineiyoudaikanlu:,xinzengkeyuanshu,yidaierkanlu:,qiriyaochilu:,daikanliang,keyuan3rineishoukanlu:,sanrishoukanlu:,keyuan15rineierkanlu:,qirishikanlu:";
        //String params = "params=";
        String url = "http://10.30.128.245:8480/indexApi/v1/getIndexDetail";
        String method = "POST";
        JSONObject jsonObject = httpRequest(url, method, params);
        System.out.println(jsonObject);
        JSONObject data = jsonObject.getJSONObject("data");
        System.out.println(data);

//        String total = ((JSONObject) jsonObject.get("data")).getString("totalCount");
//        System.out.println(total);


//        for (Map.Entry<String,Object> entry:jsonObject.getJSONObject("data").getJSONObject("mapping").entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String createtime = simpleDateFormat.format(new Date());
//        System.out.println(createtime);
    }
}
