package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.modules.sys.entity.LogEntity;
import com.company.shop.sys.service.modules.sys.entity.PacketConfigEntity;
import com.company.shop.sys.service.modules.sys.entity.PacketEntity;
import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import com.company.shop.sys.service.modules.sys.mapper.PacketMapper;
import com.company.shop.sys.service.modules.sys.service.ILogService;
import com.company.shop.sys.service.modules.sys.service.IPacketConfigService;
import com.company.shop.sys.service.modules.sys.service.IPacketService;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service("packetService")
public class PacketServiceImpl extends ServiceImpl<PacketMapper, PacketEntity> implements IPacketService {

    @Autowired
    private IStoreUserService storeUserService;

    @Autowired
    private ILogService logService;
    @Autowired
    private IPacketConfigService packConfigService;

    /**
     * 获取用户的红包领取信息
     *
     * @return
     */
    @Override
    public PacketEntity getPacket() {
        return baseMapper.getPacket(PrincipalUtils.getUsername());
    }

    /**
     * 领取红包
     *
     * @return
     */
    @Override
    public TaskInfoVo receivePacket() {

        Date date = new Date();
        PacketConfigEntity packetConfigEntity = packConfigService.getPacketConfiguration();

        PacketEntity pack = this.getPacket();

        if (null == pack) {//用户初次领取红包

            pack = new PacketEntity();
            pack.setUsername(PrincipalUtils.getUsername());//插入openid
            pack.setGetDate(date);
            pack.setPacketCount(BusinessConstant.Home.ONE);
            insertOrUpdate(pack);
            return update(date, packetConfigEntity);
        }
        if (null != pack && pack.getPacketCount() < packetConfigEntity.getPacketCount()) {//非第一次领取红包,并且小于限制

            pack.setPacketCount(pack.getPacketCount() + BusinessConstant.Home.ONE);
            insertOrUpdate(pack);
            return update(date, packetConfigEntity);
        }

        return null;
    }

    /**
     * 更新红包信息
     *
     * @param date
     * @param packetConfigEntity
     */
    private TaskInfoVo update(Date date, PacketConfigEntity packetConfigEntity) {
        TaskInfoVo readPacketVo = new TaskInfoVo();
        //将当前玩家的领取信息添加到对应表
        updateUserInfo(packetConfigEntity.getAward());//更新用户表
        //设置用户领取红包的日志
        updateLog(date, packetConfigEntity);
        readPacketVo.setAward(packetConfigEntity.getAward());
        readPacketVo.setSuccess(true);

        return readPacketVo;
    }

    @Override
    public int updateTable(PacketEntity packetEntity) {
        return insertOrUpdate(packetEntity) ? 1 : 0;
    }


    private void updateLog(Date date, PacketConfigEntity packetConfigEntity) {

        LogEntity logEntity = new LogEntity();

        logEntity.setSignTime(date);//当前时间
        logEntity.setUserName(PrincipalUtils.getUsername());
        logEntity.setAward(packetConfigEntity.getAward());//第一次签到奖励步数
        logEntity.setCategory(packetConfigEntity.getCategory());
        logEntity.setCategoryName(packetConfigEntity.getDescription());

        logService.insertLog(logEntity);//向日志表中插入用户签到数据
    }

    /**
     * 更新用户表中数据
     */
    private void updateUserInfo(int award) {
        StoreUserEntity storeUserEntity = storeUserService.getUserInfo();
        storeUserEntity.setStep(storeUserEntity.getStep() + award);
        storeUserService.insertOrUpdate(storeUserEntity);
    }
}
