package com.company.manerger.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.modules.sys.service.IGrandClassifyService;
import com.company.manerger.sys.service.modules.sys.entity.GrandClassify;
import com.company.manerger.sys.service.modules.sys.mapper.GrandClassifyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;


/**
*
* @version V1.0
* @package com.company.manerger.sys.service.modules.sys.service.impl
* @title: 商品列表服务实现
* @description: 商品列表服务实现
* @date: 2018-11-29 15:45:52
*/
@Transactional
@Service("grandclassifyService")
public class GrandClassifyServiceImpl  extends CommonServiceImpl<GrandClassifyMapper,GrandClassify> implements  IGrandClassifyService {
    @Override
    public GrandClassify findByGrandName(String grandName) {
        if (StringUtils.isEmpty(grandName)) {
            return null;
        }
        return selectOne(new EntityWrapper<GrandClassify>(GrandClassify.class).eq("grandName", grandName));
    }

    @Override
    public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
        for (Object id : idList) {
            this.deleteById((Serializable) id);
        }
        return true;
    }

    @Override
    public Page<GrandClassify> selectPage(Page<GrandClassify> page, Wrapper<GrandClassify> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectGrandClassifyList(page, wrapper));
        return page;
    }
}