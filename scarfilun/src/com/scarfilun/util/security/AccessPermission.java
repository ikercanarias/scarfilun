package com.scarfilun.util.security;

import java.security.Permission;

@SuppressWarnings("serial")
public class AccessPermission extends Permission{
    
    /**
     * Constructs a permission with the specified name.
     *
     * @param name name of the Permission object being created.
     */
    public AccessPermission(String name) {
        super(name);
    }

    public boolean implies(Permission permission) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean equals(Object obj) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int hashCode() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getActions() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
