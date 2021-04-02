package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void log(){}

    /**
     * 前置通知
     * @param jp
     */
    @Before("log()")
    public void doBefore(JoinPoint jp) throws Throwable{
        String methodName = jp.getSignature().getName();
        System.out.println("【前置通知】the method 【" + methodName + "】 execution with " + Arrays.asList(jp.getArgs()));
    }

    /**
     * 后置通知
     * @param jp
     */
    @After(" execution(* com.example.demo.controller.*.*(..)) ")
    public void after(JoinPoint jp  ){
        System.out.println("【后置通知】the method【"+ jp.getSignature().getName() +"】 execution done");
    }

    /**
     * 环绕通知，ProceedingJoinPoint 参数必须要，并且要放行，不然方法就处于阻塞状态
     * @param pjp
     */
//    @Around(" execution(* com.example.demo.controller.*.*(..)) ")
//    public void around(ProceedingJoinPoint pjp){
//        try{
//            String methodName = pjp.getSignature().getName();
//            System.out.println("【环绕通知的前置通知】the method execution with...");
//            // 放行，不放行方法调用会处于阻塞状态
//            pjp.proceed();
//            System.out.println("【环绕通知的后置通知】the method execution done " );
//        }catch (Throwable e){
//            System.out.println("【环绕通知的异常通知】exception：" + e.getMessage() );
//        }
//    }

    /**
     * 方法执行完了之后执行，跟上返回值
     * @param jp
     * @param result
     */
//    @AfterReturning(pointcut = " execution(* com.example.demo.controller.*.*(..)) " , returning = "result")
//    public void afterReturning(JoinPoint jp, Object result){
//        String methodName = jp.getSignature().getName();
//        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
//    }

    /**
     * 异常通知，方法出现异常的时候执行
     * @param jp
     * @param e
     */
    @AfterThrowing(value = " execution(* com.example.demo.controller.*.*(..)) " , throwing = "e")
    public void afterReturning(JoinPoint jp , Throwable e){
        String methodName = jp.getSignature().getName();
        System.out.println("【异常通知】the method 【" + methodName + "】 has exception 【" + e.getMessage() + "】");
    }


}
