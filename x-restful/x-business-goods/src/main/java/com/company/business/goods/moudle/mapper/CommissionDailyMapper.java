package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.CommissionDailyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommissionDailyMapper extends BaseMapper<CommissionDailyEntity> {

    CommissionDailyEntity getCommissionDaily(@Param("username")String username);
}
