package com.company.business.authorization.security.filter;

import com.company.business.authorization.security.properties.JwtConfigProperties;
import com.company.business.authorization.security.user.ITokenService;
import com.company.business.authorization.security.utils.JwtTokenUtil;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtConfigProperties jwtConfigProperties;
    @Autowired
    private ITokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(jwtConfigProperties.getHeader());
        //fixme 如为三方回调url--需单独处理/某些url无需登录
        String currentUrl = request.getRequestURI().substring(request.getContextPath().length());
        //fixme 配置测试地址
        if (currentUrl.equals("/test")) {
            chain.doFilter(request, response);
            return;
        }

        if (authHeader != null && authHeader.startsWith(jwtConfigProperties.getTokenHead())) {
            final String authToken = authHeader.substring(jwtConfigProperties.getTokenHead().length() + 1); // The part after "Bearer "

            String username = jwtTokenUtil.getUserNameFromToken(authToken);//openid--数据库中

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                //fixme redis缓存中当前token保存的信息不为空(token有效时间和redis缓存时间一致)--设置有效的全局Authorization
                if (!TextUtils.isEmpty(tokenService.getInfoByToken(authToken))) {//key为token，value为sessionKey
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }
        }
        chain.doFilter(request, response);
    }


}

