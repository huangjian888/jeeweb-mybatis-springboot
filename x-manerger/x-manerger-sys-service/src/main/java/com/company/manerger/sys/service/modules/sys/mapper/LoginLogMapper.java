package com.company.manerger.sys.service.modules.sys.mapper;

import com.company.manerger.sys.service.modules.sys.entity.LoginLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: 登陆日志数据库控制层接口
*/
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

}