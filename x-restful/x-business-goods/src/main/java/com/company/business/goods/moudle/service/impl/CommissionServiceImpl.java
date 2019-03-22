package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.CommissionVo;
import com.company.business.goods.moudle.entity.*;
import com.company.business.goods.moudle.mapper.CommissionMapper;
import com.company.business.goods.moudle.service.*;
import com.company.business.goods.utils.BigDecimalUtils;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("commissionService")
@Transactional
public class CommissionServiceImpl extends ServiceImpl<CommissionMapper, CommissionEntity> implements ICommissionService {

    @Autowired
    private ICommissionConfigService commissionConfigService;

    @Autowired
    private ICommissionDailyService commissionDailyService;

    @Autowired
    private IPropertyService propertyService;//个人财富接口
    @Autowired
    private ICommissionTipService commissionTipService;//包含用户每天可提现的次数

    private boolean insertCommission(String money) {
        CommissionEntity commissionEntity = new CommissionEntity();
        commissionEntity.setCommission_date(new Date());
        commissionEntity.setCommission_money(getCommissionMoney(money));
        commissionEntity.setUser_name(PrincipalUtils.getUsername());
        commissionEntity.setCommission_order(new StringBuilder(StringUtils.randomString(TomatoConstant.Message.NUMBER_8)).append(System.currentTimeMillis()).toString());
        commissionEntity.setStatus(TomatoConstant.Common.NUMBER_0);
        return insertOrUpdate(commissionEntity);
    }


