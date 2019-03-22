package com.company.manerger.sys.common.idgenerator.local.impl;


import com.company.manerger.sys.common.idgenerator.local.CustomLocalIdGenerator;
import com.company.manerger.sys.common.idgenerator.local.utils.CustomSnowflakeIdGenerator;
import com.company.manerger.sys.common.utils.StringUtils;
import org.hashids.Hashids;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomLocalIdGeneratorImpl implements CustomLocalIdGenerator {
    private volatile Map<String, CustomSnowflakeIdGenerator> idGeneratorMap = new ConcurrentHashMap<String, CustomSnowflakeIdGenerator>();

    @Override
    public String nextUniqueId(long dataCenterId, long machineId) throws Exception {
        return nextUniqueId(dataCenterId, machineId,false);
    }

    @Override
    public String nextUniqueId(long dataCenterId, long machineId, boolean useHashIds) {
        return nextUniqueId(dataCenterId, machineId,useHashIds,null);
    }

    @Override
    public String nextUniqueId(long dataCenterId, long machineId, boolean useHashIds, String salt) {
        String nextUniqueId = getIdGenerator(dataCenterId, machineId).nextId();
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
        return nextUniqueIds(dataCenterId,machineId,count,false);
    }

    @Override
    public String[] nextUniqueIds(long dataCenterId, long machineId, int count, boolean useHashIds) throws Exception {
        return nextUniqueIds(dataCenterId,machineId,count,useHashIds,null);
    }

    @Override
    public String[] nextUniqueIds(long dataCenterId, long machineId, int count, boolean useHashIds, String salt) throws Exception {
        String[] nextUniqueIds = getIdGenerator(dataCenterId, machineId).nextIds(count);
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

    private CustomSnowflakeIdGenerator getIdGenerator(long dataCenterId, long machineId) {
        String key = dataCenterId + "-" + machineId;
        CustomSnowflakeIdGenerator idGenerator = idGeneratorMap.get(key);
        if (idGenerator == null) {
            CustomSnowflakeIdGenerator newIdGnerator = new CustomSnowflakeIdGenerator(dataCenterId, machineId);
            idGenerator = idGeneratorMap.putIfAbsent(key, newIdGnerator);
            if (idGenerator == null) {
                idGenerator = newIdGnerator;
            }
        }
        return idGenerator;
    }
}
