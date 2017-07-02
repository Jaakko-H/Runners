package fi.runners.runners.api;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileCtrl {
	
	@RequestMapping(path="/uploadfilecontents/", method=RequestMethod.POST)
	public void uploadFileContents(HttpSession session) {
		
	}
}
