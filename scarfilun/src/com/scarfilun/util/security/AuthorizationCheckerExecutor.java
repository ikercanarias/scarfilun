package com.scarfilun.util.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.scarfilun.util.SecurityUtil;
import com.scarfilun.util.exception.SecurityMessages;
import com.scarfilun.util.exception.SecurityViolationException;

import java.security.Permission;

public class AuthorizationCheckerExecutor {

    public Object checkAuthorization(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature o = (MethodSignature) pjp.getSignature();
        SecurityConstraint sc = o.getMethod().getAnnotation(SecurityConstraint.class);
        if (sc != null) {
            Permission[] permissions = Permissions.getPermissionsByTypes(sc.permissions());
            if (permissions != null) {
                if (SecurityUtil.hasPermissions(permissions)) {
                    return pjp.proceed();
                } else {
                    throw new SecurityViolationException(SecurityMessages.OPERATION_FORBIDDEN);
                }
            }
        }
        return pjp.proceed();
    }
}
