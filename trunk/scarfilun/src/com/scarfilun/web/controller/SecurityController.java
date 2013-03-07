package com.scarfilun.web.controller;

import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.scarfilun.util.SecurityUtil;
import com.scarfilun.util.exception.SecurityMessages;
import com.scarfilun.util.exception.SecurityViolationException;

import java.io.Serializable;
import java.security.Permission;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public abstract class SecurityController implements Serializable {

    //private String checkPermissions;

    public String getCheckPermissions() {
        if (getPermisssions() != null && !SecurityUtil.hasPermissions(getPermisssions())) {
            publishException(new SecurityViolationException(SecurityMessages.ACCESS_FORBIDDEN));
        }
        return "";
    }

    protected <T> T execute(Callable<T> c) throws Exception {
        try {
            return c.call();
        } catch (Exception e) {
            publishException(e);
            throw e;
        }
    }

    protected void publishException(Exception e) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExceptionQueuedEventContext eventContext = new ExceptionQueuedEventContext(ctx, e);
        ctx.getApplication().publishEvent(ctx, ExceptionQueuedEvent.class, eventContext);
    }

    protected abstract Permission[] getPermisssions();

}
