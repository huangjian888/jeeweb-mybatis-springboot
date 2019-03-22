package com.company.manerger.sys.service.aspectj;

import com.company.manerger.sys.common.base.disruptor.Task;
import com.company.manerger.sys.common.base.disruptor.TaskHelper;
import com.company.manerger.sys.common.utils.IpUtils;
import com.company.manerger.sys.common.utils.ServletUtils;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.aspectj.annotation.Log;
import com.company.manerger.sys.service.modules.sys.entity.OperationLog;
import com.company.manerger.sys.service.modules.sys.entity.User;
import com.company.manerger.sys.service.modules.sys.service.IOperationLogService;
import com.company.manerger.sys.service.utils.UserUtils;
import com.alibaba.fastjson.JSONObject;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description: 操作日志记录处理
 */
@Aspect
@Component
public class LogAspect
{
    /**
     * 配置织入点
     */
    @Pointcut("@annotation(com.company.manerger.sys.service.aspectj.annotation.Log)")
    public void logPointCut()
    {
    }

    /**
     * 前置通知 用于拦截操作
     *
     * @param joinPoint
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint)
    {
        handleLog(joinPoint, null);
    }

    /**
     * 拦截异常操作
     * 
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e)
    {
        handleLog(joinPoint, e);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e)
    {
        try
        {
            // 方法注解
            Log methodAnnotationLog = getMethodAnnotationLog(joinPoint);
            if (methodAnnotationLog == null)
            {
                return;
            }
            // 类注解
            Log clazzAnnotationLog = getClazzAnnotationLog(joinPoint);

            // 获取当前的用户
            User currentUser = UserUtils.getUser();

            // *========数据库日志=========*//
            OperationLog operationLog = new OperationLog();
            operationLog.setStatus(OperationLog.OPERATION_LOG_SUCCESS);
            // 请求的地址
            // 获取客户端操作系统
            final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
            String os = userAgent.getOperatingSystem().getName();
            // 获取客户端浏览器
            String browser = userAgent.getBrowser().getName();
            operationLog.setBrowser(browser);
            operationLog.setOs(os);
            String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
            operationLog.setOperationIp(ip);
            operationLog.setRequestUri(ServletUtils.getRequest().getRequestURI());
            if (currentUser != null)
            {
                operationLog.setOperationName(currentUser.getUsername());
            }else{
                operationLog.setOperationName("未登录用户");
            }

            if (e != null)
            {
                operationLog.setStatus(OperationLog.OPERATION_LOG_FAIL);
                operationLog.setMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operationLog.setMethod(className + "." + methodName + "()");
            // 设置标题
            if (clazzAnnotationLog == null) {
                operationLog.setTitle(methodAnnotationLog.title());
            }else{
                String title = clazzAnnotationLog.title();
                if (!StringUtils.isEmpty(methodAnnotationLog.title())){
                    title+="-"+methodAnnotationLog.title();
                }
                operationLog.setTitle(title);
            }
            // 设置操作人类别
            operationLog.setLogType(StringUtils.lowerCase(methodAnnotationLog.logType().name()));
            // 是否需要保存request，参数和值
            if (methodAnnotationLog.requestParam())
            {
                // 获取参数的信息，传入到数据库中。
                Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
                String params = JSONObject.toJSONString(map);
                operationLog.setParams(params);
            }
            // 保存日志
            //创建异步任务
            Task task  = new Task()
            {
                @Override
                public void run()
                {
                    // 封装对象
                    SpringContextHolder.getBean(IOperationLogService.class).insert(operationLog);
                }
            };
            // 运行任务
            SpringContextHolder.getBean(TaskHelper.class).doTask(task);
        }
        catch (Exception exp)
        {
            // 记录本地异常日志
            exp.printStackTrace();
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private Log getMethodAnnotationLog(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }

    /**
     * 是否类注解，如果存在就获取
     */
    private Log getClazzAnnotationLog(JoinPoint joinPoint) throws Exception
    {
        Class clazz = joinPoint.getTarget().getClass();
        return (Log)clazz.getAnnotation(Log.class);
    }

}
