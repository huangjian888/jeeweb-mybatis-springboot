package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.moudle.entity.CommissionTipEntity;
import com.company.business.goods.moudle.mapper.CommissionTipMapper;
import com.company.business.goods.moudle.service.ICommissionTipService;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("commissionTipService")
public class CommissionTipServiceImpl extends ServiceImpl<CommissionTipMapper, CommissionTipEntity> implements ICommissionTipService {

    @Override
    public boolean insertCommissionTip(JSONObject json) {


        String day_count_times = json.getString("day_count_times");//每天提现次数
        String commission_money_max = json.getString("commission_money_max");//每天最多提现金额
        String remark = json.getString("remarks");

        CommissionTipEntity commissionTipEntity = this.getCommissionTip();
        if (null == commissionTipEntity) {
            commissionTipEntity = new CommissionTipEntity();
            commissionTipEntity.setCreate_date(new Date());
            commissionTipEntity.setCreate_by(TomatoConstant.Common.company_ADMIN);
        } else {
            commissionTipEntity.setUpdate_date(new Date());
            commissionTipEntity.setUpdate_by(TomatoConstant.Common.company_ADMIN);
        }
        if (!TextUtils.isEmpty(day_count_times)) {
            commissionTipEntity.setDay_count_times(Integer.parseInt(day_count_times));
        }
        if (!TextUtils.isEmpty(commission_money_max)) {
            commissionTipEntity.setCommission_money_max(Integer.parseInt(commission_money_max));
        }
        commissionTipEntity.setRemarks(remark);

        return insertOrUpdate(commissionTipEntity);
    }


    @Override
    public CommissionTipEntity getCommissionTip() {

        return baseMapper.getCommissionTip(TomatoConstant.Common.company_ADMIN);
    }


}
