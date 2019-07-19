package com.june.apps;

public class GraphicsProcessors {
	private String nvidia;
	private String amd;
	private String intel;
	private Headers headers = new Headers();
	
	public GraphicsProcessors() {}

	
	
	public GraphicsProcessors(String nvidia, String amd, String intel, Headers headers) {
		super();
		this.nvidia = nvidia;
		this.amd = amd;
		this.intel = intel;
		this.headers= headers;
	}

	public String getNvidia() {
		return nvidia;
	}

	public void setNvidia(String nvidia) {
		this.nvidia = nvidia;
	}

	public String getAmd() {
		return amd;
	}

	public void setAmd(String amd) {
		this.amd = amd;
	}

	public String getIntel() {
		return intel;
	}

	public void setIntel(String intel) {
		this.intel = intel;
	}
	public Headers getHeaders() {
		return headers;
	}

	public void setHeaders(Headers headers) {
		this.headers = headers;
	}
	
}
