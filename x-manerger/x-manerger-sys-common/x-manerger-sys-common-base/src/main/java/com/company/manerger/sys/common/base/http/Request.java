package com.company.manerger.sys.common.base.http;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * @description: 数据请求实体
 */
public class Request extends LinkedHashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;

   /* public Page getPage() {
        Integer page=0;
        Integer limit=10;
        //分页参数
        if(this.get("page") != null){
            page = (Integer) this.get("page");
        }
        if(this.get("limit") != null){
            page = (Integer) this.get("limit");
        }

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = (String) this.get("sidx");
        String order = (String) this.get("order");
        this.put("sidx", sidx);
        this.put("order", order);

        //mybatis-plus分页
        Page pageBean = new Page(page, limit);

        //排序
        if(StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)){
            pageBean.setOrderByField(sidx);
            pageBean.setAsc("ASC".equalsIgnoreCase(order));
        }
        return pageBean;
    }*/

    @Override
    public Object get(Object key) {
        Object value = super.get(key);
        if (value!=null && value instanceof String){
            value = ((String) value).trim();
        }
        return value;
    }
    public String getString(Object key) {
        String value = (String)get(key);
        return value;
    }
}