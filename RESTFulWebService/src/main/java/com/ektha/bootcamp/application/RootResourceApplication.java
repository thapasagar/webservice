package com.ektha.bootcamp.application;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import com.ektha.bootcamp.service.UserService;

public class RootResourceApplication extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rootClassSet = new HashSet<Class<?>>();
		rootClassSet.add(UserService.class);
		rootClassSet.add(MyMessageBodyReader.class);
		rootClassSet.add(MyMessageBodyWriter.class);
		rootClassSet.add(UserNotFoundExceptionMapper.class);
		
		return rootClassSet;
	}
}
