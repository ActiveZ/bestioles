package fr.diginamic.bestioles.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerMethodNameLoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Before("execution(* find*(..))")
    public void logAllMethodFind(JoinPoint joinPoint) {
        logger.info("Executing find method {}", joinPoint.getSignature().getName());
    }
}
