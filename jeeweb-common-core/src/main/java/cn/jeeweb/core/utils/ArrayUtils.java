package cn.jeeweb.core.utils;

import java.util.*;

public class ArrayUtils extends org.apache.commons.lang3.ArrayUtils {
	public static List<String> split(final String str, final String separatorChar) {
		List<String> strList = new ArrayList<String>();
		String[] strs = StringUtils.split(str, separatorChar);
		for (String string : strs) {
			strList.add(string);
		}
		return strList;
	}

	public static final <T> ArrayList<T> newArrayList(T... t) {
		ArrayList<T> list = newArrayList();
		Collections.addAll(list, t);
		return list;
	}

	public static final <T> HashSet<T> newHashSet() {
		return new HashSet<T>();
	}

	public static <T> Set<T> newHashSet(T[] t) {
		Set<T> set = newHashSet();
		Collections.addAll(set, t);
		return set;
	}
}
