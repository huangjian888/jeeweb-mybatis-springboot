package cn.jeeweb.sso.modules.sys.service.impl;


import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.utils.CacheUtils;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.entity.Menu;
import cn.jeeweb.modules.sys.entity.Role;
import cn.jeeweb.modules.sys.entity.User;
import cn.jeeweb.modules.sys.service.IMenuService;
import cn.jeeweb.modules.sys.service.IRoleService;
import cn.jeeweb.modules.sys.service.IUserService;
import cn.jeeweb.sso.entity.SsoUser;
import cn.jeeweb.sso.service.ISsoUserService;
import cn.jeeweb.sso.utils.SsoAuthUtil;
import cn.jeeweb.sso.utils.SsoJwtUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.jeeweb.modules.sys.Constants;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by hexin on 2018/9/13.
 */
@CacheConfig(cacheNames = "SsoUser")
@Service(interfaceClass = ISsoUserService.class)
public class SsoUserServiceImpl implements ISsoUserService {
    @Autowired
    private SsoJwtUtil ssoJwtUtil;

    @Resource
    private IUserService userService;
    @Resource
    private IRoleService roleService;
    @Resource
    private IMenuService menuService;

    /**
     * select.cache.timeout:300  过期时间，单位秒
     * @param userid
     * @return
     */
    @Cacheable(value = Constants.CACHE_NAMESPACE + "getRoleList"+"#${select.cache.timeout:300}")
    public Set<String> getRoleList(String userid){
        Set<Role> roles = Sets.newConcurrentHashSet(roleService.findListByUserId(userid));
        return Sets.newHashSet(Collections2.transform(roles, new Function<Role, String>() {
            @Override
            public String apply(Role role) {
                return role.getCode();
            }
        }));
    }

    @Cacheable(value = Constants.CACHE_NAMESPACE + "getMenuListAll"+"#${select.cache.timeout:300}")
    public Set<String> getMenuListAll(String userid){
        Set<String> permissionsList = Sets.newConcurrentHashSet();
        List<Menu> list = menuService.findMenuByUserId(userid);
        for (Menu menu : list) {
            if (StringUtils.isNotBlank(menu.getPermission())) {
                // 添加基于Permission的权限信息
                for (String permission : StringUtils.split(menu.getPermission(), ",")) {
                    if (StringUtils.isNotBlank(permission)) {
                        permissionsList.add(permission);
                    }
                }
            }
        }
        return permissionsList;
    }

    private SsoUser user2SsoUser(User user){
        Set<String> roles = getRoleList(user.getId());
        Set<String> permissions = getMenuListAll(user.getId());
        SsoUser ssoUser = new SsoUser();
        ssoUser.setId(user.getId());
        ssoUser.setUsername(user.getUsername());
        ssoUser.setEmail(user.getEmail());
        ssoUser.setPhone(user.getPhone());
        ssoUser.setStatus(user.getStatus());
        ssoUser.setPermissions(permissions);
        ssoUser.setRoles(roles);
        ssoUser.setPortrait(user.getPortrait());
        ssoUser.setRealname(user.getRealname());
        return ssoUser;
    }

    @Override
    public AjaxJson findByUsername(String username, String pwd) {
        AjaxJson ret = new AjaxJson();
        User user = userService.findByUsername(username);
        if(user != null){
            if(user.getPassword().equals(SsoAuthUtil.generatePassWord("md5",pwd,user.getCredentialsSalt(),2))){
                if(User.STATUS_LOCKED.equals(user.getStatus())){
                    ret.fail("帐号已锁定...");
                }else if(User.STATUS_DELETE.equals(user.getStatus())){
                    ret.fail("帐号已删除...");
                } else {
                    ret.success("success");
                    ret.setData(JSON.toJSONString(user2SsoUser(user)));
                }
            }else{
                ret.fail("密码错误...");
            }
        }else{
            ret.fail("没有找到当前帐号...");
        }
        return ret;
    }

    @Override
    public AjaxJson findByEmail(String email,String pwd) {
        AjaxJson ret = new AjaxJson();
        User user = userService.findByEmail(email);
        if(user != null){
            if(user.getPassword().equals(SsoAuthUtil.generatePassWord("md5",pwd,user.getCredentialsSalt(),2))){
                if(User.STATUS_LOCKED.equals(user.getStatus())){
                    ret.fail("帐号已锁定...");
                }else if(User.STATUS_DELETE.equals(user.getStatus())){
                    ret.fail("帐号已删除...");
                } else {
                    ret.success("success");
                    ret.setData(JSON.toJSONString(user2SsoUser(user)));
                }
            }else{
                ret.fail("密码错误...");
            }
        }else{
            ret.fail("没有找到当前帐号...");
        }
        return ret;
    }

    @Override
    public AjaxJson findByPhone(String phone,String pwd) {
        AjaxJson ret = new AjaxJson();
        User user = userService.findByPhone(phone);
        if(user != null){
            if(user.getPassword().equals(SsoAuthUtil.generatePassWord("md5",pwd,user.getCredentialsSalt(),2))){
                if(User.STATUS_LOCKED.equals(user.getStatus())){
                    ret.fail("帐号已锁定...");
                }else if(User.STATUS_DELETE.equals(user.getStatus())){
                    ret.fail("帐号已删除...");
                } else {
                    ret.success("success");
                    ret.setData(JSON.toJSONString(user2SsoUser(user)));
                }
            }else{
                ret.fail("密码错误...");
            }
        }else{
            ret.fail("没有找到当前帐号...");
        }
        return ret;
    }

    @Override
    public String generateToken(String user) {
        String token = ssoJwtUtil.generateToken(user);
        CacheUtils.getCache().set(Constants.REDIS_TOKEN + token,user);
        return token;
    }

    @Override
    public AjaxJson parseToken(String token, String clientUrl) {
        AjaxJson ret = new AjaxJson();
        if(ssoJwtUtil.isTokenExpiration(token)){
            ret.fail("token 已过期");
        }else {
            String user = ssoJwtUtil.parseToken(token);
            if(user != null){
                ret.success("success");
                ret.setData(user);
            }else {
                ret.fail("无效token");
            }
        }
        return ret;
    }

}
