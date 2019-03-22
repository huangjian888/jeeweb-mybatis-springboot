package com.company.manerger.sys.common.lock.redis.redisson.util;

import org.redisson.config.Config;

import java.io.IOException;

public class RedissonUtil {

    // 创建Yaml格式的配置文件
    public static Config createYamlFileConfig(String yamlConfigPath) throws IOException {
        RedissionContent content = new RedissionContent(yamlConfigPath, "UTF-8");
        return createYamlConfig(content.getContent());
    }

    // 创建Json格式的配置文件
    public static Config createJsonFileConfig(String jsonConfigPath) throws IOException {
        RedissionContent content = new RedissionContent(jsonConfigPath,"UTF-8");
        return createJsonConfig(content.getContent());
    }

    // 创建Yaml格式的配置文件
    public static Config createYamlConfig(String yamlConfigContent) throws IOException {
        return Config.fromYAML(yamlConfigContent);
    }

    // 创建Json格式的配置文件
    public static Config createJsonConfig(String jsonConfigContent) throws IOException {
        return Config.fromJSON(jsonConfigContent);
    }
}