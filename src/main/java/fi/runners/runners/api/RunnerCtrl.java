package fi.runners.runners.api;

import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.runners.runners.dao.RunnerDAO;
import fi.runners.runners.dao.RunnerDAOImpl;
import fi.runners.runners.model.Runner;

@Controller
public class RunnerCtrl {
	
	@Inject
	private RunnerDAO runnerDAO;
	
	@Bean
	public RunnerDAOImpl getRunnerDAO() {
		return new RunnerDAOImpl();
	}
	
	public void setRunnerDAO(RunnerDAO runnerDAO) {
		this.runnerDAO = runnerDAO;
	}
	
	@RequestMapping(path="/runners/", method=RequestMethod.POST)
	public String saveRunner(HttpSession session, Model model,
			@RequestParam(required=true) String runnerName) {
		String uuid = UUID.randomUUID().toString();
		Runner r = new Runner(uuid, runnerName);
		runnerDAO.save(r);
		model.addAttribute("id");
		model.addAttribute("name");
		return "index";
	}
}
