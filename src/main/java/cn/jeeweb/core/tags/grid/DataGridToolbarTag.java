package cn.jeeweb.core.tags.grid;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import cn.jeeweb.core.tags.common.tag.AbstractGridHtmlTag;
import cn.jeeweb.core.utils.MessageUtils;
import cn.jeeweb.core.utils.StringUtils;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: DataGridToolbarTag.java
 * @package cn.jeeweb.core.tags.grid
 * @description:工具栏目
 * @author: auth_team
 * @date: 2017年3月12日 下午1:32:07
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class DataGridToolbarTag extends AbstractGridHtmlTag {
	private static String[] INNER_DEFAULT_FUNCTION = { "create", "update", "delete", "search", "reset" };
	private String title = "";// 标题文字
	private String winwidth = "800px";// 打开窗口宽度
	private String winheight = "500px";// 打开窗口高度
	private String btnclass = "";// 按样式
	private String icon = "";// 图标
	private String url = "";// 方法请求地址
	private String baseUrl = "";
	private String function = "";// 默认的create,update,delete方法
	private String onclick = "";// click事件
	private String layout = "left";// left，right;默认在左边
	private String tipMsg = ""; // 当时询问时打开的时候的询问提示语
	private String exp = ""; // 表达式

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
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

	public String getTipMsg() {
		return tipMsg;
	}

	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}
	

	public String getBtnclass() {
		return btnclass;
	}

	public void setBtnclass(String btnclass) {
		this.btnclass = btnclass;
	}

	public int doEndTag() throws JspTagException {
		// toobar参数配置
		Tag t = findAncestorWithClass(this, DataGridTag.class);
		final DataGridTag parent = (DataGridTag) t;
		dealDefault(parent);
		Map<String, Object> toobarMap = new HashMap<String, Object>();
		toobarMap.putAll(staticAttributes);
		if (dynamicAttributes == null) {
			dynamicAttributes = new HashMap<String, Object>();
		}
		toobarMap.put("dynamicAttributes", dynamicAttributes);
		parent.addToolbar(toobarMap);
		return EVAL_PAGE;
	}

	private void dealDefault(DataGridTag parent) {
		if (!StringUtils.isEmpty(this.function) && isFunction(this.function)) {
			baseUrl = parent.getBaseUrl();
			staticAttributes.put("baseUrl", baseUrl);
			// 预处理Url问题
			if (StringUtils.isEmpty(url)) {
				String url = "";
				if (this.function.equals("delete")) {
					url = parent.getBaseUrl() + "/batch/delete";
				} else if (this.function.equals("update")) {
					url = parent.getBaseUrl() + "/{id}/" + this.function;
				} else {
					url = parent.getBaseUrl() + "/" + this.function;
				}
				staticAttributes.put("url", url);
			}

			if (StringUtils.isEmpty(title)) {
				String title = "sys.common." + this.function;
				staticAttributes.put("title", MessageUtils.getMessageOrSelf(title));
			}

			if (StringUtils.isEmpty(this.icon)) {
				String icon = "";
				if (this.function.equals("create")) {
					// btn-info
					icon = "fa-plus";
				} else if (this.function.equals("update")) {
					icon = "fa-file-text-o";
				} else if (this.function.equals("delete")) {
					icon = "fa-trash-o";
				} else if (this.function.equals("search")) {
					icon = "fa-search";
				} else if (this.function.equals("reset")) {
					icon = "fa-refresh";
				}
				staticAttributes.put("icon", icon);
			}

			if (StringUtils.isEmpty(this.btnclass)) {
				String btnclass = "";
				if (this.function.equals("create")) {
					// btn-info
					btnclass = "btn-primary";
				} else if (this.function.equals("update")) {
					btnclass = "btn-success";
				} else if (this.function.equals("delete")) {
					btnclass = "btn-danger";
				} else if (this.function.equals("search")) {
					btnclass = "btn-info";
				} else if (this.function.equals("reset")) {
					btnclass = "btn-warning";
				} else {
					btnclass = "btn-info";
				}
				staticAttributes.put("btnclass", btnclass);
			}

			if (this.function.equals("search") || this.function.equals("reset")) {
				staticAttributes.put("layout", "right");
			}
		}
	}


	@Override
	public void setDynamicAttribute(String url, String localName, Object value) throws JspException {
		super.setDynamicAttribute(url, localName, value);
		if (localName.equals("title") && StringUtils.isEmpty(title)) {
			dynamicAttributes.put(localName, MessageUtils.getMessageOrSelf((String) value));
		}
	}

	@Override
	public void setStaticAttribute(String localName, Object value) throws JspException {
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