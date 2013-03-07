package com.scarfilun.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.scarfilun.domain.dao.GenericDao;
import com.scarfilun.domain.exception.DaoException;
import com.scarfilun.domain.model.AbstractEntity;
import com.scarfilun.service.GenericService;
import com.scarfilun.util.exception.ServiceException;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public abstract class GenericServiceSupport<T extends AbstractEntity, PK extends Serializable> implements GenericService<T, PK> {

    protected static final Log log = LogFactory.getLog(GenericServiceSupport.class);

    public PK insert(T t) throws ServiceException {
        try {
            t.setCreationDate(new Timestamp(System.currentTimeMillis()));
            return getDao().insert(t);
        } catch (DaoException e) {
            log.error(e);
            throw new ServiceException(e);
        }
    }

    public void update(T t) throws ServiceException {
        try {
            getDao().update(t);
        } catch (DaoException e) {
            log.error(e);
            throw new ServiceException(e);
        }
    }

    public void delete(T t) throws ServiceException {
        try {
            getDao().delete(t);
        } catch (DaoException e) {
            log.error(e);
            throw new ServiceException(e);
        }
    }

    public T findById(PK pk) throws ServiceException {
        try {
            return getDao().findById(pk);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public List<T> getAll() throws ServiceException {
        try {
            return getDao().getAll();
        } catch (DaoException e) {
            log.error(e);
            throw new ServiceException(e);
        }
    }

    public abstract GenericDao<T, PK> getDao();
}
