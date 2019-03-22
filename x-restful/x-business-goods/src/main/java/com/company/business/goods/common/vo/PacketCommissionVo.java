package com.company.business.goods.common.vo;

import com.company.business.goods.moudle.entity.PacketCommissionEntity;
import lombok.Data;

import java.util.List;

@Data
public class PacketCommissionVo extends BaseTomatoVo {
    List<PacketCommissionEntity> list;
}
