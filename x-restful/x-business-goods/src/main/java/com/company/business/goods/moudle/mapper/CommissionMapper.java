package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.CommissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommissionMapper extends BaseMapper<CommissionEntity> {
    List<CommissionEntity> getCommissionList(@Param("username") String username);
}
