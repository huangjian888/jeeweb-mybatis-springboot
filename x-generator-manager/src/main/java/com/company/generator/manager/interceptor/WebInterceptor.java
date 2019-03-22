package com.company.generator.manager.interceptor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.utils.CacheUtils;
import com.company.manerger.sys.common.utils.MessageUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 公共拦截器
 */
public class WebInterceptor extends HandlerInterceptorAdapter {
    private static final String GENERATOR_CACHE_NAME="generator_cache_name";
    private static Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //加入公用参数的
        String ctx = request.getServletContext().getContextPath();
        request.setAttribute("ctx",ctx);
        request.setAttribute("adminPath",ctx + "/admin");
        request.setAttribute("staticPath",ctx + "/static");
        request.setAttribute("platformName", MessageUtils.getMessage("platform.name"));
        request.setAttribute("platformCopyright", MessageUtils.getMessage("platform.copyright"));
        request.setAttribute("platformVersion", MessageUtils.getMessage("platform.version"));

        // 过滤ajax
        if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        }
        //设置导航
        //返回读取指定资源的输入流
        List<Object> navigations=(List<Object>) CacheUtils.get(GENERATOR_CACHE_NAME,"navigations");
        if(navigations==null) {
            InputStream is = this.getClass().getResourceAsStream("/data/navigation.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String json = "";
            String itemJson = "";
            while ((itemJson = br.readLine()) != null) {
                json += itemJson;
            }
            navigations = JSONArray.parseArray(json, Object.class);
            CacheUtils.put(GENERATOR_CACHE_NAME,"navigations", navigations);
        }
        request.setAttribute("navigations",navigations);
        //设置当前的URL
        String currentPath=request.getServletPath();
        if (currentPath.contains("/admin")){
            currentPath=currentPath.substring("/admin".length(),currentPath.length());
        }
        if (StringUtils.isEmpty(currentPath)){
            currentPath=currentPath+"/";
        }
        //获得档期那菜单
        Object currentMenu=null;
        for (Object object :navigations) {
            JSONObject jsonObject= (JSONObject) object;
            String url=jsonObject.getString("url");
            if (url.equals(currentPath)){
                currentMenu=jsonObject;
            }
        }
        request.setAttribute("currentMenu",currentMenu);
        request.setAttribute("currentPath",currentPath);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
