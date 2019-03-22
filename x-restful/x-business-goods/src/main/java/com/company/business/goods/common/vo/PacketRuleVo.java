package com.company.business.goods.common.vo;

import com.company.business.goods.moudle.entity.PacketRuleEntity;
import lombok.Data;

import java.util.List;

@Data
public class PacketRuleVo extends BaseTomatoVo {
    List<PacketRuleEntity> list;
}
