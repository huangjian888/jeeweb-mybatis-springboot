package com.company.manerger.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.manerger.sys.service.modules.sys.entity.Grand;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @version V1.0
 * @package com.company.manerger.sys.service.modules.sys.controller.mapper
 * @title: 品牌功能数据库控制层接口
 * @description: 品牌实体数据库控制层接口
 * @date: 2018-11-27 13:55:10
 */
@Mapper
public interface GrandMapper extends BaseMapper<Grand> {
 /**
  *
  * @title: selectGrandList
  * @description: 查找品牌列表
  * @param wrapper
  * @return
  * @return: List<Grand>
  */
   List<Grand> selectGrandList(Pagination page, @Param("ew") Wrapper<Grand> wrapper);

}