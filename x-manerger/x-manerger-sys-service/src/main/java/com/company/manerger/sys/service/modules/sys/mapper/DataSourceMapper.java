package com.company.manerger.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.manerger.sys.service.modules.sys.entity.DataSource;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 数据源数据库控制层接口
 */
@Mapper
public interface DataSourceMapper extends BaseMapper<DataSource> {

}
