package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.modules.sys.entity.LogEntity;
import com.company.shop.sys.service.modules.sys.entity.ProcedureConfigEntity;
import com.company.shop.sys.service.modules.sys.entity.ProcedureUserEntity;
import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import com.company.shop.sys.service.modules.sys.mapper.ProcedureUserMapper;
import com.company.shop.sys.service.modules.sys.service.ILogService;
import com.company.shop.sys.service.modules.sys.service.IProcedureConfigService;
import com.company.shop.sys.service.modules.sys.service.IProcedureUserService;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("procedureUserService")
public class ProcedureUserServiceImpl extends ServiceImpl<ProcedureUserMapper, ProcedureUserEntity> implements IProcedureUserService {

    @Autowired
    private IProcedureConfigService procedureConfigService;
    @Autowired
    private ILogService logService;
    @Autowired
    private IStoreUserService userService;

    @Override
    public ProcedureUserEntity getProcedureUserEntity() {
        return baseMapper.getProcedureUserEntity(PrincipalUtils.getUsername());
    }

    /**
     * 添加到小程序
     *
     * @return
     */
    @Override
    public TaskInfoVo addProcedure() {
        Date date = new Date();
        TaskInfoVo taskInfoVo = new TaskInfoVo();
        ProcedureConfigEntity procedureConfigEntity = procedureConfigService.getProcedureEntity();
        if (null == this.getProcedureUserEntity()) {//

            ProcedureUserEntity procedureUserEntity = new ProcedureUserEntity();
            procedureUserEntity.setCompleteDate(date);
            procedureUserEntity.setPacketCount(procedureConfigEntity.getPacketCount());
            procedureUserEntity.setUsername(PrincipalUtils.getUsername());
            insertOrUpdate(procedureUserEntity);
            updateUser(procedureConfigEntity.getAward());
            updateProcedureLog(date, procedureConfigEntity);//上传日志
            taskInfoVo.setAward(procedureConfigEntity.getAward());
            taskInfoVo.setSuccess(true);
            return taskInfoVo;
        }
        taskInfoVo.setAward(BusinessConstant.Home.ZERO);
        taskInfoVo.setSuccess(false);
        return taskInfoVo;
    }

    @Transactional
    private void updateUser(int award) {

        StoreUserEntity storeUserEntity = userService.getUserInfo();
        storeUserEntity.setStep(storeUserEntity.getStep() + award);
        userService.insertOrUpdate(storeUserEntity);


    }

    private void updateProcedureLog(Date date, ProcedureConfigEntity procedureConfigEntity) {
        LogEntity logEntity = new LogEntity();
        logEntity.setSignTime(date);//当前时间
        logEntity.setUserName(PrincipalUtils.getUsername());
        logEntity.setCategory(procedureConfigEntity.getCategory());
        logEntity.setAward(procedureConfigEntity.getAward());//第一次签到奖励步数
        logEntity.setCategoryName(procedureConfigEntity.getDescription());
        logService.insertLog(logEntity);//向日志表中插入用户签到数据
    }
}
