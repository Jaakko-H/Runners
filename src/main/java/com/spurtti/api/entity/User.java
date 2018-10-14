package com.spurtti.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "username")
	private String username;

	protected User() {}

	public User(String userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
