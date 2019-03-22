package com.company.generator.manager.controller;

import com.company.generator.manager.common.data.DbTableInfo;
import com.company.generator.manager.common.definition.DefinitionUtils;
import com.company.generator.manager.entity.*;
import com.company.generator.manager.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.company.manerger.sys.common.base.http.PageResponse;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.query.annotation.PageableDefaults;
import com.company.manerger.sys.common.query.data.PropertyPreFilterable;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.utils.QueryableConvertUtils;
import com.company.manerger.sys.common.utils.CacheUtils;
import com.company.manerger.sys.common.utils.ObjectUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.common.utils.mapper.JsonMapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("${admin.url.prefix}/generator/table")
@ViewPrefix("modules/generator/table")
public class TableController extends BaseBeanController<Table> {

    @Autowired
    private ITableService tableService;
    @Autowired
    private IColumnService columnService;
    @Autowired
    private ISchemeService schemeService;
    @Autowired
    private IDataSourceService dataSourceService;
    @Autowired
    private ITemplateSchemeService templateSchemeService;
    @Autowired
    private ITemplateService templateService;

    private String[] types = { "String", "Double", "Text", "Date", "Blob", "Short", "Integer", "Boolean" ,"User","StoreUser"};


    @GetMapping
    public ModelAndView list(Model model) {
        List<DataSource> dataSourceList = dataSourceService.selectList(new EntityWrapper<>(DataSource.class));
        String sourceFormatterValue = StringUtils.toFormatterValue(dataSourceList, "dbKey", "id");
        model.addAttribute("sourceFormatterValue", sourceFormatterValue);
        return displayModelAndView("list");
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    @PageableDefaults(sort = "createDate=desc")
    public void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        EntityWrapper<Table> entityWrapper = new EntityWrapper<>(entityClass);
        entityWrapper.eq("test","0");
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<Table> pagejson = new PageResponse<>(tableService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

    public void preEdit(Table table, HttpServletRequest request) {
        String sourceId=request.getParameter("sourceId");
        if (table != null && !StringUtils.isEmpty(table.getId())){
            sourceId=table.getSourceId();
        }
        if (table != null && !StringUtils.isEmpty(table.getId()) && StringUtils.isEmpty(table.getClassName())) {
            String entityName = StringUtils.toUpperCaseFirstOne(StringUtils.underlineToCamel(table.getTableName().toLowerCase()));
            table.setClassName(entityName);
        }
        DataSource dataSource=dataSourceService.selectById(sourceId);
        // 查询表明
        List<DbTableInfo> dbTableInfos = tableService.getTableNameList(sourceId);
        request.setAttribute("dbTableInfos", dbTableInfos);
        List<Column> columns = columnService.selectListByTableId(table.getId());
        for (Column column:columns) {
            column.setDbType(dataSource.getDbType());
        }
        String columnsJson = JsonMapper.toJsonString(columns);
        request.setAttribute("columns", columnsJson);
        List<String> javaTypes = Arrays.asList(types);
        String dbTypes = DefinitionUtils.getDefinitionUtils().getDefinition(dataSource.getDbType()).getDb().getAllTypes().trim();
        List<String> typeNames = Arrays.asList(dbTypes.split(","));
        String extendTypes = "";
        for (Column column : columns) {
            String javaType = column.getJavaType();
            if (javaType.contains("|")) {
                String[] innerJavaTypes = javaType.split("\\|");
                if (!javaTypes.contains(innerJavaTypes[1]) && !extendTypes.contains(innerJavaTypes[1])) {
                    extendTypes += ";";
                    extendTypes += javaType + ":" + innerJavaTypes[1];
                }
            }
        }
        request.setAttribute("extendTypes", extendTypes);
        request.setAttribute("typeNames", typeNames);
        request.setAttribute("javaTypes", javaTypes);
        List<Table> mainTables = tableService.selectList(new EntityWrapper<Table>(Table.class).eq("tableType", "2"));
        request.setAttribute("mainTables", mainTables);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
        Table table = new Table();
        model.addAttribute("data",table);
        preEdit(table,request);
        return displayModelAndView ("edit");
    }

    @PostMapping("add")
    public Response add(Table entity, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        preSave(entity,request);
        tableService.insert(entity);
        return Response.ok("添加成功");
    }

    @GetMapping(value = "{id}/update")
    public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                               HttpServletResponse response) {
        Table entity = tableService.selectById(id);
        model.addAttribute("data", entity);
        preEdit(entity,request);
        return displayModelAndView ("edit");
    }

    @PostMapping("{id}/update")
    public Response update(Table entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        preSave(entity,request);
        tableService.insertOrUpdate(entity);
        return Response.ok("更新成功");
    }

    @PostMapping("{id}/delete")
    public Response delete(@PathVariable("id") String id) {
        tableService.deleteById(id);
        return Response.ok("删除成功");
    }

    @PostMapping("batch/delete")
    public Response batchDelete(@RequestParam("ids") String[] ids) {
        List<String> idList = Arrays.asList(ids);
        tableService.deleteBatchIds(idList);
        return Response.ok("删除成功");
    }

    public void preSave(Table table, HttpServletRequest request) {
        if (!StringUtils.isEmpty(table.getId())) {
            Table oldTable = tableService.selectById(table.getId());
            String[] fields = { "tableName", "remarks" };
            // 检查表信息是否更新
            if (!ObjectUtils.isEquals(oldTable, table, fields)) {
                table.setSyncDatabase(Boolean.FALSE);
            }
            List<Column> oldColumnList = columnService.selectListByTableId(table.getId());

            // 字段
            String columnListStr = StringEscapeUtils
                    .unescapeHtml4(request.getParameter("columnList"));
            List<Column> columnList = JSONObject.parseArray(columnListStr, Column.class);
            // 检查表信息是否更新
            if (checkIsModify(oldColumnList, columnList)) {
                table.setSyncDatabase(Boolean.FALSE);
            }
        }
        table.setTest(Boolean.FALSE);
    }

    public Boolean checkIsModify(List<Column> oldColumnList, List<Column> newColumnList) {
        if (oldColumnList.size() != newColumnList.size()) {
            return Boolean.TRUE;
        }
        for (Column columnEntity : newColumnList) {
            Boolean isUpdate = Boolean.FALSE;
            for (Column oldColumnEntity : oldColumnList) {
                if (columnEntity.getId().equals(oldColumnEntity.getId())) {
                    String[] fields = { "remarks", "columnName", "typeName", "columnSize", "parmaryKey", "importedKey",
                            "importedKey", "nullable", "columnDef", "decimalDigits"};
                    if (ObjectUtils.isEquals(columnEntity, oldColumnEntity, fields)) {
                        isUpdate = Boolean.FALSE;
                        break;
                    }
                }
                isUpdate = Boolean.TRUE;
            }
            if (isUpdate) {
                return isUpdate;
            }
        }
        return Boolean.FALSE;
    }

    @GetMapping(value = "{id}/generateCode")
    public ModelAndView generateCode(@PathVariable("id") String id, Model model, HttpServletRequest request,
                               HttpServletResponse response) {
        Table table = tableService.selectById(id);
        if (!table.getSyncDatabase()) {
            return displayModelAndView("un_sync_database");
        }
        //获得模版方案列表
        List<TemplateScheme> templateSchemes=templateSchemeService.selectList(new EntityWrapper<TemplateScheme>(TemplateScheme.class));
        request.setAttribute("templateSchemes",templateSchemes);
        Scheme scheme = schemeService.selectOne(new EntityWrapper<Scheme>(Scheme.class).eq("table.id", id));
        if (scheme == null) {
            String tableName = table.getTableName();
            String remarks = table.getRemarks();
            String entityName = StringUtils.toUpperCaseFirstOne(StringUtils.underlineToCamel(tableName.toLowerCase()));
            scheme = new Scheme();
            scheme.setEntityName(entityName);
            scheme.setTableName(tableName);
            scheme.setFunctionDesc(remarks);
            scheme.setFunctionName(remarks);
            scheme.setTable(table);
            schemeService.insert(scheme);
        }
        String templateSchemeId=request.getParameter("templateSchemeId");
        if (StringUtils.isEmpty(templateSchemeId)&&templateSchemes.size()>0){
            templateSchemeId=templateSchemes.get(0).getId();
        }
        request.setAttribute("templateSchemeId",templateSchemeId);
        //模版列表
        EntityWrapper<Template> entityWrapper =  new EntityWrapper<Template>(Template.class);
        entityWrapper.eq("scheme_id",templateSchemeId);
        entityWrapper.orderBy("sort");
        List<Template> templates=
                templateService.selectList(entityWrapper);
        for (Template template: templates ) {
            Template templateCache = (Template) CacheUtils.get(template.getId());
            if (templateCache != null) {
                template.setTargetPackage(templateCache.getTargetPackage());
                template.setTargetPath(templateCache.getTargetPath());
            }
        }
        request.setAttribute("templates",templates);
        request.setAttribute("scheme", scheme);
        request.setAttribute("tableid", id);
        return displayModelAndView("generate_code");
    }

    @PostMapping(value = "generateCode")
    public Response generateCode(Scheme scheme, HttpServletRequest request,
                                 HttpServletResponse response) {
        try {
            String[] templateKeys=request.getParameterValues("templateKeys");
            if (templateKeys==null||templateKeys.length==0){
                return Response.error("请选择要生成的模板");
            }
            List<Template> templates=new ArrayList<>();
            for (String templateKey: templateKeys ) {
                Template template=templateService.selectById(templateKey);
                //生成目录获取
                String targetPath=request.getParameter("template_path_"+templateKey);
                String targetPackage=request.getParameter("template_package_"+templateKey);
                template.setTargetPath(targetPath);
                template.setTargetPackage(targetPackage);
                templates.add(template);
            }
            //所有模板
            List<Template> allTemplates=templateService.selectList(new EntityWrapper<Template>(Template.class).eq("scheme_id",scheme.getTemplateSchemeId()));
            for (Template template: allTemplates ) {
                String templateKey=template.getId();
                //生成目录获取
                String targetPath=request.getParameter("template_path_"+templateKey);
                String targetPackage=request.getParameter("template_package_"+templateKey);
                template.setTargetPath(targetPath);
                template.setTargetPackage(targetPackage);
                CacheUtils.put(template.getId(),template);
            }
            String tableid = request.getParameter("tableid");
            Table table = tableService.selectById(tableid);
            scheme.setTableType(table.getTableType());
            schemeService.insertOrUpdate(scheme);
            Scheme oldEntity = schemeService.selectById(scheme.getId());
            tableService.generateCode(oldEntity, templates,allTemplates);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("代码生成失败!<br />原因:" + e.getMessage());
        }
        return Response.ok("代码生成成功");
    }

    @GetMapping(value = "/importDatabase")
    public ModelAndView importDatabase(HttpServletRequest request, HttpServletResponse response) {
        String sourceId=request.getParameter("sourceId");
        // 查询表明
        List<DbTableInfo> dbTableInfos = tableService.getTableNameList(sourceId);
        request.setAttribute("dbTableInfos", dbTableInfos);
        request.setAttribute("data", new Table());
        return displayModelAndView("import_database");
    }

    @PostMapping(value = "/importDatabase")
    public Response importDatabase(HttpServletRequest request, Table table, HttpServletResponse response) {
        tableService.importDatabase(table);
        return  Response.ok("数据库导入成功");
    }

    @PostMapping(value = "{id}/syncDatabase")
    public Response syncDatabase(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("id") String id) {
        try {
            tableService.dropTable(id);
            tableService.syncDatabase(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(e.getMessage());
        }
        return  Response.ok("数据库同步成功");
    }

    @PostMapping(value = "{id}/remove")
    public Response remove(@PathVariable("id") String id) {
        try {
            tableService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("移除失败");
        }
        return  Response.ok("移除成功");
    }
}