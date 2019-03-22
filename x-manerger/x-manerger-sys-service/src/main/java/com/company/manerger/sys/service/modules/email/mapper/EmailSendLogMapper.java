package com.company.manerger.sys.service.modules.email.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.manerger.sys.service.modules.email.entity.EmailSendLog;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: 邮件发送日志数据库控制层接口
*/
@Mapper
public interface EmailSendLogMapper extends BaseMapper<EmailSendLog> {

}