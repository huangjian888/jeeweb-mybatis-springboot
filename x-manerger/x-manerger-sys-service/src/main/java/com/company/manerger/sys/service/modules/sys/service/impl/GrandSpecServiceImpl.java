package com.company.manerger.sys.service.modules.sys.service.impl;

import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.service.modules.sys.service.IGrandSpecService;
import com.company.manerger.sys.service.modules.sys.entity.GrandSpec;
import com.company.manerger.sys.service.modules.sys.mapper.GrandSpecMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
*
* @version V1.0
* @package com.company.manerger.sys.service.modules.sys.service.impl
* @title: 商品规格服务实现
* @description: 显示商品规格服务实现
* @date: 2018-12-03 14:41:15
*/
@Transactional
@Service("grandSpecService")
public class GrandSpecServiceImpl  extends CommonServiceImpl<GrandSpecMapper,GrandSpec> implements  IGrandSpecService {

    @Override
    public List<GrandSpec> selectGrandSpecList() {
        return baseMapper.selectGrandSpecList();
    }

}