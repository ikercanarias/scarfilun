package com.scarfilun.domain.dao;

import com.scarfilun.domain.model.RoleEntity;

public interface RoleDao extends GenericDao<RoleEntity, Long>{

    RoleEntity findByName(String roleName);
}
