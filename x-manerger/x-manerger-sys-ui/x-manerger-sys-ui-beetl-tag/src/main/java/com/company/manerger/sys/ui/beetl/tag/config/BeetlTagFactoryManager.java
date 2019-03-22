package com.company.manerger.sys.ui.beetl.tag.config;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.beetl.ext.spring.SpringBeanTagFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 标签处理
 */
@Component
public class BeetlTagFactoryManager implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean(name = "tagFactorys")
    public Map<String, TagFactory> tagFactorys() {
        Map<String, TagFactory> tags = new HashMap<>();
        Map<String, Tag> beans = applicationContext.getBeansOfType(Tag.class);
        for (String beanName : beans.keySet()) {
            // 读取自定义标签名
            BeetlTagName tagAnno = beans.get(beanName).getClass().getAnnotation(BeetlTagName.class);
            String tagName = tagAnno != null ? tagAnno.value() : beanName;
            tags.put(tagName, toSpringBeanTagFactory(beanName));
        }
        return tags;
    }

    private SpringBeanTagFactory toSpringBeanTagFactory(String beanName) {
        SpringBeanTagFactory springBeanTagFactory = new SpringBeanTagFactory();
        springBeanTagFactory.setApplicationContext(applicationContext);
        springBeanTagFactory.setName(beanName);
        return springBeanTagFactory;
    }
}
