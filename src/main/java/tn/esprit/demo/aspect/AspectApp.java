package tn.esprit.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectApp {

    @Before("execution(* tn.esprit.demo.services.impl.*.ajouter*(..))")
    public void entry (JoinPoint joinPoint){

        String name = joinPoint.getSignature().getName();
        log.info("Début Exécution : {}" , name);
    }
}
