package com.company.manerger.sys.service.security.shiro.credential;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import com.company.manerger.sys.service.security.shiro.exception.RepeatAuthenticationException;
import com.company.manerger.sys.service.security.shiro.filter.authc.UsernamePasswordToken;
import com.company.manerger.sys.service.security.shiro.filter.jcaptcha.JCaptchaValidateFilter;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * @description:   密码重试次数限制
 *
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private Cache<String, AtomicInteger> passwordRetryCache;
	private int maxRetryCount = 10;
	private int showCaptchaRetryCount = 2;

	public void setMaxRetryCount(int maxRetryCount) {
		this.maxRetryCount = maxRetryCount;
	}

	public void setShowCaptchaRetryCount(int showCaptchaRetryCount) {
		this.showCaptchaRetryCount = showCaptchaRetryCount;
	}

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
		String username = authcToken.getUsername();
		// retry count + 1
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		//增加一次
		retryCount.incrementAndGet();
		if (retryCount.get() > maxRetryCount) {
			throw new ExcessiveAttemptsException();
		}
		// 判断是否提交验证码
		JCaptchaValidateFilter jCaptchaValidateFilter = SpringContextHolder.getBean(JCaptchaValidateFilter.class);
		// 显示验证码的配置
		if (retryCount.get() >= showCaptchaRetryCount && jCaptchaValidateFilter.isValidateCaptcha()) {
			if (!jCaptchaValidateFilter.isSubmitCapcha()) {
				throw new RepeatAuthenticationException();
			}
		}

		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);
		}
		return matches;
	}

	/**
	 * 是否重复去登录
	 * 
	 * @param useruame
	 * @return
	 */
	public boolean isRepeatLogin(String useruame) {
		AtomicInteger retryCount = passwordRetryCache.get(useruame);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
		}
		return retryCount.get() >= showCaptchaRetryCount;
	}

	/**
	 * 是否显示验证码登录
	 * 
	 * @param useruame
	 *            用户名
	 * @return
	 */
	public boolean isShowCaptcha(String useruame) {
		// 判断是否提交验证码
		JCaptchaValidateFilter jCaptchaValidateFilter = SpringContextHolder.getBean(JCaptchaValidateFilter.class);
		AtomicInteger retryCount = passwordRetryCache.get(useruame);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
		}
		if (retryCount.get() >= showCaptchaRetryCount && jCaptchaValidateFilter.isValidateCaptcha()) {
			return true;
		}
		return false;
	}

	/**
	 * 刷新登录 做好相应的处理
	 * 
	 * @param useruame
	 *            用户名
	 * @return
	 */
	public boolean isForceLogin(String useruame) {
		AtomicInteger retryCount = passwordRetryCache.get(useruame);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
		}
		return retryCount.get() >= maxRetryCount;
	}

	/**
	 * 清除验证
	 * 
	 * @return
	 */
	public void clear(String useruame) {
		passwordRetryCache.remove(useruame);
	}

}
