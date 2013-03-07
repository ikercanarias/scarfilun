package com.scarfilun.service.impl;


import org.springframework.stereotype.Service;

import com.scarfilun.domain.dao.RoleDao;
import com.scarfilun.domain.model.RoleEntity;
import com.scarfilun.service.RoleService;

import javax.annotation.Resource;

@Service("roleService")
public class RoleServiceImpl extends GenericServiceSupport<RoleEntity, Long> implements RoleService {

    @Resource(name = "roleDao")
    private RoleDao dao;

    public RoleEntity getAnonymousRole() {
        return dao.findByName("ROLE_ANONYMOUS");
    }

    public RoleDao getDao() {
        return dao;
    }

    public void setDao(RoleDao dao) {
        this.dao = dao;
    }
}
