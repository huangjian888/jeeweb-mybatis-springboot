//package com.company.shop.sys.service.config;
//
//import com.company.manerger.sys.common.utils.SpringContextHolder;
//import com.company.shop.sys.service.security.springsecurity.filter.JwtAuthenticationTokenFilter;
//import com.company.shop.sys.service.security.springsecurity.handler.EntryPointUnauthorizedHandler;
//import com.company.shop.sys.service.security.springsecurity.handler.RestAccessDeniedHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * Created by hexin on 2018/11/26.
// */
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    private UserDetailsService userDetailsService;
//    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;
//    private RestAccessDeniedHandler restAccessDeniedHandler;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public WebSecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter,
//                             EntryPointUnauthorizedHandler entryPointUnauthorizedHandler, RestAccessDeniedHandler restAccessDeniedHandler) {
//        this.userDetailsService = userDetailsService;
//        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
//        this.entryPointUnauthorizedHandler = entryPointUnauthorizedHandler;
//        this.restAccessDeniedHandler = restAccessDeniedHandler;
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // 由于使用的是JWT，我们这里不需要csrf
//                .headers().frameOptions().disable().and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 基于token，所以不需要session
//                .authorizeRequests()
//                .antMatchers("/authentication/**").permitAll() // 对于获取token的rest api要允许匿名访问
//                .antMatchers("/business/order/message").permitAll() // 管理后台调用的管理后台发货信息
//                .anyRequest().authenticated() // 除上面外的所有请求全部需要鉴权认证
//                .and().headers().cacheControl();// 禁用缓存
//        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        http.exceptionHandling().authenticationEntryPoint(entryPointUnauthorizedHandler).accessDeniedHandler(restAccessDeniedHandler);
//    }
//
//    @Bean
//    public SpringContextHolder springContextHolder() {
//        return new SpringContextHolder();
//    }
//}
