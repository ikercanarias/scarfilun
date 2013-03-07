package com.scarfilun.service.impl;


import javax.annotation.Resource;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.scarfilun.domain.dao.UserDao;
import com.scarfilun.domain.exception.DaoException;
import com.scarfilun.domain.model.UserEntity;
import com.scarfilun.service.UserService;
import com.scarfilun.service.model.User;
import com.scarfilun.util.exception.ServiceException;

@Service("userService")
public class UserServiceImpl extends GenericServiceSupport<UserEntity, Long> implements UserService {

    @Resource(name = "userDao")
    private UserDao dao;

    public User login(String userName, String password) throws ServiceException, LoginException {
        UserEntity userEntity = dao.findByUserName(userName);
        if (userEntity == null) {
            throw new CredentialNotFoundException("El usuario '"+userName+"' no se ha encontrado.");
        } else if (!userEntity.getPassword().equals(password)) {
            throw new CredentialNotFoundException("La contraseña es incorrecta.");
        } else {
            userEntity.setOnline(true);
            try {
                dao.update(userEntity);
            } catch (DaoException e) {
                log.error(e.getMessage(), e);
                throw new ServiceException(e);
            }
            return new User(userEntity);
        }
    }

    public void logout(User user) throws ServiceException {
        try {
            UserEntity userEntity = dao.findById(user.getId());
            userEntity.setOnline(false);
            dao.update(userEntity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
