package com.make.assure.exceptions;

public class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = -786256830371391258L;

	public BaseException(String message) {
        super(message, new Throwable(message));
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
	

}

