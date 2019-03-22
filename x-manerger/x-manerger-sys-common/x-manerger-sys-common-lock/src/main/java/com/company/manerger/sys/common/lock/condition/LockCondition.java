package com.company.manerger.sys.common.lock.condition;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LockCondition implements Condition {
    private String key;
    private String value;

    public LockCondition(String key, String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String beanName = conditionContext.getEnvironment().getProperty(key);
        return StringUtils.equals(beanName, value);
    }
}
