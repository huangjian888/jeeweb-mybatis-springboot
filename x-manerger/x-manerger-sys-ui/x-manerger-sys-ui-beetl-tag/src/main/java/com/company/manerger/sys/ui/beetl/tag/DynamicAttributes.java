package com.company.manerger.sys.ui.beetl.tag;

import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;

/**
 * @description: 动态数据整理
 */
public interface DynamicAttributes {
    void setDynamicAttribute(String localName, Object value) throws BeetlTagException;
}
