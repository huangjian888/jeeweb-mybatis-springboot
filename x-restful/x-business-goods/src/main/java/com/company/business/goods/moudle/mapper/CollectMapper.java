package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.business.goods.moudle.entity.CollectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectMapper extends BaseMapper<CollectEntity> {

    List<CollectEntity> getCollectList(Pagination page, @Param("username") String username);

    CollectEntity selectCollect(@Param("username") String username, @Param("couponId") String couponId);

    int cancelCollect(@Param("username") String username,@Param("couponId") String couponId);


}
