package com.ektha.bootcamp.application;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.ektha.bootcamp.model.User;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class MyMessageBodyWriter implements MessageBodyWriter<User> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public long getSize(User t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return convertUserToString(t).length();
	}

	@Override
	public void writeTo(User t, Class<?> type, Type genericType, 
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
					throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		String output = convertUserToString(t);
		entityStream.write(output.getBytes());
	}

	private String convertUserToString(User t) {
		// TODO Auto-generated method stub
		return t.getUserId()+ "&" + t.getEmail();
	}

}
