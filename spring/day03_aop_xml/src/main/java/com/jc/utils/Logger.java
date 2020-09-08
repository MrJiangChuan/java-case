package com.jc.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void beforeLog(){
        System.out.println("前置通知：记录日志");
    }
    public void returnAfterLog(){
        System.out.println("后置通知：记录日志");
    }
    public void exceptionLog(){
        System.out.println("异常通知：记录日志");
    }
    public void afterLog(){
        System.out.println("最终通知：记录日志");
    }
    public void roundLog(ProceedingJoinPoint pjp) {
        try {
            System.out.println("前置通知：记录日志");
            Object[] args = pjp.getArgs();
            Object proceed = pjp.proceed(args);
            System.out.println("后置通知：记录日志");
        } catch (Throwable throwable) {
            System.out.println("异常通知：记录日志");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知：记录日志");
        }

    }
}
