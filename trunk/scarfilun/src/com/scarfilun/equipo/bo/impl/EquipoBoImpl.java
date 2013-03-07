package com.scarfilun.equipo.bo.impl;
 
import java.util.List;

import com.scarfilun.equipo.bo.EquipoBo;
import com.scarfilun.equipo.dao.EquipoDao;
import com.scarfilun.equipo.model.Equipo;
 
public class EquipoBoImpl implements EquipoBo{
 
	EquipoDao equipoDao;
 
	public void setEquipoDao(EquipoDao equipoDao) {
		this.equipoDao = equipoDao;
	}
 
	public void addEquipo(Equipo equipo){
 
		equipoDao.addEquipo(equipo);
	}
 
	public List<Equipo> findAllEquipo(){
 
		return equipoDao.findAllEquipo();
	}

	@Override
	public void deleteEquipo(int idEquipo) {
		equipoDao.deleteEquipo(idEquipo);
	}
}