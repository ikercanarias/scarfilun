package com.scarfilun.penya.dao;
 
import java.util.List;

import com.scarfilun.equipo.model.Equipo;
import com.scarfilun.penya.model.Penya;

 
public interface PenyaDao{
 
	List<Penya> findAllPenya();
	List<Penya> findPenyasByEquipo(Equipo equipo);
}