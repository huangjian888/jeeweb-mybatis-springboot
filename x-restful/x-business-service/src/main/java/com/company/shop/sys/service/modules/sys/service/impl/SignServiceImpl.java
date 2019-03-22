package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.exception.BusinessException;
import com.company.shop.sys.service.common.vo.SignVo;
import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.modules.sys.entity.SignConfigEntity;
import com.company.shop.sys.service.modules.sys.entity.SignEntity;
import com.company.shop.sys.service.modules.sys.entity.LogEntity;
import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import com.company.shop.sys.service.modules.sys.mapper.SignMapper;
import com.company.shop.sys.service.modules.sys.service.ILogService;
import com.company.shop.sys.service.modules.sys.service.ISignConfigService;
import com.company.shop.sys.service.modules.sys.service.ISignService;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("signService")
public class SignServiceImpl extends ServiceImpl<SignMapper, SignEntity> implements ISignService {

    @Autowired
    private ISignConfigService signConfigurationService;

    @Autowired
    private ILogService signLogService;

    @Autowired
    private IStoreUserService storeUserService;

    /**
     * 签到操作
     *
     * @return
     */
    @Override
    public TaskInfoVo onSign() {
        Date date = new Date();
        TaskInfoVo taskInfoVo = new TaskInfoVo();

        SignEntity signEntity = baseMapper.getSignTable(PrincipalUtils.getUsername());

        if (null == signEntity) {//第一次签到操作:插入到用户签到表与用户签到日志表
            signEntity = new SignEntity();
            signEntity.setFirstTime(BusinessConstant.Home.ZERO);
            signEntity.setSignCount(BusinessConstant.Home.ONE);//七天后重置连续签到时间为1
            signEntity.setSignTime(date);
            signEntity.setUserName(PrincipalUtils.getUsername());
            insertOrUpdate(signEntity);//fixme 连续签到七天后重新刷新连续签到天数
            // this.updateSign(sign);
            //insertSign(signEntity);
            SignConfigEntity signConfigEntity = signConfigurationService.getStep(BusinessConstant.Home.ONE);
            taskInfoVo.setSuccess(true);
            taskInfoVo.setAward(signConfigEntity.getStep());

            updateUserAward(signConfigEntity.getStep());
            updateLog(date, signConfigEntity);//fixme 上传日志
            return taskInfoVo;
        }


        if (isRepetitionSign(signEntity, date)) {//非第一次签到--获取上一次签到日期，如是当天，则返回已经签到的状态
            taskInfoVo.setSuccess(false);
            taskInfoVo.setAward(BusinessConstant.Home.ZERO);

            return taskInfoVo;
        }

        if (checkDay(signEntity)) {//非第一次签到并且连续七天后--7天后

            return getSignTask(signEntity, date);

        }

        //fixme 平常的签到操作:非第一次--七天内

        int count = 0;
        if (isLink(signEntity.getSignTime(), date)) {//fixme 是连续的天数签到
            count = signEntity.getSignCount() + BusinessConstant.Home.ONE;
            Log.i("是连续签到,count:" + count);

        } else {
            count = BusinessConstant.Home.ONE;//fixme 不为连续签到，连续签到的天数置为1
        }

        signEntity.setSignTime(date);

        signEntity.setSignCount(count);


        //fixme 当前信息插入用户签到数据表--签到成功-->返回前端对应步数奖励
        insertOrUpdate(signEntity);
        //updateSign(signEntity);

        SignConfigEntity signConfigEntity = signConfigurationService.getStep(count);
        if (null == signConfigEntity) {
            throw new BusinessException(ErrorCodeEnum.TASK1050.code(), ErrorCodeEnum.TASK1050.msg());
        }
        taskInfoVo.setAward(signConfigEntity.getStep());
        taskInfoVo.setSuccess(true);

        updateUserAward(signConfigEntity.getStep());
        updateLog(date, signConfigEntity);//fixme 上传日志
        return taskInfoVo;
    }

    /**
     * 是连续签到时间
     */
    private boolean isLink(Date lastDate, Date nowDate) {

        if (DateUtils.daysBetween(lastDate, nowDate) == 1) {
            Log.i("连续一天");
            return true;
        }
        return false;
    }

