package com.june.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/")
public class CallWS {
	public static final String rBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:us=\"http://june.com/customerwsdlmodel\">" +
		    "<soapenv:Header/>" +
		    "<soapenv:Body>" + 
		    "   <us:getUserRequest>" + 
		    "       <us:name>NinaPark</us:name>" +
		    "   </us:getUserRequest>" +
		    "</soapenv:Body>" +
		    "</soapenv:Envelope>";
	
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@PostMapping("/getWs") 
	public ResponseEntity<String> getUserWithRest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_XML);
		
		try {
			String result = webClientBuilder.build()
					.post()
					.uri("http://localhost:9090/customerWS/users") 
					.accept(MediaType.TEXT_XML)
					.contentType(MediaType.TEXT_XML)
					.body(BodyInserters.fromObject(rBody))
					.retrieve()
					.bodyToMono(String.class)
					.block();
			return ResponseEntity.ok().headers(headers).body(result);
		} catch(Exception e) {
			return ResponseEntity.ok().body(e.toString());
		}
	}
	
	@PostMapping("/theSoapConnectorWay")
	public String getUserWithModels() {
		return null;
	}
	
}