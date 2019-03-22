package com.company.manerger.sys.service.utils;

import com.company.manerger.sys.common.utils.CookieUtils;
import com.company.manerger.sys.common.utils.ServletUtils;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import org.springframework.core.env.Environment;

import javax.servlet.http.Cookie;

/**
 * @description: 模板样式
 */
public class ThemeUtils {
    /**
     * 设置样式
     * @param theme 央视
     */
    public static void setTheme(String theme){
        CookieUtils.setCookie(ServletUtils.getResponse(), "theme", theme);
    }

    /**
     * 获得样式
     * @return
     */
    public static String getTheme(){
        // 默认风格
        Environment env = SpringContextHolder.getBean(Environment.class);
        String theme = env.getProperty("company.admin.default.theme");
        if (StringUtils.isEmpty(theme)) {
            theme = "uadmin";
        }
        // cookies配置中的模版
        Cookie[] cookies = ServletUtils.getRequest().getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
                    continue;
                }
                if (cookie.getName().equalsIgnoreCase("theme")) {
                    theme = cookie.getValue();
                }
            }
        }
        return theme;
    }

}
