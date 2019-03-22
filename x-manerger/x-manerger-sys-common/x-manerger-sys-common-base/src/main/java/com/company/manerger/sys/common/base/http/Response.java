package com.company.manerger.sys.common.base.http;

import com.company.manerger.sys.common.utils.fastjson.FastjsonPropertyPreFilter;
import com.company.manerger.sys.common.utils.fastjson.FastjsonUnXssFilter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 数据响应实体
 */
public class Response extends HashMap<String,Object> implements Serializable {
    public static  final int OK_CODE = 0;
    public static  final int ERROR_CODE = 500;

    public Response() {
        put("code", 0);
        put("msg", "操作成功");
    }
    public Response putList(String key, List list, String includesProperties){
        if (list.size()>0) {
            FastjsonPropertyPreFilter fastjsonPropertyPreFilter = new FastjsonPropertyPreFilter(list.get(0).getClass().getClass(), includesProperties);
            FastjsonUnXssFilter fastjsonUnXssFilter = new FastjsonUnXssFilter();
            SerializeFilter[] filters = {fastjsonPropertyPreFilter, fastjsonUnXssFilter};
            String objectStr = JSON.toJSONString(list, filters);
            List<Map> dataList = JSON.parseObject(objectStr, List.class);
            put(key, dataList);
        }else{
            put(key, new ArrayList<Map>());
        }
        return this;
    }

    public Response putList(String key, List list){
        if (list.size()>0) {
            FastjsonUnXssFilter fastjsonUnXssFilter = new FastjsonUnXssFilter();
            SerializeFilter[] filters = { fastjsonUnXssFilter};
            String objectStr = JSON.toJSONString(list, filters);
            List<Map> dataList = JSON.parseObject(objectStr, List.class);
            put(key, dataList);
        }else{
            put(key, new ArrayList<Map>());
        }
        return this;
    }

   public Response putObject(Object object, String includesProperties){
        if (object!=null) {
            FastjsonPropertyPreFilter fastjsonPropertyPreFilter = new FastjsonPropertyPreFilter(object.getClass(), includesProperties);
            FastjsonUnXssFilter fastjsonUnXssFilter = new FastjsonUnXssFilter();
            SerializeFilter[] filters = {fastjsonPropertyPreFilter, fastjsonUnXssFilter};
            String objectStr = JSON.toJSONString(object, filters);
            Map dataMap = JSON.parseObject(objectStr, Map.class);
            dataMap.remove("class");
            putAll(dataMap);
        }
       return this;
   }

    public Response putObject(Object object){
        if (object!=null) {
            FastjsonUnXssFilter fastjsonUnXssFilter = new FastjsonUnXssFilter();
            String objectStr = JSON.toJSONString(object, fastjsonUnXssFilter);
            Map dataMap = JSON.parseObject(objectStr, Map.class);
            dataMap.remove("class");
            putAll(dataMap);
        }
        return this;
    }

    public static Response ok(){
        return new Response();
    }

    public static Response ok(String msg){
        return error(OK_CODE,msg);
    }


    public static Response error(String msg){
        return error(ERROR_CODE,msg);
    }

    public static Response error(int code, String msg) {
        Response response = new Response();
        response.put("code", code);
        response.put("msg", msg);
        return response;
    }

}
