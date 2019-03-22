package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.SignConfigEntity;
import lombok.Data;

import java.util.List;
@Data
public class SignConfigVo extends BaseVo {
    List<SignConfigEntity> list;
}
