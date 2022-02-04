package com.bycoders.cnabdemo.utils;

import org.springframework.http.HttpStatus;

public class ResourceResponseUtil {

	private HttpStatus status;
	private int statusCode;
	private String message;
	private Object payload;
	
	public ResourceResponseUtil() {
		super();
	}
	public ResourceResponseUtil(HttpStatus status, String mensagem, Object payload) {
		super();
		this.status = status;
		this.message = mensagem;
		this.payload = payload;
		this.statusCode = status.value();
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String mensagem) {
		this.message = mensagem;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
