package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.ProduceQrCodeVo;
import com.company.business.goods.moudle.entity.QrCodeEntity;
import com.company.business.goods.moudle.service.IQrCodeService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class QrCodeController {

    @Autowired
    private IQrCodeService qrCodeService;

    /**
     * 前端获取二维码图片
     *
     * @return
     */
    @GetMapping(value = "/qrcode")
    public Response showQrCode() {
        QrCodeEntity qrCodeEntity = qrCodeService.showQrCode();
        if (null == qrCodeEntity) {
            return Response.error(ErrorCodeEnum.COUPON2014.code(), ErrorCodeEnum.COUPON2014.msg());
        }
        return Response.ok().putObject(qrCodeEntity);
    }

    /**
     * 生成商品二维码
     *
     * @param request
     * @param json
     * @return
     */
    @PostMapping(value = "/qrcode/product")
    public Response showProductQrCode(HttpServletRequest request, @RequestBody JSONObject json) {
        ProduceQrCodeVo produceQrCodeVo = qrCodeService.createProductQrCode(request, json);
        if (null == produceQrCodeVo) {
            return Response.error(ErrorCodeEnum.COUPON2018.code(), ErrorCodeEnum.COUPON2018.msg());
        } else if (!TextUtils.isEmpty(produceQrCodeVo.getErrMsg())) {
            return Response.error(produceQrCodeVo.getErrCode(), produceQrCodeVo.getErrMsg());
        }
        return Response.ok().putObject(produceQrCodeVo);

    }

}
