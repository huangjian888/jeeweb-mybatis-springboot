package com.company.manerger.sys.common.oss.client;

import com.company.manerger.sys.common.oss.constant.Constants;

/**
 * 文件上传Factory
 *
 *
 */
public final class OSSClientFactory {
    private static IOSSClient ossClient;

    public static IOSSClient build(String clientType){
        if(Constants.CLIENT_LOCAL.equals(clientType)){
            return new LocalClient();
        }else if(Constants.CLIENTA_ALIYUN.equals(clientType)){
            return new AliyunOSSClient();
        }
        return null;
    }

}