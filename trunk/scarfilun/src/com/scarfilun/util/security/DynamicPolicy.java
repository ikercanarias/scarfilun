package com.scarfilun.util.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.scarfilun.service.model.Role;

import java.security.*;

@Component("dynamicPolicy")
public class DynamicPolicy extends Policy implements InitializingBean {

    private Policy deferredPolicy;

    public DynamicPolicy() {
        super();
        deferredPolicy = Policy.getPolicy();
    }

    public PermissionCollection getPermissions(ProtectionDomain domain) {
        PermissionCollection pc = deferredPolicy.getPermissions(domain);
        String location = domain.getCodeSource().getLocation().toString();
//        System.out.println(location+" ->> "+domain.getPrincipals().length);
        if (location.indexOf("scarfilun") > 0) {
            if (!pc.isReadOnly()) {
                for (Principal p : domain.getPrincipals()) {
                    Role role = (Role) p;
                    for (Permission perm : role.getPermissions()) {
                        pc.add(perm);
                    }
                }
            }
        }
        return pc;
    }

    public void refresh() {
        deferredPolicy.refresh();
    }

    public void afterPropertiesSet() throws Exception {
        Policy.setPolicy(this);
    }
}
