package com.scarfilun.jugador;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.scarfilun.jugador.bo.JugadorBo;
import com.scarfilun.jugador.model.Jugador;


@SuppressWarnings("serial")
@ManagedBean(name = "jugador")
@RequestScoped
public class JugadorBean implements java.io.Serializable {

	//DI via Spring
	@ManagedProperty(value = "#{jugadorBo}")
	JugadorBo jugadorBo;
	
	private String nombre;
	private String descripcion;
	private Date date1;

	public JugadorBean() {
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
	
	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setJugadorBo(JugadorBo jugadorBo) {
		this.jugadorBo = jugadorBo;
	}
 
	//get all customer data from database
	public List<Jugador> getJugadorList(){
		return jugadorBo.findAllJugador();
	}
	
	//add a new customer data into database
	public String addJugador(){
		
		Jugador jugador = new Jugador();
		jugador.setNombre(getNombre());
		jugador.setDescripcion(getDescripcion());
		
		jugadorBo.addJugador(jugador);
		
		clearForm();
		
		return "";
	}
	
	public void deleteJugador(int idJugador){
		System.out.println("deleteJugador: " + idJugador);
		jugadorBo.deleteJugador(idJugador);
	}
	
	//clear form values
	public void clearForm(){
		setNombre("");
		setDescripcion("");
	}
}
