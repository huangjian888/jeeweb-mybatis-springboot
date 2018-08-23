package cn.jeeweb.core.tags.view;

import java.io.IOException;
import java.lang.reflect.Field;
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
import cn.jeeweb.modules.sys.tags.SysFunctions;

@SuppressWarnings("serial")
public class TreeviewTag extends AbstractGridHtmlTag {
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	private String id = "treeview"; // 树唯一标示
	private String dataUrl = "";// 访问路径
	private Object datas;// 设置的数据
	private String onNodeSelected = "";// 事件
	protected String treeviewSettingCallback = ""; // 配置方法,为js方法，返回配置

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

	public String getOnNodeSelected() {
		return onNodeSelected;
	}

	public void setOnNodeSelected(String onNodeSelected) {
		this.onNodeSelected = onNodeSelected;
	}

	public String getTreeviewSettingCallback() {
		return treeviewSettingCallback;
	}

	public void setTreeviewSettingCallback(String treeviewSettingCallback) {
		this.treeviewSettingCallback = treeviewSettingCallback;
	}

	public HtmlComponentManager getHtmlComponentManager() {
		return htmlComponentManager;
	}

	public void setHtmlComponentManager(HtmlComponentManager htmlComponentManager) {
		this.htmlComponentManager = htmlComponentManager;
	}

	@Override
	public int doStartTag() throws JspException {
		// 清空资源
		if (staticAttributes != null) {
			staticAttributes.clear();
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
		try {
			htmlComponentManager.init();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Object> rootMap = new HashMap<String, Object>();
		String appPath = pageContext.getServletContext().getContextPath();
		String adminPath = pageContext.getServletContext().getContextPath() + SysFunctions.getAdminUrlPrefix();
		String staticPath = pageContext.getServletContext().getContextPath() + "/static";
		rootMap.put("appPath", appPath);
		rootMap.put("adminPath", adminPath);
		rootMap.put("staticPath", staticPath);
		if (datas != null) {
			String initDatas = "";
			List dataList = (List) datas;
			if (dataList != null && dataList.size() > 0) {
				Class<?> clazz = dataList.get(0).getClass();
				PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
				propertyPreFilterable.addQueryProperty("text", "href", "tags", "nodes");
				SerializeFilter filter = propertyPreFilterable.constructFilter(clazz);
				initDatas = JSON.toJSONString(datas, filter);
			}
			if (StringUtils.isEmpty(initDatas)) {
				initDatas = "[]";
			}
			rootMap.put("initDatas", initDatas);
		}
		Map<String, Object> staticMap = FreemarkerFormTagHelper.getTagStatic(this, pageContext);
		rootMap.putAll(staticMap);
		String fragment = htmlComponentManager.getFragmentComponent("bootstrap-treeview", rootMap);
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
