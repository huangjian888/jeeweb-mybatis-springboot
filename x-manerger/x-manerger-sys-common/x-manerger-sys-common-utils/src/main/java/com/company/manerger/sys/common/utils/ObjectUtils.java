package com.company.manerger.sys.common.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.Map;



@SuppressWarnings("rawtypes")
public final class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {

	/**
	 * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;

		if (obj instanceof Collection)
			return ((Collection) obj).isEmpty();

		if (obj instanceof Map)
			return ((Map) obj).isEmpty();

		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			if (object.length == 0) {
				return true;
			}
			boolean empty = true;
			for (int i = 0; i < object.length; i++) {
				if (!isNullOrEmpty(object[i])) {
					empty = false;
					break;
				}
			}
			return empty;
		}
		return false;
	}

	/**
	 * 判断一个类是否为基本数据类型。
	 * 
	 * @param clazz
	 *            要判断的类。
	 * @return true 表示为基本数据类型。
	 */
	public static boolean isBaseDataType(Class<?> clazz) {
		Boolean isBaseType = (clazz.equals(String.class) || clazz.equals(Integer.class) || clazz.equals(Byte.class)
				|| clazz.equals(Long.class) || clazz.equals(Double.class) || clazz.equals(Float.class)
				|| clazz.equals(Character.class) || clazz.equals(Short.class) || clazz.equals(BigDecimal.class)
				|| clazz.equals(BigInteger.class) || clazz.equals(Boolean.class) || clazz.equals(Date.class)
				|| clazz.isPrimitive());
		return isBaseType;
	}

	/**
	 * 判断是否相等
	 * 
	 * @param object1
	 * @param object2
	 * @param fields
	 * @return
	 */
	public static boolean isEquals(Object object1, Object object2, String[] fields) {
		for (String fieldName : fields) {
			Object object1FieldVal = Reflections.getFieldValue(object1, fieldName);
			Object object2FieldVal = Reflections.getFieldValue(object2, fieldName);
			if (object1FieldVal == null || !object1FieldVal.equals(object2FieldVal)) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
}
