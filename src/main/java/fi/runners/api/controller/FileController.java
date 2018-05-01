package fi.runners.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/file")
public class FileController {
	
	@RequestMapping(path="/uploadContent", method=RequestMethod.POST)
	public ResponseEntity<Object> uploadFileContents(HttpSession session) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
