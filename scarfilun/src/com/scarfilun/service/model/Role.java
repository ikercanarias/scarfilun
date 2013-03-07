package com.scarfilun.service.model;

import java.io.Serializable;
import java.security.Permission;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.scarfilun.domain.model.PermissionEntity;
import com.scarfilun.domain.model.RoleEntity;

public class Role implements Principal, Serializable {

	private static final long serialVersionUID = 1L;
	
    private String name;
    private List<Permission> permissions = new ArrayList<Permission>();

    public Role(RoleEntity roleEntity) {
        this.name = roleEntity.getName();
        for (PermissionEntity pe : roleEntity.getPermissions()) {
            addPermission(pe.toPermision());
        }
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Permission> getPermissions() {
        return Collections.unmodifiableList(permissions);
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions.clear();
        if (permissions != null) {
            this.permissions.addAll(permissions);
        }
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

}
