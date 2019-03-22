package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.ProcedureUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProcedureUserMapper extends BaseMapper<ProcedureUserEntity> {
    ProcedureUserEntity getProcedureUserEntity(@Param("username") String username);
}
