package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.CommissionTipEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommissionTipMapper extends BaseMapper<CommissionTipEntity> {
    CommissionTipEntity getCommissionTip(@Param("username") String username);

}
