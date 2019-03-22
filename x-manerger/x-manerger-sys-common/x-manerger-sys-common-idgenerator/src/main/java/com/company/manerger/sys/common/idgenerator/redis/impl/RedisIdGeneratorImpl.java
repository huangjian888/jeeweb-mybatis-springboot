package com.company.manerger.sys.common.idgenerator.redis.impl;

import com.company.manerger.sys.common.idgenerator.exception.IdGeneratorException;
import com.company.manerger.sys.common.idgenerator.redis.RedisIdGenerator;
import com.company.manerger.sys.common.utils.DateUtils;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import org.hashids.Hashids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedisIdGeneratorImpl implements RedisIdGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(RedisIdGeneratorImpl.class);
    private static final String DATE_FORMAT = "yyyyMMddHHmmssSSS";
    private static final String DECIMAL_FORMAT = "00000000";
    private static final int MAX_BATCH_COUNT = 1000;
    private RedisTemplate<Serializable, Serializable> redisTemplate;
    private RedisScript<List<Object>> redisScript;
    @Value("${idgenerator.prefix:idGeneratorPrefix}")
    private String prefix;

    public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = SpringContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @PostConstruct
    public void initialize() {
        String luaScript = buildLuaScript();
        redisScript = new DefaultRedisScript(luaScript, List.class);
    }

    private String buildLuaScript() {
        StringBuilder lua = new StringBuilder();
        lua.append("local incrKey = KEYS[1];");
        lua.append("\nlocal step = ARGV[1];");
        lua.append("\nlocal count;");
        lua.append("\ncount = tonumber(redis.call('incrby', incrKey, step));");
        lua.append("\nlocal now = redis.call('time');");
        lua.append("\nreturn {now[1], now[2], count}");
        return lua.toString();
    }

    @Override
    public String nextUniqueId(String name, String key, int step, int length) throws Exception {
        return nextUniqueId(name,key,step,length,false);
    }

    @Override
    public String nextUniqueId(String name, String key, int step, int length, boolean useHashIds) throws Exception {
        return nextUniqueId(name,key,step,length,useHashIds,null);
    }

    @Override
    public String nextUniqueId(String name, String key, int step, int length, boolean useHashIds, String salt) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new IdGeneratorException("Name is null or empty");
        }
        if (StringUtils.isEmpty(key)) {
            throw new IdGeneratorException("Key is null or empty");
        }
        String compositeKey = prefix + "_" + name + "_" + key;
        return nextUniqueId(compositeKey,step,length,useHashIds,salt);
    }

    @Override
    public String nextUniqueId(String compositeKey, int step, int length) throws Exception {
        return nextUniqueId(compositeKey,step,length,false);
    }

    @Override
    public String nextUniqueId(String compositeKey, int step, int length, boolean useHashIds) throws Exception {
        return nextUniqueId(compositeKey,step,length,useHashIds,null);
    }

    @Override
    public String nextUniqueId(String compositeKey, int step, int length, boolean useHashIds, String salt) throws Exception {
        if (StringUtils.isEmpty(compositeKey)) {
            throw new IdGeneratorException("Composite key is null or empty");
        }
        List<Serializable> keys = new ArrayList<Serializable>();
        keys.add(compositeKey);

        RedisTemplate<Serializable, Serializable> redisTemplate = getRedisTemplate();
        List<Object> result = redisTemplate.execute(redisScript, keys, step);

        Object value1 = result.get(0);
        Object value2 = result.get(1);
        Object value3 = result.get(2);

        Date date = new Date(Long.parseLong(String.valueOf(value1)) * 1000 + Long.parseLong(String.valueOf(value2)) / 1000);

        StringBuilder builder = new StringBuilder();
        builder.append(DateUtils.formatDate(date, DATE_FORMAT));
        builder.append(com.company.manerger.sys.common.idgenerator.redis.utils.StringUtils.formatString((long) value3, length, DECIMAL_FORMAT));
        String nextUniqueId = builder.toString();

        if(useHashIds){
            Hashids hashids;
            if(!StringUtils.isEmpty(salt)){
                hashids = new Hashids(salt);
            }else{
                hashids = new Hashids();
            }
            nextUniqueId = hashids.encodeHex(nextUniqueId);
        }
        return nextUniqueId;
    }

    @Override
    public String[] nextUniqueIds(String name, String key, int step, int length, int count) throws Exception {
        return nextUniqueIds(name,key,step,length,count,false);
    }

    @Override
    public String[] nextUniqueIds(String name, String key, int step, int length, int count, boolean useHashIds) throws Exception {
        return nextUniqueIds(name,key,step,length,count,useHashIds,null);
    }

    @Override
    public String[] nextUniqueIds(String name, String key, int step, int length, int count, boolean useHashIds, String salt) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new IdGeneratorException("Name is null or empty");
        }
        if (StringUtils.isEmpty(key)) {
            throw new IdGeneratorException("Key is null or empty");
        }
        String compositeKey = prefix + "_" + name + "_" + key;
        return nextUniqueIds(compositeKey,step,length,count,useHashIds,salt);
    }

    @Override
    public String[] nextUniqueIds(String compositeKey, int step, int length, int count) throws Exception {
        return nextUniqueIds(compositeKey,step,length,count,false);
    }

    @Override
    public String[] nextUniqueIds(String compositeKey, int step, int length, int count, boolean useHashIds) throws Exception {
        return nextUniqueIds(compositeKey,step,length,count,useHashIds,null);
    }

    @Override
    public String[] nextUniqueIds(String compositeKey, int step, int length, int count, boolean useHashIds, String salt) throws Exception {
        if (count <= 0 || count > MAX_BATCH_COUNT) {
            throw new IdGeneratorException(String.format("Count can't be greater than %d or less than 0", MAX_BATCH_COUNT));
        }
        if (StringUtils.isEmpty(compositeKey)) {
            throw new IdGeneratorException("Composite key is null or empty");
        }
        String[] nextUniqueIds = new String[count];
        for (int i = 0; i < count; i++) {
            nextUniqueIds[i] = nextUniqueId(compositeKey,step,length,useHashIds,salt);
        }
        return nextUniqueIds;
    }
}