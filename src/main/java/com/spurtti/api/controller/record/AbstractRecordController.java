package com.spurtti.api.controller.record;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spurtti.api.controller.AbstractController;

@Controller
public abstract class AbstractRecordController {

	protected static final String CONTEXT_PATH = AbstractController.CONTEXT_PATH + "/records";
}
