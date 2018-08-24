package cn.jeeweb.modules.email.controller;

import cn.jeeweb.core.common.controller.BaseController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.email.EmailResult;
import cn.jeeweb.modules.email.service.IEmailSendService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: 邮件发送
 * @Description: 邮件发送
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/email/send")
@RequiresPathPermission("email:send")
public class EmailSendController extends BaseController {
	@Autowired
	private IEmailSendService emailSendService;

	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String email(HttpServletRequest request, HttpServletResponse response) {
		return display("email");
	}

	@RequestMapping(value = "/sendEmailByContent", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson sendEmailByContent(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("邮件发送成功");
		try {
			String email = request.getParameter("email");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			content = StringEscapeUtils.unescapeHtml4(content);
			EmailResult emailResult = emailSendService.sendSyncEmail(email, subject, content);
			if (!emailResult.isSuccess()) {
				ajaxJson.fail(emailResult.getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("邮件发送失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "/sendEmailByCode", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson sendEmailByCode(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("邮件发送成功");
		try {
			String email = request.getParameter("email");
			String code = request.getParameter("code");
			String data = request.getParameter("data");
			EmailResult emailResult = null;
			if (!StringUtils.isEmpty(data)) {
				String[] datas = data.split(",");
				emailResult = emailSendService.sendSyncEmailByCode(email, code, datas);
			} else {
				emailResult = emailSendService.sendSyncEmailByCode(email, code);
			}

			if (!emailResult.isSuccess()) {
				ajaxJson.fail(emailResult.getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("邮件发送失败");
		}
		return ajaxJson;
	}
}