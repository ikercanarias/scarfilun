package com.scarfilun.service;

import javax.security.auth.login.LoginException;

import com.scarfilun.domain.model.UserEntity;
import com.scarfilun.service.model.User;
import com.scarfilun.util.exception.ServiceException;
import com.scarfilun.util.security.PermissionType;
import com.scarfilun.util.security.SecurityConstraint;

import java.util.List;

public interface UserService extends GenericService<UserEntity, Long>{

    @SecurityConstraint(permissions = {PermissionType.CREATE_USER})
    Long insert(UserEntity userEntity) throws ServiceException;

    @SecurityConstraint(permissions = {PermissionType.UPDATE_USER})
    void update(UserEntity userEntity) throws ServiceException;

    @SecurityConstraint(permissions = {PermissionType.DELETE_USER})
    void delete(UserEntity userEntity) throws ServiceException;

    @SecurityConstraint(permissions = {PermissionType.VIEW_USER})
    UserEntity findById(Long aLong) throws ServiceException;

    @SecurityConstraint(permissions = {PermissionType.VIEW_USERS_LIST})
    List<UserEntity> getAll() throws ServiceException;

    User login(String userName, String password) throws ServiceException, LoginException;

    void logout(User user) throws ServiceException;
}
