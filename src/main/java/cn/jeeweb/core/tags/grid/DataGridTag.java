package cn.jeeweb.core.tags.grid;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import cn.jeeweb.core.query.data.PropertyPreFilterable;
import cn.jeeweb.core.query.data.QueryPropertyPreFilter;
import cn.jeeweb.core.tags.common.tag.AbstractGridHtmlTag;
import cn.jeeweb.core.tags.form.support.FreemarkerFormTagHelper;
import cn.jeeweb.core.tags.html.manager.HtmlComponentManager;
import cn.jeeweb.core.utils.ObjectUtils;
import cn.jeeweb.core.utils.Reflections;
import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.entity.Dict;
import cn.jeeweb.modules.sys.tags.SysFunctions;
import cn.jeeweb.modules.sys.utils.DictUtils;

@SuppressWarnings("serial")
public class DataGridTag extends AbstractGridHtmlTag {
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	private List<Map<String, Object>> columnList = new ArrayList<Map<String, Object>>();
	private List<Map<String, Object>> toobarList = new ArrayList<Map<String, Object>>();// 工具栏
	private List<Map<String, Object>> buttonList = new ArrayList<Map<String, Object>>();// 行内按钮逼
	private List<Map<String, Object>> queryList = new ArrayList<Map<String, Object>>();
	private Map<String, List<Dict>> columnDictMap = new HashMap<String, List<Dict>>();
	private String id = "datagridid"; // 表格唯一标示
	private String gridtype = "jqgrid"; // grid的类型,默认jqgrid
	private String gridShowType = "list";// list,form,js
	private String caption = ""; // 表格的标题
	private String url = ""; // 从datas中加入的数据,请求的地址
	private String baseUrl = "";// 请求的基础网页
	private String editurl = "clientArray"; // 行内编辑URL
	private Boolean editable = Boolean.FALSE;// 是否行内编辑
	private String datatype = "json"; // 默认为JSON,local,jsonp远程
	private String ajaxType = "get"; // 默认为JSON,local
	private Object datas;// local时的数据
	private Boolean pageable = Boolean.TRUE;// 是否分页
	private String width = "auto"; // 表格宽度
	private String height = "450";// 表格高度
	private Boolean multiselect = true;// 是否多选
	private Boolean multiSort = Boolean.TRUE;// 是否多列排序
	private Boolean sortable = Boolean.TRUE;
	private String sortname = "id";
	private String sortorder = "asc";
	private Boolean showQueryLabel = Boolean.TRUE;

	private int page = 1;// 页码开始
	private int rowNum = 10; // 这个参数是要被传递到后台，树结构时候，rowNum无效
	private Boolean treeGrid = Boolean.FALSE;// 是否数机构
	private String expandColumn = "";// 指定那列来展开treegrid，默认为第一列，只有在treeGrid为true时起作用
	private Boolean async = Boolean.FALSE; // 树情况是否异步
	private String gridSetting = "";// 扩展设置
	private String gridSettingCallback = ""; // 配置方法,为js方法，返回配置
	private Boolean shrinkToFit=Boolean.TRUE; //是否

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGridtype() {
		return gridtype;
	}

