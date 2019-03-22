package com.company.business.goods.moudle.service;

import com.company.business.goods.common.vo.FormIdVo;

import java.util.Map;


public interface ITemplateService {
    void sendNotifyTemplate(String openId, FormIdVo formIdVo, Map<String,Object> map, int type);


    int saveFormId(String formId);
}
