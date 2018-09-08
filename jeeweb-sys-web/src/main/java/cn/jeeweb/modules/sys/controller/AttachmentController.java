package cn.jeeweb.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.model.PageJson;
import cn.jeeweb.core.query.data.PropertyPreFilterable;
import cn.jeeweb.core.query.data.Queryable;
import cn.jeeweb.core.query.utils.QueryableConvertUtils;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.IpUtils;
import cn.jeeweb.core.utils.MessageUtils;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.core.utils.upload.exception.FileNameLengthLimitExceededException;
import cn.jeeweb.core.utils.upload.exception.InvalidExtensionException;
import cn.jeeweb.modules.sys.data.AttachmentFile;
import cn.jeeweb.modules.sys.entity.Attachment;
import cn.jeeweb.modules.sys.service.IAttachmentService;
import cn.jeeweb.modules.sys.utils.UserUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("${admin.url.prefix}/sys/attachment")
@RequiresPathPermission("sys:attachment")
public class AttachmentController extends BaseController {

	@Resource
	private IAttachmentService attachmentService;

	@RequiresMethodPermissions("list")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
		return display("list");
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxList", method = {RequestMethod.GET, RequestMethod.POST})
	private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
		propertyPreFilterable.addQueryProperty("id");
		// 预处理
		QueryableConvertUtils.convertQueryValueToEntityValue(queryable, Attachment.class);
		SerializeFilter filter = propertyPreFilterable.constructFilter(Attachment.class);
		PageJson<Attachment> pagejson = new PageJson<Attachment>(attachmentService.list(queryable));
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	/**
	 * 
	 * @title: ajaxUpload
	 * @description: 文件上传
	 * @param request
	 * @param response
//	 * @param files
	 * @return
	 * @return: AjaxUploadResponse
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson upload(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/plain");
		AjaxJson ajaxJson = new AjaxJson();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> ite = multiRequest.getFileNames();
			while (ite.hasNext()) {
				MultipartFile file = multiRequest.getFile(ite.next());
				try {
					String path = request.getServletContext().getRealPath("/");
					AttachmentFile attachmentFile = new AttachmentFile(file.getName(),file.getOriginalFilename(), IpUtils.getIpAddr(request),file.getContentType(),file.getBytes());
					Attachment attachment = attachmentService.upload(attachmentFile, UserUtils.getUser());
					attachmentList.add(attachment);
					continue;
				} catch (IOException e) {
					ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
					continue;
				} catch (InvalidExtensionException e) {
					ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
					continue;
				} catch (FileUploadBase.FileSizeLimitExceededException e) {
					ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
					continue;
				} catch (FileNameLengthLimitExceededException e) {
					ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
					continue;
				}
			}

			ajaxJson.setData(attachmentList);
		}
		return ajaxJson;
	}

	/**
	 * 
	 * @title: ajaxUpload
	 * @description: 文件上传
	 * @param request
	 * @param response
//	 * @param files
	 * @return
	 * @return: AjaxUploadResponse
	 */
	@RequestMapping(value = "uploadSimditor", method = RequestMethod.POST)
	@ResponseBody
	public void uploadSimditor(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/plain");
		AjaxJson ajaxJson = new AjaxJson();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		Map<String, Object> data = new HashMap<String, Object>();
		if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> ite = multiRequest.getFileNames();
			while (ite.hasNext()) {
				MultipartFile file = multiRequest.getFile(ite.next());
				try {
					String path = request.getServletContext().getRealPath("/");
					AttachmentFile attachmentFile = new AttachmentFile(file.getName(),file.getOriginalFilename(), IpUtils.getIpAddr(request),file.getContentType(),file.getBytes());
					Attachment attachment = attachmentService.upload(attachmentFile, UserUtils.getUser());
					attachmentList.add(attachment);
					continue;
				} catch (IOException e) {
					ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
					continue;
				} catch (InvalidExtensionException e) {
					ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
					continue;
				} catch (FileUploadBase.FileSizeLimitExceededException e) {
					ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
					continue;
				} catch (FileNameLengthLimitExceededException e) {
					ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
					continue;
				}
			}
			String ctxPath = request.getContextPath();
			ajaxJson.setData(attachmentList);
			data.put("success", Boolean.TRUE);
			data.put("msg", MessageUtils.getMessage("upload.server.error"));
			data.put("file_path", ctxPath + "/" + attachmentList.get(0).getFilepath());
		} else {
			data.put("success", Boolean.FALSE);
			data.put("msg", MessageUtils.getMessage("upload.server.error"));
		}
		StringUtils.printJson(response, data);
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson delete(@PathVariable("id") String id) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		try {
			attachmentService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(value = "ids", required = false) String[] ids) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		try {
			List<String> idList = Arrays.asList(ids);
			attachmentService.deleteBatchIds(idList);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}

	/**
	 * 
	 * @title: ajaxUpload
	 * @description: 文件上传
	 * @param request
	 * @param response
//	 * @param files
	 * @return
	 * @return: AjaxUploadResponse
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson list(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/plain");
		AjaxJson ajaxJson = new AjaxJson();
		String saveType = request.getParameter("saveType");
		if (saveType.equals("id")) {
			String id = request.getParameter("id");
			List<Attachment> list = attachmentService
					.selectList(new EntityWrapper<Attachment>().in("id", id.split(",")));
			ajaxJson.setData(list);
		} else {
			String filepath = request.getParameter("url");
			List<Attachment> list = attachmentService
					.selectList(new EntityWrapper<Attachment>().in("filepath", filepath.split(",")));
			ajaxJson.setData(list);
		}

		return ajaxJson;
	}
}
