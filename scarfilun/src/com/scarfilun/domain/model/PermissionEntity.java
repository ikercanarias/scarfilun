package com.scarfilun.domain.model;

import javax.persistence.*;

import com.scarfilun.util.security.AuthorizationPermission;

import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "PERMISSIONS")
//@AttributeOverride(name = "id", column = @Column(name = "PERMISSION_ID"))
public class PermissionEntity extends AbstractEntity {

    private String name;
    private String description;

    private List<PermissionActionEntity> actions;

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(
            targetEntity = PermissionActionEntity.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "PERMS_ACTIONS",
            joinColumns = @JoinColumn(name = "PERMISSION_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTION_ID")
    )
    public List<PermissionActionEntity> getActions() {
        return actions;
    }

    public void setActions(List<PermissionActionEntity> actions) {
        this.actions = actions;
    }

    public java.security.Permission toPermision(){
        int mask = 0;
        if(actions != null){
            for(PermissionActionEntity a:actions){
                mask |=a.getMask();
            }
        }
        return new AuthorizationPermission(name, mask, description);
    }

    @Override
    public String toString() {
        return "PermissionEntity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", actions=" + actions +
                '}';
    }
}
