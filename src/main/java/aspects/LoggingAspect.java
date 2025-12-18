package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    Logger log = Logger.getLogger(LoggingAspect.class.getName());

//    @Pointcut("execution(* *.*())")
//    public void pc1(){}

    @Around("@annotation(annotations.Log)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Started: " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        Object res = pjp.proceed();
        log.info("Finished: " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        return res;
    }

//    @Around("pc1()")
//    public Object aroundPc1(ProceedingJoinPoint pjp) throws Throwable {
//        log.info("Started: " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
//        Object res = pjp.proceed();
//        log.info("Finished: " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
//        return res;
//    }
}
