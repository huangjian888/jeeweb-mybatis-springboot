package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//@DS("slave_companyShop") fixme 管理后台服务将推荐数据库配置于业务数据库--tomato_promotion_subject_config
public interface SubjectMapper extends BaseMapper<SubjectEntity> {

    List<SubjectEntity> getSubjectByCategoryId(@Param("categoryId") String categoryId);

}
