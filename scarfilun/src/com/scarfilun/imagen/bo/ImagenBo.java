package com.scarfilun.imagen.bo;

import com.scarfilun.imagen.model.Imagen;


public interface ImagenBo {

	byte[] getFoto(int idFoto);
	void addFoto(Imagen imagen);
}
