package com.scarfilun.service;

import com.scarfilun.domain.model.RoleEntity;

public interface RoleService extends GenericService<RoleEntity, Long>{

    RoleEntity getAnonymousRole();
}
