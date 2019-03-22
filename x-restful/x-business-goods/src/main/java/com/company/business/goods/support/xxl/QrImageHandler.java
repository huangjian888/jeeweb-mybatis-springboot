package com.company.business.goods.support.xxl;

import com.company.business.goods.common.vo.QrCodeVo;
import com.company.business.goods.moudle.service.IQrCodeService;
import com.company.business.goods.utils.RedisCacheUtils;
import com.company.business.goods.utils.RedisKeyUtils;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 消息推送job
 */
@JobHandler(value = "qrJob")
@Component
@Data
public class QrImageHandler extends IJobHandler {

    @Autowired
    private IQrCodeService qrCodeService;
    @Autowired
    private HttpServletRequest request;

    /**
     * @params
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        try {
            QrCodeVo qrCodeVo = (QrCodeVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getQrCode());

            if (null == qrCodeVo) {
                return ReturnT.SUCCESS;
            }

            //fixme 每日删除qr缓存
            RedisCacheUtils.getRedisCacheManager().del(RedisKeyUtils.getQrCode());
        } catch (Exception e) {
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }
}
