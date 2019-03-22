package com.company.manerger.sys.service.modules.sys.service;

import com.company.manerger.sys.common.mybatis.service.ICommonService;
import com.company.manerger.sys.service.modules.sys.entity.GrandClassify;

/**
*
* @version V1.0
* @package com.company.manerger.sys.service.modules.sys.service
* @title: 商品列表服务接口
* @description: 商品列表服务接口
* @date: 2018-11-29 15:45:52
*/
public interface IGrandClassifyService extends ICommonService<GrandClassify> {
    /**
     * 根据商品名字查找商品列表
     *
     * @param grandName
     * @return
     */
    public GrandClassify findByGrandName(String grandName);

}