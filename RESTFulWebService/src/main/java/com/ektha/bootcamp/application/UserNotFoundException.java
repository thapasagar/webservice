package com.ektha.bootcamp.application;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

public class UserNotFoundException extends Exception {

	private StatusType errorCode = Response.Status.NOT_FOUND;
	private String errorMessage = "User Couldn't be Found anywhere";

	public StatusType getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(StatusType errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
