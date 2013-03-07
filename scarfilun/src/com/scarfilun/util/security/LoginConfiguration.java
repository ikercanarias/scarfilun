package com.scarfilun.util.security;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

import com.scarfilun.service.UserService;
import com.scarfilun.service.model.User;

import java.util.HashMap;
import java.util.Map;

public class LoginConfiguration extends Configuration {

    private UserService userService;
    private User user;

    public LoginConfiguration(UserService userService, User user) {
        this.userService = userService;
        this.user = user;
    }

    public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("userService", userService);
        values.put("user", user);
        AppConfigurationEntry ace = new AppConfigurationEntry(LoginModuleImpl.class.getName(), AppConfigurationEntry.LoginModuleControlFlag.REQUIRED, values);
        return new AppConfigurationEntry[]{ace};
    }
}
