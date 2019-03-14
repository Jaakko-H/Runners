package com.spurtti.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spurtti.api.dto.response.UserDto;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "username")
	private String username;

	protected User() {}

	public User(UserDto userDto) {
		this.userId = userDto.getUserId();
		this.username = userDto.getUsername();
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
