package com.scarfilun.penya.bo.impl;
 
import java.util.List;

import com.scarfilun.equipo.model.Equipo;
import com.scarfilun.penya.bo.PenyaBo;
import com.scarfilun.penya.dao.PenyaDao;
import com.scarfilun.penya.model.Penya;

 
public class PenyaBoImpl implements PenyaBo{
 
	PenyaDao penyaDao;
 
	public void setPenyaDao(PenyaDao penyaDao) {
		this.penyaDao = penyaDao;
	}
 
	@Override
	public List<Penya> findAllPenya(){
 
		return penyaDao.findAllPenya();
	}

	@Override
	public List<Penya> findPenyasByEquipo(Equipo equipo) {
		
		return penyaDao.findPenyasByEquipo(equipo);
	}
}