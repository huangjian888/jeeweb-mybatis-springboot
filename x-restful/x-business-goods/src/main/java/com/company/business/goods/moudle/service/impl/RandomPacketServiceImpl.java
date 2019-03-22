package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.vo.PacketRandomVo;
import com.company.business.goods.common.vo.RandomPacketVo;
import com.company.business.goods.moudle.entity.PageIConEntity;
import com.company.business.goods.moudle.entity.RandomPacketEntity;
import com.company.business.goods.moudle.mapper.RandomPacketMapper;
import com.company.business.goods.moudle.service.IPageIConService;
import com.company.business.goods.moudle.service.IRandomPacketService;
import com.company.business.goods.security.user.ITomatoUserService;
import com.company.business.goods.security.user.TomatoUserEntity;
import com.company.business.goods.utils.*;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("randomPacketService")
@Transactional
public class RandomPacketServiceImpl extends ServiceImpl<RandomPacketMapper, RandomPacketEntity> implements IRandomPacketService {
    @Autowired
    private ITomatoUserService tomatoUserService;

    @Autowired
    private IPageIConService pageIConService;//fixme 新用户注册是否可获取随机红包--开关

    @Override
    public boolean insertRandomPack(JSONObject json) {

        String order = json.getString("order");//fixme 更新才传order
        double randomMoney = json.getDoubleValue("random");
        if (randomMoney < TomatoConstant.Common.NUMBER_0) {
            return false;
        }

        if (!TextUtils.isEmpty(order)) {
            RandomPacketEntity randomPacketEntity = this.getRandomByOrder(Integer.parseInt(order));
            if (null == randomPacketEntity) {
                return false;
            }

            randomPacketEntity.setUpdate_by(TomatoConstant.Common.company_ADMIN);
            randomPacketEntity.setUpdate_date(new Date());
            randomPacketEntity.setRandom_amounts(BigDecimalUtils.mul(randomMoney, TomatoConstant.Common.NUMBER_1));
            return insertOrUpdate(randomPacketEntity);

        } else {
            RandomPacketEntity randomPacket = new RandomPacketEntity();
            randomPacket.setCreate_by(TomatoConstant.Common.company_ADMIN);
            randomPacket.setCreate_date(new Date());
            randomPacket.setRandom_amounts(BigDecimalUtils.mul(randomMoney, TomatoConstant.Common.NUMBER_1));

            return insertOrUpdate(randomPacket);
        }

    }

    private List<RandomPacketEntity> getRandomList() {

        PacketRandomVo packetRandomVo = (PacketRandomVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getPacketRandomKey());


        if (null == packetRandomVo) {
            List<RandomPacketEntity> list = baseMapper.getRandomPacket();
            if (list.size() > TomatoConstant.Common.NUMBER_0) {//规则为list size 0，返回null
                packetRandomVo = new PacketRandomVo();
                packetRandomVo.setList(list);
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getPacketRandomKey(), packetRandomVo, TomatoConstant.Common.EXPIRE_TIME_REDIS_1800);//半小时
                return list;
            }
            return null;
        }
        return packetRandomVo.getList();

    }

    /**
     * 获取新用户注册红包开关
     *
     * @return
     */
    private PageIConEntity getPageIconEntity() {

        PageIConEntity pageIConEntity = (PageIConEntity) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getPacketPageKey());

        if (null == pageIConEntity) {
            pageIConEntity = pageIConService.getPageIConEntity(TomatoConstant.Front.redpack_flag);//fixme 获取首页返现配置状态
            if (null != pageIConEntity) {

                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getPacketPageKey(), pageIConEntity, TomatoConstant.Common.PAGE_PACKET_HOME_REDIS);
            }
        }

        return pageIConEntity;
    }

    /**
     * 处理已注册用户点击别人的邀请链接进入却还能领取红包
     *
     * @return
     */
    @Override
    public RandomPacketVo getRandomPacket() {


        PageIConEntity pageIConEntity = getPageIconEntity();

        if (null == pageIConEntity) {
            return null;
        }


        TomatoUserEntity tomatoUser = tomatoUserService.findUserByUsername(PrincipalUtils.getUsername());
        if (null == tomatoUser) {
            return null;
        }

        if (pageIConEntity.getStatus() == TomatoConstant.Common.NUMBER_1) {//新用户注册后可以获得红包的开关可用

            if (tomatoUser.getRookie() == TomatoConstant.Common.NUMBER_1 && null == tomatoUser.getExitTime()) {//新人、并且没有退出时间
                List<RandomPacketEntity> list = getRandomList();
                if (null == list) {
                    return null;
                }

                RandomPacketVo randomPacketVo = new RandomPacketVo();
                randomPacketVo.setPacket_money(list.get((int) (Math.random() * list.size())).getRandom_amounts().doubleValue());
                return randomPacketVo;

            }
        }

        return null;

    }


    @Override
    public RandomPacketEntity getRandomByOrder(int order) {

        return baseMapper.getRandomByOrder(order);
    }

}
