package com.company.manerger.sys.common.idgenerator.local.impl;

import com.company.manerger.sys.common.idgenerator.local.LocalIdGenerator;
import com.company.manerger.sys.common.idgenerator.local.utils.SnowflakeIdGenerator;
import com.company.manerger.sys.common.utils.DateUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import org.hashids.Hashids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultLocalIdGeneratorImpl implements LocalIdGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultLocalIdGeneratorImpl.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    private static final long DEFAULT_START_TIMESTAMP = 1546272000000L; // 2019-01-01 00:00:00:000
    private volatile Map<String, SnowflakeIdGenerator> idGeneratorMap = new ConcurrentHashMap<String, SnowflakeIdGenerator>();

    @Override
    public String nextUniqueId(long dataCenterId, long machineId) throws Exception {
        return nextUniqueId(DEFAULT_START_TIMESTAMP, dataCenterId, machineId);
    }

    @Override
    public String nextUniqueId(String startTimestamp, long dataCenterId, long machineId) throws Exception {
        return nextUniqueId(DateUtils.parseDate(startTimestamp, DATE_FORMAT).getTime(), dataCenterId, machineId);
    }

    @Override
    public String nextUniqueId(long startTimestamp, long dataCenterId, long machineId) throws Exception {
        return nextUniqueId(startTimestamp,dataCenterId,machineId,false);
    }

    @Override
    public String nextUniqueId(long startTimestamp, long dataCenterId, long machineId, boolean useHashIds) {
        return nextUniqueId(startTimestamp,dataCenterId,machineId,useHashIds,null);
    }

    @Override
    public String nextUniqueId(long startTimestamp, long dataCenterId, long machineId, boolean useHashIds, String salt) {
        String nextUniqueId = getIdGenerator(startTimestamp, dataCenterId, machineId).nextId();
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
    public String[] nextUniqueIds(long dataCenterId, long machineId, int count) throws Exception {
        return nextUniqueIds(DEFAULT_START_TIMESTAMP, dataCenterId, machineId, count);
    }

    @Override
    public String[] nextUniqueIds(String startTimestamp, long dataCenterId, long machineId, int count) throws Exception {
        return nextUniqueIds(DateUtils.parseDate(startTimestamp, DATE_FORMAT).getTime(), dataCenterId, machineId, count);
    }

    @Override
    public String[] nextUniqueIds(long startTimestamp, long dataCenterId, long machineId, int count) throws Exception {
        return nextUniqueIds(startTimestamp,dataCenterId,machineId,count,false);
    }

    @Override
    public String[] nextUniqueIds(long startTimestamp, long dataCenterId, long machineId, int count, boolean useHashIds) throws Exception {
        return nextUniqueIds(startTimestamp,dataCenterId,machineId,count,useHashIds,null);
    }

    @Override
    public String[] nextUniqueIds(long startTimestamp, long dataCenterId, long machineId, int count, boolean useHashIds, String salt) throws Exception {
        String[] nextUniqueIds = getIdGenerator(startTimestamp, dataCenterId, machineId).nextIds(count);
        if(useHashIds){
            Hashids hashids;
            if(!StringUtils.isEmpty(salt)){
                hashids = new Hashids(salt);
            }else{
                hashids = new Hashids();
            }
            String[] var = new String[nextUniqueIds.length];
            for (int i = 0; i < nextUniqueIds.length; i++) {
                var[i] = hashids.encodeHex(nextUniqueIds[i]);
            }
            return var;
        }
        return nextUniqueIds;
    }

    private SnowflakeIdGenerator getIdGenerator(long startTimestamp, long dataCenterId, long machineId) {
        String key = dataCenterId + "-" + machineId;
        SnowflakeIdGenerator idGenerator = idGeneratorMap.get(key);
        if (idGenerator == null) {
            SnowflakeIdGenerator newIdGnerator = new SnowflakeIdGenerator(startTimestamp, dataCenterId, machineId);
            idGenerator = idGeneratorMap.putIfAbsent(key, newIdGnerator);
            if (idGenerator == null) {
                idGenerator = newIdGnerator;
            }
        }
        return idGenerator;
    }

}
