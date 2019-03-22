package com.company.business.goods.common.vo;

import com.company.business.goods.moudle.entity.QrCodeEntity;
import lombok.Data;

import java.util.List;

@Data
public class QrCodeVo extends BaseTomatoVo {
    List<QrCodeEntity> list;
}
