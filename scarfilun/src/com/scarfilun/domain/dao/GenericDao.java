package com.scarfilun.domain.dao;

import java.io.Serializable;
import java.util.List;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.scarfilun.domain.exception.DaoException;
import com.scarfilun.domain.model.AbstractEntity;

public interface GenericDao<T extends AbstractEntity, PK extends Serializable> {

    PK insert(T t) throws DaoException;

    void update(T t) throws DaoException;

    void delete(T t) throws DaoException;

    T findById(PK pk) throws DaoException;

    List<T> getAll() throws DaoException;

    List<T> getByCriteria(Criterion... criteria) throws DaoException;

    List<T> getByCriteria(Criterion[] criteria, Order... order) throws DaoException;
    

}
