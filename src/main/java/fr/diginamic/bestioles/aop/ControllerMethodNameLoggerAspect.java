package fr.diginamic.bestioles.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerMethodNameLoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * log toutes les methodes contenant find
     * @param joinPoint
     */
    @Before("execution(* fr.diginamic.bestioles..find*(..))")
    public void logAllMethodFind(JoinPoint joinPoint) {
        logger.info(">>>>>>>>>>>>>>>>>>>> Executing find method: {}", joinPoint.getSignature().getName());
    }

    /**
     * log les méthodes publiques des controllers
     * @param joinPoint
     */
    @Before("execution(* fr.diginamic.bestioles.controllers..*(..))")
    public void logAllMethodFromControllers(JoinPoint joinPoint) {
        logger.info(">>>>>>>>>>>>>>>>>>>> Executing controllers method: {}", joinPoint.getSignature().getName());
    }

    /**
     * log des exceptions
     * @param joinPoint
     * @throws Throwable
     */
    @AfterThrowing("execution(* fr.diginamic.bestioles..*(..))")
    public void logAfterThrowingAllMethods(JoinPoint joinPoint) {
        logger.info(">>>>>>>>>>>>>>>>>>>> Exception thrown: {}", joinPoint.getSignature().getName());
    }

    /**
     * log des methodes des services
     * @param joinPoint
     */
    @Before("within(fr.diginamic.bestioles.services..*)")
    public void logAllMethodFromServices(JoinPoint joinPoint) {
        logger.info(">>>>>>>>>>>>>>>>>>>> Executing service method: {}", joinPoint.getSignature().getName());
    }

    /**
     * mesure du temps écoulé avec l'utilisation des services
     * @param pJoinPoint
     * @return
     */
    @Around("within(fr.diginamic.bestioles.services..*)")
    public Object logExecTime(ProceedingJoinPoint pJoinPoint){
        System.out.println("+++++++++++++++++ Before method: "
                + pJoinPoint.getSignature().toShortString());
        long beforeTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = pJoinPoint.proceed();//Important
            //If method throws Exception or any error occurs
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long afterTime = System.currentTimeMillis();
        System.out.println("+++++++++++++++++  Time taken to execute: "
                + (afterTime - beforeTime) + "ms");
        return result;
    }
}
