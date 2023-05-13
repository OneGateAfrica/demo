package tn.esprit.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectApp {

    @Before("execution(* tn.esprit.demo.services.impl.*.*(..))")
    public void entry (JoinPoint joinPoint){

        String name = joinPoint.getSignature().getName();
        log.info("Method executed is : {}" , name);
    }

    @After("execution(* tn.esprit.demo.services.impl.*.*(..))")
    public void entry2 (JoinPoint joinPoint){

        String name = joinPoint.getSignature().getName();
        log.info("method is closed : {}" , name);
    }


    @Around("execution(* tn.esprit.demo.services.impl.*.*(..))")
    public void entry3(ProceedingJoinPoint joinPoint) throws Throwable {

       Long t1 = System.currentTimeMillis();

       Object obj = joinPoint.proceed();

       Long t2 = System.currentTimeMillis() -t1;


       log.info("temp d'execution est : {}ms", t2);




    }
}
