package com.scarfilun.domain.dao;

import com.scarfilun.domain.model.UserEntity;

public interface UserDao extends GenericDao<UserEntity, Long>{

    UserEntity findByUserName(String userName);
}
