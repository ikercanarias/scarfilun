package com.scarfilun.jugador.dao;
 
import java.util.List;

import com.scarfilun.jugador.model.Jugador;

 
public interface JugadorDao{
 
	void addJugador(Jugador jugador);
	void deleteJugador(int idJugador);
	List<Jugador> findAllJugador();
 
}