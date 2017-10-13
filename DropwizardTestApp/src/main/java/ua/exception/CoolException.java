package ua.exception;

import javax.ws.rs.core.Response.Status;

public class CoolException extends RuntimeException{

	private static final long serialVersionUID = 8332965891552440752L;

	private final Status status;

	public CoolException(String arg0, Status status) {
		super(arg0);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
}
