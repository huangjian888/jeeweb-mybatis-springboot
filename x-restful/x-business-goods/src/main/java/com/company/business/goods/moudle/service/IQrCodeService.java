package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.common.vo.ProduceQrCodeVo;
import com.company.business.goods.moudle.entity.QrCodeEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IQrCodeService {


    List<QrCodeEntity> getAllList();


    QrCodeEntity showQrCode();

    ProduceQrCodeVo createProductQrCode(HttpServletRequest request, JSONObject json);


}
