package com.company.manerger.sys.service.modules.oss.controller;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseController;
import com.company.manerger.sys.common.oss.exception.FileNameLengthLimitExceededException;
import com.company.manerger.sys.common.oss.exception.InvalidExtensionException;
import com.company.manerger.sys.common.utils.MessageUtils;
import com.company.manerger.sys.service.common.bean.ResponseError;
import com.company.manerger.sys.service.modules.oss.entity.Attachment;
import com.company.manerger.sys.service.modules.oss.helper.AttachmentHelper;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 附件管理控制器
 */

@RestController
@RequestMapping("${company.admin.url.prefix}/oss")
public class OSSUploadController extends BaseController {

    @Autowired
    private AttachmentHelper attachmentHelper;
    /**
     *
     * @title: ajaxUpload
     * @description: 文件上传
     * @param request
     * @param response
     * @return
     * @return: AjaxUploadResponse
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Response upload(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        Response responseResult = new Response();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();
            while (ite.hasNext()) {
                MultipartFile file = multiRequest.getFile(ite.next());
                try {
                    Attachment attachment = attachmentHelper.upload(request, file);
                    attachmentList.add(attachment);
                    continue;
                } catch (IOException e) {
                    return  Response.error(ResponseError.NORMAL_ERROR, MessageUtils.getMessage("upload.server.error"));
                } catch (InvalidExtensionException e) {
                    return  Response.error(ResponseError.NORMAL_ERROR, MessageUtils.getMessage("upload.server.error"));
                } catch (FileUploadBase.FileSizeLimitExceededException e) {
                    return  Response.error(ResponseError.NORMAL_ERROR, MessageUtils.getMessage("upload.server.error"));
                } catch (FileNameLengthLimitExceededException e) {
                    return  Response.error(ResponseError.NORMAL_ERROR, MessageUtils.getMessage("upload.server.error"));
                }
            }
            responseResult.put("attachment_list",attachmentList);
        }
        return responseResult;
    }

    /**
     *
     * @title: ajaxUpload
     * @description: 文件上传
     * @param request
     * @param response
     * @return
     * @return: AjaxUploadResponse
     */
    @RequestMapping(value = "uploadSimditor", method = RequestMethod.POST)
    public Response uploadSimditor(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        Response responseData = Response.ok();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();
            while (ite.hasNext()) {
                MultipartFile file = multiRequest.getFile(ite.next());
                try {
                    Attachment attachment = attachmentHelper.upload(request, file);
                    attachmentList.add(attachment);
                    continue;
                } catch (IOException e) {
                    responseData.error(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch (InvalidExtensionException e) {
                    responseData.error(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch (FileUploadBase.FileSizeLimitExceededException e) {
                    responseData.error(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch (FileNameLengthLimitExceededException e) {
                    responseData.error(MessageUtils.getMessage("upload.server.error"));
                    continue;
                }
            }
            String ctxPath = request.getContextPath();
            responseData.putList("attachmentList",attachmentList);
            responseData.put("success", Boolean.TRUE);
            responseData.put("msg", MessageUtils.getMessage("upload.server.error"));
            responseData.put("file_path", ctxPath + "/" + attachmentList.get(0).getFilePath());
        } else {
            responseData.put("success", Boolean.FALSE);
            responseData.put("msg", MessageUtils.getMessage("upload.server.error"));
        }
        return responseData;
    }
}