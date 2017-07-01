package fi.runners.runners.api;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainCtrl {
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getFrontPage(HttpSession session) {
		System.out.println("foo");
		return "index";
	}
}
