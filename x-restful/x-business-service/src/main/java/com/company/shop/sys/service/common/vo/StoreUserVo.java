package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import lombok.Data;

import java.util.List;

@Data
public class StoreUserVo extends BaseVo {
    List<StoreUserEntity> list;
    long total;
}
