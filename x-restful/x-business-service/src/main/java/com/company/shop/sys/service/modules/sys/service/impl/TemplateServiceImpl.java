package com.company.shop.sys.service.modules.sys.service.impl;

import com.company.manerger.sys.common.utils.RestTemplateUtils;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.FormIdVo;
import com.company.shop.sys.service.modules.sys.service.ITemplateService;
import com.company.shop.sys.service.modules.sys.service.IWxAuthenticationService;
import com.company.shop.sys.service.properties.WxConfigProperties;
import com.company.shop.sys.service.utils.MessageUtils;
import com.company.shop.sys.service.utils.PrincipalUtils;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发送签到预约模板
 */
@Service("templateService")
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    private WxConfigProperties wxconfigProperties;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IWxAuthenticationService authenticationService;
    private String PAGE_HOME = "/pages/home";

    private String getFormId(String username, FormIdVo formIdVo) {

        String formId;
        List<String> formIdList = formIdVo.getList();

        //fixme 从首个元素开始取
        formId = formIdList.get(BusinessConstant.Message.NUMBER_0);
        formIdList.remove(BusinessConstant.Message.NUMBER_0);
        formIdVo.setList(formIdList);

        RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getFormIdKey(username), formIdVo, BusinessConstant.Redis.EXPIRE_TIME_REDIS_7_day);

        return formId;
    }


    @Override
    public void sendNotifyTemplate(String openId, FormIdVo formIdVo, Map<String, Object> map, int type) {
        if (formIdVo.getList().size() == BusinessConstant.Message.NUMBER_0) {
            return;
        }

        String access_token = getToken(request);

        String url = new StringBuilder(wxconfigProperties.getWx_tamplate_url()).append(access_token).toString();
        Map<String, Object> dateMap = new HashMap<>();

        if (type == BusinessConstant.Message.NUMBER_0) { //用户签到预定
            dateMap.put("template_id", wxconfigProperties.getSignid());
            dateMap.put("data", MessageUtils.getSignMessageTemplate());
            dateMap.put("page", PAGE_HOME);
        } else if (type == BusinessConstant.Message.NUMBER_1) {//用户全天未兑换提醒
            dateMap.put("template_id", wxconfigProperties.getSignid());
            dateMap.put("data", MessageUtils.getSignMessageTemplate());
            dateMap.put("page", PAGE_HOME);
        } else if (type == BusinessConstant.Message.NUMBER_2) {//邀请者邀请好友成功
            dateMap.put("template_id", wxconfigProperties.getInviteid());
            dateMap.put("data", MessageUtils.getInviteMessageTemplate());
            dateMap.put("page", PAGE_HOME);
        } else if (type == BusinessConstant.Message.NUMBER_3) {//下单成功通知
            dateMap.put("template_id", wxconfigProperties.getOrdersuc());
            dateMap.put("data", MessageUtils.getOrderSucMessageTemplate(map));
            dateMap.put("page", new StringBuilder("/pages/business/pages/orderDetail?id=").append((String) map.get("order_id")).toString());

        } else if (type == BusinessConstant.Message.NUMBER_4) {//已经发货通知
            dateMap.put("template_id", wxconfigProperties.getOrdersend());
            dateMap.put("data", MessageUtils.getOrderSendMessageTemplate(map));
            dateMap.put("page", new StringBuilder("/pages/business/pages/orderDetail?id=").append((String) map.get("order_id")).toString());
        }

        dateMap.put("touser", openId);
        dateMap.put("access_token", access_token);
        dateMap.put("form_id", getFormId(openId, formIdVo));

        //dateMap.put("emphasis_keyword", "keyword1.DATA");//消息1大写
        RestTemplateUtils.post(request, url, dateMap);
    }

    /**
     * 保存formId
     *
     * @param formId
     * @return
     */
    @Override
    public int saveFormId(String formId) {
        FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(PrincipalUtils.getUsername()));
        if (null == formIdVo) {
            formIdVo = new FormIdVo();
            List<String> list = new ArrayList();
            list.add(formId);
            formIdVo.setList(list);
            RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getFormIdKey(PrincipalUtils.getUsername()), formIdVo, BusinessConstant.Redis.EXPIRE_TIME_REDIS_7_day);
            return BusinessConstant.Home.ONE;
        }

        List<String> formList = formIdVo.getList();
        formList.add(formId);
        formIdVo.setList(formList);

        RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getFormIdKey(PrincipalUtils.getUsername()), formIdVo, BusinessConstant.Redis.EXPIRE_TIME_REDIS_7_day);
        return BusinessConstant.Home.ONE;
    }


    private String getToken(HttpServletRequest request) {
        return authenticationService.getAccessToken(request);
    }
}
