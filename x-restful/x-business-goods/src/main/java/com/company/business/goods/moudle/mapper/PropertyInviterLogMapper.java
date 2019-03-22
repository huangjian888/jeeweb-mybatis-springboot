package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PropertyInviterLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PropertyInviterLogMapper extends BaseMapper<PropertyInviterLogEntity> {

    List<PropertyInviterLogEntity> getPropertyInviterList(@Param("inviter_user") String inviter_user, @Param("invited_user") String invited_user);

    PropertyInviterLogEntity getPropertyInviterLog(@Param("order_no") String order_no);
}
