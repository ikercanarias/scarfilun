package com.scarfilun.util.exception;

public enum SecurityMessages {

	ACCESS_FORBIDDEN("No tienes permisos para acceder a esta página."),
	OPERATION_FORBIDDEN("No tienes permisos para realizar esta operación.");
	
	private String message;
	
	private SecurityMessages(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
	
}
