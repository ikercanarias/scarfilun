package com.scarfilun.service;

import java.io.Serializable;
import java.util.List;

import com.scarfilun.domain.model.AbstractEntity;
import com.scarfilun.util.exception.ServiceException;

public interface GenericService<T extends AbstractEntity, PK extends Serializable> {

    PK insert(T t) throws ServiceException;

    void update(T t) throws ServiceException;

    void delete(T t) throws ServiceException;

    T findById(PK pk) throws ServiceException;

    List<T> getAll() throws ServiceException;
}
