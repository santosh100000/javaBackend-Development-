package com.example.L08SpringJPAdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Before("execution(*  com.example.L08SpringJPAdemo.service.*(..))")
    public void beforeMethod(){
        LOGGER.info("starting method execution");
    }
}
