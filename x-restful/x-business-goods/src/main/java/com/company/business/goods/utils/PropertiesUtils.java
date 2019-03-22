package com.company.business.goods.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;


/**
 * 此类用于解析本地的json文件配置
 */
public class PropertiesUtils {


    public static JSONObject getJsonResource(String fileName) {
        fileName += ".json";
        ClassLoader classLoader = getClassLoader();

        Enumeration<URL> resources;
        JSONObject jsonObject = new JSONObject();
        try {
            resources = classLoader.getResources(fileName);//获取resource下文件
        } catch (Exception e) {
            return jsonObject;
        }

        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            try {
                String json = Resources.toString(url, Charsets.UTF_8);
                jsonObject.putAll(JSON.parseObject(json)); // 有多个的时候，后面的覆盖前面的
            } catch (IOException e) {
            }
        }
        return jsonObject;
    }

    private static ClassLoader getClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        return PropertiesUtils.class.getClassLoader();
    }

    /**
     * 私有构造方法，防止工具类被new
     */
    private PropertiesUtils() {
        throw new IllegalAccessError();
    }
}
