package com.scarfilun.penya.bo;
 
import java.util.List;

import com.scarfilun.equipo.model.Equipo;
import com.scarfilun.penya.model.Penya;

 
public interface PenyaBo{

	List<Penya> findAllPenya();
	List<Penya> findPenyasByEquipo(Equipo equipo);
}