package com.company.business.goods.common.vo;

import com.company.business.goods.moudle.entity.CollectEntity;
import lombok.Data;

import java.util.List;

@Data
public class CollectVo extends BaseTomatoVo {
    List<CollectEntity> list;
    long total;
    boolean isCollect;
}
