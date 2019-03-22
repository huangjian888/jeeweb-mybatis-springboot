package com.company.business.goods.moudle.service;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.business.goods.moudle.entity.CateGoryEntity;


public interface ICateGoryService {


    Page<CateGoryEntity> getCateGoryList(Page<CateGoryEntity> page);//查询配置的分类列表

    boolean insertCateGory(JSONObject json);

    CateGoryEntity getCateGoryEntity(int optId);
}
