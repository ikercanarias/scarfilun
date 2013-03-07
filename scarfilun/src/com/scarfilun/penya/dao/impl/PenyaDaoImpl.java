package com.scarfilun.penya.dao.impl;
 
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scarfilun.equipo.model.Equipo;
import com.scarfilun.penya.dao.PenyaDao;
import com.scarfilun.penya.model.Penya;

 
public class PenyaDaoImpl extends 
       HibernateDaoSupport implements PenyaDao{
 
 
	@SuppressWarnings("unchecked")
	@Override
	public List<Penya> findAllPenya(){
 
		return getHibernateTemplate().find("from Penya order by nombre");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Penya> findPenyasByEquipo(Equipo equipo){
 
		return getHibernateTemplate().find("from Penya where equipo = " + equipo.getId() + " order by nombre");
	}
}