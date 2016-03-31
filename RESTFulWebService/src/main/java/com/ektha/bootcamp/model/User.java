package com.ektha.bootcamp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String userId;
	private String email;
	private String userIdEmail;

	public String getUserIdEmail() {
		return userIdEmail;
	}

	public void setUserIdEmail(String userIdEmail) {
		this.userIdEmail = userIdEmail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
