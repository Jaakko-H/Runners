package com.spurtti.api.services.user;

import com.spurtti.api.dto.response.UserDto;

public interface UserService {

	/**
	 * Create a new user.
	 * 
	 * @param userDto - User DTO containing user data to be stored
	 * @return - User DTO representing saved user data
	 */
	UserDto create(UserDto userDto);
}
