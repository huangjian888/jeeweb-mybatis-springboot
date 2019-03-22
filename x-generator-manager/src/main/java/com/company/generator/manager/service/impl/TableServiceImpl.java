package com.company.generator.manager.service.impl;

import com.company.generator.manager.common.data.DbColumnInfo;
import com.company.generator.manager.common.data.DbTableInfo;
import com.company.generator.manager.common.exception.GenerationException;
import com.company.generator.manager.entity.*;
import com.company.generator.manager.mapper.TableMapper;
import com.company.generator.manager.service.IColumnService;
import com.company.generator.manager.service.IDataSourceService;
import com.company.generator.manager.service.ITableService;
import com.company.generator.manager.service.ITemplateService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.common.utils.DateUtils;
import com.company.manerger.sys.common.utils.ServletUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.*;

@Transactional
@Service("tableService")
public class TableServiceImpl extends CommonServiceImpl<TableMapper, Table> implements ITableService {
	@Autowired
	private IColumnService columnService;
	@Autowired
	private IDataSourceService dataSourceService;
	@Autowired
	private ITemplateService templateService;
	@Override
	public List<DbTableInfo> getTableNameList(String soureid) {
		return dataSourceService.getDbHelper(soureid).getDbTables();
	}

	@Override
	public boolean insert(Table table) {
		table.setSyncDatabase(Boolean.FALSE);
		// 保存主表
		super.insert(table);
		// 字段
		String columnListStr = StringEscapeUtils.unescapeHtml4(ServletUtils.getRequest().getParameter("columnList"));
		List<Column> columnList = JSONObject.parseArray(columnListStr, Column.class);
		for (int i = 0; i < columnList.size(); i++) {
			// 保存字段列表
			Column column = columnList.get(i);
			column.setId("");
			column.setSort(i);
			column.setTable(table);
			columnService.insert(column);
		}
		return true;
	}

	@Override
	public boolean insertOrUpdate(Table table) {
		// 删除已经删除的数据
		List<Column> oldColumnList = columnService.selectListByTableId(table.getId());
		// 字段
		String columnListStr = StringEscapeUtils.unescapeHtml4(ServletUtils.getRequest().getParameter("columnList"));
		List<Column> columnList = JSONObject.parseArray(columnListStr, Column.class);

		// 更新主表
		super.insertOrUpdate(table);
		columnList = JSONObject.parseArray(columnListStr, Column.class);
		List<String> newsIdList = new ArrayList<String>();
		int sort = 1;
		// 保存或更新数据
		for (Column column : columnList) {
			column.setSort(sort);
			// 保存字段列表
			if (StringUtils.isEmpty(column.getId()) || column.getId().contains("templateid")) {
				// 保存字段列表
				column.setId("");
				column.setTable(table);
				columnService.insert(column);
			} else {
				// 设置不变更的字段
				column.setTable(table);
				columnService.insertOrUpdate(column);
			}
			sort++;
			newsIdList.add(column.getId());
		}

		// 删除老数据
		for (Column column : oldColumnList) {
			String columnId = column.getId();
			if (!newsIdList.contains(columnId)) {
				columnService.deleteById(columnId);
			}
		}
		return true;
	}

