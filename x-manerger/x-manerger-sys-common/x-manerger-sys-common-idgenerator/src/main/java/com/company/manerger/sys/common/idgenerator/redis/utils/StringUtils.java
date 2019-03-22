package com.company.manerger.sys.common.idgenerator.redis.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StringUtils {
    private static volatile Map<String, DecimalFormat> decimalFormatMap = new ConcurrentHashMap<String, DecimalFormat>();

    public static String formatString(long key, int length, String pattern) {
        String value = String.valueOf(key);
        if (value.length() < length) {
            DecimalFormat format = getDecimalFormat(pattern);
            return format.format(key);
        } else {
            return value.substring(value.length() - length, value.length());
        }
    }

    private static DecimalFormat getDecimalFormat(String pattern) {
        DecimalFormat decimalFormat = decimalFormatMap.get(pattern);
        if (decimalFormat == null) {
            DecimalFormat newDecimalFormat = new DecimalFormat();
            newDecimalFormat.applyPattern(pattern);
            decimalFormat = decimalFormatMap.putIfAbsent(pattern, newDecimalFormat);
            if (decimalFormat == null) {
                decimalFormat = newDecimalFormat;
            }
        }
        return decimalFormat;
    }

    public static String convert(String[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (String array : arrays) {
            builder.append(array).append(",");
        }
        String result = builder.toString();
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
