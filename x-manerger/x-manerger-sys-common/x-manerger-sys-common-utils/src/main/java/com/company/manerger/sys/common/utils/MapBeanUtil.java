package com.company.manerger.sys.common.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MapBeanUtil {

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Map<String, Object> convertBean(Object bean)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		Class<? extends Object> type = bean.getClass();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	public static void setField(Object obj, String fieldname, Object value) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		setField(obj, fieldname, value, value.getClass());
	}

	/**
	 * 当属性类型为接口时，传入的实际对象class不等于接口，会导致 NoSuchMethodException 异常
	 * 
	 * @author ly
	 * @param obj
	 * @param fieldname
	 * @param value
	 * @param valueClass
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void setField(Object obj, String fieldname, Object value, Class<?> valueClass)
			throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {

		if (fieldname.length() > 0) {
			if (PropertyUtils.isWriteable(obj, fieldname)) {
				Class<?> valueclass = BeanUtils.findPropertyType(fieldname, obj.getClass());
				Object rObject = Caster(valueclass, String.valueOf(value));
				PropertyUtils.setProperty(obj, fieldname, rObject);
			}

			// String methodname = "set" + fieldname.substring(0,
			// 1).toUpperCase() + fieldname.substring(1, fieldname.length());
			// Method m = obj.getClass().getMethod(methodname, valueClass);
			// m.invoke(obj, value);
		}

	}

	public static void setFieldEx(Object obj, String fieldName, Object value) throws IllegalArgumentException,
            SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		int dotIndex = fieldName.indexOf(".");
		if (dotIndex > 0) {
			Object subObj = getField(obj, fieldName.substring(0, dotIndex));
			setFieldEx(subObj, fieldName.substring(dotIndex + 1), value);
		} else {
			setField(obj, fieldName, value);
		}

	}

	public static Object getFieldEx(Object obj, String fieldName) throws IllegalArgumentException,
            IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		int dotIndex = fieldName.indexOf(".");
		if (dotIndex > 0) {
			Object subObj = getField(obj, fieldName.substring(0, dotIndex));
			return getFieldEx(subObj, fieldName.substring(dotIndex + 1));
		} else {
			return getField(obj, fieldName);
		}
	}

	/**
	 * 字符串到其他类型转换
	 * 
	 * @param type
	 * @param value
	 * @return
	 */
	public static Object Caster(Class<?> type, String value) {

		Object returnValue = null;
		if (value == null || value == "null" || "".equals(value))
			return null;

		if (type.getName().equals("java.util.Date")) {
			if (value.indexOf("Z") != -1 && value.indexOf("T") != -1) {
				returnValue = value;
			} else {
				returnValue = DateUtils.parseDate(value);
			}
		} else if (type.getName().equals("java.sql.Timestamp")) {
			if (value.indexOf("Z") != -1 && value.indexOf("T") != -1) {
				value = value.replace("Z", "");
				value = value.replace("T", " ");
				Date d = DateUtils.parseDate(value);
				Timestamp t = new Timestamp(d.getTime());
				returnValue = t;
			} else {
				Date d = DateUtils.parseDate(value);
				Timestamp t = new Timestamp(d.getTime());
				returnValue = t;
			}
		} else if (type.getName().endsWith("Long")) {
			if (StringUtils.isNumericAndDot(value))
				returnValue = Long.valueOf(value);
		} else if (type.getName().endsWith("Integer")) {
			if (StringUtils.isNumericAndDot(value))
				returnValue = Integer.valueOf(value);
		} else if (type.getName().endsWith("int")) {
			if (StringUtils.isNumericAndDot(value))
				returnValue = Integer.valueOf(value);
			else
				returnValue = 0;
		} else if (type.getName().endsWith("Double")) {
			if (StringUtils.isNumericAndDot(value))
				returnValue = Double.valueOf(value);
		} else if (type.getName().endsWith("double")) {
			if (StringUtils.isNumericAndDot(value))
				returnValue = Double.valueOf(value);
			else
				returnValue = 0.0;
		} else if (type.getName().endsWith("Byte")) {
			if (StringUtils.isNumericAndDot(value))
				returnValue = Byte.valueOf(value);
		} else if (type.getName().endsWith("byte")) {
			if (StringUtils.isNumericAndDot(value))
				returnValue = Byte.valueOf(value);
			else
				returnValue = 0;
		} else if (type.getName().endsWith("Boolean") || type.getName().endsWith("boolean")) {
			returnValue = Boolean.parseBoolean(value);
		} else if (type.getName().endsWith("bool")) {
			returnValue = Boolean.parseBoolean(value);
		} else if (type.getName().endsWith("BigDecimal")) {
			returnValue = new BigDecimal(value);
		} /*else if (type.getName().endsWith("Clob")) {
			Object obj = ClobProxy.generateProxy(value);
			returnValue = obj;// proxy.getWrappedClob();
		}*/ else {
			returnValue = value.toString();
		}

		return returnValue;
	}

	public static Method getField(Object obj, String fieldname) {
		if (obj == null)
			return null;
		if (fieldname.length() > 0) {
			String methodname = "get" + fieldname.substring(0, 1).toUpperCase()
					+ fieldname.substring(1, fieldname.length());
			Method m;
			try {
				m = obj.getClass().getMethod(methodname);
				return m;
			} catch (NoSuchMethodException e) {
				System.out.println(obj.getClass().getName() + "中未找到方法 :" + methodname);

				// e.printStackTrace();
			} catch (SecurityException e) {

				e.printStackTrace();
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<String> getFiledList(Object obj) {
		List<String> list = new ArrayList<String>();
		try {
			Class<? extends Object> clazz = obj.getClass();
			Field[] fields = obj.getClass().getDeclaredFields();// 获得属性
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
				Method getMethod = pd.getReadMethod();// 获得get方法
				String filed = "";// 如果是IS开头的区两位 我也是醉了-_-!!!!
				if (getMethod.getName().toLowerCase().startsWith(("is"))) {
					filed = getMethod.getName().substring(2);
				} else
					filed = getMethod.getName().substring(3);
				list.add(filed);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();

		}
		return list;
	}

	public static Object getFieldValue(Object obj, String fieldname) {
		if (obj == null)
			return null;
		if (obj instanceof Map) {
			Map<String, Object> map = extracted(obj);
			if (map.containsKey(fieldname))
				return map.get(fieldname);
			else
				return null;
		} else {

			if (fieldname.length() > 0) {
				String methodname = "get" + fieldname.substring(0, 1).toUpperCase()
						+ fieldname.substring(1, fieldname.length());
				String methodname1 = "is" + fieldname.substring(0, 1).toUpperCase()
						+ fieldname.substring(1, fieldname.length());
				Method m;
				try {
					m = obj.getClass().getMethod(methodname);
					return m.invoke(obj);
				} catch (NoSuchMethodException e) {

					try {
						m = obj.getClass().getMethod(methodname1);
						return m.invoke(obj);
					} catch (NoSuchMethodException e1) {

						e1.printStackTrace();
					} catch (SecurityException e1) {

						e.printStackTrace();
					} catch (IllegalAccessException e1) {

						e.printStackTrace();
					} catch (IllegalArgumentException e1) {

						e.printStackTrace();
					} catch (InvocationTargetException e1) {

						e.printStackTrace();
					}

					// e.printStackTrace();
				} catch (SecurityException e) {

					e.printStackTrace();
				} catch (IllegalAccessException e) {

					e.printStackTrace();
				} catch (IllegalArgumentException e) {

					e.printStackTrace();
				} catch (InvocationTargetException e) {

					e.printStackTrace();
				}

			}
			return null;
		}
	}

	private static Map<String, Object> extracted(Object obj) {
		return ((Map<String, Object>) obj);
	}

	public static void setFieldValue(Object obj, String fieldname, Object value) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if (value != null)
			setFieldValue(obj, fieldname, value, value.getClass());
		else
			setFieldValue(obj, fieldname, value, null);

	}

	public static Method getMethod(Class<?> cls, String methodName) {
		if (cls == null)
			return null;
		for (Method m : cls.getMethods()) {
			if (m.getName().equals(methodName))
				return m;
		}
		return null;
	}

	public static boolean CopyFromOneToOther(Object from, Object to, String Exception) {
		List<String> Field = getFiledList(from);
		if (Exception == null)
			Exception = "";
		for (int i = 0; i < Field.size(); i++) {
			if (!("," + Exception + ",").contains(Field.get(i))) {
				Object value = getFieldValue(from, Field.get(i));
				if (value != null) {
					try {
						setFieldValue(to, Field.get(i), value, value.getClass());
						// setField(to, Field.get(i), value);
					} catch (SecurityException e) {

						e.printStackTrace();
					} catch (NoSuchMethodException e) {

						e.printStackTrace();
					} catch (IllegalArgumentException e) {

						e.printStackTrace();
					} catch (IllegalAccessException e) {

						e.printStackTrace();
					} catch (InvocationTargetException e) {

						e.printStackTrace();
					}
				}
			}
		}
		return true;
	}

	// list的Where方法
	public static <T> List<T> ListDoWhere(List<T> list, String FieldName, Object Value) {
		List<T> reslist = new ArrayList<T>();
		if (list == null)
			return reslist;
		for (int i = 0; i < list.size(); i++) {
			T obj = list.get(i);
			Object myobj = getFieldValue(obj, FieldName);
			if (myobj != null || (myobj == null && Value == null)) {
				if (myobj.equals(Value)) {
					reslist.add(obj);
				}
			}
		}
		return reslist;
	}

	// list的Select方法
	public static <T> List<Object> ListDoSelect(List<T> list, String FieldName) {
		List<Object> reslist = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			T obj = list.get(i);
			Object myobj = getFieldValue(obj, FieldName);
			if (myobj != null) {
				reslist.add(myobj);
			}
		}
		return reslist;
	}

	/**
	 * 当属性类型为接口时，传入的实际对象class不等于接口，会导致 NoSuchMethodException 异常
	 * 
	 * @author ly
	 * @param obj
	 * @param fieldname
	 * @param value
	 * @param valueClass
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void setFieldValue(Object obj, String fieldname, Object value, Class<?> valueClass)
			throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
		if (obj == null)
			return;

		if (obj instanceof Map) {
			Map map = (Map) obj;
			map.put(fieldname, value);
		} else {

			if (fieldname.length() > 0) {

				String methodname = "set" + fieldname.substring(0, 1).toUpperCase()
						+ fieldname.substring(1, fieldname.length());
				try {
					Method m = null;
					// if (valueClass != null)
					// {
					m = getMethod(obj.getClass(), methodname);// obj.getClass().getMethod(methodname);
					// } else
					// m = Utils.getMethod(obj.getClass(), methodname);
					if (m != null)
						m.invoke(obj, value);
					else {

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void setFieldValueEx(Object obj, String fieldName, Object value) {

		try {
			int dotIndex = fieldName.indexOf(".");
			if (dotIndex > 0) {
				Object subObj = getFieldValue(obj, fieldName.substring(0, dotIndex));
				setFieldValueEx(subObj, fieldName.substring(dotIndex + 1), value);
			} else {
				setFieldValue(obj, fieldName, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Object getFieldValueEx(Object obj, String fieldName) {
		int dotIndex = fieldName.indexOf(".");
		try {
			if (dotIndex > 0) {
				Object subObj = getFieldValue(obj, fieldName.substring(0, dotIndex));
				return getFieldValueEx(subObj, fieldName.substring(dotIndex + 1));
			} else {
				return getFieldValue(obj, fieldName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json中存在的属性填充到Object对象对应的属性中去,如果Json对象中不存在的将忽略
	 * 
	 * @param obj
	 *            目标对象
	 * @param json
	 * @return
	 */
	public static Object json2Objec(Object obj, JSONObject json) {
		if (json == null)
			return obj;
		if (obj == null)
			return obj;
		Iterator it = json.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value;
			try {
				value = json.get(key);
				if (!(value instanceof JSONObject) && !(value instanceof JSONArray))
					setField(obj, key, value);

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return obj;
	}

	/**
	 * 将json中存在的属性填充到Object对象对应的属性中去,如果Json对象中不存在的将忽略
	 * 
	 * @param obj
	 *            目标对象
	 * @param json
	 * @param applyChildren
	 *            子对象赋值
	 * @return
	 */
	public static Object json2Objec(Object obj, JSONObject json, Boolean applyChildren) {
		if (json == null)
			return obj;
		if (obj == null)
			return obj;
		Iterator it = json.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value;
			try {
				value = json.get(key);
				if (!(value instanceof JSONObject) && !(value instanceof JSONArray))
					setField(obj, key, value);
				else if (value instanceof JSONObject) {
					if (applyChildren) {
						Method method = getField(obj, key);
						if (method != null) {
							try {
								Object newObject = method.getReturnType().newInstance();
								if (newObject != null) {
									json2Objec(newObject, (JSONObject) value, applyChildren);
								}
							} catch (Exception ec) {

							}
						}

					}
				} else if (value instanceof JSONArray) {
					JSONArray jarray = (JSONArray) value;
					for (Object jobj : jarray) {
						if (jobj instanceof JSONObject) {
							JSONObject jsonObj = (JSONObject) jobj;
							if (applyChildren) {
								Method method = getField(obj, key);
								if (method != null) {
									try {
										Object newObject = method.getReturnType().newInstance();
										if (newObject != null) {
											json2Objec(newObject, jsonObj, applyChildren);
										}
									} catch (Exception ec) {

									}
								}

							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return obj;
	}
}
