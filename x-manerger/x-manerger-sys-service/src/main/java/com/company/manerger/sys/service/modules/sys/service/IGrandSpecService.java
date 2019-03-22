package com.company.manerger.sys.service.modules.sys.service;

import com.company.manerger.sys.common.mybatis.service.ICommonService;
import com.company.manerger.sys.service.modules.sys.entity.GrandSpec;

import java.util.List;

/**
*
* @version V1.0
* @package com.company.manerger.sys.service.modules.sys.service
* @title: 商品规格服务接口
* @description: 显示商品规格服务接口
* @date: 2018-12-03 14:41:15
*/
public interface IGrandSpecService extends ICommonService<GrandSpec> {

    public List<GrandSpec> selectGrandSpecList();

}