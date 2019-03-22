package com.company.manerger.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.manerger.sys.service.modules.sys.entity.GrandClassify;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @version V1.0
 * @package com.company.manerger.sys.service.modules.sys.mapper
 * @title: 商品列表数据库控制层接口
 * @description: 商品列表数据库控制层接口
 * @date: 2018-11-29 15:45:52
 */
@Mapper
public interface GrandClassifyMapper extends BaseMapper<GrandClassify> {

    /**
     *
     * @title: selectGrandClassifyList
     * @description:查找商品列表
     * @param wrapper
     * @return
     * @return: List<GrandClassify>
     */
    List<GrandClassify> selectGrandClassifyList(Pagination page, @Param("ew") Wrapper<GrandClassify> wrapper);

}