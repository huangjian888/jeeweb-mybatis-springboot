package cn.jeeweb.core.config;

import cn.jeeweb.core.exception.DefaultExceptionHandler;
import cn.jeeweb.core.interceptor.EncodingInterceptor;
import cn.jeeweb.core.interceptor.ReloadConfigInterceptor;
import cn.jeeweb.core.mapper.JsonMapper;
import cn.jeeweb.core.query.resolver.*;
import cn.jeeweb.core.security.shiro.interceptor.PermissionInterceptorAdapter;
import cn.jeeweb.core.tags.html.builder.DefaultHtmlComponentBuilder;
import cn.jeeweb.core.tags.html.listener.HtmlComponentInitListener;
import cn.jeeweb.core.tags.html.manager.HtmlComponentManager;
import cn.jeeweb.modules.common.interceptor.LogInterceptor;
import cn.jeeweb.modules.common.jcaptcha.JCaptchaFilter;
import cn.jeeweb.modules.common.listener.WebStartInitListener;
import cn.jeeweb.modules.task.listener.ScheduleJobInitListener;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import net.sf.ehcache.CacheManager;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.MultipartConfigElement;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexin on 2018/8/13.
 */
@Configuration
//@EnableWebMvc 不能开启当前注解
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean encodingFilterRegistration(){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(encodingFilter);
        filterRegistrationBean.setName("CharacterEncodingFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setAsyncSupported(true);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean sitemeshFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SiteMeshFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer config = new PropertyPlaceholderConfigurer();
        config.setIgnoreResourceNotFound(true);
        List<Resource> resourceList = new ArrayList<Resource>();
        resourceList.add(new ClassPathResource("jdbc.properties"));
        resourceList.add(new ClassPathResource("upload.properties"));
        resourceList.add(new ClassPathResource("jeeweb.properties"));
        resourceList.add(new ClassPathResource("shiro.properties"));
        config.setLocations(resourceList.toArray(new Resource[]{}));
        return config;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new FormModelMethodArgumentResolver());
        argumentResolvers.add(new PageableMethodArgumentResolver());
        argumentResolvers.add(new PropertyPreFilterMethodArgumentResolver());
        argumentResolvers.add(new QueryMethodArgumentResolver());
        argumentResolvers.add(new RequestJsonParamMethodArgumentResolver());
    }

//    @Bean
//    public MultipartConfigElement multipartConfigElement(){
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize("1024Mb");
//        factory.setMaxRequestSize("1024Mb");
//        return factory.createMultipartConfig();
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/upload/**").addResourceLocations("/upload/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/webpage/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> fastJsonHttpMessageConverter_supportedMediaTypes = new ArrayList<>();
        fastJsonHttpMessageConverter_supportedMediaTypes.add(MediaType.valueOf("application/json;charset=UTF-8"));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastJsonHttpMessageConverter_supportedMediaTypes);

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        List<MediaType> stringHttpMessageConverter_supportedMediaTypes = new ArrayList<>();
        stringHttpMessageConverter_supportedMediaTypes.add(new MediaType("text","plain", Charset.forName("UTF-8")));
        stringHttpMessageConverter_supportedMediaTypes.add(new MediaType("*","*",Charset.forName("UTF-8")));
        stringHttpMessageConverter.setSupportedMediaTypes(stringHttpMessageConverter_supportedMediaTypes);

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mappingJackson2HttpMessageConverter_supportedMediaTypes = new ArrayList<>();
        mappingJackson2HttpMessageConverter_supportedMediaTypes.add(MediaType.valueOf("application/json;charset=UTF-8"));
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mappingJackson2HttpMessageConverter_supportedMediaTypes);
        mappingJackson2HttpMessageConverter.setPrettyPrint(false);
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mappingJackson2HttpMessageConverter.setObjectMapper(jsonMapper);

        converters.add(fastJsonHttpMessageConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor()).order(1);
        LogInterceptor logInterceptor = new LogInterceptor();
        logInterceptor.setOpenAccessLog(true);
        registry.addInterceptor(logInterceptor).order(2);
        ReloadConfigInterceptor reloadConfigInterceptor = new ReloadConfigInterceptor();
        reloadConfigInterceptor.setDevelopMode(false);
        reloadConfigInterceptor.setReloadConfigInterval(60000);
        registry.addInterceptor(reloadConfigInterceptor).order(3);
        List<String> excludePathPatterns = new ArrayList<>();
        excludePathPatterns.add("/static/**");
        excludePathPatterns.add("/upload/**");
        registry.addInterceptor(new EncodingInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePathPatterns).order(4);
        registry.addInterceptor(new PermissionInterceptorAdapter()).addPathPatterns("/**").excludePathPatterns(excludePathPatterns).order(5);
    }

    @Bean(name = "conversionService")
    public FormattingConversionServiceFactoryBean conversionService(){
        return new FormattingConversionServiceFactoryBean();
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(@Qualifier("conversionService") FormattingConversionServiceFactoryBean conversionService){
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("cn.jeeweb.core.query.utils.QueryableConvertUtils.setConversionService");
        methodInvokingFactoryBean.setArguments(conversionService.getObject());
        return methodInvokingFactoryBean;
    }

    @Bean
    public ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver(){
        return new ExceptionHandlerExceptionResolver();
    }

    @Bean
    public DefaultExceptionHandler defaultExceptionHandler(){
        return new DefaultExceptionHandler();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() throws Exception{
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(52428800);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        multipartResolver.setUploadTempDir(resolver.getResource("/upload/temp/"));
        multipartResolver.setUploadTempDir(new FileSystemResource("/upload/temp"));
        return multipartResolver;
    }

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setUseCodeAsDefaultMessage(false);
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setCacheSeconds(60);
        List<String> basename = new ArrayList<>();
        basename.add("i18n/messages");
        basename.add("i18n/ValidationMessages");
        resourceBundleMessageSource.setBasenames( basename.toArray(new String[basename.size()]));
        return resourceBundleMessageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator(@Qualifier("messageSource") ResourceBundleMessageSource messageSource){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }

    @Bean
    public SessionLocaleResolver localeResolver(){
        return new SessionLocaleResolver();
    }

    @Bean
    public WebStartInitListener webStartInitListener(){
        return new WebStartInitListener();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        return new SchedulerFactoryBean();
    }

    @Bean
    public ScheduleJobInitListener scheduleJobInitListener(){
        return new ScheduleJobInitListener();
    }

    @Bean(name = "defaultHtmlComponentBuilder")
    public DefaultHtmlComponentBuilder defaultHtmlComponentBuilder(){
        DefaultHtmlComponentBuilder defaultHtmlComponentBuilder = new DefaultHtmlComponentBuilder();
        defaultHtmlComponentBuilder.setFileNames(new String[]{"classpath*:/mapper/tags/html/*-html-component.xml"});
        return defaultHtmlComponentBuilder;
    }

    @Bean
    public HtmlComponentManager htmlComponentManager(@Qualifier("defaultHtmlComponentBuilder") DefaultHtmlComponentBuilder defaultHtmlComponentBuilder){
        HtmlComponentManager htmlComponentManager = new HtmlComponentManager();
        htmlComponentManager.setDynamicStatementBuilder(defaultHtmlComponentBuilder);
        return htmlComponentManager;
    }

    @Bean
    public HtmlComponentInitListener htmlComponentInitListener(){
        return new HtmlComponentInitListener();
    }


    @Bean
    public ServletListenerRegistrationBean<RequestContextListener> requestContextListenerServletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean<RequestContextListener>(new RequestContextListener());
    }
}
