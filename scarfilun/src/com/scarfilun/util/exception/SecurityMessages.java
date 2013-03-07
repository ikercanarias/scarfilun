package com.scarfilun.util.exception;

public enum SecurityMessages {

	ACCESS_FORBIDDEN("No tienes permisos para acceder a esta p�gina."),
	OPERATION_FORBIDDEN("No tienes permisos para realizar esta operaci�n.");
	
	private String message;
	
	private SecurityMessages(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
	
}
