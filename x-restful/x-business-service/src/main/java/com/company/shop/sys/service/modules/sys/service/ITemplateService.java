package com.company.shop.sys.service.modules.sys.service;

import com.company.shop.sys.service.common.vo.FormIdVo;

import java.util.Map;

public interface ITemplateService {

    void sendNotifyTemplate(String openId, FormIdVo formIdVo, Map<String,Object> map, int type);


    int saveFormId(String formId);
}
