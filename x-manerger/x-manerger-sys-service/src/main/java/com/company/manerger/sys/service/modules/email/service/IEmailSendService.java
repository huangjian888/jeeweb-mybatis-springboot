package com.company.manerger.sys.service.modules.email.service;

import java.util.Map;

/**
* @description: 系统消息服务接口
*/
public interface IEmailSendService {
    void send(String email, String code, Map<String, Object> datas);

    void send(String[] emails, String code, Map<String, Object> datas);

    void send(String eventId, String email, String code, Map<String, Object> datas);

    void send(String eventId, String[] emails, String code, Map<String, Object> datas);
}