package com.company.manerger.sys.common.utils;

import org.springframework.context.MessageSource;


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
		try {
			if (messageSource == null) {
				messageSource = SpringContextHolder.getBean(MessageSource.class);
			}
			return messageSource.getMessage(code, args, null);
		} catch (Exception e) {

		}
		return "";
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
		try {
			if (messageSource == null) {
				messageSource = SpringContextHolder.getBean(MessageSource.class);
			}
			return messageSource.getMessage(code, args, defaultMessage, null);
		} catch (Exception e) {

		}
		return "";
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
			if (messageSource == null) {
				messageSource = SpringContextHolder.getBean(MessageSource.class);
			}
			return messageSource.getMessage(code, args, null);
		} catch (Exception e) {
			message = code;
		}
		return message;
	}

}
