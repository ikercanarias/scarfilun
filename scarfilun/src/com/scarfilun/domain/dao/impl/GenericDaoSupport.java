package com.scarfilun.domain.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.scarfilun.domain.dao.GenericDao;
import com.scarfilun.domain.exception.DaoException;
import com.scarfilun.domain.model.AbstractEntity;

public abstract class GenericDaoSupport<T extends AbstractEntity, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK>{

    protected static Log log = LogFactory.getLog(GenericDaoSupport.class);
	private Class<T> clazz;
	
	public GenericDaoSupport(Class<T> clazz){
		this.clazz = clazz;
	}
	
	@SuppressWarnings("unchecked")
	public T findById(PK pk) throws DaoException {
        log.debug("find object with id = " + pk.toString());
        return (T) getHibernateTemplate().get(clazz, pk);
    }

	@SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
        log.debug("get all records for " + clazz.getSimpleName());
        return (List<T>) getHibernateTemplate().find("from "+clazz.getSimpleName());
    }

	@SuppressWarnings("unchecked")
    public List<T> getByCriteria(Criterion... criterions) throws DaoException {
        if(criterions==null || criterions.length==0){
            return getAll();
        }
        Criteria criteria = getSession().createCriteria(clazz);
        for(Criterion c:criterions){
            criteria.add(c);
        }
        log.debug("get all records by criteria for " + clazz.getSimpleName());
        return (List<T>) criteria.list();
    }

	@SuppressWarnings("unchecked")
    public List<T> getByCriteria(Criterion[] criterions, Order... orders) throws DaoException {
        if(orders==null || orders.length==0){
            return getByCriteria(criterions);
        }
        Criteria criteria = getSession().createCriteria(clazz);
        for(Criterion c:criterions){
            criteria.add(c);
        }
        for(Order order:orders){
            criteria.addOrder(order);
        }
        log.debug("get all records by criteria and order for " + clazz.getSimpleName());
        return (List<T>) criteria.list();
    }

	@SuppressWarnings("unchecked")
    public PK insert(T t) throws DaoException {
        log.debug("insert object " + t.toString());
        return (PK)getHibernateTemplate().save(t);
    }

    public void update(T t) throws DaoException {
        log.debug("update object " + t.toString());
        getHibernateTemplate().update(t);
    }

    public void delete(T t) throws DaoException {
        log.debug("delete object " + t.toString());
        getHibernateTemplate().delete(t);
    }

    @SuppressWarnings("unchecked")
    protected T executeQueryWithUniqueResult(String query, QueryParam... params) {
        return (T) getHibernateTemplate().execute(new QueryExecutor(query, params, true));
    }

    @SuppressWarnings("unchecked")
    protected List<T> executeQueryWithMultipleResult(String query, QueryParam... params) {
        return (List<T>) getHibernateTemplate().execute(new QueryExecutor(query, params, false));
    }

    private class QueryExecutor implements HibernateCallback {

        private String queryString;
        private QueryParam[] params;
        private boolean uniqueResult;

        QueryExecutor(String queryString, QueryParam[] params, boolean uniqueResult) {
            this.queryString = queryString;
            this.params = params;
            this.uniqueResult = uniqueResult;
        }

        @SuppressWarnings("rawtypes")
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
            Query query = session.createQuery(queryString);
            if (params != null && params.length > 0) {
                for (QueryParam param : params) {
                    if (param.value instanceof Collection) {
                        query.setParameterList(param.name, (Collection) param.value);
                    } else {
                        query.setParameter(param.name, param.value);
                    }
                }
            }
            if (uniqueResult) {
                return query.uniqueResult();
            } else {
                return query.list();
            }
        }
    }
}
