package com.tutorial.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by kishore on 22/1/17.
 */

@Aspect
public class LoggingAspect {

    @Before("execution(* com.tutorial.spring.aop.bo.CustomerBo.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("logBefore() is running...!");
        System.out.println("Before Advice : " + joinPoint.getSignature().getName());
        System.out.println("**********");
    }

    @After("execution (* com.tutorial.spring.aop.bo.CustomerBo.addCustomer(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("logAfter() is running...!");
        System.out.println("After advice : " + joinPoint.getSignature().getName());
        System.out.println("**********");
    }

    @AfterReturning(pointcut = "execution (* com.tutorial.spring.aop.bo.CustomerBo.addCustomerReturnValue(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("logAfterReturning() is running...!");
        System.out.println("After returning advice : " + joinPoint.getSignature().getName());
        System.out.println("Return value : " + result);
        System.out.println("************");
    }

    @AfterThrowing(pointcut = "execution (* com.tutorial.spring.aop.bo.CustomerBo.addCustomerThrowException(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("logAfterThrowing() is running...!");
        System.out.println("After throwing advice : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error.getMessage());
        System.out.println("**************");

    }

    @Around("execution (* com.tutorial.spring.aop.bo.CustomerBo.addCustomerAround(..))")
    public void logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("logAround() is running...!");
        System.out.println("Around advice : " + proceedingJoinPoint.getSignature().getName());
        System.out.println("arguments : " + Arrays.toString(proceedingJoinPoint.getArgs()));

        System.out.println("Around before is running");
        proceedingJoinPoint.proceed();
        System.out.println("Around after is running");

        System.out.println("*********");

    }
}
