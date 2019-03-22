package com.company.manerger.sys.common.sms.client;

import com.company.manerger.sys.common.sms.config.SmsConfigProperties;
import com.company.manerger.sys.common.sms.data.SmsResult;
import com.company.manerger.sys.common.sms.exception.SmsException;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.company.manerger.sys.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 阿里云客户端操作
 */
public class AliyunSmsClient implements ISmsClient {
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    //是否开启
    private Boolean isOpen;
    //签名
    private String signName;
    //阿里云API的密钥Access Key ID
    private  String accessKeyId;
    //阿里云API的密钥Access Key Secret
    private  String accessKeySecret;
    private SmsConfigProperties smsConfigProperties;
    private IAcsClient acsClient;

    @Override
    public void init(SmsConfigProperties smsConfigProperties) {
        this.smsConfigProperties = smsConfigProperties;
        isOpen=this.smsConfigProperties.getOpen();
        signName=this.smsConfigProperties.getSignName();
        accessKeyId = this.smsConfigProperties.getAliyun().getAccessKeyId();
        accessKeySecret = this.smsConfigProperties.getAliyun().getAccessKeySecret();
        try {
            //初始化acsClient,暂不支持region化
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            this.acsClient = new DefaultAcsClient(profile);
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
        SmsResult smsResult = new SmsResult();
        try {
            //可自助调整超时时间
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");

            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号
            request.setPhoneNumbers(phone);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(signName);
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(template);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(JSON.toJSONString(datas));

            //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
            request.setSmsUpExtendCode(StringUtils.randomNumber(7));

            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            //request.setOutId("yourOutId");

            //hint 此处可能会抛出异常，注意catch
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode().equals("OK"))
            {
                smsResult = SmsResult.success(sendSmsResponse.getMessage());
            }else{
                smsResult = SmsResult.fail(sendSmsResponse.getMessage());
            }
            smsResult.setSmsid(request.getSmsUpExtendCode());
            smsResult.setReponseData(JSON.toJSONString(sendSmsResponse));
        }catch (Exception e){
            smsResult = SmsResult.fail(e.getMessage());
        }
        return smsResult;
    }
}