    private BigDecimal getCommissionMoney(String money) {
        return new BigDecimal(money).setScale(TomatoConstant.Message.NUMBER_2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal getCommissionDiv(String money, CommissionConfigEntity commissionConfigEntity) {
        return BigDecimalUtils.sub(getCommissionMoney(money).doubleValue(), commissionConfigEntity.getCommission_money().doubleValue());
    }


    private boolean insertCommissionDaily(String money) {

        CommissionDailyEntity commissionDailyEntity = commissionDailyService.getCommissionDaily(PrincipalUtils.getUsername());

        if (null == commissionDailyEntity) {
            commissionDailyEntity = new CommissionDailyEntity();
            commissionDailyEntity.setUser_name(PrincipalUtils.getUsername());
            commissionDailyEntity.setCommission_times(TomatoConstant.Common.NUMBER_1);
        } else {
            commissionDailyEntity.setCommission_times(commissionDailyEntity.getCommission_times() + TomatoConstant.Common.NUMBER_1);
        }

        commissionDailyEntity.setCommission_money(new BigDecimal(money));
        commissionDailyEntity.setCommission_date(new Date());
        return commissionDailyService.insertCommissionEntity(commissionDailyEntity);

    }


    /**
     * fixme 提现成功用户的可提现额度变化
     */
    private boolean updateProper(PropertyEntity propertyEntity, double money) {

        String moneyStr = String.valueOf(money);
        boolean commissionSuc = insertCommission(moneyStr);
        boolean dailySuc = insertCommissionDaily(moneyStr);

        if (commissionSuc && dailySuc) {
            propertyEntity.setCommission_money_able(BigDecimalUtils.sub(propertyEntity.getCommission_money_able().doubleValue(), money));
            return propertyService.insertProperty(propertyEntity);
        }

        return false;
    }

    @Override
    public int commission(String money) {
        CommissionTipEntity commissionTipEntity = commissionTipService.getCommissionTip();
        if (isCanCommission(commissionTipEntity)) {
            //Fixme 当天还可以提现,查询用户是第几次提现

            PropertyEntity propertyEntity = propertyService.getProperEntity(PrincipalUtils.getUsername());
            if (null == propertyEntity) {//个人财产列表为空

                return ErrorCodeEnum.COUPON2025.code();
            }

            double targetMoney = Double.valueOf(money);

            if (propertyEntity.getCommission_money_able().doubleValue() < targetMoney) {
                return ErrorCodeEnum.COUPON2025.code();
            }


            if (targetMoney < TomatoConstant.Common.NUMBER_0 || targetMoney > commissionTipEntity.getCommission_money_max()) {
                return ErrorCodeEnum.COUPON2023.code();
            }


            List<CommissionEntity> list = this.getCommissionList();
            if (list.size() == TomatoConstant.Common.NUMBER_0) {//用户首次进行提现操作
                CommissionConfigEntity commissionConfigEntity = commissionConfigService.getCommissionConfig(TomatoConstant.Common.NUMBER_1);
                if (getCommissionDiv(money, commissionConfigEntity).doubleValue() < TomatoConstant.Common.NUMBER_0) {//当前提现金额小于配置体现金额
                    return ErrorCodeEnum.COUPON2020.code();
                } else if (BigDecimalUtils.sub(propertyEntity.getCommission_money_able().doubleValue(), targetMoney).doubleValue() < 0) {

                    return ErrorCodeEnum.COUPON2026.code();
                }

                return updateProper(propertyEntity, targetMoney) ? TomatoConstant.Common.NUMBER_1 : ErrorCodeEnum.COUPON2021.code();
            } else {
                //fixme 判断用户是第几次进行提现
                CommissionConfigEntity commissionConfigEntity = commissionConfigService.getCommissionConfig(list.size());
                if (null == commissionConfigEntity) {

                    List<CommissionConfigEntity> configList = commissionConfigService.getCommissionConfigList();
                    commissionConfigEntity = commissionConfigService.getCommissionConfig(configList.size());

                    if (getCommissionDiv(money, commissionConfigEntity).doubleValue() < TomatoConstant.Common.NUMBER_0) {
                        return ErrorCodeEnum.COUPON2020.code();
                    } else if (BigDecimalUtils.sub(propertyEntity.getCommission_money_able().doubleValue(), targetMoney).doubleValue() < 0) {
                        return ErrorCodeEnum.COUPON2026.code();
                    }

                    return updateProper(propertyEntity, targetMoney) ? TomatoConstant.Common.NUMBER_1 : ErrorCodeEnum.COUPON2021.code();


                } else {
                    if ((getCommissionDiv(money, commissionConfigEntity).doubleValue() < TomatoConstant.Common.NUMBER_0)) {
                        return ErrorCodeEnum.COUPON2020.code();

                    } else if (BigDecimalUtils.sub(propertyEntity.getCommission_money_able().doubleValue(), targetMoney).doubleValue() < 0) {
                        return ErrorCodeEnum.COUPON2026.code();
                    }

                    return updateProper(propertyEntity, targetMoney) ? TomatoConstant.Common.NUMBER_1 : ErrorCodeEnum.COUPON2021.code();
                }

            }


        }

        return ErrorCodeEnum.COUPON2022.code();
    }

    /**
     * 查询用户是第几次提现
     *
     * @return
     */
    @Override
    public List<CommissionEntity> getCommissionList() {
        return baseMapper.getCommissionList(PrincipalUtils.getUsername());
    }

    @Override
    public CommissionVo getCommissionVo() {
        CommissionVo commissionVo = new CommissionVo();
        CommissionTipEntity commissionTipEntity = commissionTipService.getCommissionTip();

        if (null == commissionTipEntity) {
            return null;
        }

        commissionVo.setCounts(commissionTipEntity.getDay_count_times());
        commissionVo.setMax(commissionTipEntity.getCommission_money_max());

        CommissionConfigEntity commissionConfigEntity = null;

        List<CommissionEntity> list = this.getCommissionList();


        if (list.size() == TomatoConstant.Common.NUMBER_0) {//用户首次进行提现操作
            commissionConfigEntity = commissionConfigService.getCommissionConfig(TomatoConstant.Common.NUMBER_1);
            commissionVo.setCommission_money(commissionConfigEntity.getCommission_money());

            return commissionVo;

        } else {
            commissionConfigEntity = commissionConfigService.getCommissionConfig(list.size() + TomatoConstant.Common.NUMBER_1);

            if (null == commissionConfigEntity) {

                List<CommissionConfigEntity> configList = commissionConfigService.getCommissionConfigList();

                commissionConfigEntity = commissionConfigService.getCommissionConfig(configList.size());
                commissionVo.setCommission_money(commissionConfigEntity.getCommission_money());
                return commissionVo;
            }

            commissionVo.setCommission_money(commissionConfigEntity.getCommission_money());
            return commissionVo;

        }


    }

    @Override
    public int commissionAble() {
        return isCanCommission(commissionTipService.getCommissionTip()) ? TomatoConstant.Common.NUMBER_1 : TomatoConstant.Common.NUMBER_0;
    }

    @Override
    public boolean insertUpdateConfig(JSONObject json) {
        double money = json.getDoubleValue("money");
        int counts = json.getIntValue("counts");
        String tips = json.getString("tips");
        if (counts <= TomatoConstant.Common.NUMBER_0) {
            return false;
        }
        CommissionConfigEntity commissionConfigEntity = commissionConfigService.getCommissionConfig(counts);

        if (null == commissionConfigEntity) {
            commissionConfigEntity = new CommissionConfigEntity();
            commissionConfigEntity.setCreate_by(TomatoConstant.Common.company_ADMIN);
            commissionConfigEntity.setCreate_date(new Date());

        } else {
            commissionConfigEntity.setUpdate_by(TomatoConstant.Common.company_ADMIN);
            commissionConfigEntity.setUpdate_date(new Date());
        }

        commissionConfigEntity.setCount_times(counts);
        commissionConfigEntity.setTips(tips);
        commissionConfigEntity.setCommission_money(BigDecimalUtils.mul(money, TomatoConstant.Common.NUMBER_1));
        return commissionConfigService.insertCommissionConfig(commissionConfigEntity);


    }


    private boolean isCanCommission(CommissionTipEntity commissionTipEntity) {
        CommissionDailyEntity commissionDailyEntity = commissionDailyService.getCommissionDaily(PrincipalUtils.getUsername());
        if (null == commissionDailyEntity) {
            return true;
        } else if (commissionDailyEntity.getCommission_times() < commissionTipEntity.getDay_count_times()) {
            return true;
        }
        return false;
    }


}
