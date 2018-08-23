package cn.jeeweb.modules.common.interceptor;

import cn.jeeweb.core.utils.DateUtils;
import cn.jeeweb.modules.sys.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: LogInterceptor.java
 * @package cn.jeeweb.modules.common.interceptor
 * @description: 访问日志拦截器
 * @author: auth_team
 * @date: 2017年7月11日 下午12:17:54
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class LogInterceptor implements HandlerInterceptor {

	private Boolean openAccessLog = Boolean.FALSE;

	 

	public void setOpenAccessLog(Boolean openAccessLog) {
		this.openAccessLog = openAccessLog;
	}

	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (logger.isDebugEnabled()) {
			long beginTime = System.currentTimeMillis();// 1、开始时间
			startTimeThreadLocal.set(beginTime); // 线程绑定变量（该数据只有当前请求的线程可见）
			logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime),
					request.getRequestURI());
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			//logger.info("ViewName: " + modelAndView.getViewName());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (openAccessLog) {
			// 保存日志
			LogUtils.saveLog(request, handler, ex, null);
			// 打印JVM信息。
			if (logger.isDebugEnabled()) {
				long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
				long endTime = System.currentTimeMillis(); // 2、结束时间
				logger.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
						new SimpleDateFormat("hh:mm:ss.SSS").format(endTime),
						DateUtils.formatDateTime(endTime - beginTime), request.getRequestURI(),
						Runtime.getRuntime().maxMemory() / 1024 / 1024,
						Runtime.getRuntime().totalMemory() / 1024 / 1024,
						Runtime.getRuntime().freeMemory() / 1024 / 1024,
						(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()
								+ Runtime.getRuntime().freeMemory()) / 1024 / 1024);
			}
		}

	}

}
