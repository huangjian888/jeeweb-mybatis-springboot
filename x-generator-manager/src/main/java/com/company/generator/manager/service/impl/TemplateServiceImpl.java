package com.company.generator.manager.service.impl;

import com.company.generator.manager.entity.Scheme;
import com.company.generator.manager.entity.Table;
import com.company.generator.manager.entity.Template;
import com.company.generator.manager.mapper.TemplateMapper;
import com.company.generator.manager.service.ITableService;
import com.company.generator.manager.service.ITemplateService;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Service("templateService")
public class TemplateServiceImpl  extends CommonServiceImpl<TemplateMapper,Template> implements ITemplateService {

    @Autowired
    private ITableService tableService;

    @Override
    public boolean inlineEdit(Template template) {
        return insertOrUpdate(template);
    }

    /**
     * 测试
     * @param template
     */
    @Override
    public void test(Template template) {
        try {
            List<Template> templates=new ArrayList<>();
            templates.add(template);
            //所有模板
            List<Template> allTemplates=selectList(new EntityWrapper<Template>(Template.class).eq("scheme_id",template.getSchemeId()));
            EntityWrapper tableEntityWrapper=new EntityWrapper();
            tableEntityWrapper.eq("table_name","t_test_template");
            // 加一个状态

            Table table = tableService.selectOne(tableEntityWrapper);
            Scheme scheme = new Scheme();
            scheme.setEntityName("TestTemplate");
            scheme.setFunctionAuthor("测试");
            scheme.setFunctionDesc("测试");
            scheme.setFunctionName("测试");
            scheme.setTable(table);
            scheme.setTableType(table.getTableType());
            tableService.generateCode(scheme, templates,allTemplates);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
