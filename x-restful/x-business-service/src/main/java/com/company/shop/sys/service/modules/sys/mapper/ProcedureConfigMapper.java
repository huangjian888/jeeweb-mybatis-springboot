package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.company.shop.sys.service.modules.sys.entity.ProcedureConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProcedureConfigMapper extends BaseMapper<ProcedureConfigEntity> {
    ProcedureConfigEntity getProcedureEntity();

    ProcedureConfigEntity getProcedure(@Param("username") String username);
}
