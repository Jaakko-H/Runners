package fi.runners.api.controller;

import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.runners.api.entity.Runner;
import fi.runners.api.repositories.RunnerRepository;

@Controller
@RequestMapping("/runners")
public class RunnerCtrl {
	
	@Inject
	private RunnerRepository runnerRepository;
	
	@PostMapping(path="/", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String saveRunner(HttpSession session, Model model,
			@RequestParam(required=true) String runnerName) {
		String uuid = UUID.randomUUID().toString();
		Runner r = new Runner(uuid, runnerName);
		runnerRepository.save(r);
		model.addAttribute("id");
		model.addAttribute("name");
		return "index";
	}
}
