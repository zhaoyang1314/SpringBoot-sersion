package com.session.springsession.aspectAop;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author: wade
 * @Date: 2021/07/19/17:48
 * @qq:1143011510
 * @Description: 使用AOP实现发送邮件
 */
@Component
@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class SendExceptionMailAOPHandler {


    /**
     * 创建切入点,在service层进行切入
     */
    @Pointcut("execution(public * com.session.springsession.service.ConsumerService.*(..))")
    public void servicePointcut(){}

    @AfterThrowing(value = "servicePointcut()",throwing = "e")
    public void sendThrowExceptionMail(Exception  e){
        System.out.println("发送邮件");
    }
}
