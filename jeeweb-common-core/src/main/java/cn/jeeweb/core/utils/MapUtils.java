package cn.jeeweb.core.utils;

import java.util.Map;

public class MapUtils extends org.apache.commons.collections.MapUtils {

	public static Boolean containsAndKeys(Map<String, Object> dataMap, String[] keys) {
		for (String key : keys) {
			if (!dataMap.containsKey(key)) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	public static Boolean containsOrKeys(Map<String, Object> dataMap, String[] keys) {
		for (String key : keys) {
			if (dataMap.containsKey(key)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

}
