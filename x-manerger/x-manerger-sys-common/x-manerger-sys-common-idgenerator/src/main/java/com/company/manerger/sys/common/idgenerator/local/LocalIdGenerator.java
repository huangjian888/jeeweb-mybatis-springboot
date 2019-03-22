package com.company.manerger.sys.common.idgenerator.local;

/**
 * 获取全局唯一ID，根据Twitter雪花ID算法。为兼顾到前端失精问题，把返回值long改成String
 * SnowFlake算法用来生成64位的ID，刚好可以用long整型存储，能够用于分布式系统中生产唯一的ID， 并且生成的ID有大致的顺序。 在这次实现中，生成的64位ID可以分成5个部分：
 * 0 - 41位时间戳 - 5位数据中心标识 - 5位机器标识 - 12位序列号
 * @param startTimestamp 起始计算时间戳
 * @param dataCenterId 数据中心标识ID
 * @param machineId 机器标识ID
 * @param useHashIds 是否使用hashids 库进行加密
 * @param salt hashids 盐值
 * @return String
 */
public interface LocalIdGenerator {

    String nextUniqueId(long dataCenterId, long machineId) throws Exception;

    String nextUniqueId(String startTimestamp, long dataCenterId, long machineId) throws Exception;

    String nextUniqueId(long startTimestamp, long dataCenterId, long machineId) throws Exception;

    String nextUniqueId(long startTimestamp, long dataCenterId, long machineId,boolean useHashIds);

    String nextUniqueId(long startTimestamp, long dataCenterId, long machineId,boolean useHashIds,String salt);

    String[] nextUniqueIds(long dataCenterId, long machineId, int count) throws Exception;

    String[] nextUniqueIds(String startTimestamp, long dataCenterId, long machineId, int count) throws Exception;

    String[] nextUniqueIds(long startTimestamp, long dataCenterId, long machineId, int count) throws Exception;

    String[] nextUniqueIds(long startTimestamp, long dataCenterId, long machineId, int count,boolean useHashIds) throws Exception;

    String[] nextUniqueIds(long startTimestamp, long dataCenterId, long machineId, int count,boolean useHashIds,String salt) throws Exception;
}
