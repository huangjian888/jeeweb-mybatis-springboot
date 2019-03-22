package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.InviteAwardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InviteAwardMapper extends BaseMapper<InviteAwardEntity> {

    int deleteInviteAward(@Param("id") String id);

    List<InviteAwardEntity> getInviteAward(@Param("username") String username);

    InviteAwardEntity getAward(@Param("id") String id);
}
