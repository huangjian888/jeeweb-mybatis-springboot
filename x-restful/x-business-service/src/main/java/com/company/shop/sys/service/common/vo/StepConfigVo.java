package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.AwardConfigEntity;
import lombok.Data;

import java.util.List;

@Data
public class StepConfigVo extends BaseVo {
    List<AwardConfigEntity> list;
}
