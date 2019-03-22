package com.company.manerger.sys.ui.beetl.tag.dict;

import com.company.manerger.sys.common.utils.CacheUtils;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典工具类
 *
 */
public class DictUtils {
	public static String DICT_CACHE_KEY = "DICT_CACHE_KEY";
	protected final static String DICT_CACHE_NAME = "dictCache";
	public static String getDictLabel(String value, String code, String defaultValue) {
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(value)) {
			for (Dict dict : getDictList(code)) {
				if (value.equals(dict.getValue())) {
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}

	public static String getDictLabels(String values, String code, String defaultValue) {
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(values)) {
			List<String> valueList = new ArrayList<String>();
			for (String value : StringUtils.split(values, ",")) {
				valueList.add(getDictLabel(value, code, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	public static String getDictValue(String label, String code, String defaultLabel) {
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(label)) {
			for (Dict dict : getDictList(code)) {
				if (label.equals(dict.getLabel())) {
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}

	public static List<Dict> getDictList(String code) {
		//数据字典
		if (CacheUtils.get(DICT_CACHE_NAME,DICT_CACHE_KEY)==null){
			initDict();
		}
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) CacheUtils.get(DICT_CACHE_NAME,DICT_CACHE_KEY);
		List<Dict> dictList = dictMap.get(code);
		if (dictList == null) {
			dictList = new ArrayList<Dict>();
		}
		return dictList;
	}

	public static void putDict(String code, List<Dict> dictList) {
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) CacheUtils.get(DICT_CACHE_NAME,DICT_CACHE_KEY);
		if (dictMap == null) {
			dictMap = new HashMap<String, List<Dict>>();
		}
		dictMap.put(code, dictList);
		CacheUtils.put(DICT_CACHE_NAME,DICT_CACHE_KEY, dictMap);
	}

	public static void putDict(Map<String, List<Dict>> dictMap) {
		CacheUtils.put(DICT_CACHE_NAME,DICT_CACHE_KEY, dictMap);
	}

	/*
	 * 清除换成
	 */
	public static void clear() {
		CacheUtils.remove(DICT_CACHE_NAME,DICT_CACHE_KEY);
	}

	public static void initDict() {
		// 字典初始化
		Map<String, InitDictable> baseInterfaceBeans = SpringContextHolder.getApplicationContext().getBeansOfType(InitDictable.class);
		for(InitDictable initDictable : baseInterfaceBeans.values()) {
			try {
				Map<String, List<Dict>> dictMap =initDictable.initDict();
				if (dictMap!=null) {
					DictUtils.putDict(dictMap);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}