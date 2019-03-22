package com.company.manerger.sys.common.idgenerator.redis;

/**
 * 获取全局唯一ID
 * ID规则：
 * 1. ID的前半部分为yyyyMMddHHmmssSSS格式的17位数字
 * 2. ID的后半部分为由length(最大为8位，如果length大于8，则取8)决定，取值Redis对应Value，如果小于length所对应的数位，如果不足该数位，前面补足0
 *    例如Redis对应Value为1234，length为8，那么ID的后半部分为00001234；length为2，那么ID的后半部分为34
 * @param name 资源名字
 * @param key 资源Key
 * @param step 递增值
 * @param length 长度
 * @return String
 */
public interface RedisIdGenerator {

    String nextUniqueId(String name, String key, int step, int length) throws Exception;

    String nextUniqueId(String name, String key, int step, int length,boolean useHashIds) throws Exception;

    String nextUniqueId(String name, String key, int step, int length,boolean useHashIds,String salt) throws Exception;

    String nextUniqueId(String compositeKey, int step, int length) throws Exception;

    String nextUniqueId(String compositeKey, int step, int length,boolean useHashIds) throws Exception;

    String nextUniqueId(String compositeKey, int step, int length,boolean useHashIds,String salt) throws Exception;

    String[] nextUniqueIds(String name, String key, int step, int length, int count) throws Exception;

    String[] nextUniqueIds(String name, String key, int step, int length, int count,boolean useHashIds) throws Exception;

    String[] nextUniqueIds(String name, String key, int step, int length, int count,boolean useHashIds,String salt) throws Exception;

    String[] nextUniqueIds(String compositeKey, int step, int length, int count) throws Exception;

    String[] nextUniqueIds(String compositeKey, int step, int length, int count,boolean useHashIds) throws Exception;

    String[] nextUniqueIds(String compositeKey, int step, int length, int count,boolean useHashIds,String salt) throws Exception;
}