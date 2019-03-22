package com.company.business.authorization.moudle.service.impl;

import com.company.manerger.sys.common.utils.RestTemplateUtils;
import com.company.shop.sys.service.common.vo.FormIdVo;
import com.company.shop.sys.service.modules.sys.service.ITemplateService;
import com.company.shop.sys.service.utils.Log;
import com.company.shop.sys.service.utils.PrincipalUtils;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.business.authorization.security.authorization.AuthenticationConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 发送签到预约模板
 */
@Service("templateService")
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    private AuthenticationConfigProperties wxconfigProperties;

    @Autowired
    private HttpServletRequest request;

    /**
     * 发送消息
     *
     * @param
     * @param
     */


    private String getUrl() {

        return wxconfigProperties.getWx_tamplate_url();
    }

    //fixme 根据头中的token key获取到对应的access-TOKEN
    private String getToken(HttpServletRequest request) {
        return (String) RedisCacheUtils.getRedisCacheManager().get(PrincipalUtils.getHeaderToken(request));
    }

    @Override
    public void sendNotifyTemplate(String openId, FormIdVo formIdVo, Map<String, Object> map, int type) {
        String url = getUrl() + getToken(request);
        Log.i("url:" + url);

        map.put("touser", openId);
        map.put("access_token", getToken(request));
        map.put("template_id", wxconfigProperties.getTemplateId());
        map.put("form_id", "");
        String response = RestTemplateUtils.post(request, url, null);
        Log.i("response:" + response);
    }

    @Override
    public int saveFormId(String formId) {
        return 0;
    }
}
