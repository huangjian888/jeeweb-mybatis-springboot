package cn.jeeweb.core.tags.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import cn.jeeweb.core.tags.common.tag.AbstractGridHtmlTag;
import cn.jeeweb.core.utils.MapUtils;
import cn.jeeweb.core.utils.MessageUtils;
import cn.jeeweb.core.utils.ObjectUtils;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.entity.Dict;
import cn.jeeweb.modules.sys.utils.DictUtils;
import com.alibaba.fastjson.JSON;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @Title: DataGridColumnTag.java
 * @Package cn.jeeweb.core.tags.grid
 * @Description: 数据列
 * @author: auth_team
 * @date: 2017年3月4日 下午9:03:39
 * @version V1.0
 * @Copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class DataGridColumnTag extends AbstractGridHtmlTag {
	private final static String[] keys = { "prefix", "suffix", "formatterValue", "formatterClass", "formatterColor",
			"imageWidth", "imageHeight", "dict", "dateformat" };
	private String label;// 标题文字
	private String name;// 列字段名称
	private String queryMode = "input";// 默认为input，有dict时候，默认为select
	private int width = 120;// 宽度
	private Boolean query = Boolean.FALSE;// 是否为查询
	private String condition = "eq";// 查询方式
	private String align = "left"; // 对齐方式
	private Boolean sortable = Boolean.TRUE;// 是否开启排序
	private Boolean checkbox = Boolean.TRUE;// 是否为复选框
	private Boolean hidden = Boolean.FALSE;// 是否隐藏列
	private String dict;// 字典类型
	private String formatter;// 格式化，默认格式化有integer,currency,email,link,label,image,button,date
	private String formatoptions;// 格式化参数
	private String prefix;// 前綴
	private String suffix;// 后缀
	private String formatterValue;// 格式化的值
	private String formatterClass;// 格式化的样式
	private String formatterColor;// 格式化的颜色
	private String imageWidth;// 图片的宽度
	private String imageHeight;// 图片的高度
	private String dateformat;// 时间格式化
	private String columnSetting = "{}";// 扩展设置
	private String columnSettingCallback = ""; // 配置方法,为js方法，返回配置

	private Boolean editable = Boolean.FALSE;// 是否开启编辑
	private String edittype = "text";// 类型可以编辑的类型。可选值：text, textarea,
										// select,password,date,autocomplete
										// 不支持checkbox, button, image and file.
	private String editdateformat = "yyyy-mm-dd";
	private String editoptions = "";// 行内编辑回调
	// 验证
	private String editrules;
	private String datatype;// 验证规则
	private String nullmsg;// 空验证
	private String errormsg;// 验证错误

	private Map<String, Object> queryStaticAttributes;
	private Map<String, Object> queryDynamicAttributes;
	private DataGridTag parentTag = null;

	public int doEndTag() throws JspTagException {
		parentTag = (DataGridTag) findAncestorWithClass(this, DataGridTag.class);
		this.label = MessageUtils.getMessageOrSelf(label);
		addQuery();
		addColumn();
		return EVAL_PAGE;
	}

	private void addQuery() {
		// 初始化数据
		if (query) {
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("name", name);
			queryMap.put("label", label);
			if (!StringUtils.isEmpty(dict)) {
				queryMap.put("dict", dict);
			}else if(!StringUtils.isEmpty(formatterValue)) {
				String dict=this.name+"_"+formatterValue.hashCode();
				queryMap.put("dict",dict);
				parentTag.putColumnDict(dict,formatterValueToDict(this.formatterValue));
			}
			queryMap.put("queryMode", queryMode);
			queryMap.put("condition", condition);
			if (queryDynamicAttributes != null) {
				queryMap.putAll(queryDynamicAttributes);
			}
			if (queryStaticAttributes != null) {
				queryMap.putAll(queryStaticAttributes);
			}
			if (!queryMap.containsKey("class")) {
				queryMap.put("class", "form-control");
			}
			if (queryMode.equals("radio") || queryMode.equals("checkbox")) {
				queryMap.put("class", queryMap.get("class") + " i-checks");
			}
			parentTag.addQuery(queryMap);
		}
	}

	private void addColumn() {
		Map<String, Object> columnMap = new HashMap<String, Object>();
//		System.out.println("########staticAttributes:"+ JSON.toJSONString(staticAttributes));
		columnMap.putAll(staticAttributes);
		if (!StringUtils.isEmpty(editoptions)) {
			columnMap.put("editoptions", editoptions + "()");
		}
		// 编辑的时候，行不需要格式化显示
		if (editable) {
			if (edittype.equals("select")) {
				if (columnMap.get(editoptions) == null && !StringUtils.isEmpty(dict)) {
					if (StringUtils.isEmpty(editoptions)) {
						columnMap.put("editoptions", dict + "SelectEditoptions");
					}
				}
			}
			if (edittype.equals("date")) {
				if (StringUtils.isEmpty(editoptions)) {
					columnMap.put("editoptions", "date");
				}
				columnMap.put("edittype", "text");
			}
		}
		if (!StringUtils.isEmpty(dict)) {
			parentTag.putColumnDict(dict);
		}
		if (StringUtils.isEmpty(formatter)) {
			if (MapUtils.containsOrKeys(columnMap, keys)) {
				String formatter= "label";
				columnMap.put("formatter", formatter);
			}
		}
		if (!StringUtils.isEmpty(dict) && StringUtils.isEmpty(formatterValue)) {
			String formatterValue = dictToFormatterValue(dict);
			columnMap.put("formatterValue", formatterValue);
		}
		parentTag.addColumn(columnMap);
	}

	private List<Dict> formatterValueToDict(String formatterValue){
		String[] dicts=formatterValue.split(";");
		List<Dict> dictList=new ArrayList<Dict>();
		for (int i = 0; i < dicts.length; i++) {
			String dict=dicts[i];
			if (!StringUtils.isEmpty(dict)) {
				String[] dictMap= dict.split(":");
				if (dictMap.length==2) {
					Dict dictBean=new Dict();
					dictBean.setLabel(dictMap[1]);
					dictBean.setValue(dictMap[0]);
					dictList.add(dictBean);
				}
			}
		}
		return dictList;
	}

	public String dictToFormatterValue(String dict) {
		String dictStr = "";
		List<Dict> dictList = DictUtils.getDictList(dict);
		for (Dict dictEntity : dictList) {
			if (!StringUtils.isEmpty(dictStr)) {
				dictStr += ";";
			}
			dictStr += dictEntity.getValue() + ":" + dictEntity.getLabel();
		}
		return dictStr;
	}

	@Override
	public void setStaticAttribute(String localName, Object value) throws JspException {
		if (this.staticAttributes == null) {
			this.staticAttributes = new HashMap<String, Object>();
		}
		if (this.queryStaticAttributes == null) {
			this.queryStaticAttributes = new HashMap<String, Object>();
		}
		if (!ObjectUtils.isNullOrEmpty(value)) {
			if (localName.equals("query")) {// 不处理
				return;
			} else if (localName.equals("condition") || localName.startsWith("query_")) {// query参数
				localName = localName.replace("query_", localName);// 去掉前缀
				queryStaticAttributes.put(localName, value);
			} else {
				staticAttributes.put(localName, value);
			}
		}
		if (localName.equals("label")) {
			staticAttributes.put(localName, MessageUtils.getMessageOrSelf((String) value));
		}
	}

	@Override
	public void setDynamicAttribute(String url, String localName, Object value) throws JspException {
		if (this.dynamicAttributes == null) {
			this.dynamicAttributes = new HashMap<String, Object>();
		}
		if (this.queryDynamicAttributes == null) {
			this.queryDynamicAttributes = new HashMap<String, Object>();
		}

		if (localName.equals("condition") || localName.startsWith("query_")) {// query参数
			localName = localName.replace("query_", "");// 去掉前缀
			queryDynamicAttributes.put(localName, value);
		} else {
			dynamicAttributes.put(localName, value);
		}
		if (localName.equals("label")) {
			dynamicAttributes.put(localName, MessageUtils.getMessageOrSelf((String) value));
		}

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Boolean getQuery() {
		return query;
	}

	public void setQuery(Boolean query) {
		this.query = query;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	public Boolean getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(Boolean checkbox) {
		this.checkbox = checkbox;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public String getDict() {
		return dict;
	}

	public void setDict(String dict) {
		this.dict = dict;
	}

	public String getQueryMode() {
		return queryMode;
	}

	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}

	public String getDateformat() {
		return dateformat;
	}

	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	public String getColumnSetting() {
		return columnSetting;
	}

	public void setColumnSetting(String columnSetting) {
		this.columnSetting = columnSetting;
	}

	public String getColumnSettingCallback() {
		return columnSettingCallback;
	}

	public void setColumnSettingCallback(String columnSettingCallback) {
		this.columnSettingCallback = columnSettingCallback;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public String getFormatoptions() {
		return formatoptions;
	}

	public void setFormatoptions(String formatoptions) {
		this.formatoptions = formatoptions;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public String getEdittype() {
		return edittype;
	}

	public void setEdittype(String edittype) {
		this.edittype = edittype;
	}

	public String getEditoptions() {
		return editoptions;
	}

	public void setEditoptions(String editoptions) {
		this.editoptions = editoptions;
	}

	public String getEditdateformat() {
		return editdateformat;
	}

	public void setEditdateformat(String editdateformat) {
		this.editdateformat = editdateformat;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFormatterValue() {
		return formatterValue;
	}

	public void setFormatterValue(String formatterValue) {
		this.formatterValue = formatterValue;
	}

	public String getFormatterClass() {
		return formatterClass;
	}

	public void setFormatterClass(String formatterClass) {
		this.formatterClass = formatterClass;
	}

	public String getFormatterColor() {
		return formatterColor;
	}

	public void setFormatterColor(String formatterColor) {
		this.formatterColor = formatterColor;
	}

	public String getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}

	public String getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(String imageHeight) {
		this.imageHeight = imageHeight;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getNullmsg() {
		return nullmsg;
	}

	public void setNullmsg(String nullmsg) {
		this.nullmsg = nullmsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getEditrules() {
		return editrules;
	}

	public void setEditrules(String editrules) {
		this.editrules = editrules;
	}

}