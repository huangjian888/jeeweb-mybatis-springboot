package cn.jeeweb.modules.sys.security.shiro.web.filter.authc.credential;

import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.modules.sys.security.shiro.exception.RepeatAuthenticationException;
import cn.jeeweb.modules.sys.security.shiro.web.filter.authc.UsernamePasswordToken;
import cn.jeeweb.modules.sys.security.shiro.web.filter.jcaptcha.JCaptchaValidateFilter;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * @title:  RetryLimitHashedCredentialsMatcher.java   
 * @package cn.jeeweb.modules.sys.security.shiro.web.filter.authc.credential   
 * @description:   密码重试次数限制  
 * @author: auth_team
 * @date:   2017年6月26日 下午5:55:43   
 * @version V1.0 
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved. 
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
		if(passwordRetryCache != null){
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
		}
		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			// clear retry count
			if(passwordRetryCache != null){
				passwordRetryCache.remove(username);
			}
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
		if(passwordRetryCache != null){
			AtomicInteger retryCount = passwordRetryCache.get(useruame);
			if (retryCount == null) {
				retryCount = new AtomicInteger(0);
			}
			return retryCount.get() >= showCaptchaRetryCount;
		}
		return false;
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
		if(passwordRetryCache != null){
			AtomicInteger retryCount = passwordRetryCache.get(useruame);
			if (retryCount == null) {
				retryCount = new AtomicInteger(0);
			}
			if (retryCount.get() >= showCaptchaRetryCount && jCaptchaValidateFilter.isValidateCaptcha()) {
				return true;
			}
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
		if(passwordRetryCache != null){
			AtomicInteger retryCount = passwordRetryCache.get(useruame);
			if (retryCount == null) {
				retryCount = new AtomicInteger(0);
			}
			return retryCount.get() >= maxRetryCount;
		}
		return false;
	}

	/**
	 * 清除验证
	 * 
	 * @return
	 */
	public void clear(String useruame) {
		if(passwordRetryCache != null){
			passwordRetryCache.remove(useruame);
		}
	}

}
