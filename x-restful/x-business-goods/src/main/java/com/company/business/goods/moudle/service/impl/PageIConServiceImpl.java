package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.PageIConEntity;
import com.company.business.goods.moudle.mapper.PageIConMapper;
import com.company.business.goods.moudle.service.IPageIConService;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("pageIConService")
@Transactional
public class PageIConServiceImpl extends ServiceImpl<PageIConMapper, PageIConEntity> implements IPageIConService {

    @Override
    public PageIConEntity getPageIConEntity(String markId) {

        return baseMapper.getPageIConEntity(markId);
    }

    @Override
    public boolean insertPageICon(JSONObject json) {
        String pageInfo = json.getString("pageInfo");
        String markId = json.getString("markId");
        String remark = json.getString("remark");
        int status = json.getIntValue("status");

        PageIConEntity pageIConEntity = this.getPageIConEntity(markId);


        if (null == pageIConEntity) {
            pageIConEntity = new PageIConEntity();
            pageIConEntity.setCreateDate(new Date());
            pageIConEntity.setCreateId(PrincipalUtils.getUsername());
            pageIConEntity.setPageInfo(pageInfo);
            pageIConEntity.setIconMark(markId);
            pageIConEntity.setRemark(remark);
            pageIConEntity.setStatus(status);
            return insertOrUpdate(pageIConEntity);

        }

        return false;


    }

    /**
     * 更新修改页面,当前更新者id
     *
     * @param json
     * @return
     */
    @Override
    public boolean updatePageIcon(JSONObject json) {
        String pageInfo = json.getString("pageInfo");
        String markId = json.getString("markId");
        String remark = json.getString("remark");
        int status = json.getIntValue("status");

        PageIConEntity pageIConEntity = this.getPageIConEntity(markId);


        if (null == pageIConEntity) {
            return false;
        }

        return baseMapper.updatePageIcon(markId, pageInfo, remark, status, PrincipalUtils.getUsername(), new Date());

    }


}
