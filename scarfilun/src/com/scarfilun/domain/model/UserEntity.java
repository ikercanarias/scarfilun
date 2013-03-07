package com.scarfilun.domain.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings("serial")
@Entity
@Table(name = "USERS")
public class UserEntity extends AbstractEntity {

    private String userName;
    private String password;
    private boolean online;
    @Embedded
    private UserDetailsEntity details;
    @Embedded
    private UserAddressEntity address;

    private Collection<RoleEntity> roles;

    @Column(name = "USERNAME", nullable = false, unique = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "IS_ONLINE", nullable = false, length = 1)
    @Type(type = "yes_no")
    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public UserDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(UserDetailsEntity details) {
        this.details = details;
    }

    public UserAddressEntity getAddress() {
        return address;
    }

    public void setAddress(UserAddressEntity address) {
        this.address = address;
    }

    @ManyToMany(
            targetEntity = RoleEntity.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    public Collection<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleEntity> roles) {
        this.roles = roles;
    }
}
