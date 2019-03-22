package com.company.manerger.sys.common.idgenerator.condition;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class IdGeneratorCondition implements Condition {
    private String key;
    private String value;

    public IdGeneratorCondition(String key, String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String beanName = conditionContext.getEnvironment().getProperty(key);
        return StringUtils.equals(beanName, value);
    }
}
