package com.spurtti.api.controller.user;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spurtti.api.dto.response.UserDto;
import com.spurtti.api.services.user.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Inject
	private UserService userService;
	
	@PostMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.create(userDto), HttpStatus.OK);
	}
}
