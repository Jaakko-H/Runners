package com.spurtti.api.dto.response;

import java.util.UUID;

import org.springframework.data.annotation.ReadOnlyProperty;

import com.spurtti.api.entity.User;

public class UserDto {
	
	@ReadOnlyProperty
	private String userId;
	
	private String username;

	public UserDto() {
		this.userId = UUID.randomUUID().toString();
		this.username = "";
	}

	public UserDto(User entity) {
		this.userId = entity.getUserId();
		this.username = entity.getUsername();
	}

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
