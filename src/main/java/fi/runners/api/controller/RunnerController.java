package fi.runners.api.controller;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.runners.api.entity.Runner;
import fi.runners.api.repositories.RunnerRepository;
import fi.runners.dtos.request.RunnerRequestObject;

@Controller
@RequestMapping("/runners")
public class RunnerController {
	
	@Inject
	private RunnerRepository runnerRepository;
	
	@PostMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Runner> saveRunner(@RequestBody RunnerRequestObject requestBody) {
		String uuid = UUID.randomUUID().toString();
		Runner runner = new Runner(uuid, requestBody.getName());
		runnerRepository.save(runner);
		return new ResponseEntity<>(runner, HttpStatus.OK);
	}
}
