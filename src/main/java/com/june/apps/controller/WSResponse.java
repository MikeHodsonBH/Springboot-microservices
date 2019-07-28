package com.june.apps.controller;

import javax.xml.soap.SOAPEnvelope;

public class WSResponse {
	SOAPEnvelope soapEnvelope;
	String status;
	String soapException;
	
	public WSResponse() {}

	public WSResponse(SOAPEnvelope soapEnvelope, String status, String soapException) {
		super();
		this.soapEnvelope = soapEnvelope;
		this.status = status;
		this.soapException = soapException;
	}

	public SOAPEnvelope getSoapEnvelope() {
		return soapEnvelope;
	}

	public void setSoapEnvelope(SOAPEnvelope soapEnvelope) {
		this.soapEnvelope = soapEnvelope;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSoapException() {
		return soapException;
	}

	public void setSoapException(String soapException) {
		this.soapException = soapException;
	}
	
}
