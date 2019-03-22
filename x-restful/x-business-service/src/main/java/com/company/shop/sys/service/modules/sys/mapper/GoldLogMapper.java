package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.shop.sys.service.modules.sys.entity.GoldLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoldLogMapper extends BaseMapper<GoldLogEntity> {
    List<GoldLogEntity> getGoldList(Pagination page, @Param("username") String username);
}
