package com.june.apps;

import java.util.HashMap;
import java.util.Map;

public class Headers {
	public Map<String, String> requestHeaders = new HashMap<>();

	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	public Headers(Map<String, String> requestHeaders) {
		super();
		this.requestHeaders = requestHeaders;
	}

	public Headers() {}
	
}
