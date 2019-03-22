package com.company.shop.sys.service.modules.sys.service.impl;

import com.company.shop.sys.service.common.bean.GoldLogEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.StepVo;
import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.common.vo.TaskVo;
import com.company.shop.sys.service.modules.sys.entity.*;
import com.company.shop.sys.service.modules.sys.service.*;
import com.company.shop.sys.service.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("homeService")
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private IAwardConfigService awardLimitService;

    @Autowired
    private IStoreUserService storeUserService;
    @Autowired
    private IGoldLogService goldLogService;

    @Autowired
    private IPacketConfigService packConfigService;
    @Autowired
    private IPacketService packetService;
    @Autowired
    private ISignService signService;
    @Autowired
    private ISignConfigService signConfigService;

    @Autowired
    private IProcedureConfigService procedureService;
    @Autowired
    private IProcedureUserService procedureUserService;

    @Autowired
    private IInviteConfigService inviteConfigService;

    @Autowired
    private IInviteAwardService iInviteAwardService;
    @Autowired
    private IStepService stepService;

    /**
     * 获取用户今日步数兑奖状态
     *
     * @return
     */
    @Override
    public List<StepEntity> getUserStep() {
        List<StepEntity> stepList = stepService.getUserStep();

        if (stepList.size() == BusinessConstant.Home.ZERO) {
            List<AwardConfigEntity> limitList = awardLimitService.getAwardList();

            if (null == limitList) {
                return null;
            }
            for (AwardConfigEntity award : limitList) {
                StepEntity stepEntity = new StepEntity();
                stepEntity.setUserName(PrincipalUtils.getUsername());
                stepEntity.setStep(award.getAward());
                stepEntity.setGold(award.getGold());
                stepService.updateUserStep(stepEntity);
            }
            return stepService.getUserStep();
        }//fixme 如运营修改步数兑换金币限制，需要每日删除用户的默奖励兑换

        return stepList;
    }


    /**
     * 获取用户标志位的步数金币兑换list
     *
     * @param stepList
     * @return
     */
    private List<StepEntity> getSymbolList(List<StepEntity> stepList) {

        List<StepEntity> symbolList = new ArrayList<>();
        for (StepEntity stepEntity : stepList) {

            if (stepEntity.getSymbol() == BusinessConstant.Home.ONE) {
                symbolList.add(stepEntity);
            }
        }

        return symbolList;
    }

    /**
     * 领取步数兑换金币
     *
     * @param id
     * @return
     */
    @Override
    public StepVo getGold(String id, int step) {
        Date date = new Date();
        StepEntity stepEntity = stepService.getStepEntity(id);

        if (null == stepEntity) {
            return null;
        } else if (step < stepEntity.getStep() || stepEntity.getStatus() == BusinessConstant.Home.ONE) {
            return null;
        } else {


            List<StepEntity> stepList = this.getUserStep();

            if (null == stepList) {
                return null;
            }

            //fixme 当前点击的兑换条目之前有未兑换的条目，需要设置为已兑换状态
            for (StepEntity stepNode : stepList) {

                if (stepNode.getStep() < stepEntity.getStep()) {
                    if (stepNode.getStatus() == BusinessConstant.Home.ZERO) {
                        stepNode.setStatus(BusinessConstant.Home.ONE);
                        stepNode.setExchangeDate(date);
                        stepService.updateUserStep(stepNode);
                        continue;
                    }

                }
            }

            List<StepEntity> symbolList = this.getSymbolList(stepList);

            if (symbolList.size() == BusinessConstant.Home.ZERO) {//当前无标志位
                updateStepEntity(date, stepEntity, stepEntity.getGold());
            } else {//标注为集合不为空，获取最后一个

                updateStepEntity(date, stepEntity, BigDecimalUtils.subBig(stepEntity.getGold(), (symbolList.get(symbolList.size() - 1)).getGold()));

            }

            return getStepVo(stepEntity, stepList);
        }

    }

    private void updateStepEntity(Date date, StepEntity stepEntity, BigDecimal gold) {
        stepEntity.setExchangeDate(date);
        stepEntity.setStatus(BusinessConstant.Home.ONE);
        stepEntity.setSymbol(BusinessConstant.Home.ONE);
        //更新步数领取
        stepService.updateUserStep(stepEntity);
        updateUser(gold);
        updateChangeLog(stepEntity.getStep(), gold, date);//fixme 上传用户的兑换日志
    }


    /**
     * 返回当前当前兑换任务获得的金币以及获取距离下一任务的步数
     *
     * @param stepEntity
     * @return
     */
    private StepVo getStepVo(StepEntity stepEntity, List<StepEntity> stepList) {
        StepVo stepVo = new StepVo();

        if (stepList.lastIndexOf(stepEntity) == stepList.size() - 1) {//最后一个
            stepVo.setRemain(BusinessConstant.Home.ZERO);//最后一个，距离下一任务还有0，前端判断
            stepVo.setGold(stepEntity.getGold());
            return stepVo;
        } else {

            int index = stepList.indexOf(stepEntity);

            stepVo.setRemain(stepList.get(index + 1).getStep() - stepEntity.getStep());
            stepVo.setGold(stepEntity.getGold());
            return stepVo;
        }
    }


    private void updateUser(BigDecimal gold) {
        StoreUserEntity storeUserEntity = storeUserService.getUserInfo();
        storeUserEntity.setStatus(BusinessConstant.Message.NUMBER_1);//设置用户今日步数兑换金币状态为1
        storeUserEntity.setGold(BigDecimalUtils.addBig(gold, storeUserEntity.getGold()));
        storeUserEntity.setGoldToday(BigDecimalUtils.addBig(gold, storeUserEntity.getGoldToday()));//用户今日收获的金币
        storeUserEntity.setGoldHistory(BigDecimalUtils.addBig(gold, storeUserEntity.getGoldHistory()));

        storeUserService.updateGold(storeUserEntity);//fixme 更新用户表中的金币数量,兑换后用户表中的步数也为0，前端步数为微信+任务获取

    }

    /**
     * 是连续签到时间
     */
    private boolean isLink(Date lastDate, Date nowDate) {

        if (DateUtils.daysBetween(lastDate, nowDate) == 1) {
            return true;
        }
        return false;
    }

    /**
     * 当天是否完成了任务
     */
    private boolean isRepetition(Date taskDate, Date nowDate, int target) {

        if (DateUtils.daysBetween(taskDate, nowDate) > target) {//不是一天内
            return false;
        }
        return true;
    }


    private boolean isUser(PacketEntity packetEntity, PacketConfigEntity packetConfigEntity, StoreUserEntity storeUserEntity, Date date) {
        //之前领取过红包、小于后台设置的次数、首次注册时间小于后台设置的次数
        if (!isRepetition(packetEntity.getGetDate(), date, BusinessConstant.Home.ZERO) && packetEntity.getPacketCount() < packetConfigEntity.getPacketCount() && DateUtils.daysBetween(storeUserEntity.getRegisterDate(), date) < packetConfigEntity.getPacketCount()) {
            return true;
        }

        return false;

    }


    /**
     * 获取用户所有未完成任务
     */
    @Override

    public TaskVo getAllTask() {
        //查询到当前登录用户的个人信息
        TaskVo taskVo = new TaskVo();
        Date date = new Date();

        //1.新人红包奖励--新用户，当天未领过
        PacketConfigEntity packetConfigEntity = packConfigService.getPacketConfiguration();

        PacketEntity packetEntity = packetService.getPacket();
        StoreUserEntity storeUserEntity = storeUserService.getUserInfo();
        if (null == packetEntity) {//新用户
            taskVo.setRedPacket(packetConfigEntity);

        } else if (isUser(packetEntity, packetConfigEntity, storeUserEntity, date)) {//用户之前领取过红包，但未达到限制,且注册时间未过
            taskVo.setRedPacket(packetConfigEntity);
        }

        //2.签到奖励--查询用户表连续签到天数，并获取对应奖励

        SignEntity signEntity = signService.getSignEntity();
        SignConfigEntity signConfigEntity;
        if (null == signEntity) {//还从未签到--查询1天的奖励
            signConfigEntity = signConfigService.getStep(BusinessConstant.Home.ONE);
            taskVo.setSign(signConfigEntity);

        } else {//签到过，查询对应步数
            if (isLink(signEntity.getSignTime(), date)) {
                signConfigEntity = signConfigService.getStep(signEntity.getSignCount() + BusinessConstant.Home.ONE);
                taskVo.setSign(signConfigEntity);
            } else if (!isRepetition(signEntity.getSignTime(), date, BusinessConstant.Home.ONE)) {//fixme 不是连续签到间隔大于1天
                signConfigEntity = signConfigService.getStep(BusinessConstant.Home.ONE);
                taskVo.setSign(signConfigEntity);
            }

        }

        //3.添加到我的小程序奖励
        ProcedureUserEntity procedureUserEntity = procedureUserService.getProcedureUserEntity();

        if (null == procedureUserEntity) {//还未添加到小程序
            ProcedureConfigEntity procedureConfigEntity = procedureService.getProcedureEntity();
            taskVo.setProcedure(procedureConfigEntity);
        }

        //4.邀请好友任务
        List<InviteAwardEntity> awardEntityList = iInviteAwardService.getInviteAward();
        InviteConfigEntity inviteConfigEntity = inviteConfigService.getInviteEntity();

        if (awardEntityList.size() < inviteConfigEntity.getPacketCount()) {

            taskVo.setShare(inviteConfigEntity);
        }

        return taskVo;

    }

    /**
     * 主页任务点击
     *
     * @return
     */
    @Override
    public TaskInfoVo onTaskClick(String id, Integer category) {


        if (category.intValue() == BusinessConstant.Home.CATEGORY_1) {//新人奖励
            return packetService.receivePacket();
        } else if (category.intValue() == BusinessConstant.Home.CATEGORY_2) {//添加小程序
            return procedureUserService.addProcedure();
        } else if (category.intValue() == BusinessConstant.Home.CATEGORY_3) {//邀请奖励--领取,有奖励时点击触发
            return iInviteAwardService.getAward(id);
        } else if (category.intValue() == BusinessConstant.Home.CATEGORY_4) {//签到任务
            return signService.onSign();
        }


        return null;
    }


    /**
     * 上传用户兑换日志表
     */
    private void updateChangeLog(int step, BigDecimal gold, Date date) {
        GoldLogEntity goldLogEntity = new GoldLogEntity();
        goldLogEntity.setGold(gold);
        goldLogEntity.setStep(step);
        goldLogEntity.setEvent(GoldLogEnum.GoldStatusEnum.EVENT_STEP.getValue());//步数兑换金币
        goldLogEntity.setGoldType(GoldLogEnum.GoldStatusEnum.INCREASES.getValue());//获得
        goldLogEntity.setUserName(PrincipalUtils.getUsername());
        goldLogEntity.setGoldDate(date);
        goldLogService.insertLog(goldLogEntity);

    }

}
