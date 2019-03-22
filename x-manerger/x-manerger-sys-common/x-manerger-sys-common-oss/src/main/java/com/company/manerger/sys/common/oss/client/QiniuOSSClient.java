package com.company.manerger.sys.common.oss.client;

import com.company.manerger.sys.common.oss.config.OssConfig;
import com.company.manerger.sys.common.oss.exception.OSSException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;


public class QiniuOSSClient  extends  AbstractOSSClient{

    private UploadManager uploadManager;
    private String	token;
    //访问域名
    private  String domain;

    @Override
    public void init() {

    }

    @Override
    public void init(String propertiesName) {

    }


    @Override
    public void init(OssConfig config) {

    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new OSSException("上传文件失败", e);
        }
    }

    private String upload(byte[] data, String path) {
        try {
            Response res = uploadManager.put(data, path, token);
            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
        } catch (Exception e) {
            throw new OSSException("上传文件失败，请核对七牛配置信息");
        }
        return domain + "/" + path;
    }

    @Override
    public void delete(String filename) {

    }
}
