package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.shop.sys.service.modules.sys.entity.GoldLogEntity;
import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import com.company.shop.sys.service.modules.sys.mapper.StoreUserMapper;
import com.company.shop.sys.service.modules.sys.service.IGoldLogService;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.utils.JwtTokenUtil;
import com.company.shop.sys.service.utils.Log;
import com.company.shop.sys.service.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * @version V1.0
 * @package com.company.shop.sys.service.modules.sys.service.impl
 * @title: 用户表服务实现
 * @description: 用户表服务实现
 * @author: huangjian
 * @date: 2018-11-23 15:48:46
 */
@Transactional
@Service("storeuserService")
public class StoreUserServiceImpl extends CommonServiceImpl<StoreUserMapper, StoreUserEntity> implements IStoreUserService {


    @Autowired
    private TokenServiceImpl tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IGoldLogService goldLogService;

    /**
     * 微信openId--id
     *
     * @param username
     * @return
     */
    @Override
    public StoreUserEntity findByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return selectOne(new EntityWrapper<StoreUserEntity>(StoreUserEntity.class).eq("username", username));
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
    public String register(StoreUserEntity user) {
        Log.i("storeUserServiceImpl regiser");
        StoreUserEntity storeUser = this.findByUsername(user.getUsername());
        if (storeUser == null) {
           /* storeUser = this.findByPhone(user.getUsername());
            if (storeUser == null) {
                storeUser = this.findByEmail(user.getUsername());
            }*/
        }
        if (storeUser != null) {
            return "用户已存在";
        }
        boolean ret = insert(user);

        return "success";
    }

    @Override
    public String refreshToken(String oldToken) {
        String token = oldToken.substring("Bearer ".length());
        if (!jwtTokenUtil.isTokenExpired(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return "error";
    }

    /**
     * 查询用户获得的奖励步数l
     *
     * @return
     */
    @Override
    public int updateAward(int step) {

        StoreUserEntity storeUserEntity = this.getUserInfo();
        storeUserEntity.setStep(step + storeUserEntity.getStep());
        return insertOrUpdate(storeUserEntity) ? 1 : 0;

    }

    /**
     * 更新用户的金币,及历史获取金币数量
     *
     * @param
     * @return
     */
    @Override
    public int updateGold(StoreUserEntity storeUserEntity) {
        return insertOrUpdate(storeUserEntity) ? 1 : 0;
    }

    /**
     * 更新从微信获取的昵称和头像地址
     *
     * @param nickName
     * @param avatar
     * @return
     */
    @Override
    public int updateUserInfo(String nickName, String avatar) {
        StoreUserEntity storeUserEntity = this.getUserInfo();
        /*if (!TextUtils.isEmpty(storeUserEntity.getNickName())) {//用户表中有nickname则不更新--避免频繁io
            return 1;
        }*/
        storeUserEntity.setNickName(nickName);
        storeUserEntity.setAvatar(avatar);

        return insertOrUpdate(storeUserEntity) ? 1 : 0;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @Override
    public StoreUserEntity getUserInfo() {

        return baseMapper.selectAward(PrincipalUtils.getUsername());
    }

    @Override
    public StoreUserEntity getUserInfo(String username) {

        return baseMapper.selectAward(username);
    }

    /**
     * 获取用户的金币兑换记录
     *
     * @return
     */
    @Override
    public Page<GoldLogEntity> getGoldList(Page<GoldLogEntity> page) {

        return goldLogService.getGoldList(page);
    }

    /**
     * 获取用户每日邀请的好友列表--按时间降序
     *
     * @return
     */
    @Override
    public Page<StoreUserEntity> getFriendList(Page<StoreUserEntity> page) {

        return page.setRecords(baseMapper.getFriendList(page, PrincipalUtils.getUsername()));
    }

    @Override
    public List<StoreUserEntity> getUserListGold() {
        return baseMapper.getUserListGold();
    }


    @Override
    public boolean insert(StoreUserEntity entity) {
//        passwordService.encryptPassword(entity); //使用spring security进行密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = entity.getPassword();
        entity.setPassword(encoder.encode(rawPassword));
        return super.insert(entity);
    }


    @Override
    public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
        for (Object id : idList) {
            this.deleteById((Serializable) id);
        }
        return true;
    }

    @Override
    public Page<StoreUserEntity> selectPage(Page<StoreUserEntity> page, Wrapper<StoreUserEntity> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectStoreUserList(page, wrapper));
        return page;
    }
}