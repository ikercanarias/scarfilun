package com.scarfilun.imagen.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scarfilun.imagen.dao.ImagenDao;
import com.scarfilun.imagen.model.Imagen;

public class ImagenDaoImpl extends 
	HibernateDaoSupport implements ImagenDao{

	@Override
	public byte[] getFoto(int idFoto) {
		
		Imagen imagen = (Imagen)getHibernateTemplate().get(Imagen.class, new Integer(idFoto));
		return imagen.getFoto();
	}
	
	@Override
	public void addFoto(Imagen imagen) {
		
		getHibernateTemplate().save(imagen);
	}
}
