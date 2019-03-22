package com.company.manerger.sys.common.utils.fastjson;

import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.commons.lang3.StringEscapeUtils;

/**
Fastjson中，对返回值的处理
 */
public class FastjsonUnXssFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        // 判断如果是字符串反解析
        if (value instanceof  String && value != null){
            return StringEscapeUtils.unescapeHtml4(value+"");
        }
        return value;
    }
}
