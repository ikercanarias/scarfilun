package com.scarfilun.web;

import org.springframework.web.util.WebUtils;

import com.scarfilun.util.AppUtil;

import javax.security.auth.Subject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Permission;

public class SecurityFilterListener implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        Subject subject = (Subject)WebUtils.getSessionAttribute((HttpServletRequest)servletRequest, WebConstants.SUBJECT);
        if(subject==null){
            subject = new Subject();
            WebUtils.setSessionAttribute((HttpServletRequest)servletRequest, WebConstants.SUBJECT, subject);            
        }
        if(subject.getPrincipals().size()==0){
            subject.getPrincipals().add(AppUtil.getAnonymousRole((HttpServletRequest)servletRequest));
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public static boolean hasPermission(Permission p){
        SecurityManager sm = System.getSecurityManager();
        try{
            sm.checkPermission(p);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void destroy() {

    }
}
