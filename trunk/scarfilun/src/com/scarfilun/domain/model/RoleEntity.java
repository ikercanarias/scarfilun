package com.scarfilun.domain.model;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings("serial")
@Entity
@Table(name = "ROLES")
public class RoleEntity extends AbstractEntity {

    private String name;
    private Collection<PermissionEntity> permissions;

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(
            targetEntity = PermissionEntity.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "ROLES_PERMISSIONS",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID")
    )
    public Collection<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        if(permissions!=null){
            for(PermissionEntity p:permissions){
                sb.append(p.toString()).append("; ");
            }
        }
        sb.append("]");
        return "Role{" +
                "name='" + name + '\'' +
                ", rolePermissions=" + sb +
                '}';
    }
}
