package cn.jeeweb.core.config;

import cn.jeeweb.core.security.shiro.cache.SpringCacheManagerWrapper;
import cn.jeeweb.core.security.shiro.session.CacheSessionDAO;
import cn.jeeweb.core.security.shiro.session.SessionManager;
import cn.jeeweb.core.support.redis.RedisCacheManager;
import cn.jeeweb.core.support.redis.RedisSessionDAO;
import cn.jeeweb.core.support.redis.SessionListener;
import cn.jeeweb.modules.common.jcaptcha.JCaptchaFilter;
import cn.jeeweb.modules.sys.security.shiro.realm.UserRealm;
import cn.jeeweb.modules.sys.security.shiro.session.mgt.OnlineSessionFactory;
import cn.jeeweb.modules.sys.security.shiro.session.mgt.scheduler.SpringSessionValidationScheduler;
import cn.jeeweb.modules.sys.security.shiro.web.filter.authc.FormAuthenticationFilter;
import cn.jeeweb.modules.sys.security.shiro.web.filter.authc.credential.RetryLimitHashedCredentialsMatcher;
import cn.jeeweb.modules.sys.security.shiro.web.filter.jcaptcha.JCaptchaValidateFilter;
import cn.jeeweb.modules.sys.security.shiro.web.filter.online.OnlineSessionFilter;
import cn.jeeweb.modules.sys.security.shiro.web.filter.user.SysUserFilter;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hexin on 2018/8/13.
 */
@Configuration
@ConditionalOnProperty(name = "jeeweb.common-core.shiroConfig",havingValue = "true")
public class ShiroConfig {

    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistrationBean.addInitParameter("targetFilterLifecycle", "true");
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE,DispatcherType.ERROR);
        return filterRegistrationBean;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager,
                                              @Qualifier("formAuthenticationFilterRegistrationBean") FilterRegistrationBean formAuthenticationFilterRegistrationBean,
                                              @Qualifier("logoutFilterFilterRegistrationBean")FilterRegistrationBean logoutFilterFilterRegistrationBean,
                                              @Qualifier("sysUserFilterFilterRegistrationBean")FilterRegistrationBean sysUserFilterFilterRegistrationBean,
                                              @Qualifier("onlineSessionFilterFilterRegistrationBean")FilterRegistrationBean onlineSessionFilterFilterRegistrationBean,
                                              @Qualifier("jCaptchaValidateFilterFilterRegistrationBean")FilterRegistrationBean jCaptchaValidateFilterFilterRegistrationBean
                                              )
    {
        ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
        factory.setSecurityManager(securityManager);
        factory.setLoginUrl("/admin/login");
        factory.setUnauthorizedUrl("/unauthorized");

        Map<String, Filter> filters = new LinkedHashMap();
        filters.put("authc", formAuthenticationFilterRegistrationBean.getFilter());
        filters.put("logout",logoutFilterFilterRegistrationBean.getFilter());
        filters.put("sysUser",sysUserFilterFilterRegistrationBean.getFilter());
        filters.put("onlineSession",onlineSessionFilterFilterRegistrationBean.getFilter());
        filters.put("jCaptchaValidate",jCaptchaValidateFilterFilterRegistrationBean.getFilter());
        factory.setFilters(filters);

        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/jcaptcha*","anon");
        filterChainDefinitionMap.put("/upload/**","anon");
        filterChainDefinitionMap.put("/weixin/mp/front/**","anon");
        filterChainDefinitionMap.put("/admin/logout","logout");
        filterChainDefinitionMap.put("/admin/login","jCaptchaValidate,authc");
        filterChainDefinitionMap.put("/**","sysUser,onlineSession,user,perms,roles");
        factory.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return factory;
    }

    @Bean(name = "userRealm")
    public UserRealm userRealm(@Qualifier("credentialsMatcher") RetryLimitHashedCredentialsMatcher credentialsMatcher, @Qualifier("redisCacheManager") RedisCacheManager redisCacheManager){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher);
