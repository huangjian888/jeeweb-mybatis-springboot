package cn.jeeweb.core.tags.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import cn.jeeweb.core.tags.common.tag.AbstractGridHtmlTag;
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
 * @Description: 查询
 * @author: auth_team
 * @date: 2017年3月4日 下午9:03:39
 * @version V1.0
 * @Copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class DataGridQueryTag extends AbstractGridHtmlTag {
	private String label;// 标题文字
	private String name;// 列字段名称
	private String queryMode = "input";// 默认为input，有dict时候，默认为select
	private String condition = "eq";// 查询方式
	private String dict;// 字典类型

	private Map<String, Object> queryStaticAttributes;
	private Map<String, Object> queryDynamicAttributes;
	private DataGridTag parentTag = null;

	public int doEndTag() throws JspTagException {
		parentTag = (DataGridTag) findAncestorWithClass(this, DataGridTag.class);
		this.label = MessageUtils.getMessageOrSelf(label);
		addQuery();
		return EVAL_PAGE;
	}

	private void addQuery() {
		// 初始化数据

		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("name", name);
		queryMap.put("label", label);
		if (!StringUtils.isEmpty(dict)) {
			queryMap.put("dict", dict);
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
		System.out.println("queryMap:"+ JSON.toJSONString(queryMap));
		parentTag.addQuery(queryMap);

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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

}