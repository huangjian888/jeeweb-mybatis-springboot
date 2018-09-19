package cn.jeeweb.core.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by hexin on 2018/8/22.
 */
@Configuration
@ConditionalOnProperty(name = "jeeweb.common-core.cacheConfig",havingValue = "true")
@EnableCaching
public class CacheConfig {

    /*
     * ehcache 主要的管理器
     */
    @Bean(name = "springCacheManager")
    public EhCacheCacheManager springCacheManager(@Qualifier("ehcacheManager") EhCacheManagerFactoryBean ehcacheManager){
        return new EhCacheCacheManager (ehcacheManager.getObject());
    }

    /*
     * 据shared与否的设置,Spring分别通过CacheManager.create()或new CacheManager()方式来创建一个ehcache基地.
     */
    @Bean(name = "ehcacheManager")
    public EhCacheManagerFactoryBean ehcacheManager(){
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
        cacheManagerFactoryBean.setConfigLocation (new ClassPathResource("ehcache/ehcache.xml"));
        cacheManagerFactoryBean.setShared (true);
        return cacheManagerFactoryBean;
    }
}
