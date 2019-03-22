package com.company.manerger.sys.service.modules.sys.service.impl;

import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.service.modules.sys.entity.LoginLog;
import com.company.manerger.sys.service.modules.sys.mapper.LoginLogMapper;
import com.company.manerger.sys.service.modules.sys.service.ILoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* @description: 登陆日志服务实现
*/
@Transactional
@Service("loginlogService")
public class LoginLogServiceImpl  extends CommonServiceImpl<LoginLogMapper,LoginLog> implements  ILoginLogService {

}