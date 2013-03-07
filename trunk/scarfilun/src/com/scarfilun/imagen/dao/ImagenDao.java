package com.scarfilun.imagen.dao;

import com.scarfilun.imagen.model.Imagen;

public interface ImagenDao {

	byte[] getFoto(int idFoto);
	void addFoto(Imagen imagen);
}
