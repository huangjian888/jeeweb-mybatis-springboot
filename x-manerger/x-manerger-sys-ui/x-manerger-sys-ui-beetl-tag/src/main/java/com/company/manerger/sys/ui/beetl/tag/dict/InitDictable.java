package com.company.manerger.sys.ui.beetl.tag.dict;

import java.util.List;
import java.util.Map;

/**
 * @title: 字典初始化接口
 * @description: 字典初始化
 */
public interface InitDictable {
    /**
     * 字典初始化
     * @return
     */
    public Map<String, List<Dict>> initDict();
}
