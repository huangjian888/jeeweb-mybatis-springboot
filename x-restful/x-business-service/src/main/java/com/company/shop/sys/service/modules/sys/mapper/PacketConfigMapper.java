package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.PacketConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PacketConfigMapper extends BaseMapper<PacketConfigEntity> {
    PacketConfigEntity getPackConfig();
    PacketConfigEntity getPackConfigUser(@Param("username")String username);
}
