package com.company.manerger.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.manerger.sys.service.modules.sys.entity.StoreUser;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @version V1.0
 * @package com.company.shop.sys.service.modules.sys.mapper
 * @title: 用户表数据库控制层接口
 * @description: 用户表数据库控制层接口
 * @author: huangjian
 * @date: 2018-11-23 15:48:46
 */
@Mapper
public interface StoreUserMapper extends BaseMapper<StoreUser> {
}