//        userRealm.setAuthenticationCachingEnabled(true);
//        userRealm.setAuthorizationCachingEnabled(true);
        userRealm.setCacheManager(redisCacheManager);
        return userRealm;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm,
                                                     @Qualifier("sessionManager") SessionManager sessionManager,
                                                     @Qualifier("rememberMeManager") CookieRememberMeManager rememberMeManager,
                                                     @Qualifier("redisCacheManager") RedisCacheManager redisCacheManager){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        defaultWebSecurityManager.setSessionManager(sessionManager);
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager);
        defaultWebSecurityManager.setCacheManager(redisCacheManager);
        return defaultWebSecurityManager;
    }

    @Bean(name = "sessionManager")
    public SessionManager sessionManager(
//                                         @Qualifier("onlineSessionFactory") OnlineSessionFactory onlineSessionFactory,
                                         @Qualifier("redisSessionDAO") RedisSessionDAO redisSessionDAO,
//                                         @Qualifier("shiroCacheManager") SpringCacheManagerWrapper shiroCacheManager,
                                         @Qualifier("sessionIdCookie") SimpleCookie sessionIdCookie,
                                         @Qualifier("sessionListener") SessionListener sessionListener){
        SessionManager sessionManager = new SessionManager();
        sessionManager.setGlobalSessionTimeout(1800000);//全局session超时时间 1000*30*60milliseconds = 30 分钟（1800000）
//        sessionManager.setSessionFactory(onlineSessionFactory);
        sessionManager.setSessionDAO(redisSessionDAO);
        sessionManager.setDeleteInvalidSessions(false);
        sessionManager.setSessionValidationInterval(3600000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
//        sessionManager.setCacheManager(shiroCacheManager);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(sessionIdCookie);
        sessionManager.getSessionListeners().add(sessionListener);
        return sessionManager;
    }

//    @Bean(name = "shiroCacheManager")
//    public SpringCacheManagerWrapper shiroCacheManager(@Qualifier("springCacheManager") EhCacheCacheManager springCacheManager){
//        SpringCacheManagerWrapper shiroCacheManager = new SpringCacheManagerWrapper();
//        shiroCacheManager.setCacheManager(springCacheManager);
//        return shiroCacheManager;
//    }

    @Bean(name = "redisSessionDAO")
    public RedisSessionDAO redisSessionDAO(){
        return new RedisSessionDAO();
    }

    @Bean(name = "redisCacheManager")
    public RedisCacheManager redisCacheManager(){
        return new RedisCacheManager();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "credentialsMatcher")
    public RetryLimitHashedCredentialsMatcher credentialsMatcher(@Qualifier("redisCacheManager") RedisCacheManager redisCacheManager){
        RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(redisCacheManager);
        retryLimitHashedCredentialsMatcher.setMaxRetryCount(10);
        retryLimitHashedCredentialsMatcher.setShowCaptchaRetryCount(3);
        retryLimitHashedCredentialsMatcher.setHashAlgorithmName("md5");
        retryLimitHashedCredentialsMatcher.setHashIterations(2);
        retryLimitHashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return retryLimitHashedCredentialsMatcher;
    }

//    @Bean(name = "sessionIdGenerator")
//    public JavaUuidSessionIdGenerator sessionIdGenerator(){
//        return new JavaUuidSessionIdGenerator();
//    }

    @Bean(name = "sessionIdCookie")
    public SimpleCookie sessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("uid");
        simpleCookie.setDomain("");
        simpleCookie.setPath("/");
        simpleCookie.setHttpOnly(true);
//        simpleCookie.setMaxAge(1800000);
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }

    @Bean(name = "rememberMeCookie")
    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setDomain("");
        simpleCookie.setPath("/");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }

    @Bean(name = "onlineSessionFactory")
    public OnlineSessionFactory onlineSessionFactory(){
        return new OnlineSessionFactory();
    }

    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager rememberMeManager(@Qualifier("rememberMeCookie") SimpleCookie rememberMeCookie){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie);
        cookieRememberMeManager.setCipherKey(Base64.decode("bya2HkYo57u6fWh5theAWw=="));
        return cookieRememberMeManager;
        /*try { //setCipherKey的值通过已下方式加密算出
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecretKey deskey = keygen.generateKey();
            System.out.println("~~~~~~~~~~~~~~:"+Base64.encodeToString(deskey.getEncoded()));
        }catch (Exception e){

        }*/
    }

    @Bean
    public SpringSessionValidationScheduler sessionValidationScheduler(@Qualifier("sessionManager") SessionManager sessionManager){
        SpringSessionValidationScheduler springSessionValidationScheduler = new SpringSessionValidationScheduler();
        springSessionValidationScheduler.setSessionValidationInterval(3600000); //session验证时间间隔(即验证会话是否还有效) 1000*60*60milliseconds = 1小时（3600000）
        springSessionValidationScheduler.setSessionManager(sessionManager);
        return springSessionValidationScheduler;
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(securityManager);
        return methodInvokingFactoryBean;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public FilterRegistrationBean<JCaptchaFilter> jCaptchaFilterFilterRegistrationBean(){
        JCaptchaFilter jCaptchaFilter = new JCaptchaFilter();
        FilterRegistrationBean<JCaptchaFilter> filterFilterRegistrationBean = new FilterRegistrationBean<JCaptchaFilter>(jCaptchaFilter);
        filterFilterRegistrationBean.addUrlPatterns("/jcaptcha.jpg");
        return filterFilterRegistrationBean;
    }

    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        formAuthenticationFilter.setSuccessUrl("/admin");
        formAuthenticationFilter.setUsernameParam("username");
        formAuthenticationFilter.setPasswordParam("password");
        formAuthenticationFilter.setRememberMeParam("rememberMe");
        return formAuthenticationFilter;
    }

    @Bean
    public LogoutFilter logoutFilter(){
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/admin/login?logout=1");
        return logoutFilter;
    }

    @Bean
    public SysUserFilter sysUserFilter(){
        SysUserFilter sysUserFilter = new SysUserFilter();
        sysUserFilter.setUserLockedUrl("/admin/login?blocked=1");
        sysUserFilter.setUserNotfoundUrl("/admin/login?notfound=1");
        sysUserFilter.setUserUnknownErrorUrl("/admin/login?unknown=1");
        return sysUserFilter;
    }

    @Bean
    public OnlineSessionFilter onlineSessionFilter(@Qualifier("redisSessionDAO") RedisSessionDAO sessionDAO){
        OnlineSessionFilter onlineSessionFilter = new OnlineSessionFilter();
        onlineSessionFilter.setForceLogoutUrl("/admin/login?forcelogout=1");
        onlineSessionFilter.setSessionDAO(sessionDAO);
        return onlineSessionFilter;
    }

    @Bean(name = "jCaptchaValidateFilter")
    public JCaptchaValidateFilter jCaptchaValidateFilter(){
        JCaptchaValidateFilter jCaptchaValidateFilter = new JCaptchaValidateFilter();
        jCaptchaValidateFilter.setJcaptchaEbabled(true);
        jCaptchaValidateFilter.setJcaptchaParam("jcaptchaCode");
        jCaptchaValidateFilter.setJcapatchaErrorUrl("/admin/login?jcaptchaError=1");
        return jCaptchaValidateFilter;
    }

    @Bean(name = "formAuthenticationFilterRegistrationBean")
    public FilterRegistrationBean formAuthenticationFilterRegistrationBean(FormAuthenticationFilter formAuthenticationFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(formAuthenticationFilter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean(name = "logoutFilterFilterRegistrationBean")
    public FilterRegistrationBean logoutFilterFilterRegistrationBean(LogoutFilter logoutFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(logoutFilter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean(name = "sysUserFilterFilterRegistrationBean")
    public FilterRegistrationBean sysUserFilterFilterRegistrationBean(SysUserFilter sysUserFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(sysUserFilter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean(name = "onlineSessionFilterFilterRegistrationBean")
    public FilterRegistrationBean onlineSessionFilterFilterRegistrationBean(OnlineSessionFilter onlineSessionFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(onlineSessionFilter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean(name = "jCaptchaValidateFilterFilterRegistrationBean")
    public FilterRegistrationBean jCaptchaValidateFilterFilterRegistrationBean(JCaptchaValidateFilter jCaptchaValidateFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(jCaptchaValidateFilter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean(name = "sessionListener")
    public SessionListener sessionListener(){
        return new SessionListener();
    }
}
