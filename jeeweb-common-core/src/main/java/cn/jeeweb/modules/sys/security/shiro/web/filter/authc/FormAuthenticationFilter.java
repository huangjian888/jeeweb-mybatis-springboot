package cn.jeeweb.modules.sys.security.shiro.web.filter.authc;

import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.utils.IpUtils;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.security.shiro.exception.RepeatAuthenticationException;
import cn.jeeweb.modules.sys.security.shiro.realm.UserRealm.Principal;
import cn.jeeweb.modules.sys.utils.UserUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * All rights Reserved, Designed By www.jeeweb.cn
 * @title:  FormAuthenticationFilter.java
 * @package cn.jeeweb.modules.sys.security.shiro.web.filter.authc
 * @description:   表单验证
 * @author: auth_team
 * @date:   2017年6月26日 下午5:56:03
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	public static final String DEFAULT_MOBILE_PARAM = "mobileLogin";
	public static final String DEFAULT_MESSAGE_ERROR_PARAM = "error";
	public static final String DEFAULT_MESSAGE_SUCCESS_PARAM = "success";
	public static final String DEFAULT_MESSAGE_NORMAL_PARAM = "normal";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	private String mobileLoginParam = DEFAULT_MOBILE_PARAM;
	private String messageErrorParam = DEFAULT_MESSAGE_ERROR_PARAM;
	private String messageSuccessParam = DEFAULT_MESSAGE_SUCCESS_PARAM;
	private String messageNormallParam = DEFAULT_MESSAGE_NORMAL_PARAM;

	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		System.out.println("FormAuthenticationFilter-------------------------createToken");
		if (password == null) {
			password = "";
		}
		boolean rememberMe = isRememberMe(request);
		String host = IpUtils.getIpAddr((HttpServletRequest) request);
		String captcha = getCaptcha(request);
		boolean mobile = isMobileLogin(request);
		return new UsernamePasswordToken(username, password.toCharArray(), rememberMe, host, captcha, mobile);
	}

	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	public void setMobileLoginParam(String mobileLoginParam) {
		this.mobileLoginParam = mobileLoginParam;
	}

	public void setMessageErrorParam(String messageErrorParam) {
		this.messageErrorParam = messageErrorParam;
	}

	public void setMessageSuccessParam(String messageSuccessParam) {
		this.messageSuccessParam = messageSuccessParam;
	}

	public void setMessageNormallParam(String messageNormallParam) {
		this.messageNormallParam = messageNormallParam;
	}

	public String getMessageErrorParam() {
		return messageErrorParam;
	}

	public String getMessageSuccessParam() {
		return messageSuccessParam;
	}

	public String getMessageNormallParam() {
		return messageNormallParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	public String getMobileLoginParam() {
		return mobileLoginParam;
	}

	protected boolean isMobileLogin(ServletRequest request) {
		return WebUtils.isTrue(request, getMobileLoginParam());
	}

	/**
	 * 登录成功之后跳转URL
	 */
	public String getSuccessUrl() {
		System.out.println("FormAuthenticationFilter----------------getSuccessUrl");
		System.out.println("FormAuthenticationFilter---------getSuccessUrl:"+super.getSuccessUrl());
		return super.getSuccessUrl();
	}

	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		System.out.println("FormAuthenticationFilter----------------issueSuccessRedirect");
		Principal p = UserUtils.getPrincipal();
		UserUtils.clearCache();
		if (p != null && !p.isMobileLogin()) {
			WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
		} else {
			AjaxJson ajaxJson = new AjaxJson();
			ajaxJson.setRet(AjaxJson.RET_SUCCESS);
			ajaxJson.setMsg("登录成功!");
			ajaxJson.put("username", p.getUsername());
			ajaxJson.put("realname", p.getRealname());
			ajaxJson.put("mobileLogin", p.isMobileLogin());
			ajaxJson.put("JSESSIONID", p.getSessionid());
			StringUtils.printJson((HttpServletResponse) response, ajaxJson);
		}
	}

	/**
	 * 登录失败调用事件
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
                                     ServletResponse response) {
		super.onLoginFailure(token, e, request, response);
		UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
		if (!authcToken.isMobileLogin()) {
			String className = e.getClass().getName(), message = "";
			if (IncorrectCredentialsException.class.getName().equals(className)
					|| UnknownAccountException.class.getName().equals(className)) {
				message = "用户或密码错误, 请重试.";
			} else if (RepeatAuthenticationException.class.getName().equals(className)) {
				message = "请勿重复提交认证.";
			} else if (ExcessiveAttemptsException.class.getName().equals(className)) {
				message = "请勿重复提交认证,请半小时之后登录";
			} else if (StringUtils.isNoneBlank(e.getMessage())) {
				message = e.getMessage();
			} else {
				message = "系统出现点问题，请稍后再试！";
				e.printStackTrace(); // 输出到控制台
			}
			request.setAttribute(getFailureKeyAttribute(), className);
			request.setAttribute(getMessageErrorParam(), message);
			return true;
		} else {
			// 登录失败返回false
			AjaxJson ajaxJson = new AjaxJson();
			ajaxJson.setRet(AjaxJson.RET_FAIL);
			ajaxJson.setMsg("登录失败!");
			ajaxJson.put("mobileLogin", authcToken.isMobileLogin());
			ajaxJson.put("JSESSIONID", UserUtils.getSession().getId());
			StringUtils.printJson((HttpServletResponse) response, ajaxJson);
			return false;
		}
	}

}