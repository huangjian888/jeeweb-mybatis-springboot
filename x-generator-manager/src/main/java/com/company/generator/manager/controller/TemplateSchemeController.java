package com.company.generator.manager.controller;

import com.company.generator.manager.entity.TemplateScheme;
import com.company.generator.manager.service.ITemplateSchemeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.company.manerger.sys.common.base.http.PageResponse;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.query.annotation.PageableDefaults;
import com.company.manerger.sys.common.query.data.PropertyPreFilterable;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.utils.QueryableConvertUtils;
import com.company.manerger.sys.common.utils.FileUtils;
import com.company.manerger.sys.common.utils.ObjectUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("${admin.url.prefix}/generator/template/scheme")
@ViewPrefix("modules/generator/template")
public class TemplateSchemeController extends BaseBeanController<TemplateScheme> {

    @Autowired
    protected ITemplateSchemeService templateSchemeService;

    public TemplateScheme get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return templateSchemeService.selectById(id);
        } else {
            return newModel();
        }
    }

    @GetMapping
    public ModelAndView list(Model model, HttpServletRequest request, HttpServletResponse response) {
        return displayModelAndView("scheme_list");
    }

    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    @PageableDefaults(sort = "id=desc")
    private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<TemplateScheme> entityWrapper = new EntityWrapper<TemplateScheme>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<TemplateScheme> pagejson = new PageResponse<TemplateScheme>(templateSchemeService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response, content);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", newModel());
        }
        return displayModelAndView("scheme_edit");
    }

    @PostMapping(value = "add")
    public Response add(Model model, @Valid @ModelAttribute("data") TemplateScheme templateScheme, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(templateScheme,result);
        templateSchemeService.insert(templateScheme);
        return Response.ok("添加成功");
    }

    @GetMapping(value = "{id}/update")
    public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                         HttpServletResponse response) {
        TemplateScheme templateScheme = get(id);
        model.addAttribute("data", templateScheme);
        return displayModelAndView("scheme_edit");
    }

    @PostMapping(value = "{id}/update")
    public Response update(Model model, @Valid @ModelAttribute("data") TemplateScheme templateScheme, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(templateScheme,result);
        templateSchemeService.insertOrUpdate(templateScheme);
        return Response.ok("更新成功");
    }

    @PostMapping(value = "{id}/delete")
    public Response delete(@PathVariable("id") String id) { ;
        try {
            templateSchemeService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("删除失败");
        }
        return  Response.ok("删除成功");
    }

    @PostMapping(value = "batch/delete")
    public Response batchDelete(@RequestParam(value = "ids", required = false) String[] ids) {
        try {
            List<String> idList = java.util.Arrays.asList(ids);
            templateSchemeService.deleteBatchIds(idList);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("删除失败");
        }
        return Response.ok("删除成功");
    }

    /**
     * 复制
     * @param id
     * @return
     */
    @PostMapping(value = "{id}/copy")
    public Response copy(@PathVariable("id") String id) { ;
        try {
            templateSchemeService.copy(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("删除失败");
        }
        return  Response.ok("删除成功");
    }

    /**
     * 导出模板
     * @param id
     * @param response
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    @GetMapping(value="{id}/export")
    public ResponseEntity<byte[]> export(@PathVariable("id") String id, HttpServletResponse response,
                                         HttpServletRequest request) throws UnsupportedEncodingException,IOException{
        TemplateScheme templateScheme = templateSchemeService.selectById(id);
        String text= JSONObject.toJSONString(templateSchemeService.export(id));
        String fileName=templateScheme.getTitle()+"_"+ System.currentTimeMillis()+"模板方案.json";
        //下载文件路径
        String path = request.getServletContext().getRealPath("/generator/txt/");
        FileUtils.mkDir(path);
        File file = new File(path + File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();
        OutputStream os = new FileOutputStream(file);
        IOUtils.write(text,os);
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    /**
     * 导入模板
     * @return
     */
    @GetMapping(value="/import")
    public ModelAndView loadImport() {
        return displayModelAndView("import");
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
    @PostMapping(value = "upload")
    public Response upload(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        Response responseResult = Response.ok();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();
            while (ite.hasNext()) {
                MultipartFile file = multiRequest.getFile(ite.next());
                try {
                    //上传文件路径
                    String path = request.getServletContext().getRealPath("/generator/txt/");
                    //上传文件名
                    String filename = file.getOriginalFilename();
                    File filepath = new File(path,filename);
                    //判断路径是否存在，如果不存在就创建一个
                    if (!filepath.getParentFile().exists()) {
                        filepath.getParentFile().mkdirs();
                    }
                    //将上传文件保存到一个目标文件当中
                    File newFIle = new File(path + File.separator + filename);
                    file.transferTo(newFIle);
                    responseResult.put("fileName",newFIle.getAbsolutePath());
                    continue;
                } catch (Exception e) {
                    return  Response.error("上传失败");
                }
            }
        }
        return responseResult;
    }
    /**
     * 导入模板
     * @return
     */
    @PostMapping(value="/import")
    public Response loadImport(HttpServletRequest request,
                         @RequestParam("fileUrl") String fileUrl) throws Exception {
        //如果文件不为空，写入上传路径
        if(!StringUtils.isEmpty(fileUrl)) {
            String json = IOUtils.toString(new FileInputStream(fileUrl));
            templateSchemeService.loadImport(json);
            return Response.ok("导入成功");
        } else {
            return Response.ok("导入失败");
        }

    }
}
