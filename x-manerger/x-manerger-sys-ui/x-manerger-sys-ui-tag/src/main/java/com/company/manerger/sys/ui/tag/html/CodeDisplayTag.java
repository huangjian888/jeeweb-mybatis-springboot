package com.company.manerger.sys.ui.tag.html;

import java.util.Map;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.tag.form.support.FreemarkerFormTagHelper;
import com.company.manerger.sys.ui.tag.html.manager.HtmlComponentManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@BeetlTagName("html.codedisplay")
public class CodeDisplayTag extends DisplayTag {
	// 代码类型
	private String codeType = "java";

	@Override
	protected String getContent() {
		String bodyContent = super.getContent();
//		Map<String, Object> rootMap = new HashMap<String, Object>();
//		String ctx = (String)this.ctx.globalVar.get("ctxPath");
//		String adminPath = ctx + "";
//		String staticPath = ctx + "/static";
//		rootMap.put("ctx", ctx);
//		rootMap.put("adminPath", adminPath);
//		rootMap.put("staticPath", staticPath);
		Map<String, Object> rootMap = FreemarkerFormTagHelper.getTagStatic(this, this.ctx);
		rootMap.put("codeType", codeType.toLowerCase());
		rootMap.put("bodyContent", bodyContent);
		HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
				.getBean(HtmlComponentManager.class);
		String fragment = htmlComponentManager.getFragmentComponent("syntaxhighlighter-code", rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			return fragment;
		}
		return bodyContent;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

}