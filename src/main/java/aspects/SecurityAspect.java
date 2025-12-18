package aspects;

import annotations.SecuredBy;
import context.SecurityContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SecurityAspect {

    @Around(value = "@annotation(securedBy)", argNames = "proceedingJoinPoint,securedBy")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, SecuredBy securedBy) throws Throwable {
        boolean authz = false;
        for(var role: securedBy.roles()){
            if(SecurityContext.hasRole(role)){
                authz = true;
                break;
            }
        }
        if(authz){
            return proceedingJoinPoint.proceed();
        } else {
            throw new SecurityException("User is not authorized to perform this action");
        }
    }

}
