package cn.jeeweb.sso.modules.sys.service.impl;


import cn.jeeweb.modules.sys.service.IUserService;
import cn.jeeweb.sso.service.ISsoUserService;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * Created by hexin on 2018/9/13.
 */
@Service(interfaceClass = ISsoUserService.class)
public class SsoUserServiceImpl implements ISsoUserService {

    @Resource
    private IUserService userService;



}
