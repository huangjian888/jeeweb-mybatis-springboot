package com.company.manerger.sys.service.modules.sys.service;

import com.company.manerger.sys.common.mybatis.service.ICommonService;
import com.company.manerger.sys.service.modules.sys.entity.Grand;
import java.util.List;

/**
*
* @version V1.0
* @package com.company.manerger.sys.service.modules.sys.service
* @title: 品牌功能服务接口
* @description: 品牌实体服务接口
* @date: 2018-11-27 13:55:10
*/
public interface IGrandService extends ICommonService<Grand> {
    /**
     * /通过名字查找品牌信息
     * @param name
     * @return
     */


    public Grand findByName(String name);
    /**
     * /查询所有品牌名字,商品列表下拉选查询
     *
     *
     */
    public List<Grand> selectAll();

    }


