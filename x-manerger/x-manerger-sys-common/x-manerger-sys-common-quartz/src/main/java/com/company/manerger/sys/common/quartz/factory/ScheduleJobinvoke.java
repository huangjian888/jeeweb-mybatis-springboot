package com.company.manerger.sys.common.quartz.factory;

import com.company.manerger.sys.common.quartz.data.ScheduleJob;
import com.company.manerger.sys.common.quartz.exception.QuartzException;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ScheduleJobinvoke {

	/**
	 * 通过反射调用scheduleJob中定义的方法
	 *
	 * @param scheduleJob
	 */
	public static void invokeMethod(ScheduleJob scheduleJob) {
		try {
			Object object = null;
			Class<?> clazz = null;
			Method method = null;
			if (scheduleJob.getLoadWay().equals("1")) {
				object = SpringContextHolder.getBean(scheduleJob.getExecuteClass());
			} else if (StringUtils.isNotBlank(scheduleJob.getExecuteClass())) {
				clazz = Class.forName(scheduleJob.getExecuteClass());
				object = clazz.newInstance();
			}
			if (object == null) {
				throw new QuartzException("任务对象不存在");
			}
			clazz = object.getClass();
			method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
			if (method != null) {
				String params = scheduleJob.getMethodParams();
				ReflectionUtils.makeAccessible(method);
				if (StringUtils.isNotEmpty(params))
				{
					method.invoke(object, params);
				}else
				{
					method.invoke(object);
				}
			}
		} catch (InstantiationException e) {
			throw new QuartzException(e.getMessage());
		}  catch (ClassNotFoundException e) {
		 	throw new QuartzException(e.getMessage());
		} catch (NoSuchMethodException e) {
		  	throw new QuartzException(e.getMessage());
		} catch (SecurityException e) {
			throw new QuartzException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new QuartzException(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new QuartzException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new QuartzException(e.getMessage());
		}
	}
}
