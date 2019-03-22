package com.company.manerger.sys.service.modules.oss.controller;

import com.company.manerger.sys.common.base.mvc.controller.BaseController;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.oss.exception.FileNameLengthLimitExceededException;
import com.company.manerger.sys.common.oss.exception.InvalidExtensionException;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.modules.oss.entity.Attachment;
import com.company.manerger.sys.service.modules.oss.helper.AttachmentHelper;
import com.company.manerger.sys.service.modules.oss.model.ReturnCatchimageListImage;
import com.company.manerger.sys.service.modules.oss.model.ReturnListImage;
import com.company.manerger.sys.service.modules.oss.model.ReturnUploadImage;
import com.company.manerger.sys.service.modules.oss.service.IAttachmentService;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("${company.admin.url.prefix}/oss/ueditor")
public class OSSUeditorUploadController extends BaseController {
    @Autowired
    private AttachmentHelper attachmentHelper;
    @Autowired
    private IAttachmentService attachmentService;
    public static final String[] IMAGE_EXTENSION = {"bmp", "gif", "jpg", "jpeg", "png"};

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
    @ResponseBody
    public ReturnUploadImage upload(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        ReturnUploadImage returnUploadImage = new ReturnUploadImage();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();
            while (ite.hasNext()) {
                MultipartFile file = multiRequest.getFile(ite.next());
                try {
                    Attachment attachment = attachmentHelper.upload(request, file);
                    returnUploadImage.setUrl(attachment.getFilePath());
                    returnUploadImage.setState("SUCCESS");
                    returnUploadImage.setTitle(attachment.getFileName());
                    returnUploadImage.setOriginal(attachment.getFileName());
                    continue;
                } catch (IOException e) {

                    continue;
                } catch (InvalidExtensionException e) {

                    continue;
                } catch (FileUploadBase.FileSizeLimitExceededException e) {
                    continue;
                } catch (FileNameLengthLimitExceededException e) {
                   continue;
                }
            }
        }
        return returnUploadImage;
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
    @RequestMapping(value = "catchimage")
    @ResponseBody
    public ReturnCatchimageListImage catchimage(@RequestParam("source[]") String[] sources, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        ReturnCatchimageListImage returnUploadImage = new ReturnCatchimageListImage();
        returnUploadImage.setState("SUCCESS");
        for (String source:sources) {
            try {
                Attachment attachment = attachmentHelper.remote(request, source);
                returnUploadImage.putItem(attachment.getFilePath(),source);
                continue;
            } catch (IOException e) {

                continue;
            } catch (InvalidExtensionException e) {

                continue;
            } catch (FileUploadBase.FileSizeLimitExceededException e) {
                continue;
            } catch (FileNameLengthLimitExceededException e) {
                continue;
            }
        }
        return returnUploadImage;
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
    @RequestMapping(value = "listfile")
    @ResponseBody
    public ReturnListImage listimage(Integer start, Integer size, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        Page  pageBean = new Page(start,size);
        String listtype=request.getParameter("listtype");
        Page<Attachment> attachmentPage=null;
        if (!StringUtils.isEmpty(listtype)&&listtype.equals("image")) {
            attachmentPage = attachmentService.selectPage(pageBean, new EntityWrapper<Attachment>(Attachment.class).in("fileext", IMAGE_EXTENSION).orderBy("a.create_date"));
        }else{
            attachmentPage = attachmentService.selectPage(pageBean, new EntityWrapper<Attachment>(Attachment.class).orderBy("a.create_date"));
        }
        ReturnListImage returnListImage = new ReturnListImage();
        returnListImage.setState("SUCCESS");
        returnListImage.setStart(start);
        returnListImage.setTotal(pageBean.getTotal());
        for (Attachment attachment: attachmentPage.getRecords()) {
            returnListImage.putUrl(attachment.getFilePath());
        }
        return returnListImage;
    }
}
