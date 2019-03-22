package com.company.business.goods.security.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TomatoUserMapper extends BaseMapper<TomatoUserEntity> {
    TomatoUserEntity getUserByUserName(@Param("username") String username);

    List<TomatoUserEntity> getAllUser();

    List<TomatoUserEntity> getUserFansList(Pagination page, @Param("username") String username);

    List<TomatoUserEntity> getUserFansListSize(@Param("username") String username);
}
