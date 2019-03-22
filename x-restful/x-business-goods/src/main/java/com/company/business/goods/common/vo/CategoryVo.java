package com.company.business.goods.common.vo;

import com.company.business.goods.moudle.entity.CateGoryEntity;
import lombok.Data;

import java.util.List;
@Data
public class CategoryVo extends BaseTomatoVo{
    List<CateGoryEntity> list;
    long total;
}
