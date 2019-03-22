package com.company.generator.manager.service;

import com.company.generator.manager.entity.Template;
import com.company.manerger.sys.common.mybatis.service.ICommonService;


public interface ITemplateService extends ICommonService<Template> {

    /**
     * 复制
     * @param template
     * @return
     */
    boolean inlineEdit(Template template);

    /**
     *  模版测试
     * @param template
     * @return
     */
    void test(Template template);
}

