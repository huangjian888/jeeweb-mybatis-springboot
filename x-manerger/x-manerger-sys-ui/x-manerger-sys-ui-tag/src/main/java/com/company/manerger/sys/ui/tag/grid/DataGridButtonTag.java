package com.company.manerger.sys.ui.tag.grid;

import java.util.HashMap;
import java.util.Map;

import com.company.manerger.sys.common.utils.MessageUtils;
import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import com.company.manerger.sys.ui.tag.tag.AbstractGridHtmlTag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @description: 按钮
 *
 */
@Component
@Scope("prototype")
@BeetlTagName("grid.button")
public class DataGridButtonTag extends AbstractGridHtmlTag {
	private static String[] INNER_DEFAULT_FUNCTION = { "delete" };
	private String title = "";// 标题文字
	private String groupname = "";// 分组名
	private String winwidth = "1000px";// 打开窗口宽度
	private String winheight = "500px";// 打开窗口高度
	private String url = "";// 方法请求地址
	private String function = "";// 默认的add，update方法
	private String onclick = "";// click事件,重写事件（与function不能共用）
	private String tipMsg = ""; // 当时询问时打开的时候的询问提示语
	private String outclass = "";// 外部样式
	private String innerclass = "";// 按钮内部的I样式
	private String innerhtml = "";// 按钮内部内容
	private String exp = ""; // 表达式

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getWinwidth() {
		return winwidth;
	}

	public void setWinwidth(String winwidth) {
		this.winwidth = winwidth;
	}

	public String getWinheight() {
		return winheight;
	}

	public void setWinheight(String winheight) {
		this.winheight = winheight;
	}

	public String getOutclass() {
		return outclass;
	}

	public void setOutclass(String outclass) {
		this.outclass = outclass;
	}

	public String getInnerclass() {
		return innerclass;
	}

	public void setInnerclass(String innerclass) {
		this.innerclass = innerclass;
	}

	public String getInnerhtml() {
		return innerhtml;
	}

	public void setInnerhtml(String innerhtml) {
		this.innerhtml = innerhtml;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getTipMsg() {
		return tipMsg;
	}

	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}

	private void dealDefault(DataGridTag parent) {
		if (!StringUtils.isEmpty(this.function) && isFunction(this.function)) {
			// 预处理Url问题
			if (StringUtils.isEmpty(url)) {
				String url = "";
				if (this.function.equals("delete")) {
					url = parent.getBaseUrl() + "/{id}/delete";
				} else {
					url = parent.getBaseUrl() + "/" + this.function;
				}
				staticAttributes.put("url", url);
			}
			if (StringUtils.isEmpty(title)) {
				String title = "sys.common." + this.function;
				 staticAttributes.put("title", MessageUtils.getMessageOrSelf(title));
			}

			if (StringUtils.isEmpty(outclass)) {
				String outclass = "";
				if (this.function.equals("delete")) {
					outclass = "btn-danger";
				}
				staticAttributes.put("outclass", outclass);
			}

			if (StringUtils.isEmpty(innerclass)) {
				String innerclass = "";
				if (this.function.equals("delete")) {
					innerclass = "fa-trash";
				}
				staticAttributes.put("innerclass", innerclass);
			}
		}
	}

	public int doEndTag() throws BeetlTagException {
		// toobar参数配置
		final DataGridTag parent = (DataGridTag)this.ctx.globalVar.get(PARENT_VARIABLE_NAME);;
		dealDefault(parent);
		Map<String, Object> buttonMap = new HashMap<String, Object>();
		buttonMap.putAll(staticAttributes);
		if (buttonMap.containsKey("outclass")) {
			buttonMap.put("outclass", "btn btn-xs " + buttonMap.get("outclass"));
		}
		if (buttonMap.containsKey("innerclass")) {
			buttonMap.put("innerclass", "fa " + buttonMap.get("innerclass"));
		} else {
			buttonMap.put("innerclass", "empty");
		}
		// 预处理onclick
		if (!StringUtils.isEmpty(onclick)) {
			buttonMap.put("onclick", handleOnclick(onclick));
		}
		if (dynamicAttributes == null) {
			dynamicAttributes = new HashMap<String, Object>();
		}
		if (!dynamicAttributes.containsKey("class")) {
			dynamicAttributes.put("class", "btn btn-xs ");
		}
		buttonMap.put("dynamicAttributes", dynamicAttributes);
		parent.addButton(buttonMap);
		return EVAL_PAGE;
	}

	private String handleOnclick(String onclickFunc) {
		String[] funcs = StringUtils.split(onclickFunc.replace(")", ""), "(");
		String func = funcs[0];
		String parameter = funcs[1];
		String[] parameters = parameter.split(",");
		String newParameters = "";
		for (String parameterItem : parameters) {
			if (!StringUtils.isEmpty(newParameters)) {
				newParameters += ",";
			}
			if (parameterItem.contains("row.")) {
				parameterItem = "'\"+" + parameterItem + "+\"'";
			}
			newParameters += parameterItem;
		}
		String newFunc = func + "(" + newParameters + ")";
		return newFunc;
	}

	@Override
	public void setDynamicAttribute( String localName, Object value) throws BeetlTagException {
		super.setDynamicAttribute(localName, value);
		if (localName.equals("title")) {
			 dynamicAttributes.put(localName, MessageUtils.getMessageOrSelf((String) value));
		}
	}

	@Override
	public void setStaticAttribute(String localName, Object value) throws BeetlTagException {
		super.setStaticAttribute(localName, value);
		if (localName.equals("title")) {
			staticAttributes.put(localName, MessageUtils.getMessageOrSelf((String) value));
		}
	}

	public Boolean isFunction(String function) {
		for (String defaultFunction : INNER_DEFAULT_FUNCTION) {
			if (defaultFunction.equals(function.toLowerCase())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}