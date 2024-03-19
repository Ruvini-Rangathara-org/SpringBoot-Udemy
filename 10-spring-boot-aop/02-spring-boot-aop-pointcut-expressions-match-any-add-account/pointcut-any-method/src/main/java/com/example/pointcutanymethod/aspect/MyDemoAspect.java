package com.example.pointcutanymethod.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoAspect {

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.example.pointcutanymethod.dao.AccountDAO.addAccount())")
    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }


    @Before("execution(void update*())")
    public void beforeUpdateAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on updateAccount()");
    }

//    @Before("execution(void deleteAccount(com.example.pointcutanymethod.dto.Account, boolean ))")
//    @Before("execution(void deleteAccount(com.example.pointcutanymethod.dto.Account, .. ))")
    @Before("execution(void deleteAccount(..))")
    public void beforeDeleteAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on deleteAccount()");
    }


    //only for com.example.pointcutanymethod package
    @Before("execution(void com.example.pointcutanymethod..searchAccount(..))")
    public void beforeSearchAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on searchAccount()");
    }

    @Before("execution(* com.example.pointcutanymethod.dao.*.*(..))")
    public void beforeMethodAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method()");
    }
}
