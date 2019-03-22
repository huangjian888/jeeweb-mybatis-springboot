package com.company.manerger.sys.common.base.listener;

import com.company.manerger.sys.common.base.listener.data.ApplicationInitable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * @description:   spring容器初始化完成事件
 *
 */
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger _log = LoggerFactory.getLogger(ApplicationContextListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // root application context
        if(null == contextRefreshedEvent.getApplicationContext().getParent()) {
            _log.debug(">>>>> spring初始化开始 <<<<<");
            // 系统入口初始化
            Map<String, ApplicationInitable> baseInterfaceBeans = contextRefreshedEvent.getApplicationContext().getBeansOfType(ApplicationInitable.class);
            for(ApplicationInitable applicationInitable : baseInterfaceBeans.values()) {
                _log.debug(">>>>> {}.init()", applicationInitable.getClass().getName());
                try {
                    applicationInitable.init();
                } catch (Exception e) {
                    _log.error("初始化ApplicationInitable的init方法异常", e);
                    e.printStackTrace();
                }
            }

        }
    }

}
