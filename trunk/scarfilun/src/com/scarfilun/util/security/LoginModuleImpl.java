package com.scarfilun.util.security;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.scarfilun.service.UserService;
import com.scarfilun.service.model.Role;
import com.scarfilun.service.model.User;
import com.scarfilun.util.AppUtil;
import com.scarfilun.util.exception.ServiceException;

import java.io.IOException;
import java.util.Map;

public class LoginModuleImpl implements LoginModule {

    private UserService userService;
    private Subject subject;
    private CallbackHandler callbackHandler;
    private User user;

    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.userService = (UserService) options.get("userService");
        this.user = (User) options.get("user");
    }

    public boolean login() throws LoginException {
        NameCallback nameCallback = new NameCallback("Username");
        PasswordCallback passwordCallback = new PasswordCallback("Password", false);
        Callback[] callbacks = new Callback[]{nameCallback, passwordCallback};
        try {
            callbackHandler.handle(callbacks);
        } catch (IOException e) {
            e.printStackTrace();
            LoginException ex = new LoginException("IOException logging in.");
            ex.initCause(e);
            throw ex;
        } catch (UnsupportedCallbackException e) {
            String className = e.getCallback().getClass().getName();
            LoginException ex = new LoginException(className + " is not a supported Callback.");
            ex.initCause(e);
            throw ex;
        }
        String userName = nameCallback.getName();
        String password = String.valueOf(passwordCallback.getPassword());
        try {
            user = userService.login(userName, password);
            return true;
        } catch (ServiceException e) {
            throw new LoginException(e.getMessage());
        }
    }

    public boolean commit() throws LoginException {
        subject.getPublicCredentials().add(user);
        for (Role role : user.getRoles()) {
            subject.getPrincipals().add(role);
        }
        return true;
    }

    public boolean abort() throws LoginException {
        subject.getPublicCredentials().clear();
        subject.getPrincipals().clear();
        subject.getPrincipals().add(AppUtil.getAnonymousRole());
        user = null;
        return true;
    }

    public boolean logout() throws LoginException {
        try {
            userService.logout(user);
            return true;
        } catch (ServiceException e) {
            throw new LoginException("Can not execute logout process!!!");
        } finally {
            subject.getPublicCredentials().clear();
            subject.getPrincipals().clear();
            subject.getPrincipals().add(AppUtil.getAnonymousRole());
        }
    }
}
