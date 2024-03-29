package com.scarfilun.equipo.model;

// Generated 11-nov-2011 13:04:17 by Hibernate Tools 3.4.0.CR1

/**
 * Equipo generated by hbm2java
 */
@SuppressWarnings("serial")
public class Equipo implements java.io.Serializable {

	private int id;
	private String nombre;
	private String url;
	private String parser;
	private String imagen;

	public Equipo() {
	}

	public Equipo(int id, String nombre, String url, String parser, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.parser = parser;
		this.imagen = imagen;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParser() {
		return this.parser;
	}

	public void setParser(String parser) {
		this.parser = parser;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
