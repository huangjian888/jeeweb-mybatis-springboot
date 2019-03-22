package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.business.goods.moudle.entity.PacketInviteLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PacketInviteLogMapper extends BaseMapper<PacketInviteLogEntity> {

    List getPacketInviteLogList(Pagination page, @Param("inviteUser") String inviteUser);

}
