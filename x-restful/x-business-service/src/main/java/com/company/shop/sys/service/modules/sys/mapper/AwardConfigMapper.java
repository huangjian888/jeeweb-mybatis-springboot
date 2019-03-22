package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.AwardConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface AwardConfigMapper extends BaseMapper<AwardConfigEntity> {

    List<AwardConfigEntity> getAwardList();

    AwardConfigEntity getAwardConfigEntity(@Param("order_no") int order_no);
}
