package com.scarfilun.penya.model;

// Generated 25-feb-2012 15:52:22 by Hibernate Tools 3.4.0.CR1

/**
 * PenyaId generated by hbm2java
 */
@SuppressWarnings("serial")
public class PenyaId implements java.io.Serializable {

	private int id;
	private int idEquipo;

	public PenyaId() {
	}

	public PenyaId(int id, int idEquipo) {
		this.id = id;
		this.idEquipo = idEquipo;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PenyaId))
			return false;
		PenyaId castOther = (PenyaId) other;

		return (this.getId() == castOther.getId())
				&& (this.getIdEquipo() == castOther.getIdEquipo());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getIdEquipo();
		return result;
	}

}
