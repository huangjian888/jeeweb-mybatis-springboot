package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.CommissionConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommissionConfigMapper extends BaseMapper<CommissionConfigEntity> {

    CommissionConfigEntity getCommissionConfig(@Param("countTimes") int countTimes);

    List<CommissionConfigEntity> getCommissionConfigList();
}
