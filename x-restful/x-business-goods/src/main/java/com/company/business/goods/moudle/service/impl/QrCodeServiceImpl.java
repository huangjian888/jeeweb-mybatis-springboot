package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.vo.ProduceQrCodeVo;
import com.company.business.goods.common.vo.QrCodeVo;
import com.company.business.goods.moudle.entity.QrCodeEntity;
import com.company.business.goods.moudle.mapper.QrCodeMapper;
import com.company.business.goods.moudle.service.IQrCodeService;
import com.company.business.goods.security.authorization.AuthenticationConfigProperties;
import com.company.business.goods.security.authorization.IAuthenticationService;
import com.company.business.goods.utils.*;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service("qrCodeService")
public class QrCodeServiceImpl extends ServiceImpl<QrCodeMapper, QrCodeEntity> implements IQrCodeService {
    @Autowired
    private IAuthenticationService authenticationService;
    @Autowired
    private AuthenticationConfigProperties configProperties;


    /**
     * 从管理后台后去到所有可用状态的二维码
     *
     * @return
     */

    @Override
    public List<QrCodeEntity> getAllList() {
        try {
            return baseMapper.getAllQrList(TomatoConstant.Common.NUMBER_1);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private int getRandom(int size) {
        return (int) (Math.random() * size);
    }

    /**
     * 返回给前端符合规则的二维码图片--主动调用
     *
     * @return
     */
    @Override
    public QrCodeEntity showQrCode() {

        QrCodeVo qrCodeVo = (QrCodeVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getQrCode());
        if (null == qrCodeVo) {
            List<QrCodeEntity> list = this.getAllList();
            if (list.size() == TomatoConstant.Common.NUMBER_0) {
                return null;
            }

            //线程??
            QrCodeVo qrCodeVoEntity = new QrCodeVo();
            qrCodeVoEntity.setList(list);
            RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getQrCode(), qrCodeVoEntity, TomatoConstant.Common.QR_CODE_TIME_REDIS);

            //fixme 从服务后台返回的qr二维码中随机返回一个给前端

            return list.get(getRandom(list.size()));

        }

        List<QrCodeEntity> qrList = qrCodeVo.getList();

        List<QrCodeEntity> tartList = new ArrayList<>();

        for (QrCodeEntity qrCodeEntity : qrList) {

            if (qrCodeEntity.getShow_counts() < TomatoConstant.QrCode.QR_LIMIT_500) {
                tartList.add(qrCodeEntity);
            }

        }

        if (tartList.size() == TomatoConstant.Common.NUMBER_0) {
            return null;
        }


        int random = getRandom(tartList.size());
        QrCodeEntity qr = tartList.get(random);

        Log.i("random:" + random);
        qr.setShow_counts(qr.getShow_counts() + TomatoConstant.Common.NUMBER_1);

        qrList.set(random, qr);
        qrCodeVo.setList(qrList);

        //保存到redis
        RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getQrCode(), qrCodeVo, TomatoConstant.Common.QR_CODE_TIME_REDIS);

        return qr;

    }

    /**
     * 生成商品的二维码图片
     *
     * @param json
     * @return
     */
    @Override
    public ProduceQrCodeVo createProductQrCode(HttpServletRequest request, JSONObject json) {
        ProduceQrCodeVo produceQrCodeVo = null;
        String productId = json.getString("productId");

        Log.i("productId:" + productId);
        String qrUrl = getProductUrlCode(productId);
        if (!TextUtils.isEmpty(qrUrl)) {
            produceQrCodeVo = new ProduceQrCodeVo();
            produceQrCodeVo.setQrCodeUrl(qrUrl);
            Log.i("get qrUrl from redis key:" + productId + ",value:" + qrUrl);
            return produceQrCodeVo;
        }
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("path", json.getString("path"));
        String token = PrincipalUtils.getHeaderToken(request);
        String access_token = (String) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getAccessWxTokenKey(token));

        if (TextUtils.isEmpty(access_token)) {
            access_token = authenticationService.getAccessToken(request);
        }

        String requestUrl = new StringBuilder(configProperties.getWx_qrcode_url()).append(access_token).toString();


        try {
            //返回文件地址
            String qrCodeUrl = HttpUtils.httpPostWithJSON(requestUrl, JSON.toJSONString(requestMap));
            Log.i("bitmap local address url:" + qrCodeUrl);
            if (!TextUtils.isEmpty(qrCodeUrl)) {
                if (qrCodeUrl.contains("errmsg")) {
                    Log.i("contain errorMsg");
                    JSONObject errorJson = JSON.parseObject(qrCodeUrl);

                    produceQrCodeVo = new ProduceQrCodeVo();
                    produceQrCodeVo.setErrCode(errorJson.getIntValue("errmsg"));
                    produceQrCodeVo.setErrMsg(errorJson.getString("errmsg"));
                    return produceQrCodeVo;
                }
                produceQrCodeVo = new ProduceQrCodeVo();

                Log.i("product redis key:" + productId);
                Log.i("qrCodeUrl redis value:" + qrCodeUrl);
                produceQrCodeVo.setQrCodeUrl(qrCodeUrl);
                storeQrCode(productId, qrCodeUrl);
                return produceQrCodeVo;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private String getProductUrlCode(String productId) {
        return (String) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getQrcodeProductKey(productId));
    }

    /**
     * 保存生成的qrcode
     */
    private void storeQrCode(String productId, String imageUrl) {

        RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getQrcodeProductKey(productId), imageUrl, TomatoConstant.Common.LOG_TIME_REDIS);


    }


}
