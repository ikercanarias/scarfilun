package com.scarfilun.imagen.bo.impl;

import com.scarfilun.imagen.bo.ImagenBo;
import com.scarfilun.imagen.dao.ImagenDao;
import com.scarfilun.imagen.model.Imagen;

public class ImagenBoImpl implements ImagenBo{

	ImagenDao imagenDao;
	
	@Override
	public byte[] getFoto(int idFoto) {
		
		return imagenDao.getFoto(idFoto);
	}

	@Override
	public void addFoto(Imagen imagen) {
		
		imagenDao.addFoto(imagen);
	}
	
	public void setImagenDao(ImagenDao imagenDao) {
		this.imagenDao = imagenDao;
	}
}
