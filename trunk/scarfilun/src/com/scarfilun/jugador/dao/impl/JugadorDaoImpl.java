package com.scarfilun.jugador.dao.impl;
 
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scarfilun.jugador.dao.JugadorDao;
import com.scarfilun.jugador.model.Jugador;

 
public class JugadorDaoImpl extends 
       HibernateDaoSupport implements JugadorDao{
 
	public void addJugador(Jugador jugador){

		getHibernateTemplate().save(jugador); 
	}
 
	@SuppressWarnings("unchecked")
	public List<Jugador> findAllJugador(){
 
		return getHibernateTemplate().find("from Jugador");
	}

	@Override
	public void deleteJugador(int idJugador) {
		
		Jugador jugador = (Jugador)getHibernateTemplate().get(Jugador.class, new Integer(idJugador));
		getHibernateTemplate().delete(jugador);
	}
}