package com.scarfilun.equipo.bo;
 
import java.util.List;

import com.scarfilun.equipo.model.Equipo;
 
public interface EquipoBo{
 
	void addEquipo(Equipo equipo);
	void deleteEquipo(int idEquipo);
	List<Equipo> findAllEquipo();
}