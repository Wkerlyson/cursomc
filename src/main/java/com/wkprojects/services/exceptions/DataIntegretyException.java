package com.wkprojects.services.exceptions;

public class DataIntegretyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegretyException(String message) {
		super(message);
	}

	public DataIntegretyException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
