package com.company.business.goods.security.user;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TomatoUserServiceImpl extends ServiceImpl<TomatoUserMapper, TomatoUserEntity> implements ITomatoUserService {
    @Autowired
    private ITokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public TomatoUserEntity findUserByUsername(String username) {
        return baseMapper.getUserByUserName(username);
    }

    @Override
    public boolean updateTomatoUser(TomatoUserEntity tomatoUserEntity) {

        return insertOrUpdate(tomatoUserEntity);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);//实例化全局Authentication对象--登录成功后会实例化UserDetails实例
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //fixme 测试
        String token = jwtTokenUtil.generateToken(userDetails);
        tokenService.storeToken(token, username);
        return token;
    }

    @Override
    public String register(TomatoUserEntity user) {
        TomatoUserEntity storeUser = this.findUserByUsername(user.getUsername());

        if (storeUser != null) {
            return "用户已存在";
        }
        boolean ret = this.insert(user);

        return "success";
    }

    @Override
    public boolean updateUserInfo(TomatoUserEntity tomatoUserEntity) {

        return insertOrUpdate(tomatoUserEntity);
    }

    @Override
    public boolean insert(TomatoUserEntity entity) {
//        passwordService.encryptPassword(entity); //使用spring security进行密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = entity.getPassword();
        entity.setPassword(encoder.encode(rawPassword));
        entity.setRegisterDate(new Date());
        return super.insert(entity);
    }

}