	public void setGridtype(String gridtype) {
		this.gridtype = gridtype;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getAjaxType() {
		return ajaxType;
	}

	public void setAjaxType(String ajaxType) {
		this.ajaxType = ajaxType;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

	public Boolean getPageable() {
		return pageable;
	}

	public void setPageable(Boolean pageable) {
		this.pageable = pageable;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Boolean getMultiselect() {
		return multiselect;
	}

	public void setMultiselect(Boolean multiselect) {
		this.multiselect = multiselect;
	}

	public Boolean getMultiSort() {
		return multiSort;
	}

	public void setMultiSort(Boolean multiSort) {
		this.multiSort = multiSort;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public Boolean getTreeGrid() {
		return treeGrid;
	}

	public void setTreeGrid(Boolean treeGrid) {
		this.treeGrid = treeGrid;
	}

	public String getExpandColumn() {
		return expandColumn;
	}

	public void setExpandColumn(String expandColumn) {
		this.expandColumn = expandColumn;
	}

	public Boolean getAsync() {
		return async;
	}

	public void setAsync(Boolean async) {
		this.async = async;
	}

	public String getGridSetting() {
		return gridSetting;
	}

	public void setGridSetting(String gridSetting) {
		this.gridSetting = gridSetting;
	}

	public String getGridSettingCallback() {
		return gridSettingCallback;
	}

	public void setGridSettingCallback(String gridSettingCallback) {
		this.gridSettingCallback = gridSettingCallback;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getEditurl() {
		return editurl;
	}

	public void setEditurl(String editurl) {
		this.editurl = editurl;
	}

	public Boolean getShrinkToFit() {
		return shrinkToFit;
	}

	public void setShrinkToFit(Boolean shrinkToFit) {
		this.shrinkToFit = shrinkToFit;
	}

	public void putColumnDict(String dict) {
		columnDictMap.put(dict, DictUtils.getDictList(dict));
	}
	public void putColumnDict(String dict,List<Dict> dictList) {
		columnDictMap.put(dict,dictList);
	}

	public void addColumn(Map<String, Object> column) {
		columnList.add(column);
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public String getGridShowType() {
		return gridShowType;
	}

	public void setGridShowType(String gridShowType) {
		this.gridShowType = gridShowType;
	}

	public void addQuery(Map<String, Object> column) {

		queryList.add(column);
	}

	public void addToolbar(Map<String, Object> toolbar) {
		toobarList.add(toolbar);
	}

	public void addButton(Map<String, Object> button) {
		buttonList.add(button);
	}

	@Override
	public int doStartTag() throws JspException {
		// 清空资源
		queryList.clear();
		columnList.clear();
		toobarList.clear();
		buttonList.clear();
		columnDictMap.clear();
		if (staticAttributes != null) {
			staticAttributes.clear();
		}
		if (StringUtils.isEmpty(baseUrl) && !StringUtils.isEmpty(url)) {
			this.baseUrl = url.substring(0, url.lastIndexOf("/"));
		}
		if (StringUtils.isEmpty(url) && !StringUtils.isEmpty(baseUrl)) {
			this.url = this.baseUrl + "/ajaxList";
		}
		Field[] field = getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		for (int j = 0; j < field.length; j++) { // 遍历所有属性
			Field field2 = field[j];
			if (ObjectUtils.isBaseDataType(field2.getType())) {
				String name = field[j].getName(); // 获取属性的名字
				setStaticAttribute(name, Reflections.invokeGetter(this, name));
			}
		}
		return EVAL_PAGE;
	}

	public Boolean getShowQueryLabel() {
		return showQueryLabel;
	}

	public void setShowQueryLabel(Boolean showQueryLabel) {
		this.showQueryLabel = showQueryLabel;
	}

	public int doEndTag() throws JspTagException {
		try {
			writeFragment();
		} catch (JspException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@SuppressWarnings("rawtypes")
	private void writeFragment() throws JspException {
		if (!StringUtils.isEmpty(url)) {
			if (this.url.contains("?")) {
				this.url = this.url + "&gridtype=" + gridtype;
			} else {
				this.url = this.url + "?gridtype=" + gridtype;
			}
		}
		if (async) {
			this.url = this.url + "&async=1";
		}
		Map<String, Object> rootMap = new HashMap<String, Object>();
		String appPath = pageContext.getServletContext().getContextPath();
		String adminPath = pageContext.getServletContext().getContextPath() + SysFunctions.getAdminUrlPrefix();
		String staticPath = pageContext.getServletContext().getContextPath() + "/static";
		rootMap.put("appPath", appPath);
		rootMap.put("adminPath", adminPath);
		rootMap.put("staticPath", staticPath);
		rootMap.put("staticPath", staticPath);
		if (datas != null) {
			String initDatas = "";
			List dataList = (List) datas;
			if (dataList != null && dataList.size() > 0) {
				Class<?> clazz = dataList.get(0).getClass();
				PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
				for (Map<String, Object> columnItem : columnList) {
					String name = (String) columnItem.get("name");
					propertyPreFilterable.addQueryProperty(name);
				}
				propertyPreFilterable.addQueryProperty("id");
				SerializeFilter filter = propertyPreFilterable.constructFilter(clazz);
				initDatas = JSON.toJSONString(datas, filter);
			}
			if (StringUtils.isEmpty(initDatas)) {
				initDatas = "[]";
			}
			rootMap.put("initDatas", initDatas);
			this.datatype = "local";
			this.sortable = Boolean.FALSE;// 本地访问不能进行排序
		}
//		System.out.println("queryList:"+JSON.toJSONString(queryList));
//		System.out.println("columnDictMap:"+JSON.toJSONString(columnDictMap));
		rootMap.put("columnList", columnList);
		rootMap.put("columnDictMap", columnDictMap);
		rootMap.put("queryList", queryList);
		rootMap.put("toobarList", toobarList);
		rootMap.put("buttonList", buttonList);
		System.out.println("##################################################");
		System.out.println("columnList:"+JSON.toJSONString(columnList));
		System.out.println("columnDictMap:"+JSON.toJSONString(columnDictMap));
		System.out.println("queryList:"+JSON.toJSONString(queryList));
		System.out.println("toobarList:"+JSON.toJSONString(toobarList));
		System.out.println("buttonList:"+JSON.toJSONString(buttonList));
		System.out.println("##################################################");
		Map<String, Object> staticMap = FreemarkerFormTagHelper.getTagStatic(this, pageContext);
		rootMap.putAll(staticMap);
//		System.out.println("##########rootMap:"+rootMap);
		String fragment = htmlComponentManager.getFragmentComponent(gridtype + "-grid", rootMap);

//		System.out.println("fragment:"+fragment);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			try {
				super.pageContext.getOut().write(fragment);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}