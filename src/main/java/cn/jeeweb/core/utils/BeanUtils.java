package cn.jeeweb.core.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 
 * 
 * @ClassName: BeanUtils
 * @Description:Bean操作类 http://blog.csdn.net/calvinxiu/article/details/277748
 * @author: auth_team
 * @date: 2017年3月1日 上午8:50:31
 * 
 * @Copyright: 2017 www.jeeweb Inc. All rights reserved.
 *
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {
	/**
	 * 判断一个类是否为基本数据类型。
	 * 
	 * @param clazz
	 *            要判断的类。
	 * @return true 表示为基本数据类型。
	 */
	public static boolean isBaseDataType(Class<?> clazz) throws Exception {
		return (clazz.equals(String.class) || clazz.equals(Integer.class) || clazz.equals(Byte.class)
				|| clazz.equals(Long.class) || clazz.equals(Double.class) || clazz.equals(Float.class)
				|| clazz.equals(Character.class) || clazz.equals(Short.class) || clazz.equals(BigDecimal.class)
				|| clazz.equals(BigInteger.class) || clazz.equals(Boolean.class) || clazz.equals(Date.class)
				|| clazz.isPrimitive());
	}

}
