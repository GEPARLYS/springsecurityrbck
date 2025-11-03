package com.ssm.aop;

import com.ssm.domain.SysLog;
import com.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author j
 * @Date 2019/9/10 15:01
 * @Version 1.0
 */
@Aspect
@Component
public class LogHandler {
    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 前置通知
     */
    @Before(value = "execution(* com.ssm.controller.*Controller.*(..))")
    public void logBefore(JoinPoint joinPoint){

        addLog(joinPoint,"Before");
    }

    /**
     * 后置通知
     */
    @After(value = "execution(* com.ssm.controller.*Controller.*(..))")
    public void logAfter(JoinPoint joinPoint){
        addLog(joinPoint,"After");
    }

    /**
     * 添加日志
     */
    private void addLog(JoinPoint joinPoint,String adviceType){
        //获取用户的IP
        String ip = request.getRemoteAddr();
        //方法名字
        String methodName = joinPoint.getSignature().getName();
        Class clazz = joinPoint.getSignature().getDeclaringType();

        SysLog sysLog = new SysLog();
        sysLog.setIp(ip);
        sysLog.setMethod(adviceType+":"+clazz+"."+methodName);
        sysLog.setUsername(getUserName());
        sysLog.setVisitTime(new Date());

        //添加日志操作
        sysLogService.addLog(sysLog);
    }
    /***
     * 获取用户名字
     * @return
     */
    private String getUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
