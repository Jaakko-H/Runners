package com.spurtti.api.controller.user;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spurtti.api.controller.AbstractController;
import com.spurtti.api.dto.response.UserDto;
import com.spurtti.api.services.user.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(UserController.CONTEXT_PATH)
public class UserController extends AbstractController {
	
	protected static final String CONTEXT_PATH = AbstractController.CONTEXT_PATH + "/users";
	
	@Inject
	private UserService userService;
	
	@PostMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Create a new user")
	@ApiResponses({
		@ApiResponse(code = 200, message = "New user created.")
	})
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.create(userDto), HttpStatus.OK);
	}
}
