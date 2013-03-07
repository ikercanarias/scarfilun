package com.scarfilun.penya;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.scarfilun.equipo.model.Equipo;
import com.scarfilun.penya.bo.PenyaBo;
import com.scarfilun.penya.model.Penya;

@SuppressWarnings("serial")
@ManagedBean(name = "penya")
@SessionScoped
public class PenyaBean implements java.io.Serializable {

	@ManagedProperty(value = "#{penyaBo}")
	PenyaBo penyaBo;

	private String nombre;
	private String direccion;
	private String lugarIdentificador;
	private String fechaFundacion;
	private String personaContacto;
	private String telefono;
	private String fax;
	private String email;
	private String web;
	private String numMiembros;
	private String numSocios;
	
	List<Penya> penyas = new ArrayList<Penya>();
	
	public PenyaBo getPenyaBo() {
		return penyaBo;
	}

	public void setPenyaBo(PenyaBo penyaBo) {
		this.penyaBo = penyaBo;
	}

	public void setSelectedEquipo(int selectedEquipo) {
		
		Equipo equipo = new Equipo();
		equipo.setId(selectedEquipo);
		penyas =  penyaBo.findPenyasByEquipo(equipo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLugarIdentificador() {
		return lugarIdentificador;
	}

	public void setLugarIdentificador(String lugarIdentificador) {
		this.lugarIdentificador = lugarIdentificador;
	}

	public String getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(String fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getNumMiembros() {
		return numMiembros;
	}

	public void setNumMiembros(String numMiembros) {
		this.numMiembros = numMiembros;
	}

	public String getNumSocios() {
		return numSocios;
	}

	public void setNumSocios(String numSocios) {
		this.numSocios = numSocios;
	}
	
	public List<Penya> getPenyaList(){

		return penyas;
	}
}
