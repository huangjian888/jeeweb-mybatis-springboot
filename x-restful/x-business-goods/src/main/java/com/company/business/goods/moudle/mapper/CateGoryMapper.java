package com.company.business.goods.moudle.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.business.goods.moudle.entity.CateGoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CateGoryMapper extends BaseMapper<CateGoryEntity> {
    List<CateGoryEntity> getCategoryList(Pagination page);

    CateGoryEntity getCateGoryEntity(@Param("optId") int optId);

    boolean updateCateGory(@Param("optId") int optId, @Param("order") int order, @Param("level") int level, @Param("opt_name") String opt_name, @Param("parent_opt_id") int parent_opt_id);
}
