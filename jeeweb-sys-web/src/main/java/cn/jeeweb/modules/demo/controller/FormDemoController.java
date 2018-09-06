package cn.jeeweb.modules.demo.controller;

import cn.jeeweb.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: FormDemoController.java
 * @package cn.jeeweb.modules.demo.controller
 * @description: 编辑器demo
 * @author: auth_team
 * @date: 2017年5月18日 下午6:17:24
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/demo/form")
public class FormDemoController extends BaseController {

	/**
	 * 
	 * @title: editor
	 * @description: 编辑器
	 * @return
	 * @return: String
	 */
	@RequestMapping("/editor")
	public String editor() {
		return display("editor");
	}

	/**
	 * 
	 * @title: editor
	 * @description: 文件上传
	 * @return
	 * @return: String
	 */
	@RequestMapping("/upload")
	public String upload() {
		return display("upload");
	}

	@RequestMapping("/combox")
	public String combox(HttpServletRequest request) {
		return display("combox");
	}

	@RequestMapping("/ajaxCombox")
	@ResponseBody
	public List<?> ajaxCombox(HttpServletRequest request) {
		//String keyword = request.getParameter("keyword");
		return null;
	}

}
