package com.company.manerger.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.base.mvc.controller.BaseController;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.utils.CacheUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.common.utils.jcaptcha.JCaptcha;
import com.company.manerger.sys.service.modules.email.constant.EmailConstant;
import com.company.manerger.sys.service.modules.email.entity.EmailTemplate;
import com.company.manerger.sys.service.modules.email.service.IEmailSendService;
import com.company.manerger.sys.service.modules.email.service.IEmailTemplateService;
import com.company.manerger.sys.service.modules.sys.entity.User;
import com.company.manerger.sys.service.modules.sys.service.IUserService;
import com.company.manerger.sys.service.modules.sys.service.impl.PasswordService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("${company.admin.url.prefix}")
@ViewPrefix("modules/sys/register")
public class RegisterController extends BaseController {
    @Autowired
    private IEmailSendService emailSendService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IEmailTemplateService emailTemplateService;
    @Autowired
    private PasswordService passwordService;

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        return new ModelAndView("modules/sys/register/register");
    }

    @PostMapping("/register")
    public void register(@RequestParam Map<String,String> registerParams, HttpServletRequest request, HttpServletResponse response, Model model) {
        Response ret = new Response();
        String error = (String) request.getAttribute("shiroLoginFailure");
        if(error != null && error.equalsIgnoreCase("jCaptcha.error")) {
            printJson(ret,response,Response.ERROR_CODE,"验证码错误!");
            return;
        }
        String password = registerParams.get("password");
        String repassword = registerParams.get("re_password");
        if(!password.equals(repassword)){
            printJson(ret,response,Response.ERROR_CODE,"密码不一致,请重新输入!");
            return;
        }
        //判断username/email 是否被注册过
        String registerJson = JSON.toJSONString(registerParams);
        User registerUser = JSON.parseObject(registerJson, User.class);
        if(userService.findByUsername(registerUser.getUsername()) != null){
            printJson(ret,response,Response.ERROR_CODE,"用户名已被注册!");
            return;
        }
        if(userService.findByEmail(registerUser.getEmail()) != null){
            printJson(ret,response,Response.ERROR_CODE,"邮箱已被注册!");
            return;
        }
        registerUser.setRealname(registerUser.getUsername());
        sendEmailActivate(registerUser,ret,response);
    }

    private void printJson(Response ret,HttpServletResponse response,int code,String msg){
        ret.put("code",code);
        ret.put("msg",msg);
        String content = JSON.toJSONString(ret);
        StringUtils.printJson(response,content);
    }

    /**
     * 发送激活邮件
     * @param user
     * @param ret
     * @param response
     */
    public void sendEmailActivate(User user,Response ret,HttpServletResponse response){
        /**
         * 生成token发送到邮件模版中
         */
        Map<String,Object> datas = new HashMap<>();
        datas.put("username",user.getUsername());
        String token = StringUtils.randomUUID();
        CacheUtils.put(token,user);
        datas.put("token",token);
//        System.out.println("url:"+ "http://localhost:8080/admin/register/activate?token="+token);
        emailSendService.send(user.getEmail(), EmailConstant.EMAIL_ACTIVATE_EMAIL_TEMPLATE_CODE,datas);
        ret.put("msg","已将激活链接发送到您的邮箱,可能存在延迟,请注意查收并激活!");
        String content = JSON.toJSONString(ret);
        StringUtils.printJson(response,content);
    }

    /**
     * 邮箱激活
     * @param model
     * @param token
     * @return
     */
    @GetMapping("/register/activate")
    public ModelAndView activate(Model model, @RequestParam(value = "token",required = false) String token) {
        Map<String,Object> datas = new HashMap<>();
        EmailTemplate template = emailTemplateService.selectOne(new EntityWrapper<EmailTemplate>().eq("code", EmailConstant.EMAIL_TIPS_TEMPLATE_CODE));
        if (!StringUtils.isEmpty(token)){
            User user = (User) CacheUtils.get(token);
            if(user != null){
                if(userService.findByUsername(user.getUsername()) != null){
                    datas.put("tips","当前用户名已使用,请重新注册并激活!");
                    String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
                    model.addAttribute("tips",content);
                    return new ModelAndView("modules/sys/register/tips");
                }
                if(userService.findByEmail(user.getEmail()) != null){
                    datas.put("tips","当前邮箱已使用,请重新注册并激活!");
                    String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
                    model.addAttribute("tips",content);
                    return new ModelAndView("modules/sys/register/tips");
                }
                userService.insertOrUpdate(user);
                datas.put("tips","激活成功!");
                String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
                model.addAttribute("tips",content);
                return new ModelAndView("modules/sys/register/tips");
            }else {
                datas.put("tips","无效链接，请重新校验您的信息!");
                String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
                model.addAttribute("tips",content);
                return new ModelAndView("modules/sys/register/tips");
            }
        }
        datas.put("tips","无效链接，请重新校验您的信息!");
        String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
        model.addAttribute("tips",content);
        return new ModelAndView("modules/sys/register/tips");
    }

    private String parseContent(String content,Map<String, Object> dataMap) {
        try {
            String tempname = StringUtils.hashKeyForDisk(content);
            Configuration configuration = new Configuration();
            configuration.setNumberFormat("#");
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            stringLoader.putTemplate(tempname, content);
            freemarker.template.Template template = new freemarker.template.Template(tempname, new StringReader(content));
            StringWriter stringWriter = new StringWriter();
            template.process(dataMap, stringWriter);
            configuration.setTemplateLoader(stringLoader);
            content = stringWriter.toString();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("模板解析失败");
        }
        return content;
    }

    /**
     * 找回密码
     * @param model
     * @return
     */
    @GetMapping("/register/forget")
    public ModelAndView forget(Model model){
        return new ModelAndView("modules/sys/forget/forget");
    }

    /**
     * 发送找回密码邮件
     * @param forgetParams
     * @param request
     * @param response
     * @param model
     */
    @PostMapping("/register/forget")
    public void forget(@RequestParam Map<String,String> forgetParams, HttpServletRequest request, HttpServletResponse response, Model model) {
        Response ret = new Response();
        //判断验证码
        boolean validate = JCaptcha.validateResponse(request, request.getParameter("jcaptchaCode"));
        if(!validate){
            printJson(ret,response,Response.ERROR_CODE,"验证码错误!");
            return;
        }
        String forgetJson = JSON.toJSONString(forgetParams);
        User forgetUser = JSON.parseObject(forgetJson, User.class);
        User queryUser = userService.findByEmail(forgetUser.getEmail());
        if(queryUser == null){
            printJson(ret,response,Response.ERROR_CODE,"未查询到当前邮箱,请重新输入!");
            return;
        }
        //发送找回密码邮件
        Map<String,Object> datas = new HashMap<>();
        String token = StringUtils.randomUUID();
        String newPassWord = StringUtils.randomString(6);
        queryUser.setPassword(newPassWord);
        CacheUtils.put(token,queryUser);
        datas.put("token",token);
        datas.put("tips","密码："+newPassWord);
//        System.out.println("url:"+ "http://localhost:8080/admin/register/reset?token="+token);
//        System.out.println("newPassWord:"+newPassWord);
        emailSendService.send(queryUser.getEmail(), EmailConstant.EMAIL_FORGET_PASSWORD_EMAIL_TEMPLATE_CODE,datas);
        ret.put("msg","已将重置密码链接发送到您的邮箱,可能存在延迟,请注意查收并进行密码重置!");
        String content = JSON.toJSONString(ret);
        StringUtils.printJson(response,content);
    }

    /**
     * 密码重置
     * @param model
     * @param token
     * @return
     */
    @GetMapping("/register/reset")
    public ModelAndView reset(Model model, @RequestParam(value = "token",required = false) String token) {
        Map<String,Object> datas = new HashMap<>();
        EmailTemplate template = emailTemplateService.selectOne(new EntityWrapper<EmailTemplate>().eq("code", EmailConstant.EMAIL_TIPS_TEMPLATE_CODE));
        if (!StringUtils.isEmpty(token)){
            User user = (User) CacheUtils.get(token);
            if(user != null){
                if(userService.findByEmail(user.getEmail()) == null){
                    datas.put("tips","未查询到当前邮箱信息,请重新校验您的信息!");
                    String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
                    model.addAttribute("tips",content);
                    return new ModelAndView("modules/sys/register/tips");
                }
                passwordService.encryptPassword(user);
                user.setUpdateDate(new Date());
                userService.insertOrUpdate(user);
                datas.put("tips","密码重置成功,请使用最新密码登录!");
                String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
                model.addAttribute("tips",content);
                return new ModelAndView("modules/sys/register/tips");
            }else {
                datas.put("tips","无效链接，请重新校验您的信息!");
                String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
                model.addAttribute("tips",content);
                return new ModelAndView("modules/sys/register/tips");
            }
        }
        datas.put("tips","无效链接，请重新校验您的信息!");
        String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
        model.addAttribute("tips",content);
        return new ModelAndView("modules/sys/register/tips");
    }

}
