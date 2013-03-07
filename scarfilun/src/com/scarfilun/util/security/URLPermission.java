package com.scarfilun.util.security;

import java.security.BasicPermission;
import java.security.PermissionCollection;
import java.security.Permission;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("serial")
public class URLPermission extends BasicPermission {

    public URLPermission(String name) {
        super(name);
    }

//    public URLPermission(String name, String actions) {
//        super(name, actions);
//    }

    public PermissionCollection newPermissionCollection() {
        return new URLPermissionCollection();
    }
}

@SuppressWarnings("serial")
final class URLPermissionCollection extends PermissionCollection implements Serializable {

    private List<Permission> perms = new ArrayList<Permission>();

    public void add(Permission permission) {
        if (!(permission instanceof URLPermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        }
        if (isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");
        }
        synchronized (this) {
            perms.add(permission);
        }
    }

    public boolean implies(Permission permission) {
        if(permission instanceof URLPermission){
            synchronized (this){
                return perms.contains(permission);
            }
        }else{
            return false;
        }
    }

    public Enumeration<Permission> elements() {
        synchronized (this) {
            return Collections.enumeration(perms);
        }
    }
}
