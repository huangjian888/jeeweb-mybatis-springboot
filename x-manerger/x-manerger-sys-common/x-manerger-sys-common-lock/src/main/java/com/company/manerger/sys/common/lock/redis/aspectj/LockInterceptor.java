package com.company.manerger.sys.common.lock.redis.aspectj;

import com.company.manerger.sys.common.lock.LockExecutor;
import com.company.manerger.sys.common.lock.annotation.Lock;
import com.company.manerger.sys.common.lock.enums.LockType;
import com.company.manerger.sys.common.lock.redis.condition.RedisLockCondition;
import com.company.manerger.sys.common.lock.redis.redisson.exception.RedissonException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Aspect
@Component
@Conditional(RedisLockCondition.class)
public class LockInterceptor{
    private static final Logger LOG = LoggerFactory.getLogger(LockInterceptor.class);
    @Resource(name="redisLockExecutor")
    private LockExecutor<RLock> lockExecutor;
    @Value("${redisson.lockExceptionIgnore:true}")
    private Boolean lockExceptionIgnore;
    @Value("${lock.prefix:lockPrefix}")
    private String prefix;

    @Pointcut(value = "@annotation(com.company.manerger.sys.common.lock.annotation.Lock)")
    public void lockPointCut() { }

    @Around(value = "lockPointCut()")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Lock lockAnnotation = method.getAnnotation(Lock.class);
        String name = lockAnnotation.name();
        String key = lockAnnotation.key();
        long leaseTime = lockAnnotation.leaseTime();
        long waitTime = lockAnnotation.waitTime();
        boolean async = lockAnnotation.async();
        boolean fair = lockAnnotation.fair();
        LockType lockType = lockAnnotation.lockType();
        return invoke(name,key,prefix,leaseTime,waitTime,async,fair,lockType,pjp);
    }

    @AfterThrowing(value = "lockPointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e)
    {
        /**
         * 异常回调处理，可在HttpServletRequest 中添加相关异常信息
         */
    }

    public Object invoke(String name, String key,String prefix, long leaseTime, long waitTime, boolean async, boolean fair,LockType lockType,ProceedingJoinPoint pjp) throws Throwable {
        RLock lock = null;
        try {
            lock = lockExecutor.tryLock(lockType,name,key,prefix,leaseTime,waitTime,async,fair);
            if (lock != null){
                return pjp.proceed();
            }
        }catch (Exception e){
            if(lockExceptionIgnore){
                LOG.error("Redis exception while lock",e);
                return pjp.proceed();
            }else {
                throw new RedissonException("Redis exception while lock",e);
            }
        }finally {
            lockExecutor.unlock(lock);
        }
        return pjp.proceed();
    }

}
