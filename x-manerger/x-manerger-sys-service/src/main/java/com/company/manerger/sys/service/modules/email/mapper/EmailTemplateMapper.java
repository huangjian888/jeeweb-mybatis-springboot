package com.company.manerger.sys.service.modules.email.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.manerger.sys.service.modules.email.entity.EmailTemplate;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: 邮件模板数据库控制层接口
*/
@Mapper
public interface EmailTemplateMapper extends BaseMapper<EmailTemplate> {

}