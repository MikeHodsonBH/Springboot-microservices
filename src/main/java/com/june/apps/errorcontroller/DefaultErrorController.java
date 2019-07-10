package com.june.apps.errorcontroller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultErrorController implements ErrorController {
	
	public static final String PATH = "/error";
	
	@RequestMapping(value = PATH)
	public String handleError() {
		return "404 Not Found";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
	
}
