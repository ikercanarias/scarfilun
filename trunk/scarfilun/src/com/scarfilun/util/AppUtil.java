package com.scarfilun.util;

import org.springframework.web.context.WebApplicationContext;

import com.scarfilun.service.model.AnonymousRole;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AppUtil {

    private AppUtil(){}

    private static WebApplicationContext getSpringContext(HttpServletRequest request){
        ServletContext servletContext;
        if(request==null){
            FacesContext fc = FacesContext.getCurrentInstance();
            servletContext = (ServletContext)fc.getExternalContext().getContext();
        }else{
            HttpSession session = request.getSession();
            servletContext = session.getServletContext();
        }
        return (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }

    public static AnonymousRole getAnonymousRole(HttpServletRequest request){
        return getSpringBean("anonymousRole", request);
    }

    public static AnonymousRole getAnonymousRole(){
        return getAnonymousRole(null);
    }

    @SuppressWarnings("unchecked")
	public static <T>T getSpringBean(String beanName){
        return (T)getSpringBean(beanName, null);
    }

    @SuppressWarnings("unchecked")
	public static <T>T getSpringBean(String beanName, HttpServletRequest request){
        WebApplicationContext springContext = getSpringContext(request);
        if(springContext.containsBean(beanName)){
            return (T)springContext.getBean(beanName);
        }else{
            return null;
        }
    }

    public static void invalidateSession(){
        FacesContext fc = FacesContext.getCurrentInstance();
        if(fc!=null){
            HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();
            request.getSession().invalidate();
        }
    }

}
