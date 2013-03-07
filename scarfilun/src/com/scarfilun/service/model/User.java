package com.scarfilun.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.scarfilun.domain.model.RoleEntity;
import com.scarfilun.domain.model.UserEntity;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private List<Role> roles = new ArrayList<Role>();

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.userName = userEntity.getUserName();
        this.firstName = userEntity.getDetails().getFirstName();
        this.lastName = userEntity.getDetails().getLastName();        
        for(RoleEntity re:userEntity.getRoles()){
            addRole(new Role(re));
        }
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return Collections.unmodifiableList(roles);
    }

    public void setRoles(List<Role> roles) {
        this.roles.clear();
        this.roles.addAll(roles);
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}
