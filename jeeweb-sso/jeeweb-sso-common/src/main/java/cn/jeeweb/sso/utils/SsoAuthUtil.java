package cn.jeeweb.sso.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by hexin on 2018/9/14.
 */
public class SsoAuthUtil {
    /**
     *
     * @param algorithmName 加密方式：md5
     * @param source 加密源，如：明文密码
     * @param salt 盐 ：默认本框架加盐方式为 数据库中 username+salt
     * @param hashIterations 加密次数需要和jeeweb-common-core中shiroConfig中RetryLimitHashedCredentialsMatcher 定义的一致，默认本框架加密次数为2
     * @return
     */
    public static String generatePassWord(String algorithmName, Object source, Object salt, int hashIterations){
        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        return simpleHash.toString();
    }
}