    private TaskInfoVo getSignTask(SignEntity sign, Date date) {
        TaskInfoVo taskInfoVo = new TaskInfoVo();
        sign = new SignEntity();
        sign.setSignCount(BusinessConstant.Home.ONE);//七天后重置连续签到时间为1
        sign.setSignTime(date);
        insertOrUpdate(sign);//fixme 连续签到七天后重新刷新连续签到天数
        // this.updateSign(sign);
        SignConfigEntity signConfigEntity = signConfigurationService.getStep(BusinessConstant.Home.ONE);

        taskInfoVo.setSuccess(true);
        taskInfoVo.setAward(signConfigEntity.getStep());

        updateUserAward(signConfigEntity.getStep());
        updateLog(date, signConfigEntity);//fixme 上传日志
        return taskInfoVo;
    }


    /**
     * 签到成功向用户表中插入总步数
     */
    private void updateUserAward(int step) {
        StoreUserEntity storeUserEntity = storeUserService.getUserInfo();
        storeUserEntity.setStep(storeUserEntity.getStep() + step);
        storeUserService.insertOrUpdate(storeUserEntity);


    }

    /**
     * 上传日志
     */
    private void updateLog(Date date, SignConfigEntity signConfigEntity) {
        LogEntity signLogEntity = new LogEntity();
        signLogEntity.setSignTime(date);//当前时间
        signLogEntity.setUserName(PrincipalUtils.getUsername());
        signLogEntity.setAward(signConfigEntity.getStep());//第一次签到奖励步数
        signLogEntity.setCategory(signConfigEntity.getCategory());
        signLogEntity.setCategoryName(signConfigEntity.getDescription());
        signLogService.insertLog(signLogEntity);//向日志表中插入用户签到数据
    }


    /**
     * 七天以后连续签到置为0，无特殊奖励
     */
    private boolean checkDay(SignEntity signEntity) {
        if (signEntity.getSignCount() == BusinessConstant.Sign.DAY_7) {//数据库中已经连签了7天，需要重置签到状态
            return true;
        }

        return false;
    }

    /**
     * 检查当前是否符合签到规则--一天只能签到一次
     */
    private boolean isRepetitionSign(SignEntity signEntity, Date nowDate) {

        if (DateUtils.daysBetween(signEntity.getSignTime(), nowDate) > 0) {//一天内不允许重复进行签到

            return false;
        }
        return true;
    }

    /**
     * 设置签到自动提醒--处理自动提醒服务
     *
     * @return
     */

    @Override
    public int setAlert(int category) {

        SignEntity signEntity = baseMapper.getSignTable(PrincipalUtils.getUsername());
        if (null == signEntity) {
            return 0;
        }
        signEntity.setAutoAlert(category);//将用户签到表当前状态设置为1

        //需要将当前的用openid，以及前端的formId保存到redis

        return insertOrUpdate(signEntity) ? 1 : 0;
    }


    /**
     * 获取签到信息--个人界面用于展示
     *
     * @return
     */
    @Override
    public SignVo getSign() {
        Date date = new Date();
        SignVo signVo = new SignVo();

        SignEntity signEntity = baseMapper.getSignTable(PrincipalUtils.getUsername());

        if (null == signEntity) {//fixme 还没有签过到
            signVo.setSign(false);
            signVo.setSignCount(BusinessConstant.Home.ZERO);
        } else {
            //判断今日是否已经签到
            signVo.setSign(isRepetitionSign(signEntity, date));
            signVo.setSignCount(signEntity.getSignCount());//用户连续签到次数
        }


        return signVo;
    }

    /**
     * 查询签到表
     *
     * @return
     */
    @Override
    public SignEntity getSignEntity() {
        return baseMapper.getSignTable(PrincipalUtils.getUsername());
    }

    /**
     * 查询已预约签到的用户,openId集合
     *
     * @return
     */
    @Override
    public List<SignEntity> getBookingSign() {

        return baseMapper.getBookingSign(BusinessConstant.Sign.IS_FIRST);
    }

    @Override
    public int updateTable(SignEntity signEntity) {
        return insertOrUpdate(signEntity) ? 1 : 0;
    }

    @Override
    public List<SignConfigEntity> getSignConfigurationList() {

        return signConfigurationService.getSignConfig();
    }


}
