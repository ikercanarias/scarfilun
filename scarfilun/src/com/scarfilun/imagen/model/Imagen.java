package com.scarfilun.imagen.model;

@SuppressWarnings("serial")
public class Imagen implements java.io.Serializable {

	private int id;
	private byte[] foto;
	
	public Imagen() {
	}

	public Imagen(int id, byte[] foto) {
		this.id = id;
		this.foto = foto;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
