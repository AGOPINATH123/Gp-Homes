package com.react.swag.exception.entity;

import org.springframework.http.HttpStatus;

public class Exceptionentity {

	private String messege;
	
	private HttpStatus status;

	public Exceptionentity(String messege, HttpStatus status) {
		super();
		this.messege = messege;
		this.status = status;
	}

	public Exceptionentity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
	
	
}
