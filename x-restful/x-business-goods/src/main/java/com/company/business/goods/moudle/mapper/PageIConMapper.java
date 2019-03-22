package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PageIConEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface PageIConMapper extends BaseMapper<PageIConEntity> {

    PageIConEntity getPageIConEntity(@Param("markId") String markId);

    boolean updatePageIcon(@Param("markId") String markId, @Param("pageInfo") String pageInfo, @Param("remark") String remark, @Param("status") int status, @Param("username") String username, @Param("updateDate") Date updateDate);
}
