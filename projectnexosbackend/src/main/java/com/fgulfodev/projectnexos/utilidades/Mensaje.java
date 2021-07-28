package com.fgulfodev.projectnexos.utilidades;

public class Mensaje {
	
	private String msg;
	private Boolean error;
	private Boolean suces;
	
	public Mensaje() {
		
	}

	public Mensaje(String msg, Boolean error, Boolean suces) {
		super();
		this.msg = msg;
		this.error = error;
		this.suces = suces;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}
}
