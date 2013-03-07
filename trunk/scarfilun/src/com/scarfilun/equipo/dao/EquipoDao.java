package com.scarfilun.equipo.dao;
 
import java.util.List;

import com.scarfilun.equipo.model.Equipo;
 
public interface EquipoDao{
 
	void addEquipo(Equipo equipo);
	void deleteEquipo(int idEquipo);
	List<Equipo> findAllEquipo();
 
}