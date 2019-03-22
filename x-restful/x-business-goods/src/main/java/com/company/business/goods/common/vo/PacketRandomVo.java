package com.company.business.goods.common.vo;

import com.company.business.goods.moudle.entity.RandomPacketEntity;
import lombok.Data;

import java.util.List;

@Data
public class PacketRandomVo extends BaseTomatoVo {
    List<RandomPacketEntity> list;
}
