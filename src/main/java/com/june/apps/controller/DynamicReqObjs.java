package com.june.apps.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.june.apps.models.Request;
import com.june.apps.models.ResponseParser;
import com.june.apps.models.Utils;

@RestController
@RequestMapping("/dReqs")
public class DynamicReqObjs {
	
	private static final Logger logger = LoggerFactory.getLogger(DynamicReqObjs.class);
	
	@GetMapping("/request")
	public ResponseEntity<ResponseParser> parseRequest(@RequestBody(required = false) Request request) throws Exception {
		
		/* User input*/
		String ci = request.getCi();
		String change = request.getProfileChange();
		List<String> contentToFilter = request.getContentToFilter();
		
		/*
		
		 //validate source app
		Validations.removeAuthorizationHeaders(httpHeaders);
		List<String> validApps = Array.asList(configProperties.getAcceptedApps().split("\\s*,\\s*"));
		List<String> appHeader = (httpHeaders.get("X-App") == null) ? httpHeaders.get("x-app") : httpHeaders.get("X-App");
		String app = (appHeader==null) ? "" : appHeader.get(0);
		
		if(!(Validations.invalidAppName(app, validApps))) {
			
			 process payload
			
		}
		logger.error("TransactionType=doProfileChanges | SourceSystem=ms-securenet | TargetSystem=Allot | response = {} | message = Invalid Source App", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ResponseParser>(new ResponseParser(null, errormessage);
		 */
		
		try {
			if(Utils.isCiValid(ci)) {
				try {
					if(Utils.isChangeValid(change)) {
						/* Soap Request Parameter */
						String changeStr = "";
						ci += "@gpon";
						
						if(Utils.doesContentFiltering(change)) {
							try {
								if(Utils.isFilterValid(contentToFilter)) {
									changeStr = Utils.buildURLFilter(change, contentToFilter);
								} else {
									return new ResponseEntity<ResponseParser>(new ResponseParser(null, "Invalid contentToFilter parameters"), HttpStatus.BAD_REQUEST);
								}
							} catch(Exception e) {
								return new ResponseEntity<ResponseParser>(new ResponseParser(null, "Missing contentToFilter Parameter"), HttpStatus.BAD_REQUEST);
							}
						} else {
							changeStr = Utils.buildChangeStr(change);
						}
						/* Make Soap Call with ci, changeStr */
						logger.trace("TransactionType=doProfileChanges | SourceSystem=ms-securenet | TargetSystem=Allot | ci = {} | response = {} | ", ci, HttpStatus.OK);
						return new ResponseEntity<ResponseParser>(new ResponseParser(ci + " " + changeStr, null), HttpStatus.OK);
						
					}
					logger.error("TransactionType=doProfileChanges | SourceSystem=ms-securenet | TargetSystem=Allot | response = {} | message = Invalid profileChange parameter", HttpStatus.BAD_REQUEST);
					return new ResponseEntity<ResponseParser>(new ResponseParser(null, "Invalid profileChange parameter"), HttpStatus.BAD_REQUEST);
				} catch (Exception e) {
					logger.error("TransactionType=doProfileChanges | SourceSystem=ms-securenet | TargetSystem=Allot | response = {} | message = Missing profileChange parameter", HttpStatus.BAD_REQUEST);
					return new ResponseEntity<ResponseParser>(new ResponseParser(null, "Missing profileChange parameter"), HttpStatus.BAD_REQUEST);
				}
			}
			logger.error("TransactionType=doProfileChanges | SourceSystem=ms-securenet | TargetSystem=Allot | response = {} | message = Invalid ci", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<ResponseParser>(new ResponseParser(null, "Invalid Ci"), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error("TransactionType=doProfileChanges | SourceSystem=ms-securenet | TargetSystem=Allot | response = {} | message = Missing ci parameter", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<ResponseParser>(new ResponseParser(null, "Missing Ci Parameter"), HttpStatus.BAD_REQUEST);
		}
	}
	
}
