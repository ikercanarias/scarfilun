package com.scarfilun.jugador.bo;
 
import java.util.List;

import com.scarfilun.jugador.model.Jugador;

 
public interface JugadorBo{
 
	void addJugador(Jugador jugador);
	void deleteJugador(int idJugador);
	List<Jugador> findAllJugador();
}