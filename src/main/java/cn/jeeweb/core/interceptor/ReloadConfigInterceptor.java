package cn.jeeweb.core.interceptor;

import cn.jeeweb.core.tags.html.manager.HtmlComponentManager;
import cn.jeeweb.core.utils.SpringContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReloadConfigInterceptor implements HandlerInterceptor {
	private Boolean developMode = Boolean.FALSE;
	private long reloadConfigInterval = 60 * 1000;
	private long lastReloadConfigCheckTime = System.currentTimeMillis();

	public void setDevelopMode(Boolean developMode) {
		this.developMode = developMode;
	}

	public void setReloadConfigInterval(long reloadConfigInterval) {
		this.reloadConfigInterval = reloadConfigInterval;
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
                                Exception exception) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
                           ModelAndView modelAndView) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		if (developMode) {
			/**
			 * 下面是自动加载配置文件的算法实现
			 */
			long now = System.currentTimeMillis();
			if ((now - this.reloadConfigInterval > this.lastReloadConfigCheckTime)) {
				this.lastReloadConfigCheckTime = now;
				// 检查文件是否修改
				HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
						.getBean(HtmlComponentManager.class);
				htmlComponentManager.init();
			}
		}
		return true;
	}

}
