package com.ektha.bootcamp.application;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.spi.ExceptionMappers;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

	@Override
	public Response toResponse(UserNotFoundException exception) {
		
		return Response.status(exception.getErrorCode()).entity(exception.getErrorMessage()).build();
	}



}
