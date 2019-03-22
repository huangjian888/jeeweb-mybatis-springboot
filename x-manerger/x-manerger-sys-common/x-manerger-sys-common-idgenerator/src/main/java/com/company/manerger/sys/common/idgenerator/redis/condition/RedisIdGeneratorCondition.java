package com.company.manerger.sys.common.idgenerator.redis.condition;

import com.company.manerger.sys.common.idgenerator.condition.IdGeneratorCondition;

public class RedisIdGeneratorCondition extends IdGeneratorCondition {
    public RedisIdGeneratorCondition() {
        super("idgenerator.type", "redis");
    }
}
