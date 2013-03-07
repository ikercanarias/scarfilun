package com.scarfilun.equipo.dao.impl;
 
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scarfilun.equipo.dao.EquipoDao;
import com.scarfilun.equipo.model.Equipo;
 
public class EquipoDaoImpl extends 
       HibernateDaoSupport implements EquipoDao{
 
	public void addEquipo(Equipo equipo){

		getHibernateTemplate().save(equipo); 
	}
 
	@SuppressWarnings("unchecked")
	public List<Equipo> findAllEquipo(){
 
		return getHibernateTemplate().find("from Equipo");
	}

	@Override
	public void deleteEquipo(int idEquipo) {
		
		Equipo equipo = (Equipo)getHibernateTemplate().get(Equipo.class, new Integer(idEquipo));
		getHibernateTemplate().delete(equipo);
	}
}