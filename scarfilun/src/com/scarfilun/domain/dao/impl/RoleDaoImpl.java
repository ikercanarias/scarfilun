package com.scarfilun.domain.dao.impl;


import org.springframework.stereotype.Repository;

import com.scarfilun.domain.dao.RoleDao;
import com.scarfilun.domain.model.RoleEntity;

@Repository("roleDao")
public class RoleDaoImpl extends GenericDaoSupport<RoleEntity, Long> implements RoleDao {

	public RoleDaoImpl() {
		super(RoleEntity.class);
	}

    public RoleEntity findByName(String roleName) {
        String query = "from RoleEntity where name = :roleName";
        return executeQueryWithUniqueResult(query, new QueryParam("roleName", roleName));
    }
}
