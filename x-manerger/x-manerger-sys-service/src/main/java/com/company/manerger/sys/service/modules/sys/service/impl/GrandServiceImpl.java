package com.company.manerger.sys.service.modules.sys.service.impl;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.common.utils.StringUtils;

import com.company.manerger.sys.service.modules.sys.service.IGrandService;
import com.company.manerger.sys.service.modules.sys.entity.Grand;
import com.company.manerger.sys.service.modules.sys.mapper.GrandMapper;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
*
* @version V1.0
* @package com.company.manerger.sys.service.modules.sys.service.impl
* @title: 品牌功能服务实现
* @description: 品牌实体服务实现
* @date: 2018-11-27 13:55:10
*/
@Transactional
@Service("grandService")
public class GrandServiceImpl  extends CommonServiceImpl<GrandMapper,Grand> implements  IGrandService {

    @Override
    public Grand findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return selectOne(new EntityWrapper<Grand>(Grand.class).eq("name", name));
    }

    @Override
    public List<Grand> selectAll() {
        List<Grand> grandList = baseMapper.selectList(new EntityWrapper<Grand>(Grand.class));
        return grandList;
    }

    @Override
    public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
        for (Object id : idList) {
            this.deleteById((Serializable) id);
        }
        return true;
    }

    @Override
    public Page<Grand> selectPage(Page<Grand> page, Wrapper<Grand> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectGrandList(page, wrapper));
        return page;
    }

}




