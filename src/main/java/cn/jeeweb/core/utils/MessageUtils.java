package cn.jeeweb.core.utils;

import org.springframework.context.MessageSource;

/**
 * http://blog.csdn.net/hj7jay/article/details/51383248 Java
 * SpringMVC实现国际化整合案例分析（i18n） http://www.cnblogs.com/liukemng/p/3750117.html
 * SpringMVC学习系列（8） 之 国际化 http://blog.csdn.net/qyf_5445/article/details/8124306
 * spring中MessageSource的配置使用方法1
 * 
 * @author Administrator
 *
 */
public class MessageUtils {

	private static MessageSource messageSource;

	/**
	 * 根据消息键和参数 获取消息 委托给spring messageSource
	 *
	 * @param code
	 *            消息键
	 * @param args
	 *            参数
	 * @return
	 */
	public static String getMessage(String code, Object... args) {
		if (messageSource == null) {
			messageSource = SpringContextHolder.getBean(MessageSource.class);
		}
		return messageSource.getMessage(code, args, null);
	}

	/**
	 * 根据消息键和参数 获取消息 委托给spring messageSource
	 *
	 * @param code
	 *            消息键
	 * @param args
	 *            参数
	 * @return
	 */
	public static String getMessage(String code, String defaultMessage, Object... args) {
		if (messageSource == null) {
			messageSource = SpringContextHolder.getBean(MessageSource.class);
		}
		return messageSource.getMessage(code, args, defaultMessage, null);
	}

	/**
	 * 根据消息键和参数 获取消息 委托给spring messageSource
	 *
	 * @param code
	 *            消息键
	 * @param args
	 *            参数
	 * @return
	 */
	public static String getMessageOrSelf(String code, Object... args) {
		String message = "";
		try {
			message = getMessage(code, args, code);
		} catch (Exception e) {
			message = code;
		}
		return message;
	}

}
