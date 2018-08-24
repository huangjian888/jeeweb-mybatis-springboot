package cn.jeeweb.modules.sms.controller;

import cn.jeeweb.core.common.controller.BaseController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.sms.data.SmsResult;
import cn.jeeweb.modules.sms.service.ISmsSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: 短信发送
 * @Description: 短信发送
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/sms/send")
@RequiresPathPermission("sms:send")
public class SmsSendController extends BaseController {
	@Autowired
	private ISmsSendService smsSendService;

	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public String sms(HttpServletRequest request, HttpServletResponse response) {
		return display("sms");
	}

	@RequestMapping(value = "/sendSmsByContent", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson sendSmsByContent(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("短信发送成功");
		try {
			String phone = request.getParameter("phone");
			String content = request.getParameter("content");
			SmsResult smsResult = smsSendService.sendSyncSmsByContent(phone, content);
			if (!smsResult.isSuccess()) {
				ajaxJson.fail(smsResult.getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("短信发送失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "/sendSmsByCode", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson sendSmsByCode(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("短信发送成功");
		try {
			String phone = request.getParameter("phone");
			String code = request.getParameter("code");
			String data = request.getParameter("data");
			SmsResult smsResult = null;
			if (!StringUtils.isEmpty(data)) {
				String[] datas = data.split(",");
				smsResult = smsSendService.sendSyncSmsByCode(phone, code, datas);
			} else {
				smsResult = smsSendService.sendSyncSmsByCode(phone, code);
			}

			if (!smsResult.isSuccess()) {
				ajaxJson.fail(smsResult.getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("短信发送失败");
		}
		return ajaxJson;
	}
}