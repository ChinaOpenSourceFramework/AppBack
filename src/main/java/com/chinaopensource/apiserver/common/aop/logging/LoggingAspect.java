package com.chinaopensource.apiserver.common.aop.logging;


import java.util.Arrays;

import javax.inject.Inject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.chinaopensource.apiserver.common.constant.Constants;

/**
 * 以切面形式记录执行日志
 */
@Aspect
@Configuration
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private Environment env;

    /**
     * 定义切点位置
     */
    @Pointcut("within(com.chinaopensource.apiserver..*)")
    public void loggingPointcut() {

    }

    /**
     * 方法抛出异常时执行
     * pointcut / value : 用于指定该切入点对应的切入表达式。
     * throwing : 指定一个返回值形参名，增强处理定义的方法可通过该形参名来访问目标方法中所抛出的异常对象。
     */
    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_DEV)) {
            log.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null? e.getCause() : "NULL", e.getMessage());

        } else {
            log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null? e.getCause() : "NULL");
        }
    }

    /**
     * 方法进入和退出时执行
     */
    @Around("loggingPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

            throw e;
        }
    }
}
