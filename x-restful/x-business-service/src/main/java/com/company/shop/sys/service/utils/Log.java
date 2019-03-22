package com.company.shop.sys.service.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * 用作测试阶段
 */
@Slf4j
public class Log {
    private static boolean isDug = true;

    public static void i(String message) {
        if (isDug) {
            log.info(message);
        }
    }

    public static void e(String message) {
        if (isDug) {
            log.error(message);
        }
    }

    public static void w(String message) {
        if (isDug) {
            log.warn(message);
        }
    }

}
