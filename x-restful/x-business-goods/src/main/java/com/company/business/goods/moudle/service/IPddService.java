package com.company.business.goods.moudle.service;


import com.alibaba.fastjson.JSONObject;

public interface IPddService {
    String apiCenter(JSONObject json);

    String getOrder();

    String categoryProduct(JSONObject json);
}
