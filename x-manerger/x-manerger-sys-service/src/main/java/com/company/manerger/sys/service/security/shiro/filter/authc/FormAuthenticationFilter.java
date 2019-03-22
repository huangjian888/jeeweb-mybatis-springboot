package com.company.manerger.sys.service.security.shiro.filter.authc;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.company.manerger.sys.common.utils.IpUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.security.shiro.realm.UserRealm;
import com.company.manerger.sys.service.utils.LoginLogUtils;
import com.company.manerger.sys.service.utils.UserUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.util.WebUtils;
import com.company.manerger.sys.service.security.shiro.exception.RepeatAuthenticationException;

/**
 * @description:   表单验证
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
		return super.getSuccessUrl();
	}

	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		UserRealm.Principal p = UserUtils.getPrincipal();
		UserUtils.clearCache();
		if (p != null && !p.isMobileLogin()) {
			LoginLogUtils.recordSuccessLoginLog(p.getUsername(),"登陆成功");
			WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
		} else {
			/*Response ajaxJson = new Response();
			ajaxJson.setRet(Response.RET_SUCCESS);
			ajaxJson.setMsg("登录成功!");
			ajaxJson.put("username", p.getUsername());
			ajaxJson.put("realname", p.getRealname());
			ajaxJson.put("mobileLogin", p.isMobileLogin());
			ajaxJson.put("JSESSIONID", p.getSessionid());
			StringUtils.printJson((HttpServletResponse) response, ajaxJson);*/
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
			LoginLogUtils.recordFailLoginLog(authcToken.getUsername(),message);
			request.setAttribute(getFailureKeyAttribute(), className);
			request.setAttribute(getMessageErrorParam(), message);
			return true;
		} else {
			// 登录失败返回false
			/*Response ajaxJson = new Response();
			ajaxJson.setRet(Response.RET_FAIL);
			ajaxJson.setMsg("登录失败!");
			ajaxJson.put("mobileLogin", authcToken.isMobileLogin());
			ajaxJson.put("JSESSIONID", UserUtils.getSession().getId());
			StringUtils.printJson((HttpServletResponse) response, ajaxJson);*/
			return false;
		}
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//		当验证码验证失败时不再走身份认证拦截器
		String error = (String) request.getAttribute(getFailureKeyAttribute());
		if(error != null && error.equalsIgnoreCase("jCaptcha.error")) {
			request.setAttribute(getMessageErrorParam(), "验证码错误!");
			return true;
		}
		return super.onAccessDenied(request, response, mappedValue);
	}
}