package com.june.apps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.june.apps.schemas.customer.*;

@RestController
public class RestEndpointController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public SOAPConnector soapConnector;
	
	@PostMapping("/getCustomer")
	public GetUserResponse user(@RequestParam String userName) {
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warn message");
		logger.error("Error message");
		
		
		GetUserRequest request = new GetUserRequest();
		request.setName(userName);
		GetUserResponse response = (GetUserResponse)soapConnector.callWebService("http://localhost:9090/customerWS/users", request);
		return response;
	}
	
	@RequestMapping("/")
	public String defaultEndpoint() {
		return "<em>Giddy up Roach :D <br> Sucks to be you, aye?</em>";
	}
	
}






















































