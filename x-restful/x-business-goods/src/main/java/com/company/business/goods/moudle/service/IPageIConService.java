package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.moudle.entity.PageIConEntity;

public interface IPageIConService {

    PageIConEntity getPageIConEntity(String markId);

    boolean insertPageICon(JSONObject json);

    boolean updatePageIcon(JSONObject json);

}
