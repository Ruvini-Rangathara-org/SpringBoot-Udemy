package com.example.aopcrudapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggerAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.aopcrudapp.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.example.aopcrudapp.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.example.aopcrudapp.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>>> Executing @Before advice on method : "+method);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("=====>>> Argument : "+arg);
        }
    }
}
