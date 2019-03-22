package com.company.shop.sys.service.utils;

import org.apache.http.util.TextUtils;

public class PageUtils {

    public static int getPage(String page) {
        if (TextUtils.isEmpty(page)) {
            return 1;
        }
        return Integer.parseInt(page);
    }

    public static int getPageSize(String pageSize) {
        if (TextUtils.isEmpty(pageSize)) {
            return 20;
        }
        return Integer.parseInt(pageSize);
    }
}
