package com.scarfilun.web.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.scarfilun.domain.model.UserEntity;
import com.scarfilun.service.UserService;
import com.scarfilun.util.security.Permissions;

import java.security.Permission;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
@ManagedBean(name = "accountController")
@RequestScoped
public class AccountController extends SecurityController {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    public List<UserEntity> getUsers() {
        try {
            return execute(new Callable<List<UserEntity>>() {
                public List<UserEntity> call() throws Exception {
                    return userService.getAll();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected Permission[] getPermisssions() {
        return new Permission[]{Permissions.ACCESS_MY_ACCOUNT, Permissions.UPDATE_MY_ACCOUNT};
    }
}
