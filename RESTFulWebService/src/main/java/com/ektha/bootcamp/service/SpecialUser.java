package com.ektha.bootcamp.service;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;

public class SpecialUser {
	
	@PUT
	public void createSpecialUser(){
		System.out.println("CREATE SPECIAL USER");
	}
	
	@GET
	public void getSpecialUser(){
		System.out.println("GET SPECIAL USER");
	}
}
