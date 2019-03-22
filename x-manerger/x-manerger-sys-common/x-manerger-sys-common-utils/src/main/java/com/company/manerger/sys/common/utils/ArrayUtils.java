package com.company.manerger.sys.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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

	public static final <T> HashSet<T> newHashSet() {
		return new HashSet<T>();
	}

	public static final <T> ArrayList<T> newArrayList(T... t) {
		ArrayList<T> list = newArrayList();
		Collections.addAll(list, t);
		return list;
	}
}
