package com.scarfilun.jugador.bo.impl;
 
import java.util.List;

import com.scarfilun.jugador.bo.JugadorBo;
import com.scarfilun.jugador.dao.JugadorDao;
import com.scarfilun.jugador.model.Jugador;

 
public class JugadorBoImpl implements JugadorBo{
 
	JugadorDao jugadorDao;
 
	public void setJugadorDao(JugadorDao jugadorDao) {
		this.jugadorDao = jugadorDao;
	}
 
	public void addJugador(Jugador jugador){
 
		jugadorDao.addJugador(jugador);
	}
 
	public List<Jugador> findAllJugador(){
 
		return jugadorDao.findAllJugador();
	}

	@Override
	public void deleteJugador(int idJugador) {
		jugadorDao.deleteJugador(idJugador);
	}
}