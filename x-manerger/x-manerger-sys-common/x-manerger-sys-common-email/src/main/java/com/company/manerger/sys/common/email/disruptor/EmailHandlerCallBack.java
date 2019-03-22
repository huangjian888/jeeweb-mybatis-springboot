package com.company.manerger.sys.common.email.disruptor;


import com.company.manerger.sys.common.email.data.EmailResult;

public interface EmailHandlerCallBack {
    void onResult(EmailResult emailResult);
}