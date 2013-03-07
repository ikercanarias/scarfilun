package com.scarfilun.equipo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.scarfilun.equipo.bo.EquipoBo;
import com.scarfilun.equipo.model.Equipo;

@SuppressWarnings("serial")
@ManagedBean(name = "equipo")
@RequestScoped
public class EquipoBean implements java.io.Serializable {

	@ManagedProperty(value = "#{equipoBo}")
	EquipoBo equipoBo;
	
	private String nombre;
	private String url;
	private String parser;
	private String imagen;
	
	public EquipoBean() {
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

	public void setEquipoBo(EquipoBo equipoBo) {
		this.equipoBo = equipoBo;
	}
 
	public List<Equipo> getEquipoList(){
		return equipoBo.findAllEquipo();
	}
	
	public String addEquipo(){
		
		Equipo equipo = new Equipo();
		equipo.setNombre(getNombre());
		equipo.setParser(getParser());
		equipo.setUrl(getUrl());
		
		equipoBo.addEquipo(equipo);
		
		clearForm();
		
		return "";
	}
	
	public void deleteEquipo(int idEquipo){
		System.out.println("deleteEquipo: " + idEquipo);
		equipoBo.deleteEquipo(idEquipo);
	}
	
	//clear form values
	public void clearForm(){
		setNombre("");
		setParser("");
		setUrl("");
	}
}
