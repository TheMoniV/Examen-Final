package org.sid.aspect.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.sid.security.SecurityManager;
import org.sid.security.User;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class AuthenticationAspect {

    private static Map<String, String[]> session = new HashMap<>();
    private SecurityManager securityManager;


    public AuthenticationAspect(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Before("@annotation(SecuredByAspect)")
    public void authenticate(JoinPoint joinPoint) throws Throwable {
        securityManager.login("User", "Password");
        User user = securityManager.getLoggedOnUser();
        Method method = getCurrentMethod(joinPoint);
        if (user == null) {
            throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
        }
        SecuredByAspect securedByAspect = method.getAnnotation(SecuredByAspect.class);
        for (String role : securedByAspect.roles()) {
            if (!user.hasRole(role.toUpperCase())) {
                throw new SecurityException("You must have the role " + role + " before attempting to invoke the method: " + method.getName());
            }
        }

    }

    private Method getCurrentMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}
