package com.bycoders.cnabdemo.exceptions;

public class CnabdemoGenericException extends RuntimeException {
	public CnabdemoGenericException(String message) {
		super(message);
	}

	public CnabdemoGenericException(String message, Throwable cause) {
		super(message, cause);
	}
}