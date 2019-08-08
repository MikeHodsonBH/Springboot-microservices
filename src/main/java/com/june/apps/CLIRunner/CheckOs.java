package com.june.apps.CLIRunner;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CheckOs {
	
	@GetMapping("/getOsDetails")
	public String getOs() throws IOException, InterruptedException {
		
		   return System.getProperty("os.name");
		 
		
	}
	
}
