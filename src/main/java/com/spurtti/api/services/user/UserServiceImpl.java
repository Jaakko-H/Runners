package com.spurtti.api.services.user;

import javax.inject.Inject;
import javax.inject.Named;

import com.spurtti.api.dto.response.UserDto;
import com.spurtti.api.entity.User;
import com.spurtti.api.repositories.UserRepository;

@Named
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserRepository userRepository;

	@Override
	public UserDto create(UserDto userDto) {
		return new UserDto(userRepository.save(new User(userDto)));
	}
}
