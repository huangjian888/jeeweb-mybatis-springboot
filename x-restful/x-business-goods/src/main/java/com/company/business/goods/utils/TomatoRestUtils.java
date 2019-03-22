package com.company.business.goods.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRequest;
import java.util.Map;

public class TomatoRestUtils {
    private static RestTemplate restTemplate = new RestTemplate();

    public static String post(ServletRequest req, String url, Map<String, ?> params) {
        ResponseEntity<String> rss = request(req, url, HttpMethod.POST, params);
        return rss.getBody();
    }


    public static String get(ServletRequest req, String url, Map<String, ?> params) {
        ResponseEntity<String> rss = request(req, url, HttpMethod.GET, params);
        return rss.getBody();
    }


    /**
     * 拼多多--
     * 被拼多多坑了，必须要加上requestHeaders.add("Accept-Language", "zh-CN,zh;q=0.9");
     *
     * @param req
     * @param url
     * @param method
     * @param params maybe null
     * @return
     */
    private static ResponseEntity<String> request(ServletRequest req, String url, HttpMethod method, Map<String, ?> params) {
        //获取header信息
        HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.add("Accept-Language", "zh-CN,zh;q=0.9");
        requestHeaders.add("Content-Type", "application/json;charset=UTF-8");


        HttpEntity<String> requestEntity = new HttpEntity<String>(params != null ? JSONObject.toJSONString(params) : null, requestHeaders);
        ResponseEntity<String> rss = restTemplate.exchange(url, method, requestEntity, String.class);

        return rss;
    }


}
