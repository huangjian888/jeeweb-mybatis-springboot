package com.company.manerger.sys.common.sms.client;

import com.company.manerger.sys.common.sms.config.SmsConfigProperties;
import com.company.manerger.sys.common.sms.data.SmsResult;
import com.company.manerger.sys.common.sms.exception.SmsException;
import com.company.manerger.sys.common.sms.utils.huyi.HuyiRestSDK;
import com.company.manerger.sys.common.utils.mapper.JsonMapper;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 阿里云客户端操作
 */
public class HuyiSmsClient implements ISmsClient {
    //产品域名,开发者无需替换
    static final String serverUrl = "http://106.ihuyi.com/webservice/sms.php";
    //是否开启
    private Boolean isOpen;
    //签名
    private String signName;
    //应用ID
    private  String accountApiId="";
    //密钥
    private  String accountApikey="";
    private  SmsConfigProperties smsConfigProperties;
    private HuyiRestSDK huyiRestSDK;

    @Override
    public void init(SmsConfigProperties smsConfigProperties) {
        this.smsConfigProperties = smsConfigProperties;
        isOpen=this.smsConfigProperties.getOpen();
        signName=this.smsConfigProperties.getSignName();
        accountApiId = this.smsConfigProperties.getHuyi().getAccountApiId();
        accountApikey = this.smsConfigProperties.getHuyi().getAccountApiKey();
        try {
            huyiRestSDK = new HuyiRestSDK();
            huyiRestSDK.init(serverUrl);
            huyiRestSDK.setAccount(accountApiId, accountApikey);
        }catch (Exception e){
            throw new SmsException("初始化失败");
        }
    }

    @Override
    public SmsResult send(String phone, String template) {
        Map<String, Object> datas = new HashMap<>();
        return send(phone,template,datas);
    }

    @Override
    public SmsResult send(String phone, String template, Map<String, Object> datas) {
        if (!isOpen){
            return SmsResult.success("测试成功");
        }
        SmsResult smsResult;
        try {
            // 这里需要处理templateId
            String content = parseSmsContent(template,datas);
            Map<String, Object> result = huyiRestSDK.sendMsg(phone, content);
            if ("2".equals(result.get("code"))) {
                smsResult= SmsResult.success(result.get("msg")+"");
                smsResult.setSmsid(result.get("smsid")+"");
            } else {
                // 异常返回输出错误码和错误信息
                smsResult = SmsResult.fail(result.get("msg")+"");
            }
            smsResult.setReponseData(JsonMapper.toJsonString(result));
        }catch (IllegalArgumentException e){
            smsResult = SmsResult.fail("发送短信提交的参数不对");
        }catch (Exception e){
            smsResult = SmsResult.fail(e.getMessage());
        }
        return smsResult;
    }

    public String parseSmsContent(String content,Map<String,Object> datas){
        if (datas != null) {
            try {
                StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
                Configuration cfg = Configuration.defaultConfiguration();
                GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
                Template t = gt.getTemplate(content);
                t.binding(datas);
                content = t.render();
            }catch (Exception e){
                throw new SmsException("模板解析失败");
            }
        }
        return content;
    }
}
