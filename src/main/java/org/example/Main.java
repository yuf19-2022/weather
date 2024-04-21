package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        moji();
        gaode();
    }

    private static void moji() {
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            String host = "https://aliv18.data.moji.com";
            String path = "/whapi/json/alicityweather/aqiforecast5days";
            String method = "POST";
            String appcode = Constant.APPCODE;
            Map<String, String> headers = new HashMap<String, String>();
            // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            // 根据API的要求，定义相对应的Content-Type
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            Map<String, String> querys = new HashMap<String, String>();
            Map<String, String> bodys = new HashMap<String, String>();
            bodys.put("cityId", Constant.CITYID);
            bodys.put("token", "0418c1f4e5e66405d33556418189d2d0");
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            // 获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void gaode() {
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            //        String url = "https://restapi.amap.com/v3/weather/weatherInfo";
            String host = "https://restapi.amap.com";
//        String path = "/v3/weather/weatherInfo";
            String path = "/v3/ip";
            String method = "GET";
//        String appcode = "0bf64793cef6424b9ae512892ad8e92d";
            Map<String, String> headers = new HashMap<String, String>();
        /*//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");*/
            Map<String, String> querys = new HashMap<String, String>();
            // querys.put("city", "Constant.ADCODE");
            querys.put("key", Constant.KEY);
//        querys.put("ip","120.77.134.169")
            Map<String, String> bodys = new HashMap<String, String>();
        /*bodys.put("cityId", "2188");
        bodys.put("token", "0418c1f4e5e66405d33556418189d2d0");*/
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//            System.out.println(response.toString());
            // 获取response的body
            JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
            System.out.println(jsonObject.get("adcode"));
            System.out.println(JSONObject.toJSONString(jsonObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}