package com.company.manerger.sys.common.utils;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class AddressUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip)
    {
        String address = "";
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("ip",ip);
            Map<String, Object> headers = new HashMap<>();
            headers.put("accept", "*/*");
            headers.put("connection", "Keep-Alive");
            headers.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            String  rspStr = HttpClientUtils.httpGetRequest(IP_URL,headers,params);
            if (StringUtils.isEmpty(rspStr))
            {
                log.error("获取地理位置异常 {}", ip);
                return address;
            }
            JSONObject obj = JSONObject.parseObject(rspStr);
            JSONObject data = obj.getObject("data", JSONObject.class);
            String region = data.getString("region");
            String city = data.getString("city");
            address = region + " " + city;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }
}

