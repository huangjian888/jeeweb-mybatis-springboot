package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.CateGoryEntity;
import com.company.business.goods.moudle.mapper.CateGoryMapper;
import com.company.business.goods.moudle.service.ICateGoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("cateGoryService")
@Transactional
public class CateGoryServiceImpl extends ServiceImpl<CateGoryMapper, CateGoryEntity> implements ICateGoryService {


    @Override
    public Page<CateGoryEntity> getCateGoryList(Page<CateGoryEntity> page) {
        return page.setRecords(baseMapper.getCategoryList(page));
    }

    /**
     * 上传商品配置信息
     *
     * @param JSONObject
     * @return
     */
    @Override
    public boolean insertCateGory(JSONObject json) {
        int optId = json.getIntValue("opt_id");
        CateGoryEntity cateGoryEntity = this.getCateGoryEntity(optId);

        int order = json.getIntValue("order");
        int level = json.getIntValue("level");
        String opt_name = json.getString("opt_name");
        int parent_opt_id = json.getIntValue("parent_opt_id");
        if (null == cateGoryEntity) {
            cateGoryEntity = new CateGoryEntity();
            cateGoryEntity.setOpt_id(optId);
        }

        cateGoryEntity.setOrder(order);
        cateGoryEntity.setLevel(level);
        cateGoryEntity.setOpt_name(opt_name);
        cateGoryEntity.setParent_opt_id(parent_opt_id);

        return insertOrUpdate(cateGoryEntity);
    }


    @Override
    public CateGoryEntity getCateGoryEntity(int optId) {

        return baseMapper.getCateGoryEntity(optId);
    }

}
