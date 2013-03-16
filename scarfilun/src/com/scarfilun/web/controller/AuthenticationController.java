package com.scarfilun.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.security.auth.Subject;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import com.scarfilun.service.UserService;
import com.scarfilun.service.model.User;
import com.scarfilun.util.AppUtil;
import com.scarfilun.util.SecurityUtil;
import com.scarfilun.util.security.LoginConfiguration;
import com.scarfilun.web.security.HttpCallbackHandler;

import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("serial")
@ManagedBean(name = "authController")
@SessionScoped
public class AuthenticationController implements Serializable {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;
    private String userName;
    private String password;
    private String redirectView;
    private User user;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRedirectView() {
        return redirectView;
    }

    public void setRedirectView(String redirectView) {
        this.redirectView = redirectView;
    }

    public User getUser() {
        return user;
    }

    public String login() throws LoginException {
        LoginContext loginContext = createLoginContext();
        loginContext.login();
        Subject subject = SecurityUtil.getSubject();
        user = (User) subject.getPublicCredentials().iterator().next();
        redirectIfNecessary();
        return "login_success";
    }

    public String logout() throws LoginException {
        LoginContext loginContext = createLoginContext();
        loginContext.logout();
        AppUtil.invalidateSession();
        this.user = null;
        return "logout_success";
    }

    private LoginContext createLoginContext() throws LoginException {
    	
        Subject subject = SecurityUtil.getSubject();
        Configuration conf = new LoginConfiguration(userService, user);
        return new LoginContext("scarfilun", subject, new HttpCallbackHandler(userName, password), conf);
    	//return new LoginContext("scarfilun", new HttpCallbackHandler(userName, password));
    }

    private void redirectIfNecessary() {
        if (redirectView != null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(redirectView);
                redirectView = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setRedirect(String value) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{authController.redirectView}", String.class).setValue(fc.getELContext(), value);
    }

    protected void publishException(Exception e) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExceptionQueuedEventContext eventContext = new ExceptionQueuedEventContext(ctx, e);
        ctx.getApplication().publishEvent(ctx, ExceptionQueuedEvent.class, eventContext);
    }
}
