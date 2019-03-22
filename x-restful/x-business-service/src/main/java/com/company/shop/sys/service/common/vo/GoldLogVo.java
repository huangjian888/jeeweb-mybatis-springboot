package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.GoldLogEntity;
import lombok.Data;

import java.util.List;

@Data
public class GoldLogVo extends BaseVo {
    List<GoldLogEntity> list;
    long total;
}
