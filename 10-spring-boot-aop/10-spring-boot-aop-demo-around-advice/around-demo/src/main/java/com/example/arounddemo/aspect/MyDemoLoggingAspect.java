package com.example.arounddemo.aspect;

import com.example.arounddemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //@Around with Rethrow Exception
    @Around("execution(* com.example.arounddemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);
        // get begin timestamp
        long begin = System.currentTimeMillis();
        // now, let's execute the method
        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception exc) {
            // log the exception
            System.out.println(exc.getMessage());
            // rethrow exception
            throw exc;
        }

        // get end timestamp
        long end = System.currentTimeMillis();
        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }


    //@Around with Handling Exceptions
//    @Around("execution(* com.example.arounddemo.service.*.getFortune(..))")
//    public Object aroundGetFortune(
//            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
//        // print out method we are advising on
//        String method = theProceedingJoinPoint.getSignature().toShortString();
//        System.out.println("\n=====>>> Executing @Around on method: " + method);
//        // get begin timestamp
//        long begin = System.currentTimeMillis();
//        // now, let's execute the method
//        Object result = null;
//        try {
//            result = theProceedingJoinPoint.proceed();
//        }
//        catch (Exception exc) {
//            // log the exception
//            System.out.println(exc.getMessage());
//
//            // give user a custom message
//            result = "Major accident! But no worries, your private AOP helicopter is on the way!";
//        }
//        // get end timestamp
//        long end = System.currentTimeMillis();
//        // compute duration and display it
//        long duration = end - begin;
//        System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");
//        return result;
//    }

    //@Around
//    @Around("execution(* com.example.arounddemo.service.*.getFortune(..))")
//    public Object aroundGetFortune(
//            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
//        // print out method we are advising on
//        String method = theProceedingJoinPoint.getSignature().toShortString();
//        System.out.println("\n=====>>> Executing @Around on method: " + method);
//
//        // get begin timestamp
//        long begin = System.currentTimeMillis();
//
//        // now, let's execute the method
//        Object result = theProceedingJoinPoint.proceed();
//
//        // get end timestamp
//        long end = System.currentTimeMillis();
//
//        // compute duration and display it
//        long duration = end - begin;
//        System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");
//        return result;
//    }

}








