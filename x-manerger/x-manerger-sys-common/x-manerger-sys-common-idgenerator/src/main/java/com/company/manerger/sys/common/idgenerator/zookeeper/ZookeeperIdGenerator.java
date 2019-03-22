package com.company.manerger.sys.common.idgenerator.zookeeper;

/**
 * 获取全局唯一序号
 * @param name 资源名字
 * @param key 资源Key
 * @return String
 * @throws Exception 异常
 */
public interface ZookeeperIdGenerator {

    String nextSequenceId(String name, String key) throws Exception;

    String nextSequenceId(String name, String key,boolean useHashIds) throws Exception;

    String nextSequenceId(String name, String key,boolean useHashIds,String salt) throws Exception;

    String nextSequenceId(String compositeKey) throws Exception;

    String nextSequenceId(String compositeKey,boolean useHashIds) throws Exception;

    String nextSequenceId(String compositeKey,boolean useHashIds,String salt) throws Exception;

    String[] nextSequenceIds(String name, String key, int count) throws Exception;

    String[] nextSequenceIds(String name, String key, int count,boolean useHashIds) throws Exception;

    String[] nextSequenceIds(String name, String key, int count,boolean useHashIds,String salt) throws Exception;

    String[] nextSequenceIds(String compositeKey, int count) throws Exception;

    String[] nextSequenceIds(String compositeKey, int count,boolean useHashIds) throws Exception;

    String[] nextSequenceIds(String compositeKey, int count,boolean useHashIds,String salt) throws Exception;
}