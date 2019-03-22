package com.company.shop.sys.service.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderPageVo extends BaseVo {
    List<OrderVo> list;
    long total;
}
