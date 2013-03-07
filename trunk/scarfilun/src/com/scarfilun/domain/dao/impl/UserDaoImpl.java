package com.scarfilun.domain.dao.impl;


import org.springframework.stereotype.Repository;

import com.scarfilun.domain.dao.UserDao;
import com.scarfilun.domain.model.UserEntity;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoSupport<UserEntity, Long> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

    public UserEntity findByUserName(String userName) {
        String query = "from UserEntity u where upper(u.userName) = upper(:userName)";
        return executeQueryWithUniqueResult(query, new QueryParam("userName", userName));
    }
}
