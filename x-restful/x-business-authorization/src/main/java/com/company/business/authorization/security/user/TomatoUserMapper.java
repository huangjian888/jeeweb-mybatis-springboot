package com.company.business.authorization.security.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TomatoUserMapper extends BaseMapper<TomatoUserEntity> {

    TomatoUserEntity getUserByUserName(@Param("username")String username);
}
