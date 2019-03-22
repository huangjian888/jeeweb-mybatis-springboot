package com.company.manerger.sys.service.modules.email.dao;


import com.company.manerger.sys.common.email.data.EmailResult;
import com.company.manerger.sys.common.email.disruptor.EmailDao;
import com.company.manerger.sys.common.email.disruptor.EmailData;
import com.company.manerger.sys.service.modules.email.entity.EmailSendLog;
import com.company.manerger.sys.service.modules.email.service.IEmailSendLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @description: 短信信息返回
 */
public class EmailDaoImpl implements EmailDao {

    @Autowired
    private IEmailSendLogService emailSendLogService;

    @Override
    public void doResult(String eventId, EmailData emailData, EmailResult smsResult) {
        try {
            EmailSendLog sendLog = emailSendLogService.selectById(eventId);
            sendLog.setMsg(smsResult.getMsg());
            if (smsResult.isSuccess()) {
                sendLog.setStatus(EmailSendLog.EMAIL_SEND_STATUS_SUCCESS);
            } else {
                sendLog.setStatus(EmailSendLog.EMAIL_SEND_STATUS_FAIL);
            }
            sendLog.setResponseDate(new Date());
            emailSendLogService.insertOrUpdate(sendLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}