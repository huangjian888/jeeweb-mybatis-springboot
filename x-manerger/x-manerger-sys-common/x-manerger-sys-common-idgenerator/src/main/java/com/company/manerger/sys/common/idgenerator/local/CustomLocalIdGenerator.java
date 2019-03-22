package com.company.manerger.sys.common.idgenerator.local;

/**
 * @param dataCenterId 数据中心标识ID
 * @param machineId 机器标识ID
 * @param useHashIds 是否使用hashids 库进行加密
 * @param salt hashids 盐值
 * @return String
 */
public interface CustomLocalIdGenerator {

    String nextUniqueId(long dataCenterId, long machineId) throws Exception;

    String nextUniqueId(long dataCenterId, long machineId, boolean useHashIds);

    String nextUniqueId(long dataCenterId, long machineId, boolean useHashIds, String salt);

    String[] nextUniqueIds(long dataCenterId, long machineId, int count) throws Exception;

    String[] nextUniqueIds(long dataCenterId, long machineId, int count, boolean useHashIds) throws Exception;

    String[] nextUniqueIds(long dataCenterId, long machineId, int count, boolean useHashIds, String salt) throws Exception;
}
