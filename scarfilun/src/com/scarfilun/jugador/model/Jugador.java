package com.scarfilun.jugador.model;

// Generated 11-nov-2011 13:04:17 by Hibernate Tools 3.4.0.CR1

/**
 * Jugador generated by hbm2java
 */
@SuppressWarnings("serial")
public class Jugador implements java.io.Serializable {

	private int id;
	private String nombre;
	private String descripcion;

	public Jugador() {
	}

	public Jugador(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
