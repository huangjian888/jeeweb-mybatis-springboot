package cn.jeeweb.core.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils extends org.apache.commons.lang3.ArrayUtils {
	public static List<String> split(final String str, final String separatorChar) {
		List<String> strList = new ArrayList<String>();
		String[] strs = StringUtils.split(str, separatorChar);
		for (String string : strs) {
			strList.add(string);
		}
		return strList;
	}
}
