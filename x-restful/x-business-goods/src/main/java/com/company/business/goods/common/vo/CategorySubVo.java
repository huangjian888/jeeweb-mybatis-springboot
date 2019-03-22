package com.company.business.goods.common.vo;

import com.company.business.goods.moudle.entity.CateGorySubEntity;
import lombok.Data;

import java.util.List;

@Data
public class CategorySubVo extends BaseTomatoVo {

    List<CateGorySubEntity> list;
    long total;
}
