package com.june.apps;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.june.apps.schemas.customer.GetUserRequest;
import com.june.apps.schemas.customer.GetUserResponse;

@RestController
@RequestMapping("/customerWS")
public class RestEndpointController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public SOAPConnector soapConnector;
	
	@PostMapping("/getCustomer")
	public GetUserResponse user(@RequestBody GetUserRequest userObj) {
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warn message");
		logger.error("Error message");
		
		GetUserResponse response = (GetUserResponse)soapConnector.callWebService("http://localhost:9090/customerWS/users", userObj);
		return response;
	}
	
	GraphicsProcessors responseObj = new GraphicsProcessors();
	Headers requestHeaders = new Headers();
	public void populateResponseObject(Map<String, String> headerObj) {
		responseObj.setNvidia("GeForce RTX 2080");
		responseObj.setAmd("Radeon RX 5700");
		responseObj.setIntel("Intel HD 620");
		
		/*Add headers Key-value Map to response Object*/
		requestHeaders.setRequestHeaders(headerObj);
		responseObj.setHeaders(requestHeaders);
	}
	
	@GetMapping("/getGraphicProcessors")
	public ResponseEntity<GraphicsProcessors> defaultEndpoint(@RequestHeader Map<String, String> headerObj) {
		
		/*Custom Headers*/
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");
	
		/*Access Request Headers*/
		populateResponseObject(headerObj);		
		return new ResponseEntity<GraphicsProcessors>(responseObj, httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/404d")
	public ResponseEntity<Void> httpTestStatus() {		
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/validateSourceApp")
	public String interceptorTest(@RequestHeader Map<String, String> headersObj, @RequestParam String param) {
		return String.format("Auth key is: %s || Invoking System is %s ", headersObj.get("user-auth-key"), headersObj.get("app-name"));
	}
	
	/*
	 * public String interceptorTest(@RequestHeader("user-auth-key") String authkey, @RequestBody String param) {
		return String.format("Auth key is %s :", authkey) + "Request Param = " + param;
	}
	 * defaultValue can be used optionally to set default value for optional header
	 * check (optionalHeader.equals(3600)) to determine whether the header has been provided.
	 * @RequestHeader(value = "optional-header", defaultValue = "3600") int optionalHeader)
	 * public ResponseEntity<String> evaluateRequiredHeader(@RequestHeader(value="App-Name", required = false) String appName) {
		return new ResponseEntity<String>((appName.equals("Cool App") || appName.equals("Grand Aries") || appName.equals("Ancient Stitch")) ? "Valid" : "Nice Try :D ", HttpStatus.OK);
	}
	*/
	
}






















































