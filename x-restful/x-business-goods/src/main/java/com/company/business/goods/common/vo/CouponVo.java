package com.company.business.goods.common.vo;

import com.company.business.goods.moudle.entity.CouponEntity;
import lombok.Data;

import java.util.List;

@Data
public class CouponVo extends BaseTomatoVo {
    List<CouponEntity> list;
    long total;


}