	@Override
	public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
		for (Serializable id : idList) {
			deleteById(id);
		}
		return true;
	}

	@Override
	public boolean deleteById(Serializable id) {
		// 删除已经删除的数据
		Table table = selectById(id);
		// 先刪除表
		try {
			dataSourceService.getDbHelper(table.getSourceId()).dropTable(table.getTableName());
		} catch (Exception e) {
			e.printStackTrace();
			// 部分数据库在没有表而执行删表语句时会报错
			// logger.error(e.getMessage());
		}
		removeById(id);
		return true;
	}

	@Override
	public void removeById(Serializable id) {
		// 删除已经删除的数据
		List<Column> columnList = columnService.selectListByTableId((String) id);
		// 保存或更新数据
		for (Column column : columnList) {
			columnService.deleteById(column.getId());
		}
		super.deleteById(id);
	}

	@Override
	public void generateCode(Scheme scheme, List<Template> templates,List<Template> allTemplates) throws IOException, GenerationException {
		//生成代码
		for (Template template:templates) {
			generateCode(scheme,template,allTemplates);
		}
	}

	@Override
	public void importDatabase(Table table) {
		String tableName = table.getTableName();
		String title=tableName;
		if (tableName.contains(":")){
			String[] tableInfos=tableName.split(":");
			tableName=tableInfos[0];
			title=tableInfos[1];
		}
		table.setTitle(title);
		table.setRemarks(title);
		table.setTableName(tableName);
		table.setSyncDatabase(Boolean.TRUE);
		table.setTest(Boolean.FALSE);
		// 保存主表
		super.insert(table);
		DataSource dataSource=dataSourceService.selectById(table.getSourceId());
		List<DbColumnInfo> dbColumnInfos = dataSourceService.getDbHelper(table.getSourceId()).getDbColumnInfo(tableName);
		for (int j = 0; j < dbColumnInfos.size(); j++) {
			Column column = new Column(dbColumnInfos.get(j),dataSource.getDbType());
			column.setSort(j + 1);
			// 保存字段列表
			column.setTable(table);
			columnService.insert(column);
		}

	}

	public void dropTable(String tableid) {
		Table table = selectById(tableid);
		try {
			dataSourceService.getDbHelper(table.getSourceId()).dropTable(table.getTableName());
		} catch (Exception e) {
			// 部分数据库在没有表而执行删表语句时会报错
			// logger.error(e.getMessage());
		}
	}

	@Override
	public void syncDatabase(String tableid) throws TemplateException, IOException {
		Table table=selectById(tableid);
		DataSource dataSource=dataSourceService.selectById(table.getSourceId());
		List<Column> columns = columnService.selectListByTableId(table.getId());
		for (Column column:columns) {
			column.setDbType(dataSource.getDbType());
		}
		table.setColumns(columns);
		Map<String, Object> tableInfo = new HashMap<String, Object>();
		tableInfo.put("table", table);
		tableInfo.put("dbType", dataSource.getDbType());
		dataSourceService.getDbHelper(table.getSourceId()).createTable(tableInfo);
		table.setSyncDatabase(Boolean.TRUE);
		super.insertOrUpdate(table);
	}

	@Override
	public List<Table> findSubTable(String tablename) {
		return baseMapper.findSubTables(tablename);
	}

	public void generateCode(Scheme scheme, Template template,List<Template> allTemplates) throws IOException, GenerationException {
		 try {
			 Map<String, Object> ftlMap=getFtlMap(scheme,template,allTemplates);
			 //获取内容
			 String content=parseTemplate(ftlMap,template.getTemplateContent());
			 //获取路径
             File outFile=getOutPath(scheme, template);
			 //保存文件
			 FileUtils.write(outFile,content,"UTF-8");
		 } catch (TemplateException e) {
			 throw  new GenerationException("“"+template.getName()+"”"+e.getFTLInstructionStack());
		 }
	}


	public Map<String, Object> getFtlMap(Scheme scheme, Template template, List<Template> allTemplates) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//文件导入的以后再处理
		dataMap =JSON.parseObject(JSON.toJSON(scheme).toString(),Map.class);
		String packageName = parsePackageName(template.getTargetPackage(),scheme.getModuleName());
		dataMap.put("targetPackage",packageName);
		//获取table
		List<Column> columns=columnService.selectListByTableId(scheme.getTable().getId());
		dataMap.put("columns",columns);
		//引入其他模型的一些公用参数
		for (Template templateItem:allTemplates) {
			//包名字中加入模板
			String templateItemPackageName =  parsePackageName(templateItem.getTargetPackage(),scheme.getModuleName());
			templateItem.setTargetPackage(templateItemPackageName);
			dataMap.put(templateItem.getKey(),templateItem);
		}
		//设置生成的时间
		String time= DateUtils.formatDateTime(new Date());
		dataMap.put("time",time);
		//获得实体导入
	    /*List<String> importTypes = new ArrayList<String>();
		List<AttributeInfo> attributeInfos = generatorInfo.getAttributeInfos();
		Map<String, Boolean> tempImportMap = new HashMap<String, Boolean>();
		if (attributeInfos!=null) {
			for (AttributeInfo attributeInfo : attributeInfos) {
				String importType = attributeInfo.getImportType();
				if (!StringUtils.isEmpty(importType)&&!tempImportMap.containsKey(importType)) {
					importTypes.add(importType);
					tempImportMap.put(importType, true);
				}
			}
			generatorInfo.setImportTypes(importTypes);
		}*/
		return dataMap;
	}

	private String parsePackageName(String packageName,String moduleName){
		if (StringUtils.isEmpty(packageName)){
			return "";
		}
		if (!StringUtils.isEmpty(moduleName)){
			packageName =  packageName.replace("[moduleName]",moduleName);
		}else if(packageName.startsWith("[moduleName]")){
			packageName =  packageName.replace("[moduleName].", "");
		}else{
			packageName =  packageName.replace(".[moduleName]", "");
		}
		return packageName;
	}

	protected File getOutPath(Scheme scheme, Template template) {
		String outPath=template.getTargetPath();
		String packageNamePath = "";
		// 默认生成的包名
		String packageName = template.getTargetPackage();
		//包名字中加入模板
		packageName = parsePackageName(packageName,scheme.getModuleName());
		if (template.getEnablePackage().equals("1")){
			if (!"".endsWith(packageName)) {
//				outPath += File.separator + packageName;
				packageNamePath = packageName;
			}
		}
		/*// 当前模块名
		String moduleName = scheme.getModuleName();
		if (!"".endsWith(moduleName)) {
			outPath += File.separator + moduleName;
		}*/
		//
//		outPath = outPath.replace(".", File.separator).trim();
		packageNamePath = packageNamePath.replace(".", File.separator).trim();
		outPath += File.separator + packageNamePath;
		File outPathFile = new File(outPath);
		if (!outPathFile.exists()) {
			outPathFile.mkdirs();
		}
		//对文件进行格式化
		String fileName = template.getNameFormat().replace("[entityName]", scheme.getEntityName());
		if (StringUtils.isEmpty(template.getNameUnderline())&&template.getNameUnderline().equals("1")) {
			fileName = StringUtils.camelToUnderline(fileName);
		}

		File outFile = new File(outPath + File.separator+ fileName);
		if (outFile.exists()) {
			outFile.delete();
		}
		return outFile;
	}

	/**
	 * 模版解析
	 * @param rootMap
	 * @param content
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	private String parseTemplate(Map<String, Object> rootMap, String content) throws TemplateException, IOException {
		content=StringEscapeUtils.unescapeHtml4(content);
		String tempname = StringUtils.hashKeyForDisk(content);
		Configuration configuration = new Configuration();
		configuration.setNumberFormat("#");
		StringTemplateLoader stringLoader = new StringTemplateLoader();
		stringLoader.putTemplate(tempname, content);
		freemarker.template.Template template = new freemarker.template.Template(tempname, new StringReader(content),configuration);
		StringWriter stringWriter = new StringWriter();
		template.process(rootMap, stringWriter);
		configuration.setTemplateLoader(stringLoader);
		content = stringWriter.toString();
		return content;
	}
}
