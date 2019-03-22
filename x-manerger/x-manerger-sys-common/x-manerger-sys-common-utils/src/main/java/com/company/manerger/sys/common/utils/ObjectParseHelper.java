package com.company.manerger.sys.common.utils;


public abstract class ObjectParseHelper {

	public static String stringVauleOf(Object object) {
		return object != null ? String.valueOf(object) : "";
	}

	public static Integer integerVauleOf(Object object) {
		return Integer.parseInt(stringVauleOf(object));
	}

	public static Boolean booleanVauleOf(Object object) {
		return Boolean.parseBoolean(stringVauleOf(object));
	}

	public byte[] byteVauleOf(Object object) {
		return stringVauleOf(object).getBytes();
	}

	public short shortVauleOf(Object object) {
		return Short.valueOf(stringVauleOf(object));
	}

	public long longVauleOf(Object object) {
		return Long.valueOf(stringVauleOf(object));
	}

	public float floatVauleOf(Object object) {
		return Float.valueOf(stringVauleOf(object));
	}

}
