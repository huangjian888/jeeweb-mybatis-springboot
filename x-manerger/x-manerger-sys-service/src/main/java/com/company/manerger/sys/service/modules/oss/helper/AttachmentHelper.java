package com.company.manerger.sys.service.modules.oss.helper;

import com.company.manerger.sys.common.oss.OSSUploadHelper;
import com.company.manerger.sys.common.oss.config.OssConfig;
import com.company.manerger.sys.common.oss.exception.FileNameLengthLimitExceededException;
import com.company.manerger.sys.common.oss.exception.InvalidExtensionException;
import com.company.manerger.sys.common.utils.IpUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.modules.oss.entity.Attachment;
import com.company.manerger.sys.service.modules.oss.service.IAttachmentService;
import com.company.manerger.sys.service.utils.UserUtils;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @description: 附件上传助手
 */
@Component("attachmentHelper")
@EnableConfigurationProperties({OssConfig.class})
public class AttachmentHelper {

    @Autowired
    private IAttachmentService attachmentService;
    @Autowired
    private OssConfig ossConfig;

    private OSSUploadHelper uploadHelper;

    @PostConstruct
    public void initHelper() {
        uploadHelper = new OSSUploadHelper();
        uploadHelper.init(ossConfig);
    }


    public Attachment upload(HttpServletRequest request, MultipartFile file) throws FileSizeLimitExceededException,
            IOException, FileNameLengthLimitExceededException, InvalidExtensionException {
        String basePath=request.getParameter("base_path");
        String url = uploadHelper.upload(request, file, basePath);
        String filename = file.getOriginalFilename();
        long size = file.getSize();
        //file.getContentType();
        String realFileName = StringUtils.getFileNameNoEx(filename);
        String fileExtension = StringUtils.getExtensionName(filename);
        // 保存上传的信息
        Attachment attachment = new Attachment();
        attachment.setFileExtension(fileExtension);
        attachment.setFileName(realFileName);
        attachment.setContentType(file.getContentType());
        attachment.setFilePath(url);
        attachment.setFileSize(size);
        attachment.setStatus("1");
        attachment.setUploadIp(IpUtils.getIpAddr(request));
        attachment.setUploadTime(new Date());
        attachment.setUserId(UserUtils.getUser().getId());
        attachment.setBasePath(basePath);
        attachmentService.insert(attachment);
        return attachment;
    }

    public Attachment remote(HttpServletRequest request,String remoteUrl) throws FileSizeLimitExceededException,
            IOException, FileNameLengthLimitExceededException, InvalidExtensionException {
        String basePath=request.getParameter("base_path");
        String url = uploadHelper.remote(request, remoteUrl, basePath);
        String filename =  remoteUrl.substring(remoteUrl.lastIndexOf('/')+1);
        URL remoteUri = new URL(remoteUrl);
        HttpURLConnection conn = (HttpURLConnection) remoteUri.openConnection();
        conn.setConnectTimeout(10 * 1000);
        long size = Integer.parseInt(conn.getHeaderField("Content-Length"));
        String contentType =  conn.getHeaderField("Content-Type");
        String realFileName = StringUtils.getFileNameNoEx(filename);
        String fileExtension = StringUtils.getExtensionName(filename);
        // 保存上传的信息
        Attachment attachment = new Attachment();
        attachment.setFileExtension(fileExtension);
        attachment.setFileName(realFileName);
        attachment.setFilePath(url);
        attachment.setFileSize(size);
        attachment.setStatus("1");
        attachment.setUploadIp(IpUtils.getIpAddr(request));
        attachment.setUploadTime(new Date());
        attachment.setContentType(contentType);
        attachment.setUserId(UserUtils.getUser().getId());
        attachment.setBasePath(basePath);
        attachmentService.insert(attachment);
        return attachment;
    }

}
