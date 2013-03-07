package com.scarfilun.util.exception;

public class SecurityViolationException extends ServiceException{

	private static final long serialVersionUID = 1L;
	
    public SecurityViolationException() {
    }

    public SecurityViolationException(SecurityMessages message) {
        super(message.toString());
    }

    public SecurityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityViolationException(Throwable cause) {
        super(cause);
    }
}
