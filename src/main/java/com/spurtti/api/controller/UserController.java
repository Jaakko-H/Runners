package com.spurtti.api.controller;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spurtti.api.entity.User;
import com.spurtti.api.repositories.UserRepository;
import com.spurtti.dtos.request.UserRequestObject;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Inject
	private UserRepository userRepository;
	
	@PostMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveRunner(@RequestBody UserRequestObject requestBody) {
		String uuid = UUID.randomUUID().toString();
		User user = new User(uuid, requestBody.getName());
		userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
